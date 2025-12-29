package kr.soft.shopping.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/api/main")
public class MainController {

    @GetMapping("/test")
    public void test(){
        log.info("test");

    }

}
