package com.fish.service;

import com.fish.domain.StudentInfo;
import com.fish.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentInfo getById(long id){
        return studentRepository.getStudentById(id);
    }

    public void save(StudentInfo s){
        studentRepository.saveAndFlush(s);
    }

    public void update(StudentInfo s){
        studentRepository.update(s);
    }

    public List<StudentInfo> getAll(){
        return studentRepository.getAllStudents();
    }

    public List<StudentInfo> getStudentsByKlassId(long klassId){
        return studentRepository.getStudentsByKlassId(klassId);
    }

}
