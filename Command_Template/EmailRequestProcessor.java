package Command_Template;

public class EmailRequestProcessor extends UserRequestProcessor{

    public EmailRequestProcessor(String requestType, String requestData){
        super(requestType, requestData);
    }

    public void instantiateAndSetConcreteCommand(){
        super.instantiateAndSetConcreteCommand();
        this.setCommand(new SendEmailCommand(new EmailApplication(this.getRequestData())));
        System.out.println(this.getCommand() + ".");
    }

    void invoke(Command command){
        super.invoke(command);
    }

}