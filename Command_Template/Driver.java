package Command_Template;

public class Driver{
    
    public static void main(String[] args){

        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nSCENARIO 1: Make a phone call.\n");

        DigitalAssistantApplication digitalAssistant = new DigitalAssistantApplication();
        digitalAssistant.inputUserRequest("Make a phone call.", "Call Fred.");

        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nSCENARIO 2: Send an email.\n");

        digitalAssistant.inputUserRequest("Send an email.", "Email Sarah - Hi Sarah!");

        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nSCENARIO 3: Play music.\n");

        digitalAssistant.inputUserRequest("Play music.", "Play 'Come Together' by The Beatles.");

        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nSCENARIO 4: Set a reminder.\n");

        digitalAssistant.inputUserRequest("Set a reminder.", "Remind me to check the mailbox.");

        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nSCENARIO 5: Order item.\n");

        digitalAssistant.inputUserRequest("Order item.", "Order paper towels.");
        
        System.out.println();

    }

}