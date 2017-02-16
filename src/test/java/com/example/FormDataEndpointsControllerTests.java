package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FormDataEndpointsController.class)

public class FormDataEndpointsControllerTests {
    @Autowired
    private MockMvc mvc;
    private String content = "This is a people post!";
    private String author = "CM Punk";


    @Test
    public void testFormDataAsStringEndpoint() throws Exception{
        MockHttpServletRequestBuilder request = post("/fd/people")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", content)
                .param("author", author);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("content=This+is+a+people+post%21&author=CM+Punk"));
    }

    @Test
    public void testFormDataAsMapEndpoint() throws Exception{
        MockHttpServletRequestBuilder request = post("/fd/map/people")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", content)
                .param("author", author);

        this.mvc.perform(request)
                .andExpect((status().isOk()))
                .andExpect(content().string(String.format("{content=%s, author=%s}", content, author)));
    }

    @Test
    public void testFormDataAsObjectEndpoint()throws Exception{
        MockHttpServletRequestBuilder request = post("/fd/obj/people")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", content)
                .param("author", author);

        this.mvc.perform(request)
                .andExpect((status().isOk()))
                .andExpect(content().string(String.format("The author is %s and the content is: %s", author, content)));
    }


}
