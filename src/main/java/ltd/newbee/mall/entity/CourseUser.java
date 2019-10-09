package ltd.newbee.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CourseUser {
    private Long userId;

    private String userPhone;

    private String pwdMd5;

    private String loginOnlyCode;

    private Byte locked;

    private String userFrom;

    private String remark;

    private Byte userType;

    private String userEmail;

    private String userName;

    private String avatar;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    private Date updateTime;

    private String ip1;

    private String ip2;

    private String ip3;

    private String ip4;

    private Integer pwdCount;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getPwdMd5() {
        return pwdMd5;
    }

    public void setPwdMd5(String pwdMd5) {
        this.pwdMd5 = pwdMd5 == null ? null : pwdMd5.trim();
    }

    public String getLoginOnlyCode() {
        return loginOnlyCode;
    }

    public void setLoginOnlyCode(String loginOnlyCode) {
        this.loginOnlyCode = loginOnlyCode == null ? null : loginOnlyCode.trim();
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom == null ? null : userFrom.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIp1() {
        return ip1;
    }

    public void setIp1(String ip1) {
        this.ip1 = ip1 == null ? null : ip1.trim();
    }

    public String getIp2() {
        return ip2;
    }

    public void setIp2(String ip2) {
        this.ip2 = ip2 == null ? null : ip2.trim();
    }

    public String getIp3() {
        return ip3;
    }

    public void setIp3(String ip3) {
        this.ip3 = ip3 == null ? null : ip3.trim();
    }

    public String getIp4() {
        return ip4;
    }

    public void setIp4(String ip4) {
        this.ip4 = ip4 == null ? null : ip4.trim();
    }

    public Integer getPwdCount() {
        return pwdCount;
    }

    public void setPwdCount(Integer pwdCount) {
        this.pwdCount = pwdCount;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", pwdMd5=").append(pwdMd5);
        sb.append(", loginOnlyCode=").append(loginOnlyCode);
        sb.append(", locked=").append(locked);
        sb.append(", userFrom=").append(userFrom);
        sb.append(", remark=").append(remark);
        sb.append(", userType=").append(userType);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userName=").append(userName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", ip1=").append(ip1);
        sb.append(", ip2=").append(ip2);
        sb.append(", ip3=").append(ip3);
        sb.append(", ip4=").append(ip4);
        sb.append(", pwdCount=").append(pwdCount);
        sb.append("]");
        return sb.toString();
    }
}