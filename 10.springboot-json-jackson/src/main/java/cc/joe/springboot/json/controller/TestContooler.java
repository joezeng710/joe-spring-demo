package cc.joe.springboot.json.controller;

import cc.joe.springboot.json.entity.User;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@Controller
public class TestContooler {

    @Autowired
    private ObjectMapper mapper;

    @JsonView(User.AllUserFieldView.class)
    @GetMapping("getUser")
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setUsername("joe");
        user.setBirthday(new Date());
        return user;
    }

    @GetMapping("serialization")
    @ResponseBody
    public String serialization() {
        try {
            User user = new User();
            user.setUsername("joe");
            user.setBirthday(new Date());
            String str = mapper.writeValueAsString(user);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping("readjsonstring")
    @ResponseBody
    public String readJsonString() {
        try {
            String json = "{\"name\":\"joe\",\"age\":26}";
            JsonNode node = this.mapper.readTree(json);
            String name = node.get("name").asText();
            int age = node.get("age").asInt();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    @GetMapping("readcascadenode")
    @ResponseBody
    public String readCascadeNode() {
        try {
            String json = "{\"name\":\"mrbird\",\"hobby\":{\"first\":\"sleep\",\"second\":\"eat\"}}";

            JsonNode node = this.mapper.readTree(json);
            JsonNode hobby = node.get("hobby");
            String s = hobby.get("first").asText();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    @GetMapping("readjsonobject")
    @ResponseBody
    public String readJsonObject() {
        try {
            String json = "{\"user-name\":\"joe\",\"age\":26}";
            User node = this.mapper.readValue(json, User.class);
            String s = node.getUsername();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping("customize")
    @ResponseBody
    public String customize() throws JsonProcessingException {
        String jsonStr = "[{\"username\":\"mrbird\",\"age\":26},{\"username\":\"scott\",\"age\":27}]";
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, User.class);
        List<User> list = mapper.readValue(jsonStr, type);
        String msg = "";
        for (User user : list) {
            msg += user.getUsername();
        }
        return msg;
    }
}
