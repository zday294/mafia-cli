package protocol;

import java.util.Arrays;

import protocol.GameStatusMessage.GameStatus;
import protocol.NameMessage.NameType;
import protocol.RequestMessage.ReqType;

public class MessageBuilder {
    public static ProtocolMessage Build(String message) throws InvalidProtocolMessageException {
        ProtocolMessage pm;

        String[] messageTok = message.split(" ");

        switch(messageTok[0]){
            case "request":
                pm = new RequestMessage(ReqType.valueOf(messageTok[1]), messageTok[2]);
                break;
            case "name":
                pm = new NameMessage(NameType.valueOf(messageTok[1]), messageTok[2]);
                break;
            case "game":
                pm = new GameStatusMessage(GameStatus.valueOf(messageTok[1]));
                break;
            case "message":
                String[] mess = Arrays.copyOfRange(messageTok, 1, messageTok.length - 1);
                String joined = String.join(" ", Arrays.asList(mess));
                pm = new PlainMessage(joined);
                break;
            case "error":
                pm = new ErrorMessage(messageTok[1]);
                break;
            default:
                throw new InvalidProtocolMessageException();
        }

        return pm;
    }
}
