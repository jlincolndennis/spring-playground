package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/fd")

public class FormDataEndpointsController {

    @PostMapping("/people")
    public String getFormDataAsString(@RequestBody String body){
        return body;
    }

    @PostMapping("/map/people")
    public String getFormDataAsMap(@RequestParam Map<String, String> formData){
        return formData.toString();
    }

    @PostMapping("/obj/people")
    public String getFormDataAsObj(PostRequest postRequest){
        return String.format("The author is %s and the content is: %s", postRequest.getAuthor(), postRequest.getContent());
    }
}
