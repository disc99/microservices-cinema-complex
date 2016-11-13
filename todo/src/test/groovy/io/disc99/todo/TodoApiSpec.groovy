package io.disc99.todo

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.ResultActions
import org.springframework.web.context.WebApplicationContext

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoApiSpec extends Specification {

    @Autowired
    WebApplicationContext wac

    @Shared MockMvc mockMvc

    def setup() {
        mockMvc = webAppContextSetup(wac).build()
    }

    def "todo life cycle"() {
        expect:
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath('$').isEmpty())

        String json = mockMvc.perform(post("/add").contentType(APPLICATION_JSON).content('{"doing":"fix test"}'))
                .andExpect(status().isCreated())
                .andExpect(jsonPath('$.id').exists())
                .andReturn().getResponse().getContentAsString()

        String id = new ObjectMapper().readValue(json, Map).get("id")
        println id

        mockMvc.perform(get("/todos/${id}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath('$.id').value(id))
                .andExpect(jsonPath('$.doing').value("fix test"))

        mockMvc.perform(put("/modify").contentType(APPLICATION_JSON).content('{"id":"'+id+'", "doing":"check text"}'))
                .andExpect(status().isOk())

        mockMvc.perform(get("/todos/${id}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath('$.id').value(id))
                .andExpect(jsonPath('$.doing').value("check text"))

        mockMvc.perform(post("/do").contentType(APPLICATION_JSON).content('{"id":'+id+'}'))
                .andExpect(status().isNoContent())

        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath('$').isEmpty())
    }

    def "todo validation"() {
        // TODO
    }

    def "todo error"() {
        expect:
        mockMvc.perform(get("/todos/xxxx-xxx"))
                .andExpect(status().isNotFound())


    }

}