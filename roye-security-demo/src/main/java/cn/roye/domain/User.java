package cn.roye.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Past;
import java.util.Date;

public class User {

    private String username;

    // 不能为null, 并且size > 0
    @NotEmpty(message = "年龄不能为空")
    private String age;

    // 代表过去的一个时间
    @Past(message = "生日必须是过去的时间")
    private Date birthday;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
