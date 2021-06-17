package protocol;

public class RetryMessage extends ProtocolMessage {
    

    
    @Override
    public String getPayload() {
        return "";
    }

    @Override
    public String getTypeName() {
        return "retry";
    }
    
}
