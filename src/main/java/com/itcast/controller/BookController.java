package com.itcast.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itcast.controller.utils.R;
import com.itcast.domain.Book;
import com.itcast.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {

        return new R(true, bookService.list());
    }

    //插入、新增数据
    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
//        R r=new R();
//        boolean b = bookService.saveBook(book);
//        r.setFlag(b);
        if (book.getName().equals("123") ) throw new IOException();
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");

    }

    //修改、更新
    @PutMapping
    public R update(@RequestBody Book book) {

        return new R(bookService.updateById(book));
        //return bookService.modify(book);
    }

    //根据id删除数据
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {

        return new R(bookService.delete(id));
    }

    //根据id查询数据
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用第一页作为当前页码值
//        if( currentPage > page.getPages()){
//            page = bookService.getPage(1, pageSize);
//        }
//        return new R(true, page);
//    }
        @GetMapping("{currentPage}/{pageSize}")
        public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        //        System.out.println("参数==>"+book);

            IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
            //如果当前页码值大于了总页码值，那么重新执行查询操作，使用第一页作为当前页码值
            if( currentPage > page.getPages()){
                page = bookService.getPage(1, pageSize,book);
            }
            return new R(true, page);
        }
}


