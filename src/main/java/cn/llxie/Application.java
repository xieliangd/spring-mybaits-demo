package cn.llxie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//根据注解还是xml配置切换MappScan路径
@SpringBootApplication
@MapperScan("cn.llxie.mapper")
//@MapperScan("cn.llxie.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
