package cn.briup;

import cn.briup.cache.Mapper.IEmployeeMapper;
import cn.briup.cache.bean.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@SpringBootTest
class SpringBootCache01ApplicationTests {
    @Autowired
    IEmployeeMapper employeeMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {

    }
    @Test
    void Test01() {
        //list  操作
//    stringRedisTemplate.opsForList().leftPush("userlist","xia");
//    stringRedisTemplate.opsForList().leftPush("userlist","yu");
//      stringRedisTemplate.opsForValue().append("userId","10001");
//       List<String> lists= stringRedisTemplate.opsForList().range("userlist",0,1);  获取键值
//       for (String c:lists){
//           System.out.println(c);
//       }
        /*
        Employee empById = employeeMapper.getEmpById(1);
		//默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
		//redisTemplate.opsForValue().set("emp-01",empById);
		//1、将数据以json的方式保存
		 //(1)自己将对象转为json
		 //(2)redisTemplate默认的序列化规则；改变默认的序列化规则；
		empRedisTemplate.opsForValue().set("emp-01",empById);
         */
    }
}
