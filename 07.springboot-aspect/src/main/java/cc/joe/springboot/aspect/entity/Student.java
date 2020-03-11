package cc.joe.springboot.aspect.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -1287816911035312215L;

    private String sno;

    private String name;

    private String gender;
}