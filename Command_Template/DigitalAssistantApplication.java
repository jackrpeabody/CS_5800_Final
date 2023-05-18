package Command_Template;

public class DigitalAssistantApplication{
    
    public void inputUserRequest(String requestType, String requestData){
        if(requestType == "Make a phone call."){
            PhoneCallRequestProcessor phoneCallRequestProcessor = new PhoneCallRequestProcessor(requestType, requestData);
            phoneCallRequestProcessor.processRequest();
        }
        else if(requestType == "Send an email."){
            EmailRequestProcessor emailRequestProcessor = new EmailRequestProcessor(requestType, requestData);
            emailRequestProcessor.processRequest();
        }
        else if(requestType == "Play music."){
            MusicRequestProcessor musicRequestProcessor = new MusicRequestProcessor(requestType, requestData);
            musicRequestProcessor.processRequest();
        }
        else if(requestType == "Set a reminder."){
            ReminderRequestProcessor reminderRequestProcessor = new ReminderRequestProcessor(requestType, requestData);
            reminderRequestProcessor.processRequest();
        }
        else if(requestType == "Order item."){
            OrderRequestProcessor orderRequestProcessor = new OrderRequestProcessor(requestType, requestData);
            orderRequestProcessor.processRequest();
        }
    }

}