package com.giancotsu.panchine.repository;

import com.giancotsu.panchine.model.Stadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStadioRepo extends JpaRepository<Stadio, Long> {
}
