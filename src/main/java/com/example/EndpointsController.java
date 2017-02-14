package com.example;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;



@RestController
public class EndpointsController {

    @GetMapping("/")
    public String getIndex(){
        return "This is the index!";
    }

    @GetMapping("/tasks")
    public String getTasks(){
        return "These are the tasks!";
    }

    @PostMapping("/tasks")
    public String createTask(){
        return "You just POSTed to tasks, babycakes!";
    }

    @PostMapping("tables/new")
    public String createTable(){
        return "You just POSTed a... table. That's cool, I guess.";
    }

    @DeleteMapping("tables/delete")
    public String deleteTable(){
        return "You deleted the H*CK out of that table, brah!";
    }

    @GetMapping("/query1")
    public String getIndividualParams(@RequestParam String awesome){
        return String.format("This response is awesome: %s", awesome);
    }

    @GetMapping("/query2")
    public String getParamsAsMap(@RequestParam Map query){
        return query.toString();
    }

    @GetMapping("/query3")
    public String getParamsAsClass(Adventurer adventurer){
        return adventurer.toString();
    }




}
