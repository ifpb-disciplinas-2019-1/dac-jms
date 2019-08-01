## Roteiro

# criando o recurso
* `asadmin create-jms-resource --restype javax.jms.ConnectionFactory jms/aulaConnectionFactory` 
* `asadmin create-jms-resource --restype javax.jms.Queue jms/aulaQueue`
* `asadmin create-jms-resource --restype javax.jms.Topic jms/top`

# listar os recursos
* `asadmin list-jms-resources` 
* `asadmin list-jndi-entries --context jms`

# notificadores JMS

* `asadmin create-jms-resource --enabled=true --property=Name=notifierQueue --restype=javax.jms.queue jms/notifierQueue` 
* `asadmin notification-jms-configure --dynamic=true --enabled=true --contextFactoryClass=com.sun.enterprise.naming.SerialInitContextFactory --target=server-config --queueName=notifierQueue --url=localhost:7676 --connectionFactoryName=jms/_defaultConnectionFactory get-jms-notifier-configuration`

# configurando com anotacao

```
@JMSDestinationDefinition( 
    name = "java:global/jms/topic/aula", 
    resourceAdapter = "jmsra", 
    interfaceName = "javax.jms.Topic", 
    destinationName = "topic", 
    description = "Topic em aula" 
)
```

# usando no MDB
```
@MessageDriven( 
    mappedName = "java:global/jms/topic/aula", 
    activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"), @ActivationConfigProperty(propertyName = "destination", propertyValue = "topic"), @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "email='job'") } 
)
```

```
@MessageDriven(
    activationConfig = { 
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue"), @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/demoQueue") //@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "email='job'") 
    } //,mappedName = "jms/demoQueue"
)
```