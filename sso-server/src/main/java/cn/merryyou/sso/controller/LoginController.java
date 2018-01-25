package cn.merryyou.sso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created on 2018/1/25 0025.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RestController
public class LoginController {

    @GetMapping("/authentication/require")
    public ModelAndView require() {
        return new ModelAndView("ftl/login");
    }
}
