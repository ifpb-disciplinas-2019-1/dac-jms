package br.edu.ifpb.mensagem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/08/2019, 09:51:47
 */
@MessageDriven(
//    mappedName = "java:app/jms/msg",
    activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:global/jms/msg")
        
    }
)
// Processar as mensagens .. 
// Log, Autoditoria, Relatorio, Operação em Lote.. 
public class LogAsynDeMensagens implements MessageListener {
    private static final Logger LOG = Logger.getLogger(LogAsynDeMensagens.class.getName());
    
    @Override
    public void onMessage(Message message) {
        try {
            String mensagem = message.getBody(String.class);
            LOG.info(mensagem);
        } catch (JMSException ex) {
            Logger.getLogger(LogAsynDeMensagens.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

}
