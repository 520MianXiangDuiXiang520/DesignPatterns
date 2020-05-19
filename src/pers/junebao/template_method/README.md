## 模板方法

> 模板方法：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。 模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
>
> 参考：
>
> 1. [CSDN | 模板方法](https://blog.csdn.net/hguisu/article/details/7564039)
> 2. [refactoringguru | template-method](https://refactoringguru.cn/design-patterns/template-method)
> 3. [refactoringguru | strategy](https://refactoringguru.cn/design-patterns/strategy)

### 什么是模板方法

> 当不变的和可变的行为在方法的子类实现中混合在一起的时候,不变的行为就会在子类中重复出现。我们通过模板方法模式把这些不变的行为搬移到单一的地方,这样就帮助子类摆脱重复的不变行为的纠缠。

如果多个类的结构都一样，只有具体的算法不相同时，我们可以把相同的结构抽象为一个公共接口或抽象类（模板）在模板里“提前”调用子类的具体实现方法，子类只需要重写自己特有的算法即可，以此可以精简代码，提高可维护性。

Template是一个抄作业的模板，抄作业时除了名字别的都一样，所以具体的子类（Student1）只需要自己实现写名字的方法（writeName）即可，不同的实现类调用doHomework时，除了writeName是自己实现的，别的都是一样的。

```java
public abstract class Template {
    abstract String writeName();

    public final void doHomework(){
        System.out.println("name: " + writeName());
        System.out.println("别人的作业 ");
    }
}
```

```java
public class Student1 extends Template {
    @Override
    String writeName() {
        return "student1";
    }
}
```

* 模板中的顶级模块（doHomework）一般定义为`final`以防止被子类修改而违反**开闭原则**

* 模板中的抽象方法（writeName）的作用仅仅是迫使子类必须实现，所以一般定义为`protected `而不是公开给客户端。

### 实现方式

1. 将现有的算法拆分为多个子模块，分析每个子模块，找出可重用的模块
2. 将可重用的模块进行抽象
3. 子类实现接口或抽象类后重写特有模块

<img src="http://yanxuan.nosdn.127.net/fe7e91d171716370c89a7200eb40a97e.png" alt="UTOOLS1589885971103.png" style="zoom:80%;" />

### 优缺点

优点：

1. 可以减少代码冗余，提高可读性和可维护性
2. 一个类修改了自己的算法，对其他类影响很小

缺点：

1. 模板方法采用的是一种**反向控制结构（好莱坞模式）**，即父类调用子类的方法，违反了**里氏替换原则**
2. 模板方法中的步骤越多， 其维护工作就可能会越困难。

### 模板方法和策略模式

模板方法和策略模式都是针对多个类的不同算法的，有时两者可以互相替换使用，不同点在于策略模式使用**组合**方式，你可以通过对相应行为提供不同的策略来改变对象的部分行为，它在对象层次上运作， 因此允许在运行时切换行为。；模板方法是通过**继承**实现的，在类层次上运作， 因此它是静态的。

| 模板方法                                                     | 策略模式                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| <img src="http://yanxuan.nosdn.127.net/35245494275f22acad01c20368e0d467.png" alt="UTOOLS1589888485347.png" style="zoom:50%;" /> | <img src="http://yanxuan.nosdn.127.net/8d3898d8c5547525daba1a4b895c2fb7.png" alt="UTOOLS1589888507846.png" style="zoom:50%;" /> |