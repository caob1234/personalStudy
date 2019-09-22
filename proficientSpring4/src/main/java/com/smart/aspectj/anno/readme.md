# java5.0注解知识快速进阶
## 1.了解注解
>对于java开发人员来说，在编写代码时，除源程序外，还会使用Javadoc标签对类、方法或成员变量进行注释，以便利用Javadoc工具生成和源码对应的注释文档。这些@param、@return等Javadoc标签就是注解标签，它们为第三方工具提供了描述程序代码的注释信息。
java5.0注解可以看作是Javadoc和Xdoclet标签的延伸和发展。在java5.0中可以自定义这些注解，并通过反射机制获取类中标注的注解，完成特定的功能。
注解是代码的附属信息，它遵循一个基本原则：注解不能直接干扰代码的运行，无论增加或删除注解，代码都能够正常运行。
Java语言解释器会忽略这些注解，而有第三方工具负责对注解进行处理。第三方工具可以通过注解间接控制代码的运行，
他们通过java反射机制读取注解的信息，并根据这些信息更改目标程序的逻辑，而这也是spring AOP对@AspectJ提供支持所采取的方法。
## 2.一个简单的注解类
```
package com.smart.aspectj.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //1️⃣
@Target(ElementType.METHOD) //2️⃣
public @interface NeedTest {   //3️⃣
    boolean value() default true;   //4️⃣
}
```

>Java新语法规定使用@interface修饰符定义注解，如3️⃣处所示；一个注解可以拥有多个成员，成员声明和接口声明类似，这里仅定义了一个成员，
如4️⃣处所示。成员声明有以下几点限制：

>- 成员以无入参、无抛出异常的方式声明，如boolean value(String str);boolean value() throws Exception;等方式是非法的。
>- 可以通过default为成员指定默认值。
>- 成员类型是受限，合法的类型包括原始类型及其封装类、String、class、enum、注解类型，以及上述类型的数组类型，如
ForumService value（）、List value（）是非法的。

>在1️⃣和2️⃣处所看到的注解是java预定义的注解，称为元注解（Meta-Annotation）,它们被java编译器使用，会对注解类的行为产生影响。@Retention(RetentionPolicy.RUNTIME)表示NeedTest这个注解可以在运行期被JVM读取，注解的保留期限类型在java.lang.annotation.Rentention类中定义，介绍如下：
>- SOURCE：注解信息仅保留在目标类代码的源码文件中，但对应的字节码文件将不再保留。
>- CLASS：注解信息将进入目标类代码的字节码文件中，但类加载器加载字节码文件时，将不会把注解加载到JVM文件中，即运行期不能获取注解信息。
>- RUNTIME：注解信息在目标类加载到JVM后依然保留，在运行期可以通过反射机制读取注解信息。

>@Target(ElementType.METHOD) 表示NeedTest注解只能应用到目标类的方法上，注解的应用目标在java.lang.annotation.ElementType类中定义，介绍如下。
>- TYPE：类、接口、注解类、Enum声明处，相应的注解称为类型注解。
>- FIELD：类成员变量或常量声明处，相应的注解称为域值注解。
>- METHOD：方法声明处，相应的注解称为方法注解。
>- PARAMETER：参数声明处，相应的注解，称为参数注解。
>- CONSTRUCTOR：构造函数声明处，相应的注解称为构造函数注解。
>- LOCAL_VARIABLE：局部变量声明处，相应的注解称为局域变量注解。
>- ANNOTATION_TYPE：注解类声明处，相应的注解称为注解类注解。ElementType.TYPE包括ElementType.ANNOTATION_TYPE
>- PACKAGE：包声明处，相应的注解称为包注解。
- TYPE_PARAMETER：类型参数声明处。java官方文档描述：Type parameter declaration。该ElementType是在java8中新加的。
- TYPE_USE：使用一个类型。java官方文档描述：Use of a type。该ElementType是在java8中新加的。

