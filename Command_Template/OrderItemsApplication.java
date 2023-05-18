package Command_Template;

public class OrderItemsApplication{

    private String requestData;

    public OrderItemsApplication(String requestData){
        this.requestData = requestData;
    }

    public String getRequestData(){
        return this.requestData;
    }

    public void orderItem(){
        System.out.println("Ordering " + getRequestData().substring(6));
    }

}