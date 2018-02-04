package cn.roye.domain;

/**
 * 返回的消息体；
 */
public class ResultObj {
    private String code;
    private String msg;
    private Object data;

    // 正常情况下的快捷键是 alt + insert
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
