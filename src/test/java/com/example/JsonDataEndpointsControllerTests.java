package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JsonDataEndpointsController.class)

public class JsonDataEndpointsControllerTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testIndexRoute() throws Exception {
        this.mvc.perform(get("/json/").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("Yo, its the index, dawg"));
    }

    @Test
    public void testRouteWithStringLiteral() throws Exception {
        MockHttpServletRequestBuilder request = post("/json/test1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"shape\": \"round\", \"taste\": \"pizzatastic\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("This food is round and pizzatastic!"));
    }

    @Test
    public void testRouteWithSerializedJson() throws Exception {

        JsonObject ship = new JsonObject();

        ship.addProperty("type", "fighter");
        ship.addProperty("engines", 2);

        Gson builder = new GsonBuilder().create();

        String jsonString = builder.toJson(ship);

        MockHttpServletRequestBuilder request = post("/json/test2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString);

        this.mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string("The starship is a fighter type and has 2 engines"));

    }

    @Test
    public void testRouteWithJsonFile() throws Exception {
        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder request = post("/json/test3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The pokemon is named cyndaquil and it is a fire type!"));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
