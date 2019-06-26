package cn.edu.lynu.javactf.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.lynu.javactf.JavaCtfApplication;
import cn.edu.lynu.javactf.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JavaCtfApplication.class)
public class UserServiceTest {
	@Autowired
    private UserService userService;
    private User user;
    
    @Before
    public void before() throws Exception{
    	user = new User(1,"lyq1","test1");
    }
    
    @After
    public void after() throws Exception{
    }
    
    @Test
    public void insertUser() throws Exception {
        userService.save(user);
        System.out.println(user);
    }
}
