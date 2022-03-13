package pokement.lstar.common;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTUtil;
import pokement.lstar.system.SysConfig;

import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

/**
 * token工具类
 * @author L.star
 * @date 2022/2/27 10:12
 */

public class TokenUtil {
    private TokenUtil(){}

    public static String createToken(Integer userId)
    {
        Map<String, Object> map = new HashMap<String, Object>()
        {
            {
                put("user_id", userId);
                put("expire_time", LocalDateTimeUtil.now().plusHours(SysConfig.getInt("expire_time", 24)).toInstant(ZoneOffset.of("+8")).toEpochMilli());
            }
        };

        return JWTUtil.createToken(map, SysConfig.getStr("token_secret", "294554846").getBytes());
    }

    public static String createToken(String userName)
    {
        Map<String, Object> map = new HashMap<String, Object>()
        {
            {
                put("user_name", userName);
                put("expire_time", LocalDateTimeUtil.now().plusHours(SysConfig.getInt("expire_time", 24)).toInstant(ZoneOffset.of("+8")).toEpochMilli());
            }
        };

        return JWTUtil.createToken(map, SysConfig.getStr("token_secret", "294554846").getBytes());
    }

    public static Boolean verify(String token)
    {
        if (StrUtil.isEmptyIfStr(token))
            return false;
        return JWTUtil.verify(token, SysConfig.getStr("token_secret", "294554846").getBytes());
    }
}
