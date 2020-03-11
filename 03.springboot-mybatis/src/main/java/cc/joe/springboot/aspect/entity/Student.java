package cc.joe.springboot.aspect.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private static final long serialVersionUID = -1690789056521244812L;

    private String sno;
    private String name;
    private String gender;
}
