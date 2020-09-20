package cn.briup.xia.baen;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private  Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private  String userPassword;
    @Column(name = "user_age")
    private  Integer userAge;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "user_email")
    private String userEmail;
    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @NotFound(action= NotFoundAction.IGNORE)
    private Set<Customer> customers=new HashSet<>();
    @ManyToMany(targetEntity = Role.class,fetch = FetchType.LAZY)
    @JoinTable(name = "sys_user_role",joinColumns = {@JoinColumn(name = "sys_user_id",referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="sys_role_id",referencedColumnName = "role_id")})
    @NotFound(action= NotFoundAction.IGNORE)
    private Set<Role> roles=new HashSet<>();

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
    @JsonBackReference
    public Set<Role> getRoles() {
        return roles;
    }
    @JsonBackReference
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userAge=" + userAge +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
