package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record-store")

public class RecordStoreController {
    private final RecordRepository repository;

    public RecordStoreController(RecordRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    public Iterable<Record> getAllRecords(){
        return this.repository.findAll();
    }

    @PostMapping("/add")
    public Record create(@RequestBody Record record){
        this.repository.save(record);
        return record;
    }
}



