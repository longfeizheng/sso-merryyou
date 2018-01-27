package cn.merryyou.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/1/27 0027.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RestController
@SpringBootApplication
public class SsoResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoResourceApplication.class, args);
    }
    @GetMapping("/api/{id}")
    public String get(@PathVariable("id") String id) {
        System.out.println("id=" + id);
        return id;
    }
}
