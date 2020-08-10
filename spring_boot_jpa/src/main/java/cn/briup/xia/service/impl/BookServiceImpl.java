package cn.briup.xia.service.impl;

import cn.briup.xia.baen.Book;
import cn.briup.xia.exception.MyException;
import cn.briup.xia.repository.BookRepository;
import cn.briup.xia.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Page<Book> findByAll(int page,int size) {
        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(page,size);//该了
        Page<Book> pages=bookRepository.findAll(pageable);
        return pages;
    }

    @Override
    public Book findBookById(Integer id) {
     Optional<Book> book= bookRepository.findById(id);
     if(book.isPresent()){
         return book.get();
     }else{
         throw new  MyException();
     }

    }

    @Override
    @Transactional
    @Rollback(false)
    public Boolean insertBook(Book book) {
        Book book1=bookRepository.save(book);
        Boolean bl=false;
        if(book1!=null){
            bl=true;
        }
        return bl;
    }

    @Override
    @Transactional
    @Rollback(false)
    public Boolean updateBookById(Book book, Integer id)  {
       Book book1= bookRepository.findById(id).get();
       if(book.getBookName()!=null){
           book1.setBookName(book.getBookName());
       }else if(book.getBookWriter()!=null){
           book1.setBookWriter(book.getBookWriter());
       }
       bookRepository.save(book1);
       Boolean bl=true;
       return bl;
    }

    @Override
    @Transactional
    @Rollback(false)
    public Boolean deleteBookById(Integer id) {
        bookRepository.deleteById(id);
        Boolean bl=true;
        return bl;
    }
}
