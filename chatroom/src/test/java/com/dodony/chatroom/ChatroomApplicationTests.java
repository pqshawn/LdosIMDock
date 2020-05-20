package com.dodony.chatroom;

import com.dodony.chatroom.web.HelloController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ChatroomApplicationTests {
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Before
//	public void setUp() throws Exception {
//		mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
//	}
//	@Test
//	public void getHello() throws Exception {
//		System.out.println("getHellow!!!");
//
//
//		mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=⼩小明")
//				.accept(MediaType.APPLICATION_JSON_UTF8))/*.andDo(print())*/
//				.andDo(print());
//	}


}
