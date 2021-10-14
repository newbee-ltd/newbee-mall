/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.dao.StudentMapper;
import ltd.newbee.mall.entity.Student;
import ltd.newbee.mall.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public ArrayList<Student> getStudentListByName(String name) {
		// ArrayList<Student> list = studentMapper.getStudentListbyName(name);
		return studentMapper.getStudentListByName(name);
	}

	@Override
	public long insertStudent(Student stu) {
		long id = studentMapper.getMaxStudentId();
		stu.setId(id + 1);
		return studentMapper.insertStudent(stu);
	}

	/*
	 * @Override public String updateStudent(Student student) { Student temp =
	 * studentMapper.selectByStudentId(student.getId()); if (temp == null) { return
	 * ServiceResultEnum.DATA_NOT_EXIST.getResult(); }
	 * 
	 * temp.setName(student.getName()); temp.setAge(student.getAge());
	 * temp.setGender(student.getGender()); temp.setLocation(student.getLocation());
	 * temp.setNativePlace(student.getNativePlace()); temp.setTEL(student.getTEL());
	 * temp.setTotalScore(student.getTotalScore());
	 * temp.setClassName(student.getClassName());
	 * temp.setRanking(student.getRanking());
	 * temp.setBlacklist(student.getBlacklist());
	 * temp.setPhysical(student.getPhysical());
	 * temp.setChemistry(student.getChemistry());
	 * temp.setBiological(student.getBiological());
	 * 
	 * if (studentMapper.updateByStudentIdSelective(temp) > 0) { return
	 * ServiceResultEnum.SUCCESS.getResult(); } return
	 * ServiceResultEnum.DB_ERROR.getResult(); }
	 */

	@Override
	public int updateStudent(Student student) {
		return studentMapper.updateStudent(student);
	}


	@Override
	public Boolean deleteStudentById(long id) {
		return studentMapper.deleteByStudentId(id) > 0;
	}

}
