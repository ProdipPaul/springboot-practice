package com.prodip.bootjpa.dao;

import com.prodip.bootjpa.model.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepo extends CrudRepository<Alien, Integer>
{

}
