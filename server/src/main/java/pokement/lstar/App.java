package pokement.lstar;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import pokement.lstar.system.SysConfig;

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
    public Cache<String, Object> caffeineCache()
    {
        return Caffeine.newBuilder()
                .initialCapacity(DEF_MAX_CAPACITY)
                .maximumSize(DEF_MAX_CAPACITY)
                .build();
    }
}
