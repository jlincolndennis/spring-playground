package com.example;

import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Long>{

    Record findByArtistName(String artistName);
}
