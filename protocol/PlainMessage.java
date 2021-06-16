package protocol;


public class PlainMessage extends ProtocolMessage {
    String message;
    // static String TypeName = "message";

    public PlainMessage(String mes){
        message = mes;
    }

    @Override
    public String getPayload() {
        return String.format("\"%s\"", message);
    }
    @Override
    public String getTypeName() {
        return "message";
    }
}