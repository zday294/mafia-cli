package protocol;

public abstract class ProtocolMessage {
    
    public abstract String getPayload();

    public abstract String getTypeName();

    @Override
    public String toString(){
        return getTypeName() + "  " + getPayload();
    }
}