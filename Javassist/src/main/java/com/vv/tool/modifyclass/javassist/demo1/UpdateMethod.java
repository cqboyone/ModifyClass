package com.vv.tool.modifyclass.javassist.demo1;

import javassist.*;

import java.io.IOException;

public class UpdateMethod {

    public static void main(String[] args) {
        updateMethod(Constant.classPath,
                Constant.className,
                "addNumber",
                "{ return $1*$1*$1+$2*$2*$2; }"
        );
    }

    public static void updateMethod(String classPath, String className, String methodName, String methodBody) {
        try {
            ClassPool cPool = new ClassPool(true);
            //如果该文件引入了其它类，需要利用类似如下方式声明
            //cPool.importPackage("java.util.List");

            //设置class文件的位置
            cPool.insertClassPath(classPath);

            //获取该class对象
            CtClass cClass = cPool.get(className);

            //获取到对应的方法
            CtMethod cMethod = cClass.getDeclaredMethod(methodName);

            //更改该方法的内部实现
            //需要注意的是对于参数的引用要以$开始，不能直接输入参数名称
            cMethod.setBody(methodBody);

            //替换原有的文件
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