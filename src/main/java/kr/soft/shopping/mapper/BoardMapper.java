package kr.soft.shopping.mapper;

import kr.soft.shopping.dto.board.BoardListDTO;
import kr.soft.shopping.dto.board.BoardRegisterDTO;
import kr.soft.shopping.dto.board.MemberLoginDTO;
import kr.soft.shopping.dto.board.MemberRegisterDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BoardMapper {
    List<BoardListDTO> list();
    String login(String param);
    void register(BoardRegisterDTO boardRegisterDTO);
    void memberRegister(MemberRegisterDTO memberRegisterDTO);
}
