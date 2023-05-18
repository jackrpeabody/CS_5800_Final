package Command_Template;

public class OrderItemCommand implements Command{

    private OrderItemsApplication orderItemsApplication;

    public OrderItemCommand(OrderItemsApplication orderItemsApplication){
        this.orderItemsApplication = orderItemsApplication;
    }

    public void execute(){
        System.out.println("Executing the command: " + this.toString() + ".");
        this.orderItemsApplication.orderItem();
    }

    public String toString(){
        return "OrderItemCommand";
    }
    
}