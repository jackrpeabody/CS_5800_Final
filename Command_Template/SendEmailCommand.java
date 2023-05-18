package Command_Template;

public class SendEmailCommand implements Command{

    private EmailApplication emailApplication;

    public SendEmailCommand(EmailApplication emailApplication){
        this.emailApplication = emailApplication;
    }

    public void execute(){
        System.out.println("Executing the command: " + this.toString() + ".");
        this.emailApplication.sendEmail();
    }

    public String toString(){
        return "SendEmailCommand";
    }
    
}