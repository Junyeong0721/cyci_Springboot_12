package kr.soft.shopping.mapper;

import kr.soft.shopping.dto.member.MemberAuthDTO;
import kr.soft.shopping.dto.member.MemberLoginDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {

    void regist(MemberAuthDTO memberAuthDTO);

    MemberAuthDTO searchKey(String authName);
}
