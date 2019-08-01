package br.edu.ifpb.mensagem;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.JMSDestinationDefinition;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/08/2019, 10:57:26
 */

@JMSDestinationDefinition(
    name = "java:global/jms/msg",
    interfaceName = "javax.jms.Topic",
    resourceAdapter = "jmsra",
    destinationName = "topico"
)
@Startup
@Singleton
// JMS, Datasource, SessionMail...
public class InicializadorDeServicos {
    
}
