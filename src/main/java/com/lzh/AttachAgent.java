package com.lzh;

import com.sun.tools.attach.VirtualMachine;

/**
 * @Author: lizhihao
 * @Date: 2019/9/23
 */
public class AttachAgent {

    public static void main(String[] args) throws Exception{
        VirtualMachine vm = VirtualMachine.attach("1427");
        vm.loadAgent("/Users/lizhihao/code/java-agent-demo/target/java-agent-demo-1.0-SNAPSHOT-jar-with-dependencies.jar");
    }

}
