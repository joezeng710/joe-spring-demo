package cc.joe.springboot.aspect.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysLog implements Serializable {

    private static final long serialVersionUID = 5507738495116386484L;

    private Integer id;
    private String username;
    private String operation;
    private Integer responseTime;
    private String method;
    private String params;
    private String ip;
    private Date createTime;
}
