package helpers.smtp.subetha;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.subethamail.smtp.server.SMTPServer;

public class SmtpServer {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 33333;
    private static final Logger _logger = LogManager.getLogger(SmtpServer.class);

    public static void main(String[] args) {

        org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
        _logger.info("Starting SMTP server on {}:{}", HOST, PORT);

        SMTPServer smtpServer  = new SMTPServer(new MessageHandlerFactoryImpl());
        smtpServer.setHostName(HOST);
        smtpServer.setPort(PORT);
        smtpServer.start();
    }
}


