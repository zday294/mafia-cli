package protocol;

public class GameStatusMessage extends ProtocolMessage {

    enum gameStatus{
        unstarted,
        inprogress,
        ended
    }

    gameStatus status;

    public GameStatusMessage(gameStatus stat){
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