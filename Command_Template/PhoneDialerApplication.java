package Command_Template;

public class PhoneDialerApplication{

    private String requestData;

    public PhoneDialerApplication(String requestData){
        this.requestData = requestData;
    }

    public String getRequestData(){
        return this.requestData;
    }

    public void makeCall(){
        System.out.println("Calling " + getRequestData().substring(5));
    }

}