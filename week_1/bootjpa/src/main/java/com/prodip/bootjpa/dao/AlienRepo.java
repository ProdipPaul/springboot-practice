package com.prodip.bootjpa.dao;

import com.prodip.bootjpa.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepo extends JpaRepository<Alien, Integer>
{


}