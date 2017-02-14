package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EndpointsController.class)

public class EndpointsControllerTests {
    @Autowired
    private MockMvc mvc;


    @Test
    public void testTasksGetEndpoint() throws Exception {
        this.mvc.perform(get("/tasks").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("These are the tasks!"));
    }

    @Test
    public void testTasksPostEndpoint() throws Exception {
        this.mvc.perform(post("/tasks").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("You just POSTed to tasks, babycakes!"));
    }

    @Test
    public void testTablesPostEndpoint() throws Exception {
        this.mvc.perform(post("/tables/new").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("You just POSTed a... table. That's cool, I guess."));
    }

    @Test
    public void testTablesDeleteEndpoint() throws Exception {
        this.mvc.perform(delete("/tables/delete").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("You deleted the H*CK out of that table, brah!"));
    }

    @Test
    public void testQuery1Endpoint() throws Exception {
        this.mvc.perform(get("/query1?awesome=true").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("This response is awesome: true"));
    }

    @Test
    public void testQuery2Endpoint() throws Exception {
        this.mvc.perform(get("/query2?taste=yummy&price=99").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("{taste=yummy, price=99}"));
    }

    @Test
    public void testQuery3Endpoint() throws Exception {
        this.mvc.perform(get("/query3?race=dwarf&job=cleric&hp=78").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("{race=dwarf, job=cleric, hp=78}"));
    }
}
