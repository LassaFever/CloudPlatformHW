package com.fish.mapper;

import com.fish.domain.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommentMapper {
    @Select("select * from t_comment where id = #{id}")
    public Comment findById(Integer id);

    @Select("select * from ")
    public List<Comment> findByAid(Integer aid);

    @Insert("insert into t_comment (content, author, a_id) values (#{content}, #{author}, #{aId}")
    public int insertComment(Comment comment);

    @Update("update t_comment set t_content=#{content} where id=#{id}")
    public int updateComment(Comment comment);

    @Delete("delete from t_comment where id=#{id}")
    public int deleteComment(Integer id);

}
