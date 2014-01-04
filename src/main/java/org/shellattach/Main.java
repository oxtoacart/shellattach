package org.shellattach;

import java.io.File;

import com.sun.tools.attach.VirtualMachine;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Please specify arguments <port> and <pid>");
            System.exit(1);
        }
        VirtualMachine vm = VirtualMachine.attach(args[1]);
        vm.loadAgent(new File("build/libs/shellattach-0.1.0-shadow.jar")
                .getAbsolutePath(), args[0]);
        vm.detach();

        System.out
                .println(
                String.format(
                        "Loaded sattach agent, listening for socat connection at port %1$s",
                        args[0]));
    }
}
