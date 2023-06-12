package com.giancotsu.panchine.repository;

import com.giancotsu.panchine.model.Carriera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarrieraRepo extends JpaRepository<Carriera, Long> {
}
