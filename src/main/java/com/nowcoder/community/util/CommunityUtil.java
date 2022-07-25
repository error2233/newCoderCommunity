package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class CommunityUtil {
    //product random String
    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    //MD5 加密
    //hello -> abc12345def
    public static String md5(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

}
