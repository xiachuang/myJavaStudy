package cn.briup.jpa.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    /*
    A与B的关系为 OneToMany；在B类中，有属性A a,引用到A中的字段id，并作为外键。hibernate查询结果正常，可以看到返回的A对象中，有b参数值，
    但在json转换的时候就出现了无限递归的情况。个人分析，应该是json在序列化A中的b属性的时候，找到了B类，然后序列化B类，而B类中有a属性，
    因此，为了序列化a属性，json又得去序列化A类，如此递归反复，造成该问题。@JsonBackReference
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId")
    private Integer empId;
    @Column(name = "empName")
    private  String empName;
    @Column(name = "empAge")
    private  Integer empAge;
    @Column(name = "empSalary")
    private String empSalary;
    @ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_emp_id",referencedColumnName = "deptId")
    @NotFound(action = NotFoundAction.IGNORE)
    private  Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empSalary='" + empSalary + '\'' +
                ", department=" + department +
                '}';
    }
    @JsonBackReference
    public Department getDepartment() {
        return department;
    }
    @JsonBackReference
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(String empSalary) {
        this.empSalary = empSalary;
    }
}
