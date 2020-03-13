package cc.joe.springboot.swagger2.service;


import cc.joe.springboot.swagger2.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {
    private Map<Long,User> userMapper= new HashMap<>();
    private static User[] users = {
            User.builder().id(Long.valueOf(1)).name("joejoe").age(15).build(),
            User.builder().id(Long.valueOf(2)).name("scott").age(17).build(),
            User.builder().id(Long.valueOf(3)).name("harry").age(22).build(),
            User.builder().id(Long.valueOf(4)).name("august").age(25).build()
    };
    public UserService() {
        init();
    }

    private void init() {
        for (int i = 0; i < users.length; i++) {
            this.add(users[i]);
        }
    }

    public User add(User user) {

        userMapper.put(user.getId(), user);
        return user;
    }

    public User get(long id) {
        return userMapper.get(id);
    }

    public User update(User user) {
        if ( userMapper.get(user.getId()) != null) {
            return this.add(user);
        }
        return null;
    }

    public User delete(Long id) {
        User user = userMapper.get(id);
        if (user != null) {
            userMapper.remove(id);
        }
        return user;
    }

    public List<User> getUserList() {
        List<User> users = userMapper.values().stream().collect(Collectors.toList());
        return users;
    }
}
