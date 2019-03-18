package com.java.hy.adapter.loginadapter.v1.v2.adapters;

import com.java.hy.adapter.ResultMsg;

public interface LoginAdapter {

     Boolean support(Object adapter);

     ResultMsg login(String id,Object adapter);
}
