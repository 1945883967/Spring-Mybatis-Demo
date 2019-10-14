# Mybatis-Plus 笔记

## Mybatis-Plus 中的注解

**@TableName**
+ 作用：当实体名与数据库表名不同时，指定数据库表名
+ 用法：在实体上加注解，指定表名 @TableName("mp_user")

**@TableId**
+ 作用：指定实体属性为 id 

**@TableField**
+ 作用：指定实体中的属性对应的表中的列名

**排除实体中的字段**
+ 方法一：使用关键字 transient 修饰
+ 方法二：使用关键字 static 修饰
+ 方法三：使用注解 @TableField(exist = false) 表示不是数据库中的字段


**条件查询**
+ 使用 QueryWrapper 类的方法加条件
+ 使用 QueryWrapper 的构造器 `public QueryWrapper(T entity)`,传入的值默认等于。也可以自己指定
    + ```java
      // 实体类
      @Data
      public class User {
        @TableId
        private Long id;
        @TableField(value = "name",condition = SqlCondition.LIKE)
        private String realName;
        @TableField(condition = "%s&lt;#{%s}")
        private Integer age;
      }
      
      // 测试类
      User user = new User();
      user.setRealName("雨");
      user.setAge(40);
      QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
      List<User> userList = userMapper.selectList(queryWrapper);
      /* Sql
      Preparing: SELECT id,name AS realName,create_time,manager_id,email,age 
               FROM user 
               WHERE name LIKE CONCAT('%',?,'%') AND age<? 
      Parameters: 雨(String), 40(Integer)
     */
      ```
**注意**：构造器中传入的，与用方法加的条件互补影响，两个会同时存在。（不建议同时使用）

