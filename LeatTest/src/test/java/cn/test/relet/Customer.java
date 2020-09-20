package cn.test.relet;

import java.io.Serializable;

public class Customer implements Serializable {
    private Integer custId;
    private String custName;
    public  void show(Integer custId,String custName){
        System.out.println(custId+"    "+custName);
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
}
