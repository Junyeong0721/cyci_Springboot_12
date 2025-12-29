package kr.soft.shopping.dto.board;

import lombok.Data;

@Data
public class BoardListDTO {
    private int boardIdx;
    private String userId;
    private String title;
    private  String createAt;
}
