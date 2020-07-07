package helpers.smtp.subetha;

import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.MessageHandler;
import org.subethamail.smtp.MessageHandlerFactory;

public class MessageHandlerFactoryImpl implements MessageHandlerFactory {

    @Override
    public MessageHandler create(MessageContext ctx) {
        return MessageHandlerImpl.getMessageHandlerImplementation(ctx);
    }
}
