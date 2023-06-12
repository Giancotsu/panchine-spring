package com.giancotsu.panchine.repository;

import com.giancotsu.panchine.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecordRepo extends JpaRepository<Record, Long> {
}
