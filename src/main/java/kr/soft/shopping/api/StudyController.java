package kr.soft.shopping.api;

import jakarta.servlet.http.HttpServletRequest;
import kr.soft.shopping.dto.CalcDTO;
import kr.soft.shopping.dto.DataDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StudyController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test")
    public void test() {
        logger.info("Test Action");
    }
    @GetMapping("/test1")
    public String test1(){
        logger.info("Test Action");
        return "Hello World";
    }

    @GetMapping("/data1")
    public void data1(HttpServletRequest request){
        String data = request.getParameter("text");
        logger.info("data {}", data);
    }

    @GetMapping("/data2")
    public void data2(DataDTO dto){
        logger.info("data {}", dto.toString());
    }
    @GetMapping("/data3")
    public void data3(CalcDTO calcDTO){
        logger.info("plus {}", calcDTO.getNum1() + calcDTO.getNum2());
        logger.info("minus {}", calcDTO.getNum1() - calcDTO.getNum2());
    }
    @PostMapping("/post1")
    public void post1(@RequestBody DataDTO dto){
        logger.info("data {}", dto.toString());
    }
    @GetMapping("/res1")
    public DataDTO res1(DataDTO dto){
        logger.info("data {}", dto.toString());
        return dto;
    }
}
