package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Collections;
import java.util.Random;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(RecordStoreController.class)

public class RecordStoreControllerTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    RecordRepository repository;

    @Test
    public void testGetAllRecordsRoute() throws Exception {
        Long id = new Random().nextLong();
        Record record = new Record();
        record.setName("Dig Me Out");
        record.setArtistName("Sleater-Kinney");
        record.setId(id);

        when(this.repository.findAll()).thenReturn(Collections.singletonList(record));

        MockHttpServletRequestBuilder request = get("/record-store/all")
                .accept(MediaType.ALL);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", equalTo("Dig Me Out")))
                .andExpect(jsonPath("$[0].artistName", equalTo("Sleater-Kinney")));
    }

    @Test
    public void testAddAlbumRoute() throws Exception {
        MockHttpServletRequestBuilder request = post("/record-store/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Nighthawks At The Diner\", \"artistName\": \"Tom Waits\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Nighthawks At The Diner")))
                .andExpect(jsonPath("$.artistName", equalTo("Tom Waits")));

        verify(this.repository).save(any(Record.class));
    }
}
