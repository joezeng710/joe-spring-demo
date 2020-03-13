package cc.joe.springboot.filter.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TimeUtils {
    public static long getTime() {
        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }
}
