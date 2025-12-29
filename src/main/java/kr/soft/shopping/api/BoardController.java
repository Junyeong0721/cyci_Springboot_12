package kr.soft.shopping.api;

import jakarta.servlet.http.HttpServletRequest;
import kr.soft.shopping.dto.board.BoardListDTO;
import kr.soft.shopping.dto.board.BoardRegisterDTO;
import kr.soft.shopping.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/board")
public class BoardController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public List<BoardListDTO> list() {
        return boardService.list();
    }
    @PostMapping("/register")
    public void register(@RequestBody BoardRegisterDTO boardRegisterDTO) {

        logger.info("data {}", boardRegisterDTO.toString());

        boardService.register(boardRegisterDTO);
    }


}
