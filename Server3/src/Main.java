import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.Scanner;

public class Main {

    private javax.jms.Connection connect = null;
    private javax.jms.Session sendSession = null;
    private javax.jms.MessageProducer sender = null;
    private javax.jms.Queue queue = null;


    private void configurer() {
        try {
            javax.jms.ConnectionFactory factory;
            factory = new ActiveMQConnectionFactory("user", "password", "tcp://localhost:61616");
            connect = factory.createConnection ("user", "password");

            this.configurerProducteur();
            connect.start();

        } catch (javax.jms.JMSException jmse){
            jmse.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        try {
            while(true) {
                System.out.println("Post a message to send it to client :");
                String tmpMessage = sc.nextLine();
                postMessageInQueue(tmpMessage);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private void configurerProducteur() throws JMSException{
        sendSession = connect.createSession(false,javax.jms.Session.AUTO_ACKNOWLEDGE);
        Remote r = null;
        try {
            r = Naming.lookup("UniversalRegistry");
            IUniversalRegistry iur = (IUniversalRegistry)r;
            queue = iur.getQueueServiceQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sender = sendSession.createProducer(queue);
    }

    private void postMessageInQueue(String mess) throws JMSException {
        TextMessage msg = sendSession.createTextMessage();
        msg.setText(mess);
        sender.send(queue,msg);
    }


    public static void main(String[] args) {
        System.out.println("Begin Server...");

        new Main().configurer();
    }

}
