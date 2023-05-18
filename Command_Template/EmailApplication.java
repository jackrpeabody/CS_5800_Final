package Command_Template;

public class EmailApplication{

    private String requestData;

    public EmailApplication(String requestData){
        this.requestData = requestData;
    }

    public String getRequestData(){
        return this.requestData;
    }

    public void sendEmail(){
        System.out.println("Emailing " + getRequestData().substring(6));
    }

}