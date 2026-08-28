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
    public String home() {
        return "home.jsp";
    }

    // ১. @PatchMapping এর জায়গায় @PostMapping হবে
    // ২. @ResponseBody যোগ করা হয়েছে
    @PostMapping("/alien")

    public Alien addAlien(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }

    @GetMapping(path="/aliens")
    public List<Alien> getAliens() {
        return repo.findAll();
    }

    @GetMapping("/alien/{aid}") // @RequestMapping এর বদলে নির্দিষ্টভাবে @GetMapping
    public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
        return repo.findById(aid);
    }
}