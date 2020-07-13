package com.fish.repository;

import com.fish.domain.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentInfo, Long> {

    @Query(value="select s.*,k.name as klassInfoName from student_info s inner join klass_info k  on s.klass_info_id=k.id where s.klass_info_id=?1",nativeQuery=true)
    public List<StudentInfo> getStudentsByKlassId(long klassId);

    @Query(value="select s.*,k.name as klassInfoName from student_info s inner join klass_info k  on s.klass_info_id=k.id",nativeQuery=true)
    public List<StudentInfo> getAllStudents();

    @Query(value="select s.*,k.name as klassInfoName from student_info s inner join klass_info k  on s.klass_info_id=k.id where s.id=?1",nativeQuery=true)
    public StudentInfo getStudentById(long id);

    @Transactional
    @Modifying
    @Query(value="update student_info set name=:#{#s.name},age=:#{#s.age},klass_info_id=:#{#s.klassInfoId} where id=:#{#s.id}",nativeQuery=true)
    public void update(StudentInfo s);

}
