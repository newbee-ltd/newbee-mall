package ltd.newbee.mall.controller.mall;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import org.springframework.web.bind.annotation.RequestMapping;

import ltd.newbee.mall.common.Constants;
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

}
