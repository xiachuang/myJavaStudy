package cn.briup.xia.baen;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "type")
public class Type implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer id;
    @Column(name = "type_name")
    private String typeName;
    @ManyToMany(mappedBy = "types1",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @NotFound(action= NotFoundAction.IGNORE)
    private Set<Comic> comics=new HashSet<>();
    @ManyToMany(mappedBy = "types",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @NotFound(action= NotFoundAction.IGNORE)
    private Set<Book> books=new HashSet<>();
}
