package kr.soft.shopping.service;

import kr.soft.shopping.dto.member.MemberAuthDTO;
import kr.soft.shopping.dto.member.MemberLoginDTO;
import kr.soft.shopping.dto.member.MemberLoginIdxDTO;
import kr.soft.shopping.dto.member.MemberRegisterDTO;
import kr.soft.shopping.mapper.AuthMapper;
import kr.soft.shopping.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    BoardMapper boardMapper;
    @Autowired
    private AuthMapper authMapper;

    public String login(MemberLoginDTO memberLoginDTO){
        String userId = memberLoginDTO.getUserId();
        String userPw = memberLoginDTO.getUserPw();
        MemberLoginIdxDTO resultDTO = boardMapper.login(memberLoginDTO.getUserId());
        if(resultDTO == null) {
            return null;
        }
        if(!resultDTO.getUserPw().equals(userPw)){
            return null;
        }
        String text = "apple_"+memberLoginDTO.getUserId();

        MemberAuthDTO memberAuthDTO = new MemberAuthDTO();
        memberAuthDTO.setUserIdx(resultDTO.getUserIdx());
        memberAuthDTO.setAuthName(text);

        authMapper.regist(memberAuthDTO);

        return text;
    }

    public void register(MemberRegisterDTO memberRegisterDTO){
        boardMapper.memberRegister(memberRegisterDTO);
    }
}
