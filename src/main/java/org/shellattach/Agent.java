package org.shellattach;

import java.lang.instrument.Instrumentation;

import com.iterative.groovy.service.GroovyShellService;

public class Agent {
    public static void agentmain(String agentArgs, Instrumentation inst) {
        try {
            int port = Integer.parseInt(agentArgs);
            System.err.println(String.format(BANNER, port));
            GroovyShellService service = new GroovyShellService();
            service.setPort(port);
            service.start();
        } catch (Exception e) {
            System.err.println("Unable to start shell service: "
                    + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    //@formatter:off    
    private static final String BANNER =
        "******************************************************************************************************\n" +
        " ######  ##     ## ######## ##       ##          ###    ######## ########    ###     ######  ##     ##\n" + 
        "##    ## ##     ## ##       ##       ##         ## ##      ##       ##      ## ##   ##    ## ##     ##\n" +
        "##       ##     ## ##       ##       ##        ##   ##     ##       ##     ##   ##  ##       ##     ##\n" +
        " ######  ######### ######   ##       ##       ##     ##    ##       ##    ##     ## ##       #########\n" +
        "      ## ##     ## ##       ##       ##       #########    ##       ##    ######### ##       ##     ##\n" +
        "##    ## ##     ## ##       ##       ##       ##     ##    ##       ##    ##     ## ##    ## ##     ##\n" +
        " ######  ##     ## ######## ######## ######## ##     ##    ##       ##    ##     ##  ######  ##     ##\n" +
        "\n" +
        "Starting Remote Shell at port: %1$s\n" +
        "\n";
  //@formatter:on
}
