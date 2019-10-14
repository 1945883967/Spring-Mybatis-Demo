package com.minghai.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.minghai.mybatisplusdemo.domain.User;
import com.minghai.mybatisplusdemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusDemoApplicationTests {


	@Autowired
	private UserMapper userMapper;


	@Test
	public void contextLoads() {

		System.out.println("------------selectAll method test---------------");
		List<User> userList = userMapper.selectList(null);
		userList.forEach(System.out::println);
	}

    /**
     * 添加测试
     */
	@Test
    public void insertTest(){
	    User user = new User();
	    user.setRealName("向东");
	    user.setAge(26);
	    user.setEmail("xiangman@gmail.com");
        user.setCreateTime(LocalDateTime.now());
        user.setManagerId(1088248166370832385L);

        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    /**
     * 查询
     */
	@Test
	public void selectById() {
        User user = userMapper.selectById(1087982257332887553L);
        System.out.println(user);
    }
    /**
     * 批量查询
     */
	@Test
	public void selectIds() {
        List<Long> list = Arrays.asList(1183631576357605378L, 1094590409767661570L, 1088248166370832385L);
        List<User> userList = userMapper.selectBatchIds(list);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByMap(){
	    // map.put("name","王天风")
	    // map.put("age",25)
	    // where name="王天风" and age=30
        Map<String,Object>  map = new Hashtable<>();
        map.put("name","王天风");
        map.put("age",25);

        List<User> userList = userMapper.selectByMap(map);
        userList.forEach(System.out::println);

    }

    /**
     * 条件查询
     */
	@Test
	public void contextLoads1() {
		System.out.println("------------selectAll method test---------------");
		QueryWrapper<User> wrapper = Wrappers.<User>query();
//		QueryWrapper<User> wrapper1 = new QueryWrapper<>();
        wrapper.eq("id",1087982257332887553L);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    /**
     * 查询记录数
     */
    @Test
    public void selectCount1(){
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.like("name","王");

        Integer integer = userMapper.selectCount(queryWrapper);
        System.out.println(integer);

        Integer integer1 = userMapper.selectCount(null);
        System.out.println(integer1);

    }

    /**
     * 1、名字中包含雨并且年龄小于40
     * name like '%雨%' and age < 40
     */
    @Test
    public void selectByWrapper1(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","王").lt("age",20);
    }

    /**
     * 2、名字中包含雨并且年龄大于等于20且小于等40并且email不为空
     * name like '%雨%' and age between 20 and 40 and eamil is not null
     */
    @Test
    public void selectWrapper2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","雨").between("age",20,40).isNotNull("email");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 3、名字为王姓或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列
     *  name like '王%' or age >= 25 order by age desc,id asc
     */
    @Test
    public void selectWrapper3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name","王").or().ge("age",25).orderByDesc("age").orderByAsc("id");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 4、创建日期为2019年2月14日并且直属让级为名字王姓
     * where date_format(create_time,'%Y-%m-%d') and manager_id in (select id from user where name like '王%')
     */
    @Test
    public void selectWrapper4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.apply("date_format(create_time,'%Y-%m-%d') = {0}","2019-02-14")
                .inSql("manager_id","select id from user where name like '王%'");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }
    /**
     * 5、名字为王姓并且（年龄小于40或邮箱不为空）
     * name like '王%' and (age<40 or email is not null)
     */
    @Test
    public void selectByWrapper5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name","王").and(wq -> wq.lt("age",40).or().isNotNull("email"));
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 6、名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
     * name like '王%' or (age<40 and age>20 and email is not null)
     */
    @Test
    public void selectByWrapper6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name","王").or(wq->wq.lt("age",40).gt("age",27).isNotNull("email"));
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 7、（年龄小于40或邮箱不为空）并且名字为王姓
     * (age<40 or email is not null) and name like '王%'
     */
    @Test
    public void selectByWrapper7(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.nested(wq->wq.lt("age",40).or().isNotNull("email"))
                .likeRight("name","王");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 8、年龄为30、31、34,35
     * age in(30,31,34,35)
     */
    @Test
    public void selectByWrapper8(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("age",Arrays.asList(30,31,34,35));
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 9、只返回满足条件的其中一条语句即可
     * limit 1
     */
    @Test
    public void selectByWrapper9(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.last("limit 1");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }


    /**
     * 1、名字中包含雨并且年龄小于40,只查名字和年龄
     * name like '%雨%' and age < 40
     */
    @Test
    public void selectByWrapperSuppeer1(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","雨").lt("age",40)
            .select("name","age");

        List<User> userList = userMapper.selectList(queryWrapper);

        userList.forEach(System.out::println);
    }
    /**
     * 2、名字中包含雨并且年龄小于40, 查除了创建时间和邮箱
     * name like '%雨%' and age < 40
     */
    @Test
    public void selectByWrapperSuppeer2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","雨").lt("age",40)
            .select(User.class,info-> !info.getColumn().equals("create_time") && !info.getColumn().equals("email"));

        List<User> userList = userMapper.selectList(queryWrapper);

        userList.forEach(System.out::println);
    }


    /**
     *  Condition
     */
    @Test
    public void testCondition(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
       queryWrapper.last(false,"1 !=1 ");
        List<User> userList = userMapper.selectList(queryWrapper);

        userList.forEach(System.out::println);
    }
    @Test
    public void testCondition1(){

        String name = "";// 前端传过来的
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isEmpty(name),"name",name);
        List<User> userList = userMapper.selectList(queryWrapper);

        userList.forEach(System.out::println);
    }
    @Test
    public void testCondition2(){
        User user = new User();
        user.setRealName("雨");
        user.setAge(40);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        List<User> userList = userMapper.selectList(queryWrapper);
        /*
        Preparing: SELECT id,name AS realName,create_time,manager_id,email,age
                   FROM user
                   WHERE name LIKE CONCAT('%',?,'%') AND age<?
        Parameters: 雨(String), 40(Integer)

        User :
            @TableField(value = "name",condition = SqlCondition.LIKE)
            private String realName;
            @TableField(condition = "%s&lt;#{%s}")
            private Integer age;
         */
        userList.forEach(System.out::println);
    }

}
