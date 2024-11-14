package project.learnsecurity.util;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class CommonUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
