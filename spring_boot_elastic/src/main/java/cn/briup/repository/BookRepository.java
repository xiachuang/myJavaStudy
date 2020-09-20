package cn.briup.repository;

import cn.briup.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
@Component
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    public List<Book> findByBookNameLike(String bookName);
//    public Book findBookByBookId(Integer id);

}

