package cn.roye.exception;

/**
 * 定义异常, 其中的一个参数id, 这个id 如何以json的形式传递给前台
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException(String id){
        super("user not exist!");
        this.id = id;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
