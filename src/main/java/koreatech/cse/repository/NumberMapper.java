package koreatech.cse.repository;


import koreatech.cse.domain.Board;
import koreatech.cse.domain.Num;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumberMapper {
    @Select("select * from number")
    List<Num> findAll();

    @Insert("Insert into number (name,num) values (#{name},#{num})")
    void insert(@Param("name") String name,@Param("num") int num);
}
