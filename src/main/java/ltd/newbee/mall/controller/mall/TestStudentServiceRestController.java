package ltd.newbee.mall.controller.mall;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.entity.NewBeeMallShoppingCartItem;
import ltd.newbee.mall.entity.Student;
import ltd.newbee.mall.service.StudentService;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestStudentServiceRestController {

	@Resource
	private StudentService studentService;

	@RequestMapping(value = "/studentName", method = RequestMethod.GET)
	@ResponseBody
	public Result studentName(String name) {
		List<Student> list = studentService.getStudentListByName(name);
		if (CollectionUtils.isEmpty(list)) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(list);
		}

	}

	@RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
	@ResponseBody
	public Result insertStudent(@RequestBody Student stu) {
		long count = studentService.insertStudent(stu);
		if (count <= 0) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_INSERT_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult("挿入した");
		}
	}

	@PutMapping(value = "/student{studentId}/update")
	@ResponseBody
	public Result updateStudent(@PathVariable("studentId") Student student, HttpSession httpSession) {
		student.setId(student.getId());
          String updatResult= studentService.updateStudent(student);
		if (!ServiceResultEnum.SUCCESS.getResult().equals(updatResult)) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_INSERT_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult("更新した");
		}
	}

}
