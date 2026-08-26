package com.prodip.bootjpa.controller;


import com.prodip.bootjpa.dao.AlienRepo;
import com.prodip.bootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlienController
{
    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien)
    {
        repo.save(alien);
        return "home.jsp";
    }

    @RequestMapping("/alien/{aid}")
    @ResponseBody
    public String getAliens(@PathVariable int aid)
    {

        return  repo.findById(aid).toString();

    }

}