>如果注解只有一个成员，建议成员名取名为value()，则在使用时可以忽略成员名和赋值号，如@NeedTest(true)。当注解类拥有多个成员时，如果仅
对value()成员进行赋值，则也可不使用赋值号；如果同时对多个成员进行赋值，则必须使用赋值号，如DeclareParent(value="NaiveWaiter",defaultImpl=SmartSeller.class).
所有注解类都隐式继承java.lang.annotation.Annotation,但注解不允许显示继承其它接口。

java8官方文档对ElementType的描述如下：
The constants of this enumerated type provide a simple classification of the syntactic locations where annotations may appear in a Java program. These constants are used in java.lang.annotation.Target meta-annotations to specify where it is legal to write annotations of a given type.
The syntactic locations where annotations may appear are split into declaration contexts , where annotations apply to declarations, and type contexts , where annotations apply to types used in declarations and expressions.

The constants ANNOTATION_TYPE , CONSTRUCTOR , FIELD , LOCAL_VARIABLE , METHOD , PACKAGE , PARAMETER , TYPE , and TYPE_PARAMETER correspond to the declaration contexts in JLS 9.6.4.1.

For example, an annotation whose type is meta-annotated with @Target(ElementType.FIELD) may only be written as a modifier for a field declaration.

The constant TYPE_USE corresponds to the 15 type contexts in JLS 4.11, as well as to two declaration contexts: type declarations (including annotation type declarations) and type parameter declarations.

For example, an annotation whose type is meta-annotated with @Target(ElementType.TYPE_USE) may be written on the type of a field (or within the type of the field, if it is a nested, parameterized, or array type), and may also appear as a modifier for, say, a class declaration.

The TYPE_USE constant includes type declarations and type parameter declarations as a convenience for designers of type checkers which give semantics to annotation types. For example, if the annotation type NonNull is meta-annotated with @Target(ElementType.TYPE_USE), then @NonNull class C {...} could be treated by a type checker as indicating that all variables of class C are non-null, while still allowing variables of other classes to be non-null or not non-null based on whether @NonNull appears at the variable's declaration.

以上一堆主要是说明了，ElementType是为了句法定位，即注解可以出现在程序中什么位置的简单分类。比如，
用元注解（meta-annotated）@Target(ElementType.Filed)注释的注解，只能作为字段修饰符被写入。

## 3.测试注解类NeedTest

```
package com.smart.aspectj.anno;

public class ForumService {
    private static String field="this is filed declaration";
    @NeedTest(value = true)
    public void deleteForum(int forumId){
        System.out.println("delete forum module: "+forumId);
    }

    @NeedTest(value = false)
    public void deleteTopic(int postId){
        System.out.println("delete forum topic: "+postId);
    }
}

~~~~

package com.smart.aspectj.anno;

import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ToolTest {
    @Test
    public void tool(){
        Class clazz = ForumService.class;

        Method[] methods = clazz.getDeclaredMethods();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(methods.length);
        System.out.println(fields.length);
        for (Method method:methods){
            NeedTest needTest =method.getAnnotation(NeedTest.class);
            if (needTest!=null){
                if (needTest.value()){
                    System.out.println(method.getName() + " need test");
                }else {
                    System.out.println(method.getName() + " not need test");
                }
            }
        }
    }
}

```

这里可以看出来，注解本身并没有什么神奇之处。它只是在传递值的过程中起了作用。它并没有出现在最神奇的那个地方。
这就像我们每天开灯一样，电流从发电站流到了灯泡，我们只关注开灯那一刻带给我们的光明。
但如果要细究整个开灯的过程的话，你就会发现，电流从发电站经电线再由开关控制流到了灯泡里面，这个过程中还需要
电线和开关贡献力量。而注解本身恰似电线在送电过程中体现出来的作用，是一个传输的通道。而在送电过程中的开关，
更像是上面代码中反射控制，只要把它放到了合适的位置，连接到了可运行的灯泡，奇迹就会发生，光明就会覆盖你的视线。再想想，发电站就像是spring容器。
