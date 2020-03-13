package cc.joe.springboot.exception.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserNotExistException extends RuntimeException {

    private static final long serialVersionUID = 300745319277475538L;

    private String id;

    public UserNotExistException(String id) {
        super("user " + id + " does not exist");
        this.id = id;
    }


}
