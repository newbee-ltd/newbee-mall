/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.dao.StudentMapper;

import ltd.newbee.mall.entity.Student;

import ltd.newbee.mall.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
		long id = StudentMapper.getMaxStudentId();
		stu.setId(id + 1);
		return studentMapper.insertStudent(stu);
	}

}
