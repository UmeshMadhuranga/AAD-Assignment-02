package lk.ijse.gdse.springmvc_with_gradle.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@ComponentScan
@EnableWebMvc
public class WebAppRootConfig {
}
