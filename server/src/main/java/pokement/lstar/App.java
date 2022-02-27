package pokement.lstar;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import pokement.lstar.system.SysConfig;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author L.star
 * @date 2022/2/26 15:58
 */
@SpringBootApplication
@EnableCaching
public class App {

    public static final int DEF_MAX_CAPACITY = 500;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public RestTemplate restTemplate()
    {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

    /**
     * 缓存
     * @return
     */
    @Bean
    public Cache<String, Object> caffeineCache()
    {
        return Caffeine.newBuilder()
                .initialCapacity(DEF_MAX_CAPACITY)
                .maximumSize(DEF_MAX_CAPACITY)
                .build();
    }
    //永久缓存 手动更新
    @Bean
    public Map<Object, Object> staticCache()
    {
        return new ConcurrentHashMap<>();
    }
}
