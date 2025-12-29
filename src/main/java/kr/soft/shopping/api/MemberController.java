package kr.soft.shopping.api;

import kr.soft.shopping.dto.member.MemberLoginDTO;
import kr.soft.shopping.dto.member.MemberRegisterDTO;
import kr.soft.shopping.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MemberRegisterDTO memberRegisterDTO) {
        log.info("/api/member/register");
        log.info("data: {}", memberRegisterDTO.toString());
        memberService.register(memberRegisterDTO);

        return ResponseEntity.ok("ok");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberLoginDTO memberLoginDTO) {
        log.info("/api/member/login");
        log.info("data: {}", memberLoginDTO.toString());

        String check = memberService.login(memberLoginDTO);

        return ResponseEntity.ok(check);
    }
}