package cn.roye.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

public class User {

    private String username;

    // 不能为null, 并且size > 0
    @NotEmpty
    private String age;

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
