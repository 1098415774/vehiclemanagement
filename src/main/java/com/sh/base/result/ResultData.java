package com.sh.base.result;

/*
* 回传类
* */
public class ResultData {
    /*
    * 状态标志位
    * error:ResultConstant.ERROR
    * success:ResultConstant.SUCCESS
    * */
    private String state;
    //回传信息
    private String msg;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

