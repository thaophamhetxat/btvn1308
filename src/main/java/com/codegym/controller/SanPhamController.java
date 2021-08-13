package com.codegym.controller;

import models.SanPham;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.SanPhamService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


@Controller
public class SanPhamController {

    SanPhamService sanPhamService = new SanPhamService();



    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list",sanPhamService.list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create","loaisanPhams",sanPhamService.loaisanPhams);
        modelAndView.addObject("list",new SanPham());
        return modelAndView;
    }


    @PostMapping("/create")
    public String create(@ModelAttribute SanPham sanPham) {
        sanPhamService.save(sanPham);
        return "redirect:/home";
    }


    @PostMapping("/edit")
    public String edit(@RequestParam int index,@ModelAttribute SanPham sanPham) {
        sanPhamService.edit(sanPham, index);
        return "redirect:/home";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id, Model model){
        ModelAndView modelAndView = new ModelAndView("edit","loaisanPhams",sanPhamService.loaisanPhams);
        model.addAttribute("list",sanPhamService.list.get(id));
        return modelAndView;
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        sanPhamService.delete(id);
        return "redirect:/show";
    }


}
