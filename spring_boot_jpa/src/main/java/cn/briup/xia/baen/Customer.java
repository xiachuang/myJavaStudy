package cn.briup.xia.baen;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;

import java.util.Set;

@Entity
@Table(name ="customer")
public class Customer  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private  Integer id;
    @Column(name = "cust_name")
    private  String custName;
    @Column(name = "cust_way")
    private String  custWay;
    @ManyToMany(targetEntity = Comic.class,cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinTable(name = "sys_cust_comic",joinColumns = {@JoinColumn(name = "sys_cust_id",referencedColumnName = "cust_id")},
            inverseJoinColumns = {@JoinColumn(name="sys_comic_id",referencedColumnName = "comic_id")})
   @NotFound(action= NotFoundAction.IGNORE)
    private Set<Comic> comics=new HashSet<>();
    @ManyToMany(targetEntity = Book.class,cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinTable(name = "sys_cust_book",joinColumns = {@JoinColumn(name = "sys_cust_id",referencedColumnName = "cust_id")},
            inverseJoinColumns = {@JoinColumn(name="sys_book_id",referencedColumnName = "book_id")})
   @NotFound(action= NotFoundAction.IGNORE)
    private Set<Book> books=new HashSet<>();
    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cust_user_id",referencedColumnName = "user_id")
    @NotFound(action= NotFoundAction.IGNORE)
    private  User user;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }



    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustWay() {
        return custWay;
    }

    public void setCustWay(String custWay) {
        this.custWay = custWay;
    }
    @JsonBackReference
    public User getUser() {
        return user;
    }
    @JsonBackReference
    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comic> getComics() {
        return comics;
    }

    public void setComics(Set<Comic> comics) {
        this.comics = comics;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", custName='" + custName + '\'' +
                ", custWay='" + custWay + '\'' +
                '}';
    }
}
