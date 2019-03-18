package com.java.hy.adapter.loginadapter.v1.v2;

import com.java.hy.adapter.ResultMsg;
import com.java.hy.adapter.loginadapter.v1.v1.SiginService;
import com.java.hy.adapter.loginadapter.v1.v2.adapters.*;

/**
 * 原有注册登录不动兼容老代码
 */
public class IPassportForThirdAdapter extends SiginService implements IPassportForThird {
    public ResultMsg loginForQQ(String id) {
        return processLogin(id,LoginForQQAdapter.class);
    }

    public ResultMsg loginForWechat(String id) {
        return processLogin(id, LoginForWechatAdapter.class);
    }

    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    public ResultMsg loginForTelphone(String telphone, String code) {
        return processLogin(telphone, LoginForPhoneAdapter.class);
    }
    //用到父类的注册登录老代码的方法,符合开闭原则
    public ResultMsg loginForRegist(String username, String passport) {
        super.regist(username,passport);
        return super.login(username,passport);
    }
    //用到了简单工厂和策略
    public ResultMsg processLogin(String key,Class<? extends LoginAdapter> clazz){
            try {
                LoginAdapter loginAdapter = clazz.newInstance();
                if (loginAdapter.support(loginAdapter)){
                    ResultMsg login = loginAdapter.login(key, loginAdapter);
                    return login;
                }else{
                    return null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
    }
}
