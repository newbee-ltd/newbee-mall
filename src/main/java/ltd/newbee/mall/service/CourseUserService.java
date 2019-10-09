package ltd.newbee.mall.service;

import ltd.newbee.mall.util.PageResult;
import ltd.newbee.mall.entity.CourseUser;
import ltd.newbee.mall.util.PageQueryUtil;

public interface CourseUserService {
    /**
     * 根据手机号或者邮箱登陆
     *
     * @param loginString
     * @param pwdString
     * @return
     */
    String login(String loginString, String pwdString);

    /**
     * 修改密码
     *
     * @param onlyCode
     * @param originalPwd
     * @param newPwd
     * @param confirmPwd
     * @return
     */
    String changePwd(String onlyCode, String originalPwd, String newPwd, String confirmPwd);

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getCourseUsersPage(PageQueryUtil pageUtil);

    String saveCourseUser(CourseUser courseUser);

    String updateCourseUser(CourseUser courseUser);

    CourseUser getCourseUserById(Long id);

    CourseUser getCourseUserByOnlyCode(String onlyCode);

    String lockUser(Long userId);
}
