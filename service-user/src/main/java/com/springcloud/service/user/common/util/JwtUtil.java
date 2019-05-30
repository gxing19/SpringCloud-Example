package com.springcloud.service.user.common.util;

import com.springcloud.service.user.common.bean.JwtResult;
import com.springcloud.service.user.common.bean.ResponseCode;
import io.jsonwebtoken.*;

import java.util.Date;

/**
 * @name: JwtUtil
 * @desc: JWT 工具类
 * @author: gxing
 * @date: 2019-05-27 11:11
 **/
public class JwtUtil {

    /**
     * 获取 Token
     * @param uid
     * @param exp
     * @param privateKey
     * @return
     */
    public static String getToken(String uid, int exp, String privateKey) {

        Long endTime = System.currentTimeMillis() + 1000 * 60 * exp;
        String token = Jwts.builder()
                .setSubject(uid)
                .setExpiration(new Date(endTime))
                .signWith(SignatureAlgorithm.RS512, privateKey)
                .compact();
        return token;

    }

    /**
     * 验证 JWT 是否合法
     * @param token
     * @param publicKey
     * @return
     */
    public static JwtResult checkToken(String token, String publicKey) {
        JwtResult jwtResult = null;
        try {
            Claims body = Jwts.parser().setSigningKey(publicKey)
                    .parseClaimsJws(token).getBody();
            String sub = body.get("sub", String.class);
            jwtResult = new JwtResult(true, sub, "请求合法", ResponseCode.SUCCESS_CODE);
        } catch (ExpiredJwtException e) {
            //如果过期时间已早于(小于)当前时间
            jwtResult = new JwtResult(false, null, "token 已过期", ResponseCode.TOKEN_TIME_OUT);
            e.printStackTrace();
        } catch (SignatureException e) {
            //如果jwt解析异常，如密钥不对等
            jwtResult = new JwtResult(false, null, "签名异常", ResponseCode.SIGN_ERROR);
            e.printStackTrace();
        } catch (Exception e) {
            jwtResult = new JwtResult(false, null, "非法请求", ResponseCode.NO_AUTO);
            e.printStackTrace();
        }
        return jwtResult;

    }
}
