package Command_Template;

public class ReminderApplication{

    private String requestData;

    public ReminderApplication(String requestData){
        this.requestData = requestData;
    }

    public String getRequestData(){
        return this.requestData;
    }

    public void setReminder(){
        System.out.println("Set reminder to " + getRequestData().substring(13));
    }

}