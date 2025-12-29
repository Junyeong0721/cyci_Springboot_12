package kr.soft.shopping.service;

import kr.soft.shopping.dto.board.MemberLoginDTO;
import kr.soft.shopping.dto.board.MemberRegisterDTO;
import kr.soft.shopping.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    BoardMapper boardMapper;

    public boolean login(MemberLoginDTO memberLoginDTO){
        String userId = memberLoginDTO.getUserId();
        String userPw = memberLoginDTO.getUserPw();
        String dbPw = boardMapper.login(userId);
        if(dbPw == null) {
            return false;
        }
        if(!dbPw.equals(userPw)){
            return false;
        }

        return true;
    }

    public void register(MemberRegisterDTO memberRegisterDTO){
        boardMapper.memberRegister(memberRegisterDTO);
    }
}
