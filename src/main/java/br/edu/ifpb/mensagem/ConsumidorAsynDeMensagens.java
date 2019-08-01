package br.edu.ifpb.mensagem;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    mappedName = "jms/sms"
)
// Processar as mensagens .. 
// Log, Autoditoria, Relatorio, Operação em Lote.. 
public class ConsumidorAsynDeMensagens implements MessageListener {
 
    @Override
    public void onMessage(Message message) {
        try {
            String mensagem = message.getBody(String.class);
            System.out.println(
                "mensagem: " + mensagem
            );
        } catch (JMSException ex) {
            Logger.getLogger(ConsumidorAsynDeMensagens.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

}
