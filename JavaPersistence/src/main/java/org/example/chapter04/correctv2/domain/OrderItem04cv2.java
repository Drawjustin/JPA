package org.example.chapter04.correctv2.domain;

import jakarta.persistence.*;

@Entity
public class OrderItem04cv2 {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDERITEM_ID")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private OrderItem04cv2 order;


    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item04cv2 item;


    private Integer orderPrice;

    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderItem04cv2 getOrder() {
        return order;
    }

    public void setOrder(OrderItem04cv2 order) {
        this.order = order;
    }

    public Item04cv2 getItem() {
        return item;
    }

    public void setItem(Item04cv2 item) {
        this.item = item;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
