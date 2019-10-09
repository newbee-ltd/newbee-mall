package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.dao.CourseUserMapper;
import ltd.newbee.mall.service.CourseUserService;
import ltd.newbee.mall.util.*;
import ltd.newbee.mall.entity.CourseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CourseUserServiceImpl implements CourseUserService {
    @Autowired
    private CourseUserMapper courseUserMapper;

    @Override
    public String login(String loginString, String pwdString) {
        if (StringUtils.isEmpty(loginString)) {
            return "登陆信息不能为空";
        }
        if (StringUtils.isEmpty(pwdString)) {
            return "登陆密码不能为空";
        }
        if (!PatternUtil.validKeyword(pwdString)) {
            return "登陆密码输入不规范";
        }
        String pwdMd5 = MD5Util.MD5Encode(pwdString, "UTF-8");
        CourseUser courseUser = null;
        if (loginString.contains("@")) {
            courseUser = courseUserMapper.selectByEmailAndPwd(loginString, pwdMd5);
        } else {
            courseUser = courseUserMapper.selectByPhoneAndPwd(loginString, pwdMd5);
        }
        if (courseUser == null) {
            return "FAIL";
        } else {
            //更新onlyCode
            //登录后即执行修改token的操作
            String token = getNewToken(System.currentTimeMillis() + "", courseUser.getUserId());
            //登陆成功
            if (courseUserMapper.updateUserToken(courseUser.getUserId(), token) > 0) {
                //返回数据时带上token
                return token;
            }
        }
        return "FAIL";
    }

    @Override
    public String changePwd(String onlyCode, String originalPwd, String newPwd, String confirmPwd) {
        if (StringUtils.isEmpty(originalPwd)) {
            return "原密码不能为空";
        }
        if (StringUtils.isEmpty(newPwd)) {
            return "新密码不能为空";
        }
        if (StringUtils.isEmpty(confirmPwd)) {
            return "确认密码不能为空";
        }
        if (!PatternUtil.validKeyword(originalPwd)) {
            return "原密码输入不规范";
        }
        if (!PatternUtil.validKeyword(newPwd)) {
            return "新密码输入不规范";
        }
        if (!PatternUtil.validKeyword(confirmPwd)) {
            return "确认密码输入不规范";
        }
        if (!newPwd.equals(confirmPwd)) {
            return "确认密码有误";
        }
        if (newPwd.equals(originalPwd)) {
            return "新密码不能与原密码相等";
        }
        CourseUser courseUser = courseUserMapper.selectByLoginOnlyCode(onlyCode);
        if (courseUser == null) {
            return "参数异常";
        }
        if (!MD5Util.MD5Encode(originalPwd, "UTF-8").equals(courseUser.getPwdMd5())) {
            return "原密码错误";
        }
        if (courseUser.getPwdCount() > 3) {
            return "密码修改频繁，请联系站长进行修改";
        }
        courseUser.setPwdCount(courseUser.getPwdCount() + 1);
        courseUser.setPwdMd5(MD5Util.MD5Encode(newPwd, "UTF-8"));
        if (courseUserMapper.updateByPrimaryKeySelective(courseUser) > 0) {
            return "SUCCESS";
        }
        return "修改失败";
    }

    @Override
    public PageResult getCourseUsersPage(PageQueryUtil pageUtil) {
        List<CourseUser> users = courseUserMapper.findCourseUserList(pageUtil);
        int total = courseUserMapper.getTotalCourseUsers(pageUtil);
        PageResult pageResult = new PageResult(users, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String saveCourseUser(CourseUser courseUser) {
        if (courseUserMapper.selectByPhone(courseUser.getUserPhone()) != null) {
            return "手机号已注册";
        }
        if (courseUserMapper.selectByEmail(courseUser.getUserEmail()) != null) {
            return "邮箱已注册";
        }
        //默认密码
        courseUser.setPwdMd5(MD5Util.MD5Encode("123456", "UTF-8"));
        if (courseUserMapper.insertSelective(courseUser) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return "保存失败";
    }

    @Override
    public String updateCourseUser(CourseUser courseUser) {
        CourseUser tempUser = courseUserMapper.selectByPrimaryKey(courseUser.getUserId());
        if (tempUser == null) {
            return "参数非法";
        }
        //比较手机号和邮箱
        if (!courseUser.getUserPhone().equals(tempUser.getUserPhone())) {
            //改手机号了
            if (courseUserMapper.selectByPhone(courseUser.getUserPhone()) != null) {
                return "手机号已注册";
            }
        }
        if (!courseUser.getUserEmail().equals(tempUser.getUserEmail())) {
            //改邮箱了
            if (courseUserMapper.selectByEmail(courseUser.getUserEmail()) != null) {
                return "邮箱已注册";
            }
        }
        if (courseUserMapper.updateByPrimaryKeySelective(courseUser) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return "保存失败";
    }

    @Override
    public CourseUser getCourseUserById(Long id) {
        return courseUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public CourseUser getCourseUserByOnlyCode(String onlyCode) {
        return courseUserMapper.selectByLoginOnlyCode(onlyCode);
    }

    @Override
    public String lockUser(Long userId) {
        CourseUser tempUser = courseUserMapper.selectByPrimaryKey(userId);
        if (tempUser != null && tempUser.getLocked().intValue() == 0) {
            tempUser.setLocked(((byte) (1)));
            if (courseUserMapper.updateByPrimaryKeySelective(tempUser) > 0) {
                return ServiceResultEnum.SUCCESS.getResult();
            }
        }
        return "操作失败";
    }

    /**
     * 获取token值
     *
     * @param timeMillis
     * @param userId
     * @return
     */
    private String getNewToken(String timeMillis, Long userId) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(timeMillis).append("_").append(userId).append("_").append(NumberUtil.genRandomNum(4));
        return SystemUtil.genToken(stringBuffer.toString());
    }
}
