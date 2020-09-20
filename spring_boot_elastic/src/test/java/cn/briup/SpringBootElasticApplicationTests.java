package cn.briup;

import cn.briup.bean.Article;
import cn.briup.bean.Book;
import cn.briup.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootElasticApplicationTests {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    JestClient jestClient;
    @Test
    public void contextLoads() {
    }
    @Test
    public  void testElData(){
        Book book=new Book();
        book.setBookId(1004);
        book.setBookName("我的团长我的团");
        book.setAuthor("兰晓龙");
        System.out.println("suucess");
        //bookRepository.index(book);创建索引之后 可以不再使用
        bookRepository.save(book);
    }
    @Test
    public  void delete(){
        bookRepository.deleteById(1004);
        System.out.println("success");
    }
    //查所有
    @Test
    public  void findById(){
     Book book= bookRepository.findById(1001).get();
        System.out.println("success");
        System.out.println(book);

    }
    @Test
    public  void findAll(){
    Iterable<Book>  books=  bookRepository.findAll();//Iterable 迭代器
        for(Book book:books){
            System.out.println(book);
        }
    }
    @Test
    public void testFind(){
      List<Book> books =bookRepository.findByBookNameLike("呐");
      for(Book b:books){
          System.out.println(b);
      }
    }
    @Test
    public void contextJest() throws IOException {
        Article article=new Article();
        article.setId(1005);
        article.setAuthor("阿尔托莉雅");
        article.setTitle("Fate_GO");
        Index index = new Index.Builder(article).index("fate").type("zero").build();
        jestClient.execute(index);
    }
    //测试搜索
    @Test
    public void search(){

        //查询表达式
        String json ="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"title\" : \"Fate_GO\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("fate").addType("zero").build();

        //执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
