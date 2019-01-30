package koreatech.cse.repository;


import koreatech.cse.domain.Board;
import koreatech.cse.domain.Searchable;
import koreatech.cse.domain.User;
import koreatech.cse.repository.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    @Insert("INSERT INTO BOARD (subject, contents, dateTime,hits) VALUES (#{subject}, #{contents}, NOW(),0)")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    void insert(Board board);

}
