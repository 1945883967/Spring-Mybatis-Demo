package com.minghai.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.minghai.mybatisplusdemo.domain.Book;
import com.minghai.mybatisplusdemo.mapper.BookMapper;
import com.minghai.mybatisplusdemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTestBook {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testInsertBook(){
        Book book = new Book();
        book.setAuthor("金庸");
        book.setBookName("笑傲江湖");
        book.setPrice(25.0D);
        book.setPublishDate(LocalDateTime.now());

        bookMapper.insert(book);
    }



    //删除书籍
    //id值不存在则不能删除
    @Test
    public void deleteBookById(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",1);

        bookMapper.delete(queryWrapper);
    }
    //查找书籍
    //通过名字
    @Test
    public void selectBookByName(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_name","笑傲江湖");

        Book book = bookMapper.selectOne(queryWrapper);
        System.out.println(book);
    }
    //查找书籍
    //通过id
    @Test
    public void selectBookById(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",5);

        Book book = bookMapper.selectOne(queryWrapper);
        System.out.println(book);
    }
    //查找所有书籍
    @Test
    public void selectBooks(){
        List<Book> books = bookMapper.selectList(null);
        books.forEach(System.out::println);

    }
    //查找所有书籍的名字
    @Test
    public void selectBookName(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("book_name");
        List<Book> books = bookMapper.selectList(queryWrapper);
        books.forEach(System.out::println);

    }
    //查找一共有多少本书籍
    @Test
    public void selectBookCount(){
        Integer integer = bookMapper.selectCount(null);
        System.out.println(integer);
    }
    //修改书籍
    //通过id确定修改的是那本书
    @Test
    public void updateBookById(){
        Book book = new Book();
        book.setId(5);
        book.setPrice(1000D);

        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",book.getId());

        bookMapper.update(book,queryWrapper);
    }

    //查询所有书籍的名字和对应的作者
    @Test
    public void selectNamesAndAuthor(){
        QueryWrapper<Book> queryWrapper = Wrappers.query();
        queryWrapper.select("book_name","author");

        List<Book> books = bookMapper.selectList(queryWrapper);

        for (Book book : books) {
            System.out.println(book.getBookName()+" "+ book.getAuthor());
        }


    }

}
