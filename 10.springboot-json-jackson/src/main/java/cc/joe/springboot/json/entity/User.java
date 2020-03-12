package cc.joe.springboot.json.entity;

import cc.joe.springboot.json.serialize.UserDeserializer;
import cc.joe.springboot.json.serialize.UserSerializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data

public class User implements Serializable {

    public interface UserNameView {};
    public interface AllUserFieldView extends UserNameView {};

    private static final long serialVersionUID = 7429532814435042919L;

    @JsonView(UserNameView.class)
    private String username;

    @JsonView(AllUserFieldView.class)
    private String password;

    @JsonView(AllUserFieldView.class)
    private int age;

    @JsonView(AllUserFieldView.class)
    @JsonProperty("birthDay")
    @JsonFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private Date Birthday;
}
