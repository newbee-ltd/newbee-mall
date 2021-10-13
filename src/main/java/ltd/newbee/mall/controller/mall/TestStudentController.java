

package ltd.newbee.mall.controller.mall;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import ltd.newbee.mall.entity.Student;
import ltd.newbee.mall.service.StudentService;


@SpringBootTest(classes = SpringApplication.class)
public class TestStudentController {

	// 用以下注解导入Service
	@Resource
	StudentService studentService;

	String name = "三";
	String name1 = "张三一";
	String name2 = "李三二";

	@Test
	public void testStudentService() {
		ArrayList<Student> list = studentService.getStudentListByName(name);
		if (list != null && !list.isEmpty()) {
			assertEquals(2, list.size());
		}

	}

}

