package Command_Template;

import java.util.ArrayList;

public abstract class UserRequestProcessor{

    private String requestType;
    private String requestData;
    private RequestStatus requestStatus = RequestStatus.WAITING;
    private Command command;
    private static ArrayList<String> requestsDataLog = new ArrayList<String>();

    enum RequestStatus{
        WAITING, RECEIVED, VALIDATED, LOGGED, EXECUTING, COMPLETED
    }

    public UserRequestProcessor(String requestType, String requestData){
        this.requestType = requestType;
        this.requestData = requestData;
        System.out.println("Processing request type: " + this.getRequestType());
        this.updateRequestStatus(RequestStatus.RECEIVED);
        this.notifyRequestStatus();
    }

    String getRequestType(){
        return this.requestType;
    }

    String getRequestData(){
        return this.requestData;
    }

    RequestStatus getRequestStatus(){
        return this.requestStatus;
    }

    Command getCommand(){
        return this.command;
    }

    void setCommand(Command command){
        this.command = command;
    }

    static ArrayList<String> getRequestsDataLog(){
        return requestsDataLog;
    }

    void validateUserInput(){
        System.out.println("Validating user input: " + this.getRequestType());
    }

    void logRequest(){
        System.out.println("Logging request data: " + this.getRequestData());
        getRequestsDataLog().add(this.getRequestData());
    }

    void notifyRequestStatus(){
        System.out.println("Notifying request status: " + this.getRequestStatus() + ".");
    }

    void verifyRequestCompletion(){
        System.out.print("Verifying request completion: ");
    }

    void updateRequestStatus(RequestStatus requestStatus){
        this.requestStatus = requestStatus;
    }

    public void instantiateAndSetConcreteCommand(){
        System.out.print("Creating concrete command: ");
    }

    void invoke(Command command){
        System.out.println("Invoking the command: " + command + ".");
        command.execute();
    }

    void processRequest(){
        this.validateUserInput();
        this.updateRequestStatus(RequestStatus.VALIDATED);
        this.notifyRequestStatus();
        this.logRequest();
        this.updateRequestStatus(RequestStatus.LOGGED);
        this.notifyRequestStatus();
        this.instantiateAndSetConcreteCommand();
        this.updateRequestStatus(RequestStatus.EXECUTING);
        this.notifyRequestStatus();
        this.invoke(this.getCommand());
        this.updateRequestStatus(RequestStatus.COMPLETED);
        this.notifyRequestStatus();
        this.updateRequestStatus(RequestStatus.WAITING);
        this.notifyRequestStatus();
        printRequestsLog();
    }

    static void printRequestsLog(){
        System.out.println("\nRequests data log: " + getRequestsDataLog());
    }

}