package pr07;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import pr07.beans.PrototypeBean;
import pr07.beans.SingletonBean;

@SpringBootApplication
public class BeanLifeCycleApp {
  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = new SpringApplicationBuilder()
        .sources(BeanLifeCycleApp.class)
        .bannerMode(Banner.Mode.OFF)
        .run(args);

    SingletonBean sb1 = ctx.getBean(SingletonBean.class);
    SingletonBean sb2 = ctx.getBean(SingletonBean.class);
    PrototypeBean pb1 = ctx.getBean(PrototypeBean.class);
    PrototypeBean pb2 = ctx.getBean(PrototypeBean.class);

    System.out.println("SingletonBean 1: " + sb1.getMessage());
    System.out.println("SingletonBean 2: " + sb2.getMessage());
    System.out.println("PrototypeBean 1: " + pb1.getMessage());
    System.out.println("PrototypeBean 2: " + pb2.getMessage());
  }
}
