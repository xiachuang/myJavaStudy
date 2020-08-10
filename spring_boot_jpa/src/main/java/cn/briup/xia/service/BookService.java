package cn.briup.xia.service;

import cn.briup.xia.baen.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface BookService {
    public Page<Book> findByAll(int page, int size);
    public Book findBookById(Integer id);
    public Boolean insertBook(Book book);
    public Boolean updateBookById(Book book,Integer id);
    public Boolean deleteBookById(Integer id);

}
