import org.apache.activemq.*;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by colombet on 13/05/16.
 */
public class ServiceQueue {

    private javax.jms.Queue queue;
    private javax.jms.Session sp;

    public void fillQueue() throws JMSException {
        MessageProducer mp = sp.createProducer(queue);

        for(int i = 0 ; i< 5 ; i++){
            TextMessage msg = sp.createTextMessage();
            msg.setText("testing n°"+i);
            mp.send(msg);
        }
    }

    public void createQueue(){
        javax.jms.ConnectionFactory connectionf;
        connectionf =  new ActiveMQConnectionFactory("user","user","tcp://localhost:61616");

        javax.jms.Connection comm = null;
        try {
            comm = connectionf.createConnection("user","user");
            comm.start();
            sp = comm.createSession(false, Session.AUTO_ACKNOWLEDGE);

            this.queue = sp.createQueue("toto");

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public javax.jms.Queue subscribeQueue(){
        return queue;
    }


}
