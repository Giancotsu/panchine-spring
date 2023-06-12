package com.giancotsu.panchine.repository;

import com.giancotsu.panchine.model.InCasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInCasaRepo extends JpaRepository<InCasa, Long> {
}
