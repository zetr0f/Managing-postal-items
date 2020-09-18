package ir.ac.kntu;


import java.util.Objects;

public class Postage extends Thing implements Cloneable{
    private Customer sender;
    private Customer receiver;
    private City origin;
    private City destination;
    private Date deliveryTime;
    private Date receiptTime;
    private ShippingMethod shippingMethod;
    private PostMethod postMethod;
    private OrderStatus orderStatus;
    private City currentPosition;
    private double dis;
    private double weight;

    public Postage(String name, Customer sender, Customer receiver, City origin, City destination,double weight
            , Date deliveryTime,Date receiptTime, ShippingMethod shippingMethod, PostMethod postMethod)
            throws CloneNotSupportedException {
        super(name);
        this.sender = sender;
        this.receiver = receiver;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.deliveryTime = deliveryTime;
        this.receiptTime = receiptTime;
        this.shippingMethod = shippingMethod;
        this.postMethod = postMethod;
        orderStatus = OrderStatus.UNSENT;
        currentPosition = origin.clone();
        dis = City.dis(origin, destination);
    }

    public void calcAndPrintPrice(){
        System.out.println("postage created!");
        System.out.print("Price : ");
        double price = getDis() * 100d + getWeight() * 1000d;
        if (postMethod.equals(PostMethod.CUSTOM)) {
            price*=2d;
        }
        System.out.println(price);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDis() {
        return dis;
    }

    public void setDis(double dis) {
        this.dis = dis;
    }

    public Customer getSender() throws CloneNotSupportedException {
        return sender.clone();
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getReceiver() throws CloneNotSupportedException {
        return receiver.clone();
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public City getOrigin() throws CloneNotSupportedException {
        return origin.clone();
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestination() throws CloneNotSupportedException {
        return destination.clone();
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public Date getDeliveryTime() throws CloneNotSupportedException {
        return deliveryTime.clone();
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getReceiptTime() throws CloneNotSupportedException {
        return receiptTime.clone();
    }

    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public PostMethod getPostMethod() {
        return postMethod;
    }

    public void setPostMethod(PostMethod postMethod) {
        this.postMethod = postMethod;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public City getCurrentPosition() throws CloneNotSupportedException {
        return currentPosition.clone();
    }

    public void setCurrentPosition(City currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Postage)) return false;
        if (!super.equals(o)) return false;
        Postage postage = (Postage) o;
        try {
            return Objects.equals(getSender(), postage.getSender()) &&
                    Objects.equals(getReceiver(), postage.getReceiver()) &&
                    Objects.equals(getOrigin(), postage.getOrigin()) &&
                    Objects.equals(getDestination(), postage.getDestination());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int hashCode() {
        try {
            return Objects.hash(super.hashCode(), getSender(), getReceiver());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    protected Postage clone() throws CloneNotSupportedException {
        Postage postage = (Postage) super.clone();
        postage.setSender(getSender());
        postage.setReceiver(getReceiver());
        postage.setOrigin(getOrigin());
        postage.setDestination(getDestination());
        postage.setDeliveryTime(getDeliveryTime());
        postage.setReceiptTime(getReceiptTime());
        postage.setShippingMethod(getShippingMethod());
        postage.setPostMethod(getPostMethod());
        postage.setOrderStatus(getOrderStatus());
        postage.setCurrentPosition(getCurrentPosition());
        return postage;
    }

    @Override
    public String toString() {
        return "Postage{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", origin=" + origin +
                ", destination=" + destination +
                ", deliveryTime=" + deliveryTime +
                ", receiptTime=" + receiptTime +
                ", shippingMethod=" + shippingMethod +
                ", postMethod=" + postMethod +
                ", orderStatus=" + orderStatus +
                ", currentPosition=" + currentPosition +
                '}';
    }
}
