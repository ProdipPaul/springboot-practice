package com.prodip.bootjpa.controller;

import com.prodip.bootjpa.dao.AlienRepo;
import com.prodip.bootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }

    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable  int aid)
    {
        Alien a = repo.findById(aid).orElse(null);
        if(a != null){
            repo.delete(a);
            return "deleted" ;
        }
        return "Not Found";
    }



    @PostMapping("/alien")    // @PostMapping(path="/alien", consumes= {"application/json"}) //NB: only JSON format er data input nibe
    public Alien addAlien(@RequestBody Alien alien)
    {
        repo.save(alien);
        return alien;
    }

    @GetMapping(path="/aliens")
    public List<Alien> getAliens()
    {
        return repo.findAll();
    }


    @PutMapping(path= "/alien")
    public Alien saveOrUpdateAlien(@RequestBody Alien alien)
    {
        repo.save(alien);
        return alien;
    }


    @RequestMapping("/alien/{aid}")
    public Optional<Alien> getAlien(@PathVariable("aid") int aid)
    {
        return repo.findById(aid);
    }
}