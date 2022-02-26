package pokement.lstar.system;

import cn.hutool.core.convert.Convert;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 系统配置
 * @author L.star
 * @date 2022/2/26 16:02
 */
@Component
@ConfigurationProperties(prefix = "sysconfig")
public class SysConfig {
    private SysConfig(){}

    private static Map<Object, Object> config = new ConcurrentHashMap<>();

    public Map<Object, Object> getConfig() {
        return config;
    }

    public void setConfig(Map<Object, Object> config) {
        SysConfig.config = config;
    }

    public static void setVal(Object key, Object val)
    {
        config.put(key, val);
    }

    public static Integer getInt(String key, int def)
    {
        Object val = config.get(key);
        if (val == null) {
            return def;
        }

        return Convert.toInt(val);
    }

    public static String getStr(String key, String def)
    {
        Object val = config.get(key);
        if (val == null) {
            return def;
        }

        return Convert.toStr(val);
    }
}
