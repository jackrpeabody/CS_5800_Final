package Command_Template;

public class SetReminderCommand implements Command{

    private ReminderApplication reminderApplication;

    public SetReminderCommand(ReminderApplication reminderApplication){
        this.reminderApplication = reminderApplication;
    }

    public void execute(){
        System.out.println("Executing the command: " + this.toString() + ".");
        this.reminderApplication.setReminder();
    }

    public String toString(){
        return "SetReminderCommand";
    }
    
}