package com.lzh;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @Author: lizhihao
 * @Date: 2019/9/23
 */
public class MyTransformer implements ClassFileTransformer {

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("正在加载类："+ className);
        if (!"com/lzh/Person".equals(className)){
            return classfileBuffer;
        }

        CtClass cl = null;
        try {
            ClassPool classPool = ClassPool.getDefault();
            cl = classPool.makeClass(new ByteArrayInputStream(classfileBuffer));
            CtMethod ctMethod = cl.getDeclaredMethod("test");
            System.out.println("获取方法名称："+ ctMethod.getName());

            ctMethod.insertBefore("System.out.println(\" 动态插入的打印语句 \");");
            ctMethod.insertAfter("System.out.println($_);");

            byte[] transformed = cl.toBytecode();
            return transformed;
        }catch (Exception e){
            e.printStackTrace();

        }
        return classfileBuffer;
    }
}
