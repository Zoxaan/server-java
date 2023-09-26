package com.example.demo.controller;

import com.example.demo.entity.Opoveshcheniye;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("api/opoveshcheniye")
public class OpoveshcheniyeController {
    private final Opoveshcheniye opoveshcheniyeService;
    @GetMapping("/all")
    public String getALLopoveshcheniye(Model model){
        model.addAttribute("opoveshcheniyes", opoveshcheniyeService.getALLopoveshcheniye());
        model.addAttribute("opoveshcheniye", new Opoveshcheniye());
        return "index";
    }
}
