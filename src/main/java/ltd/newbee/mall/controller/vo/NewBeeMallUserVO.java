package ltd.newbee.mall.controller.vo;

import java.io.Serializable;

public class NewBeeMallUserVO implements Serializable {

    private Long userId;

    private String nickName;

    private String loginName;

    private String introduceSign;

    private String address;

    private int shopCartItemCount;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getIntroduceSign() {
        return introduceSign;
    }

    public void setIntroduceSign(String introduceSign) {
        this.introduceSign = introduceSign;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getShopCartItemCount() {
        return shopCartItemCount;
    }

    public void setShopCartItemCount(int shopCartItemCount) {
        this.shopCartItemCount = shopCartItemCount;
    }
}
