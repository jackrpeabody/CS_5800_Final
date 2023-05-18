package Command_Template;

public class MusicPlayerApplication{

    private String requestData;

    public MusicPlayerApplication(String requestData){
        this.requestData = requestData;
    }

    public String getRequestData(){
        return this.requestData;
    }

    public void playMusic(){
        System.out.println("Playing " + getRequestData().substring(5));
    }

}