package Command_Template;

public class OrderRequestProcessor extends UserRequestProcessor{

    public OrderRequestProcessor(String requestType, String requestData){
        super(requestType, requestData);
    }

    public void instantiateAndSetConcreteCommand(){
        super.instantiateAndSetConcreteCommand();
        this.setCommand(new OrderItemCommand(new OrderItemsApplication(this.getRequestData())));
        System.out.println(this.getCommand() + ".");
    }

    void invoke(Command command){
        super.invoke(command);
    }

}