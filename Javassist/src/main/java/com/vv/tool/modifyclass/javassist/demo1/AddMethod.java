package com.vv.tool.modifyclass.javassist.demo1;

import javassist.*;

import java.io.IOException;

public class AddMethod {
    public static void main(String[] args) {
        addMethod(Constant.classPath,
                Constant.className,
                "public void showParameters(int a,int b){"
                        + "  System.out.println(\"First parameter: \"+a);"
                        + "  System.out.println(\"Second parameter: \"+b);"
                        + "}",
                "addNumber",
                "{ showParameters($1,$2);return $1*$1*$1+$2*$2*$2; }"
        );
    }

    public static void addMethod(String classPath, String className, String newMethodStr, String oldMethodName, String oldMethodBody) {
        try {
            ClassPool cPool = new ClassPool(true);
            cPool.insertClassPath(classPath);
            CtClass cClass = cPool.get(className);

            CtMethod cMethod = cClass.getDeclaredMethod(oldMethodName);

            //增加一个新方法
            CtMethod newMethod = CtNewMethod.make(newMethodStr, cClass);
            cClass.addMethod(newMethod);

            //修改旧方法，调用新增的方法
            cMethod.setBody(oldMethodBody);
            cClass.writeFile(Constant.classPath);

            System.out.println("=======修改方法完=========");

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}