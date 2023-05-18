package Command_Template;

public class MakePhoneCallCommand implements Command{

    private PhoneDialerApplication phoneDialerApplication;

    public MakePhoneCallCommand(PhoneDialerApplication phoneDialerApplication){
        this.phoneDialerApplication = phoneDialerApplication;
    }

    public void execute(){
        System.out.println("Executing the command: " + this.toString() + ".");
        this.phoneDialerApplication.makeCall();
    }

    public String toString(){
        return "MakePhoneCallCommand";
    }
    
}