package org.apache.camel.order;

import org.apache.camel.main.Main;
import org.apache.camel.order.route.OrderRoute;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {

        Main main = new Main();
        main.configure().addRoutesBuilder(new OrderRoute());
        main.run(args);
    }
}

