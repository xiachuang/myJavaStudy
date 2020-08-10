package cn.briup.xia.baen;


import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import java.util.Set;

@Entity
@Table(name = "comic")
public class Comic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comic_id")
    private Integer id;
    @Column(name = "comic_name")
    private String comicName;
    @Column(name = "comic_music")
    private String comicMusic;
    @Column(name = "comic_time")
    private Date comicTime;
    @Column(name = "comic_desc")
    private String comicDesc;
    @Column(name = "comic_url")
    private String comicUrl;
    @ManyToMany(targetEntity = Type.class,fetch = FetchType.LAZY)
    @JoinTable(name = "sys_comic_type",joinColumns = {@JoinColumn(name = "sys_comic_id",referencedColumnName = "comic_id")},
            inverseJoinColumns = {@JoinColumn(name="sys_type_id",referencedColumnName = "type_id")})
    @NotFound(action= NotFoundAction.IGNORE)
    private Set<Type> types1=new HashSet<>();
    @ManyToMany(mappedBy = "comics",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @NotFound(action= NotFoundAction.IGNORE)
    private  Set<Customer> customer1=new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

    public String getComicMusic() {
        return comicMusic;
    }

    public void setComicMusic(String comicMusic) {
        this.comicMusic = comicMusic;
    }

    public Date getComicTime() {
        return comicTime;
    }

    public void setComicTime(Date comicTime) {
        this.comicTime = comicTime;
    }

    public String getComicDesc() {
        return comicDesc;
    }

    public void setComicDesc(String comicDesc) {
        this.comicDesc = comicDesc;
    }

    public String getComicUrl() {
        return comicUrl;
    }

    public void setComicUrl(String comicUrl) {
        this.comicUrl = comicUrl;
    }

    public Set<Type> getTypes1() {
        return types1;
    }

    public void setTypes1(Set<Type> types1) {
        this.types1 = types1;
    }

    public Set<Customer> getCustomer1() {
        return customer1;
    }

    public void setCustomer1(Set<Customer> customer1) {
        this.customer1 = customer1;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "id=" + id +
                ", comicName='" + comicName + '\'' +
                ", comicMusic='" + comicMusic + '\'' +
                ", comicTime=" + comicTime +
                ", comicDesc='" + comicDesc + '\'' +
                ", comicUrl='" + comicUrl + '\'' +
                ", types1=" + types1 +
                '}';
    }
}
