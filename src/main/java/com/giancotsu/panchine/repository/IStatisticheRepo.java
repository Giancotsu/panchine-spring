package com.giancotsu.panchine.repository;

import com.giancotsu.panchine.model.Statistiche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatisticheRepo extends JpaRepository<Statistiche, Long> {
}
