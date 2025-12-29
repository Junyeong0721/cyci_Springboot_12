package kr.soft.shopping.config.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.soft.shopping.dto.member.MemberAuthDTO;
import kr.soft.shopping.mapper.AuthMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    AuthMapper authMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        log.info("URI: {}", request.getRequestURI());
        log.info("********** 인터셉터 동작 확인 **********");

        String authorization = request.getHeader("Authorization");

        log.info("Authorization: {}", authorization);

        String token = authorization.substring(7);

        MemberAuthDTO memberAuthDTO = authMapper.searchKey(token);
        if(memberAuthDTO == null){
            return false;
        }
        request.setAttribute("userIdx", memberAuthDTO.getUserIdx());

        return true;
    }

}
