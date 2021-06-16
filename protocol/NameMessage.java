package protocol;

public class NameMessage extends ProtocolMessage {    
    enum NameType{
        client,
        server
    }

    // static String TypeName = "name";    
    NameType selfType;
    String selfName;

    public NameMessage(NameType cos, String name){
        selfType = cos;
        selfName = name;
    }
    
    @Override
    public String getPayload() {
        return selfType + " " + selfName;
    }

    @Override
    public String getTypeName() {
        return "name";
    }
}