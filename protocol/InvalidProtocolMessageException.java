package protocol;

public class InvalidProtocolMessageException extends Exception {
    String message;

    public InvalidProtocolMessageException(String mess){
        message = mess;
    }

    public InvalidProtocolMessageException(){
        message = "Invalid message discovered while building protocol message";
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
