package cn.briup.xia.bean;

import java.io.Serializable;

public class Employee implements Serializable {
    private  Integer id;
    private String lastName;
    private Integer gender;
    private String email;
    private Integer d_id;
    public static int cc;
//    public static void main(String[] args) {
//        System.out.println(" "+cc);
//    }

    public Employee() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dId=" + d_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getGender() {
//        String sex=null;
//        if(gender==0){
//            sex="女";
//        }else if(gender==1){
//            sex="男";
//        }else {
//            sex="填写错误";
//        }
//        return sex;
//    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }
}
