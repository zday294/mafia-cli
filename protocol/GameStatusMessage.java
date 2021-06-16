package protocol;

public class GameStatusMessage extends ProtocolMessage {

    enum GameStatus{
        unstarted,
        inprogress,
        ended
    }

    GameStatus status;

    public GameStatusMessage(GameStatus stat){
        status = stat;
    }

    @Override
    public String getPayload() {
        return status.toString();
    }

    @Override
    public String getTypeName() {
        return "game";
    }
    


}