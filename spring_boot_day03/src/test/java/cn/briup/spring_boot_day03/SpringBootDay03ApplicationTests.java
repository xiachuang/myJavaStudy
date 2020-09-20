package cn.briup.spring_boot_day03;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDay03ApplicationTests {
//日志的使用
    Logger log= LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        //日志的级别 由低到高trace<debug<info<warn<erro
        log.trace("这是日志");
        log.debug("这是debug日志");
        log.info("这是info信息");
        log.warn("这是警告日志");
        log.error("这是错误日志");

    }

}
