package protocol;

public class ErrorMessage extends ProtocolMessage {
    String errorMess;


    public ErrorMessage(String mess){
        errorMess = mess;
    }

    @Override
    public String getPayload() {
        return errorMess;
    }

    @Override
    public String getTypeName() {
        return "error";
    }
}
