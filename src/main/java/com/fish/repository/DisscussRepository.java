package com.fish.repository;

import com.fish.entity.Discuss;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DisscussRepository extends JpaRepository<Discuss, Integer> {

    List<Discuss> findByAuthorNotNull();

    @Query("select c from t_comment c where c.aId = ?1")
    List<Discuss> getDiscussPaged(Integer aId, Pageable pageable);

    @Query(value = "select * from t_comment where a_id = ?1", nativeQuery = true)
    List<Discuss> getDiscussPaged2(Integer aId, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update t_comment c set c.author = ?1 where c.id = ?2 ")
    int updateComment(String author, Integer aId);

    @Transactional
    @Modifying
    @Query("delete from t_comment c  where c.id = ?1 ")
    int deleteComment(Integer id);

}
