package ro.sd.firstapp.model;

public enum OrderStatus {
    PENDING("Pending"),
    ACCEPTED("Accepted"),
    IN_DELIVERY("In delivery"),
    DELIVERED("Delivered"),
    DECLINED("Declined");

    private final String label;
    OrderStatus(String label){
        this.label=label;
    }

    public String getLabel() {
        return label;
    }
}
