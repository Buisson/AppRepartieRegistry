import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;

public class Main implements javax.jms.MessageListener{

    private javax.jms.Connection connect = null;
    private javax.jms.Session receiveSession = null;
    private javax.jms.MessageProducer sender = null;
    private javax.jms.Queue queue = null;


    private void configurer() {

        try {
            javax.jms.ConnectionFactory factory;
            factory = new ActiveMQConnectionFactory("user", "password", "tcp://localhost:61616");
            connect = factory.createConnection ("user", "password");

            this.configurerConsommateur();
            connect.start();

        } catch (javax.jms.JMSException jmse){
            jmse.printStackTrace();
        }

    }

    private void configurerConsommateur() throws JMSException {
        // Pour consommer, il faudra simplement ouvrir une session
        receiveSession = connect.createSession(false,javax.jms.Session.AUTO_ACKNOWLEDGE);
        javax.jms.Queue tmpQueue = null;
        try {
            Remote r = Naming.lookup("UniversalRegistry");
            IUniversalRegistry iur = (IUniversalRegistry)r;
            tmpQueue = iur.getQueueServiceQueue();

        }catch(Exception e){
            e.printStackTrace();
        }
        javax.jms.MessageConsumer qReceiver = receiveSession.createConsumer(tmpQueue);
        qReceiver.setMessageListener(this); //Listener pour le OnMessage

    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("[RECUUUUUUUUUUUUUUUUU] : "+((TextMessage)message).getText());//On affiche le text du message
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println("Client3 Waiting for messages...");

        new Main().configurer(); //On lance le client
    }

}
