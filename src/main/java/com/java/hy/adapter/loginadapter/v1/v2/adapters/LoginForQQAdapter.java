package com.java.hy.adapter.loginadapter.v1.v2.adapters;

import com.java.hy.adapter.ResultMsg;

public class LoginForQQAdapter implements LoginAdapter {
    public Boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
