package cn.llxie;

import cn.llxie.domain.User;
import cn.llxie.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {


	@Autowired
	private UserMapper userMapper;

	@Test
	@Transactional
	public void test(){

		userMapper.insert((long) 91,"张三", 11);
		userMapper.insert((long) 92,"李四", 12);
		User u = userMapper.findUserByName("张三");
		System.out.println(u.toString());
	}


	@Test
	@Transactional
	public void test2(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",12);
		map.put("username","王五");
		map.put("age", 88);
		userMapper.insertByMap(map);


	}

	@Test
	@Transactional
	public void test3(){
		userMapper.insert((long) 101,"张1", 23);
		userMapper.insert((long) 102,"张2", 24);
		userMapper.insert((long) 103,"张3", 25);
		userMapper.insert((long) 104,"张4", 26);
		userMapper.insert((long) 105,"张5", 27);

		User u = userMapper.findUserByName("张1");
		System.out.println(u.toString());
		u.setUsername("张一");
		u.setAge(28);
		userMapper.update(u);

		u = userMapper.findUserByName("张2");
		userMapper.delete(u.getId());

	}

	@Test
	@Transactional
	public void test4(){
		userMapper.insert((long) 81,"张三", 114);
		userMapper.insert((long) 82,"李四", 11);

		List<User> list = userMapper.findAllUser();

		for (int i =0;i < list.size();i++){
			System.out.println(list.get(i).toString());
		}

	}




}
