package com.giancotsu.panchine.repository;

import com.giancotsu.panchine.model.Giocatore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGiocatoreRepo extends JpaRepository<Giocatore, Long> {

}
