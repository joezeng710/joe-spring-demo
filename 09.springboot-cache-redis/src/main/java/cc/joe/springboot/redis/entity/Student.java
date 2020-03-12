package cc.joe.springboot.redis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 97879188746179158L;

    private String sno;
    private String name;
    private String gender;
}
