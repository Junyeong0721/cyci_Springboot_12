package kr.soft.shopping.mapper;

import kr.soft.shopping.dto.board.BoardListDTO;
import kr.soft.shopping.dto.board.BoardRegisterDTO;
import kr.soft.shopping.dto.member.MemberLoginIdxDTO;
import kr.soft.shopping.dto.member.MemberRegisterDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BoardMapper {
    List<BoardListDTO> list();
    MemberLoginIdxDTO login(String param);
    void register(BoardRegisterDTO boardRegisterDTO);
    void memberRegister(MemberRegisterDTO memberRegisterDTO);
}
