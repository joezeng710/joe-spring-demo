package cc.joe.springboot.swagger2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@ApiModel(description = "订单查询请求数据")
public class User implements Serializable {

    private static final long serialVersionUID = -4918672655990961534L;

    @ApiModelProperty(value = "用户id", example = "1")
    private Long id;
    private String name;
    private int age;
}
