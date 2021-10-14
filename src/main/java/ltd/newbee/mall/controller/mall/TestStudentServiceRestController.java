package ltd.newbee.mall.controller.mall;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.entity.Student;
import ltd.newbee.mall.service.StudentService;
import ltd.newbee.mall.util.ResultGenerator;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;


@Controller
public class TestStudentServiceRestController {

    @Resource
    private StudentService studentService;
    
    @RequestMapping(value = "/studentName", method = RequestMethod.GET)
    @ResponseBody
    public Result studentName(@RequestParam String name) {
    	
    	List<Student> list = studentService.getStudentListByName(name);
    	if (CollectionUtils.isEmpty(list)) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(list);
    	}
    }
    
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    @ResponseBody
    public Result insertStudent(@RequestBody Student s) {
    	
    	int count = studentService.insertStudent(s);
    	if (count <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult("挿入できました.");
    	}
    }
    
    @PutMapping(value = "/student/{studentId}")
    @ResponseBody
    public Result updateStudent(@PathVariable("studentID") Student stu) {
    	
    	int countUpdateStudent = studentService.updateStudent(stu);
    	if (countUpdateStudent <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult("更新できました.");
    	}
    }

    @DeleteMapping("/student/{studentId}")
    @ResponseBody
    public Result deleteStudent(@PathVariable("studentID") int studentNumber) {
    	
    	int countDeleteStudent = studentService.deleteStudent(studentNumber);
    	if (countDeleteStudent <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult("削除できました.");
    	}
    }
   
}