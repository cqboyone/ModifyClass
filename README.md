# ModifyClass
## 技术说明

### 字节码修改方式

- JBE(Java Bytecode Editor)
  
  > 仅能实现简单的修改
  
- javassist

  > 提供了更高级的API，执行效率相对较差，但无需掌握字节码指令的知识，对使用者要求较低。

- ASM

  > 直接操作字节码指令，执行效率高，使用者需要掌握Java类字节码文件格式及指令，对使用者的要求比较高。
## 使用
1. 进入编译后的target/classes目录
2. java com.vv.tool.modifyclass.javassist.demo1.Test1
3. 若要修改Test1.clas，在源码中运行AddMethod或者UpdateMethod
## 可参考
- [在不重新编译的情况下直接修改Java Class文件中的内容](https://lucumt.info/post/modify-java-class-file-content-directly/)
- [技术最佳实践-javassist字节码编程](https://www.jianshu.com/p/553fbbd13eba)