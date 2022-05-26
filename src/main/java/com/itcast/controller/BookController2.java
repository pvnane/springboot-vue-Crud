package com.itcast.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.itcast.domain.Book;
import com.itcast.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookService bookService;
    @GetMapping
    public List<Book> getAll(){

        return bookService.list();
    }
    //插入、新增数据
    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.saveBook(book);
    }
   //修改、更新
    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.updateById(book);
        //return bookService.modify(book);
    }
    //根据id删除数据
    @DeleteMapping("/{id}")
    public  Boolean  delete(@PathVariable Integer id){

        return bookService.delete(id);
    }
    //根据id查询数据
    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        IPage<Book> page = bookService.getPage(currentPage, pageSize);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if( currentPage > page.getPages()){
//            page = bookService.getPage((int)page.getPages(), pageSize);
//        }
        //return new R(true, page);
        return page;
    }

}
