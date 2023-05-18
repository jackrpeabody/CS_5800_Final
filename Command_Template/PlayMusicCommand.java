package Command_Template;

public class PlayMusicCommand implements Command{

    private MusicPlayerApplication musicPlayerApplication;

    public PlayMusicCommand(MusicPlayerApplication musicPlayerApplication){
        this.musicPlayerApplication = musicPlayerApplication;
    }

    public void execute(){
        System.out.println("Executing the command: " + this.toString() + ".");
        this.musicPlayerApplication.playMusic();
    }

    public String toString(){
        return "PlayMusicCommand";
    }
    
}