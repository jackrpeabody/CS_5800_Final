package Command_Template;

public class PhoneCallRequestProcessor extends UserRequestProcessor{

    public PhoneCallRequestProcessor(String requestType, String requestData){
        super(requestType, requestData);
    }

    public void instantiateAndSetConcreteCommand(){
        super.instantiateAndSetConcreteCommand();
        this.setCommand(new MakePhoneCallCommand(new PhoneDialerApplication(this.getRequestData())));
        System.out.println(this.getCommand() + ".");
    }

    void invoke(Command command){
        super.invoke(command);
    }

}