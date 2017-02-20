package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/json")
public class JsonDataEndpointsController {

    @GetMapping("/")
    public String getIndex(){ return "Yo, its the index, dawg";}


    static class Food {
        private String shape;
        private String taste;

        public String getShape() {
            return shape;
        }

        public void setShape(String shape) {
            this.shape = shape;
        }

        public String getTaste() {
            return taste;
        }

        public void setTaste(String taste) {
            this.taste = taste;
        }
    }

    @PostMapping("/test1")
    public String getJsonDataFromStringLiteral(@RequestBody Food food){
        return String.format("This food is %s and %s!", food.getShape(), food.getTaste());
    }

    static class Ship {
        private String type;
        private int engines;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getEngines() {
            return engines;
        }

        public void setEngines(int engines) {
            this.engines = engines;
        }
    }
    @PostMapping("/test2")
    public String getSerializedJsonData(@RequestBody Ship ship){
        return String.format("The starship is a %s type and has %d engines", ship.getType(), ship.getEngines());
    }

    @PostMapping("/test3")
    public String getJsonDataFromFile(@RequestBody Pokemon pokemon){
        return String.format("The pokemon is named %s and it is a %s type!", pokemon.getName(), pokemon.getType());
    }
}
