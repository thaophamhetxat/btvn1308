package com.codegym.controller;

import models.SanPham;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
        modelAndView.addObject("list", sanPhamService.list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create", "loaisanPhams", sanPhamService.loaisanPhams);
        modelAndView.addObject("list", new SanPham());
        return modelAndView;
    }


    @PostMapping("/create")
    public String create(@ModelAttribute SanPham sanPham) {
        sanPhamService.save(sanPham);
        return "redirect:/home";
    }

    @GetMapping("/edit{index}")
    public ModelAndView showEdit(@PathVariable int index, Model model) {
        ModelAndView modelAndView = new ModelAndView("edit", "loaisanPhams", sanPhamService.loaisanPhams);
        model.addAttribute("list", sanPhamService.list.get(index));
        return modelAndView;
    }


    @PostMapping("/edit{index}")
    public ModelAndView edit(@PathVariable int index, SanPham sanPham){
        sanPhamService.edit(sanPham,index);
        return new ModelAndView("redirect:/home");
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        sanPhamService.delete(id);
        return "redirect:/home";
    }

    @PostMapping("/find")
    public String findByName(HttpServletRequest request) {
        String findName = request.getParameter("findName");
        sanPhamService.findByName(findName);
        request.setAttribute("list", sanPhamService.list);
        return "redirect:/home";
    }
}
