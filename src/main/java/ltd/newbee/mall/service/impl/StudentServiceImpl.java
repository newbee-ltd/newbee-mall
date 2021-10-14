package ltd.newbee.mall.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.dao.StudentMapper;
import ltd.newbee.mall.entity.Student;
import ltd.newbee.mall.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentMapper studentMapper;

    @Override
    public ArrayList<Student> getStudentListByName(String name) {
    	return studentMapper.getStudentListByName(name);
    }
    
    @Override
    public int insertStudent(Student s) {
    	int id = studentMapper.getMaxStudentID();
    	s.setStudentId(id + 1);
    	return studentMapper.insertStudent(s);
    }
    
    @Override
    public int updateStudent(Student stu) {
    	int count = studentMapper.updateStudent(stu);
    	return count;
    	
    }
    
    @Override
    public int deleteStudent(int studentNumber) {
    	int count = studentMapper.deleteStudent(studentNumber);
    	return count;
    }
    
}
