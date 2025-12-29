package kr.soft.shopping.api;

import kr.soft.shopping.dto.board.MemberLoginDTO;
import kr.soft.shopping.dto.board.MemberRegisterDTO;
import kr.soft.shopping.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/member")
public class MemberController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MemberService memberService;

    @PostMapping("/login")
    public String login(@RequestBody MemberLoginDTO memberLoginDTO) {


        String text = "apple + " + memberLoginDTO.getUserId();
        if(!memberService.login(memberLoginDTO)){
            return null;
        }

        return text;

    }
    @PostMapping("/register")
    public void register(@RequestBody MemberRegisterDTO memberRegisterDTO) {
        logger.info("data {}", memberRegisterDTO.toString());
        memberService.register(memberRegisterDTO);
    }
}
