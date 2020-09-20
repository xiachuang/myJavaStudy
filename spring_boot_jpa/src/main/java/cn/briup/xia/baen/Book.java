package cn.briup.xia.baen;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "book_writer")
    private String bookWriter;
    @ManyToMany(targetEntity = Type.class,fetch = FetchType.LAZY)
    @JoinTable(name = "sys_book_type",joinColumns = {@JoinColumn(name = "sys_book_id",referencedColumnName = "book_id")},
            inverseJoinColumns = {@JoinColumn(name="sys_type_id",referencedColumnName = "type_id")})
    @NotFound(action= NotFoundAction.IGNORE)
    private Set<Type> types=new HashSet<>();
    @ManyToMany(mappedBy = "books",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @NotFound(action= NotFoundAction.IGNORE)
    private Set<Customer> customers=new HashSet<>();

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookWriter='" + bookWriter + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }
    @JsonBackReference
    public Set<Customer> getCustomers() {
        return customers;
    }
    @JsonBackReference
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
