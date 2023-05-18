package Command_Template;

public class MusicRequestProcessor extends UserRequestProcessor{

    public MusicRequestProcessor(String requestType, String requestData){
        super(requestType, requestData);
    }

    public void instantiateAndSetConcreteCommand(){
        super.instantiateAndSetConcreteCommand();
        this.setCommand(new PlayMusicCommand(new MusicPlayerApplication(this.getRequestData())));
        System.out.println(this.getCommand() + ".");
    }

    void invoke(Command command){
        super.invoke(command);
    }

}