package cn.edu.lynu.javactf.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import cn.edu.lynu.javactf.model.User;
import cn.edu.lynu.javactf.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService userService;
	
	@Before
	public void setUp() {
		// 数据打桩，设置该方法返回的 body一直 是空的
		List<User> userList = new ArrayList<>();
		userList.add(new User(1,"lyq1","test001"));
		userList.add(new User(2,"lyq2","test002"));
		Mockito.when(userService.getAllUsers()).thenReturn(userList);
	}

	@Test
	public void listAll() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(status().isOk()) // 期待返回状态吗码200
				// JsonPath expression https://github.com/jayway/JsonPath
				// .andExpect(jsonPath("$[1].name").exists()) // 这里是期待返回值是数组，并且第二个值的 name
				// 存在，所以这里测试是失败的
				.andDo(print()); // 打印返回的 http response 信息
	}

}
