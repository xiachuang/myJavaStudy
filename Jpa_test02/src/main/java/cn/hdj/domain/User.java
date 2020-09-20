package cn.hdj.domain;


import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private  Integer userId;
    @Column(name = "user_name")
    private String userName;
   @ManyToMany(targetEntity = Role.class,cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
   @JoinTable(name = "sys_user_role",joinColumns = {@JoinColumn(name = "sys_user_id",referencedColumnName = "user_id")},
   inverseJoinColumns = {@JoinColumn(name="sys_role_id",referencedColumnName = "role_id")})
   @NotFound(action= NotFoundAction.IGNORE)
    private Set<Role> roles=new HashSet<Role>();
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
