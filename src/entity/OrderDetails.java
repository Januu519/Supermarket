package entity;

import java.math.BigDecimal;

public class OrderDetails {
    private String oid;
    private String itemCode;
    private int orderQty;
    private BigDecimal discount;

    public OrderDetails() {
    }

    public OrderDetails(String oid, String itemCode, int orderQty, BigDecimal discount) {
        this.oid = oid;
        this.itemCode = itemCode;
        this.orderQty = orderQty;
        this.discount = discount;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
