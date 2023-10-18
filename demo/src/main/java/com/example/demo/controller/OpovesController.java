package com.example.demo.controller;

import com.example.demo.entity.Opoves;
import com.example.demo.entity.User;
import com.example.demo.service.Opoveservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/opoves")

public class OpovesController {
    private final Opoveservice opovesService;
    @GetMapping("/all")
    public String getALLopoves(Model model){
        model.addAttribute("opovesh", opovesService.getALLopoves());
        model.addAttribute("opoves", new Opoves());
        return "Opoveshcheniye";
    }
    @PostMapping("/save")
    public String saveOpoves(@ModelAttribute Opoves opoves){
        opovesService.save(opoves);
        return "redirect:all";
    }
    @GetMapping("/delete")
    public String deleteOpoves(@RequestParam Long id){
        opovesService.delete(id);
        return "redirect:all";
    }
    @GetMapping("/edit")
    public String editOpoves(@RequestParam Long id, Model model){
        Optional<Opoves> opoves = opovesService.getById(id);
        model.addAttribute("opoves", opoves);
        return "opovesEdit";
    }
    @PostMapping("/update")
    public String updateOpoves(@ModelAttribute Opoves opoves){
        opovesService.save(opoves);
        return "redirect:all";
    }
}
