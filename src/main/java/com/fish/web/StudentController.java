package com.fish.web;

import com.fish.domain.KlassInfo;
import com.fish.domain.StudentInfo;
import com.fish.service.KlassService;
import com.fish.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("student")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {

    private final StudentService studentService;

    private final KlassService klassService;

    @GetMapping("/list")
    public String list(Model model,Long klassInfoId){
        List<StudentInfo> list;
        if(klassInfoId==null) {
            list = studentService.getAll();
        }
        else{
            list = studentService.getStudentsByKlassId(klassInfoId);
        }
        model.addAttribute("list",list);

        List<KlassInfo> klassList = this.klassService.findAll();
        model.addAttribute("klassList",klassList);

        return "views/student/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        List<KlassInfo> klassList = this.klassService.findAll();
        model.addAttribute("klassList",klassList);
        return "views/student/add";
    }

    @PostMapping("/add")
    public String add(StudentInfo s){
        studentService.save(s);
        return "redirect:/student/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable long id, Model model){
        StudentInfo s = studentService.getById(id);
        model.addAttribute("student",s);

        List<KlassInfo> klassList = this.klassService.findAll();
        model.addAttribute("klassList",klassList);

        return "views/student/update";
    }

    @PostMapping("/update")
    public String update(StudentInfo s){
        studentService.update(s);
        return "redirect:/student/list";
    }

}
