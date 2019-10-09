package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.CourseUser;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(CourseUser record);

    int insertSelective(CourseUser record);

    CourseUser selectByPrimaryKey(Long userId);

    CourseUser selectByLoginOnlyCode(String loginOnlyCode);

    CourseUser selectByPhoneAndPwd(@Param("phone") String phone, @Param("pwdMd5") String pwdMd5);

    CourseUser selectByPhone(String phone);

    CourseUser selectByEmailAndPwd(@Param("email") String email, @Param("pwdMd5") String pwdMd5);

    CourseUser selectByEmail(String email);

    int updateByPrimaryKeySelective(CourseUser record);

    int updateByPrimaryKey(CourseUser record);

    List<CourseUser> findCourseUserList(PageQueryUtil pageUtil);

    int getTotalCourseUsers(PageQueryUtil pageUtil);

    int updateUserToken(@Param("userId") Long userId, @Param("newToken") String newToken);
}