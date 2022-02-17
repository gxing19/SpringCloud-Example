package com.gxitsky.jwt;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.Test;

/**
 * @name: KeyProvider
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-24 15:34
 **/
public class KeyProvider {

    @Test
    public void javaJWT() throws Exception {

        //签名算法
        Algorithm algorithm = Algorithm.HMAC256("123456");
        //创建并签名 Token
        JWTCreator.Builder builder = JWT.create();
        //发布时间
        DateTime issueDateTime = DateUtil.date();
        builder.withClaim("sub", "1234567890")
                .withClaim("name", "John Doe")
                .withIssuedAt(issueDateTime)//发布时间
                .withExpiresAt(DateUtil.offsetSecond(issueDateTime, 10))//2秒过期
                .withIssuer("Rocky");

        String token = builder.sign(algorithm);
        System.out.println(token);

        //Token 解码
        DecodedJWT jwt = JWT.decode(token);
        System.out.println(JSON.toJSONString(jwt));

        //Token 验证
        Verification verification = JWT.require(algorithm);
        JWTVerifier jwtVerifier = verification
                .withIssuer("Rocky")
                .acceptLeeway(2)//2秒时间窗口
                .build();
        DecodedJWT verify = jwtVerifier.verify(token);
        System.out.println(JSON.toJSONString(verify));
    }

//    @Test
//    public void jjwtTest() throws NoSuchAlgorithmException {
//        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//
////        SecretKey key = KeyGenerator.getInstance("HS256").generateKey();
////        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
////        PrivateKey aPrivate = keyPair.getPrivate();
////        PublicKey aPublic = keyPair.getPublic();
//
//        String jws = Jwts.builder()
//                .setHeaderParam("type", "jwt")
//                .setSubject("rocky")
//                .signWith(key)
//                .compact();
//        assert Jwts.parser().setSigningKey(key).parseClaimsJws(jws).getBody().getSubject().equals("rocky");
//
//
//        System.out.println(jws);
//
//    }


}