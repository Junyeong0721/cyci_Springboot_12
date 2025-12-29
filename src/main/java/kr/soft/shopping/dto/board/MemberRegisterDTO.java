package kr.soft.shopping.dto.board;

import lombok.Data;

@Data
public class MemberRegisterDTO {
    private String userId;
    private String userPw;
    private String userEmail;
}
