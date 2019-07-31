package br.edu.ifpb.mensagem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 31/07/2019, 09:47:44
 */
@Stateless
public class ConsumidorDeMensagens {

    @Resource(lookup = "jms/dac")
    private Queue queue;

    @Inject
    private JMSContext context;

    public String lerMensagen() {
        try {
            JMSConsumer consumer = this.context.createConsumer(queue);
//        String corpo = consumer.receiveBody(String.class);
            Message mensagem = consumer.receive();
            String corpo = mensagem.getBody(String.class);
            return corpo;
        } catch (JMSException ex) {
            Logger.getLogger(ConsumidorDeMensagens.class.getName()).log(Level.SEVERE,null,ex);
        }
        return "no msg";
    }
}
