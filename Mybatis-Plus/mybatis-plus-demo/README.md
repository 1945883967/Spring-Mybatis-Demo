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