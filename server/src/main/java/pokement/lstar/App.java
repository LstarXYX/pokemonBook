package pokement.lstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pokement.lstar.system.SysConfig;

/**
 * @author L.star
 * @date 2022/2/26 15:58
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println(SysConfig.getStr("aaa", "null"));
    }
}
