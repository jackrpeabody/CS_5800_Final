package Command_Template;

public class ReminderRequestProcessor extends UserRequestProcessor{

    public ReminderRequestProcessor(String requestType, String requestData){
        super(requestType, requestData);
    }

    public void instantiateAndSetConcreteCommand(){
        super.instantiateAndSetConcreteCommand();
        this.setCommand(new SetReminderCommand(new ReminderApplication(this.getRequestData())));
        System.out.println(this.getCommand() + ".");
    }

    void invoke(Command command){
        super.invoke(command);
    }

}