package helpers.smtp.subetha;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.MessageHandler;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class MessageHandlerImpl implements MessageHandler {
    MessageContext _messageContext;
    private static final Logger _logger = LogManager.getLogger(MessageHandlerImpl.class);

    private MessageHandlerImpl(MessageContext context) {
        this._messageContext = context;
    }

    static MessageHandlerImpl getMessageHandlerImplementation (MessageContext context){
        return new MessageHandlerImpl(context);
    }

    @Override
    public void from(String mailFrom){
        _logger.info("Mail from: {}", mailFrom);
    }

    @Override
    public void recipient(String mailTo) {
        _logger.info("Rcpt to: {}", mailTo);
    }

    @Override
    public void data(InputStream inputStream) throws IOException {

        Session session = Session.getDefaultInstance(new Properties());

        try {
            MimeMessage message = new MimeMessage(session, inputStream);
                Object obj = message.getContent();
                if (obj instanceof String){
                    _logger.info("Message content: {}", obj);
                }
                else{
                    _logger.warn("Message is not textual, skipping the printout...");
                }

        } catch (MessagingException e) {
            _logger.error("Exception caught when parsing the message", e);
        }
    }

    @Override
    public void done() {
        //do nothing
    }
}
