package cn.briup.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

public class MyCacheConfig {
//     <!-- fastJson json数组有关的   使用fastJson来解析json    springBoot默认配置的是Jackson -->
//        <dependency>
//			<groupId>com.alibaba</groupId>
//			<artifactId>fastjson</artifactId>
//			<version>1.2.15</version>
//		</dependency>
////    @Bean
//    public HttpMessageConverters fastJsonMassageConverter(){
//        //创建FastJson的消息转换器
//        FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
//        //创建FastJson的配置对象
//        FastJsonConfig config =  new FastJsonConfig();
//        //对Json数据进行格式化
//        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
//
//        convert.setFastJsonConfig(config);
//        HttpMessageConverter<?> con = convert;
//        return new HttpMessageConverters(con);
//    }
}
