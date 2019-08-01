package br.edu.ifpb.mensagem;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Topic;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 31/07/2019, 09:18:13
 */


@Stateless
public class ProdutorDeMensagens {

//    @Resource(lookup = "jms/dac")
//    private Queue queue;
//    @Resource(lookup = "jms/sms")
    @Resource(lookup = "java:global/jms/msg")
    private Topic topic;

    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory factory;

    public void enviarNovaMensagem(String texto) {
        JMSContext context = factory.createContext();
        JMSProducer producer = context.createProducer();
        // criar a mensagem
        Message mensagem = context.createTextMessage(texto);
        // enviar para o canal de comunicação
//        producer.send(
//            queue,mensagem
//        );
        producer.send(
            topic,mensagem
        );
    }

}
