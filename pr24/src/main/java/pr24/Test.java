package pr24;

import org.apache.openejb.core.LocalInitialContextFactory;
import pr24.bean.BeanMgdClient;
import pr24.client.ClientTx;
import pr24.container.ContainerMgdClient;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.Properties;

public class Test {

  public static void main(String[] args) throws Exception {
    final Properties properties = new Properties();
    properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, LocalInitialContextFactory.class.getName());
    final EJBContainer container = EJBContainer.createEJBContainer(properties);

    System.out.println("\n\n===== BEAN-MANAGED TX =====");
    BeanMgdClient.test();

    System.out.println("\n\n===== CONTAINER-MANAGED TX =====");
    ContainerMgdClient.test();

    System.out.println("\n\n===== CLIENT-MANAGED TX =====");
    ClientTx.test();

    System.out.println("\n");
    container.close();
  }
}