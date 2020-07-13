package com.fish.web;

import com.fish.domain.KlassInfo;
import com.fish.service.KlassService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("klass")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KlassController {

    private final KlassService klassService;

    @GetMapping("/list")
    public String list(Model model){
        List<KlassInfo> all = klassService.findAll();
        model.addAttribute("list", all);

        return "/views/Klass/list";
    }

    @GetMapping("/del")
    public String deleteById(@RequestParam(name = "id") Long id){
        klassService.deleteKlassById(id);
        return "redirect:/klass/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable long id, Model model){
        KlassInfo klass = klassService.findById(id);
        model.addAttribute("klass",klass);
        return "views/klass/update";
    }

    @PostMapping("/update")
    public String update(KlassInfo klass){
        klassService.updateKlass(klass);
        return "redirect:/klass/list";
    }

    @GetMapping("/add")
    public String add(){
        return "views/klass/add";
    }

    @PostMapping("/add")
    public String add(KlassInfo klass){
        klassService.saveKlass(klass);
        return "redirect:/klass/list";
    }






}
