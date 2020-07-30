package cn.hdj.domain;



import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "cst_linkman")
public class LinkMan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private  Integer lkmId;
    @Column(name="lkm_name")
    private String lkmName;
    @Column(name = "lkm_phone")
    private String lkmPhone;
    @Column(name = "lkm_Email")
    private String lkmEmail;
    @Column(name="lkm_memo")
    private String lkmMemo;
    @Column(name = "lkm_position")
    private String lkmPosition;
    /**
     * 配置联系人到客户的多对一关系
     *     使用注解的形式配置多对一关系
     *      1.配置表关系
     *          @ManyToOne : 配置多对一关系
     *              targetEntity：对方的实体类字节码
     *      2.配置外键（中间表）
     *,fetch = FetchType.LAZY
     * * 配置外键的过程，配置到了多的一方，就会在多的一方维护外键
     */
    @ManyToOne(targetEntity = Customer.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "lkm_cst_id",referencedColumnName = "cust_id")
    private  Customer customer;

    public Integer getLkmId() {
        return lkmId;
    }

    public void setLkmId(Integer lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "LinkMan{" +
                "lkmId=" + lkmId +
                ", lkmName='" + lkmName + '\'' +
                ", lkmPhone='" + lkmPhone + '\'' +
                ", lkmEmail='" + lkmEmail + '\'' +
                ", lkmMemo='" + lkmMemo + '\'' +
                ", lkmPosition='" + lkmPosition + '\'' +
                '}';
    }

    public LinkMan() {
        super();
    }
}
