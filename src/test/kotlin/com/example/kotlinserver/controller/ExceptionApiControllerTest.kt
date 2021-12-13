package com.example.kotlinserver.controller

import com.example.kotlinserver.model.UserInformation
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

import org.springframework.util.LinkedMultiValueMap


@WebMvcTest
@AutoConfigureMockMvc
class ExceptionApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun getTest(){
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("name", "abc")
        queryParams.add("age", "10")
        mockMvc.perform(
            //MockMvcRequestBuilders.get("/api/exception?name=abc&age=10")
            MockMvcRequestBuilders.get("/api/exception").queryParams(queryParams)
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andExpect(
            MockMvcResultMatchers.content().string("abc 10")
        ).andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun getFailTest(){
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("name", "abcdsa12")
        queryParams.add("age", "4")
        mockMvc.perform(
            //MockMvcRequestBuilders.get("/api/exception?name=abc&age=10")
            MockMvcRequestBuilders.get("/api/exception").queryParams(queryParams)
        ).andExpect(
            MockMvcResultMatchers.status().isBadRequest
        ).andExpect(
            //MockMvcResultMatchers.content().string("abc 10")
            MockMvcResultMatchers.content().contentType("application/json")
        ).andExpect(
            jsonPath("\$.result_code").value("FAIL")
        ).andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun postTest(){
        val userInformation = UserInformation().apply {
            this.name = "abc"
            this.age = 10
            this.phone_number ="010-1234-1234"
            this.email = "abc@gmail.com"
            this.created_at = "2021-12-12 13:00:00"
        }

        val json = jacksonObjectMapper().writeValueAsString(userInformation)
        println(json)

        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/post/object")
                .content(json)
                .contentType("application/json")
                .accept("application/json")
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andExpect(
            jsonPath("\$.name").value("abc")
        ).andExpect(
            jsonPath("\$.age").value("10")
        ).andExpect(
            jsonPath("\$.email").value("abc@gmail.com")
        ).andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun postFailTest(){
        val userInformation = UserInformation().apply {
            this.name = "abcbdbds"
            this.age = -1
            this.phone_number ="010-1234-1234"
            this.email = "abc@gmail.com"
            this.created_at = "2021-12-12 13:00:00"
        }

        val json = jacksonObjectMapper().writeValueAsString(userInformation)
        println(json)

        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/post/object")
                .content(json)
                .contentType("application/json")
                .accept("application/json")
        ).andExpect(
            MockMvcResultMatchers.status().isBadRequest
        ).andDo(MockMvcResultHandlers.print())
    }
}