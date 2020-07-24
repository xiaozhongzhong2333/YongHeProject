package com.zb.pojo;

/**
 * 自定义返回类型
 */
public class JsonResult {
    Integer code;
    String msg;
    Integer count;
    Object data;

    public JsonResult(Integer code, String msg, Integer count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

   
}
