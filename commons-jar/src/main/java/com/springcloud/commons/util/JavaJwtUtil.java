package com.springcloud.commons.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

/**
 * @name: JavaJwtUtil
 * @desc: java_jwt 库工具类,签发验证token
 * @author: gxing
 * @date: 2019-05-27 11:11
 **/
public class JavaJwtUtil {

    /*默认有效期 1天 = 24小时*/
    private static final Long END_DATETIME = System.currentTimeMillis() + 1000 * 60 * 1440;
    private static RSAPrivateKey rsaPrivateKey = RSAUtil.getPrivateKey(RSAUtil.MODULUS, RSAUtil.PRIVATE_EXPONENT);
    private static RSAPublicKey rsaPublicKey = RSAUtil.getPublicKey(RSAUtil.MODULUS, RSAUtil.PUBLIC_EXPONENT);


    /**
     * HMAC256 算法签发Token
     *
     * @param jwtId    用户id
     * @param secret 密钥
     * @return String
     */
    public static String getTokenByHMAC256(String jwtId, String secret) {
        String token = JWT.create()
                .withClaim("jwtId", jwtId)
                .withExpiresAt(new Date(END_DATETIME))
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    /**
     * HMAC256 算法签发Token
     *
     * @param jwtId    用户id
     * @param exp    过期时间,单位:分钟
     * @param secret 密钥
     * @return String
     */
    public static String getTokenByHMAC256(String jwtId, int exp, String secret) {
        Long endDateTime = System.currentTimeMillis() + 1000 * 60 * exp;

        String token = JWT.create()
                .withClaim("jwtId", jwtId)
                .withExpiresAt(new Date(endDateTime))
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    /**
     * RSA512 算法签发Token
     *
     * @param jwtId 用户ID
     * @return String
     */
    public static String getTokenByRSA512(String jwtId) {
        Algorithm algorithm = Algorithm.RSA512(rsaPublicKey, rsaPrivateKey);
        String token = JWT.create()
                .withClaim("jwtId", jwtId)
                .withExpiresAt(new Date(END_DATETIME))
                .sign(algorithm);
        return token;
    }

    /**
     * RSA512 算法签发Token
     *
     * @param jwtId 用户id
     * @param exp 有效期
     * @return String
     */
    public static String getTokenByRSA512(String jwtId, int exp) {

        Long endDateTime = System.currentTimeMillis() + 1000 * 60 * exp;

        Algorithm algorithm = Algorithm.RSA512(rsaPublicKey, rsaPrivateKey);
        String token = JWT.create()
                .withClaim("jwtId", jwtId)
                .withExpiresAt(new Date(endDateTime))
                .sign(algorithm);
        return token;
    }

    /**
     * 验证 HMAC256 Token
     *
     * @param token  令牌
     * @param jwtId    用户id
     * @param secret 密钥
     * @return boolean
     */
    public static boolean verifyTokenByHMAC256(String token, String jwtId, String secret) {

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret))
                .withClaim("jwtId", jwtId).build();
        return verifyToken(token, jwtVerifier);
    }

    /**
     * 验证 RSA512 Token
     *
     * @param token 令牌
     * @param jwtId   用户ID
     * @return boolean
     */
    public static boolean verifyTokenByRSA512(String token, String jwtId) {

        JWTVerifier jwtVerifier = JWT.require(Algorithm.RSA512(rsaPublicKey, rsaPrivateKey))
                .withClaim("jwtId", jwtId).build();
        return verifyToken(token, jwtVerifier);
    }

    /**
     * 验证 Token
     *
     * @param token 令牌
     * @param jwtVerifier JWTVerifier对象
     * @return boolean
     */
    private static boolean verifyToken(String token, JWTVerifier jwtVerifier) {
        try {
            jwtVerifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            throw e;
//            return false;
        }
    }

    /*
    public static void main(String[] args) {

        String token1 = JavaJwtUtil.getTokenByHMAC256("1001", 60, "AABBCCDD");
        System.out.println(token1);

        String token2 = JavaJwtUtil.getTokenByHMAC256("1001", "aabbccdd");
        System.out.println(token2);

        boolean check = JavaJwtUtil.verifyTokenByHMAC256(token2, "1001", "aabbccdd");
        System.out.println(check);

        String tokenByRSA = JavaJwtUtil.getTokenByRSA512("1001");
        String tokenByRSA = JavaJwtUtil.getTokenByRSA512("1001", 1);

        System.out.println(tokenByRSA);

        boolean check = JavaJwtUtil.verifyTokenByRSA512(tokenByRSA, "1001");
        System.out.println(check);

    }
    */
}