package protocol;

public class RequestMessage extends ProtocolMessage {
    // static String TypeName = "request";

    enum ReqType{
        name,
        action,
        vote,
        present,
        gamestatus,
        playerStatus

    }

    ReqType reqType;
    String identifyer;

    public RequestMessage(ReqType req, String id){
        reqType = req;
        identifyer = id;
    }

    @Override
    public String getPayload() {
        return reqType + " " + identifyer;
    }

    @Override
    public String getTypeName() {
        return "request";
    }

}
