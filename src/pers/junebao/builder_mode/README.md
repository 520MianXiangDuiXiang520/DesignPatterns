## 建造者模式（生成器模式）

> 建造者模式（Builder）将一个复杂对象的构建和表示分离，使同样的构建过程可以创建不同的表示。

建造者模式被用来一步一步的构造一些复杂对象，这些对象被构建的步骤（过程）都一样，所以可以把**对象的构建过程**抽离出去作为一个接口或抽象类（Builder），然后具体的建造者（ConcreteBuilder）实现Builder，提供每一步具体做的事。用户需要某个产品时，调用指导者（Director），Director会控Builder按步骤生产具体产品，并返回给用户。

比如要修一个房子，所有修房子的基本步骤是一样的，先打地基，再修四壁，再封顶，最后装修，但具体修不同房子时这些步骤的具体实现却不相同，所以可以把基本步骤抽象到一起（Builder），

```java
public interface BuildHoseBase {
    void foundation();
    void buildWall();
    void buildTop();
    void decoration();
}
```

然后不管是修别墅还是茅草屋，都分别实现这个方法，填写他们自己特有的具体动作（ConcreteBuilder）

```java
public class BuildThatchedHouse implements BuildHoseBase {
    @Override
    public void foundation() {
        System.out.println("茅草屋打什么地基");
    }
    
    @Override
    public void buildWall() {
        System.out.println("插一圈竹子做墙");
    }
    
    @Override
    public void buildTop() {
        System.out.println("房顶搭上茅草");
    }

    @Override
    public void decoration() {
        System.out.println("门口种朵花");
    }
}

public class BuildVilla implements BuildHoseBase {
    // ......
}
```

然后指导者Director负责按顺序调用ConcreteBuilder中的这些方法

```java
public class BuildHouseDirector {
    private BuildHoseBase bb;

    BuildHouseDirector(BuildHoseBase bb){
        this.bb = bb;
    }

    public void build(){
        bb.decoration();
        bb.buildWall();
        bb.buildTop();
        bb.buildTop();
    }
}
```

客户端只需要与Director交互即可

```java
public class Client {
    public static void main(String[] args) {
        new BuildHouseDirector(new BuildThatchedHouse()).build();
    }
}
```



组成角色：

1. 抽象的建造者（Builder）：定义产品被构建的过程或组成成分
2. 具体的建造者（ConcreteBuilder）：实现了Builder的类，定义了构建产品的每一步的具体动作
3. 指导者（Director）：生成器Builder负责每一步骤应该怎么做，指导者Director负责按指定步骤调用生成器生成最终产品；客户端只和指导者交互。
4. 产品（Product）：指导者根据客户端要求创建出的具体的对象。

![UTOOLS1590079429387.png](http://yanxuan.nosdn.127.net/e74479f60d10b17c36cba7eebb31b770.png)

### 优缺点

优点：

1. 隔离了复杂对象的创建和表示，简化了客户端使用的难度
2. 同一创建过程可以创建不同的产品
3. 通过使用建造者模式，对于一些需要很多默认参数的构造器可以不必用”重叠构造函数 （telescopic constructor）“
4. 添加新的产品不需要修改原有代码，符合开闭原则

缺点：

1. 建造者模式只适用于创建具有相同创建过程的对象，对于相差甚大的复杂对象，不适用于创建者模式，可以使用工厂模式
2. 增加多个类，代码复杂度提高。

### 例

>   例子2：计算工资：工资的计算一般是：底薪+奖金-税。但底薪分为一级8000、二级6000、三级4000三个等级。根据岗位不同奖金的发放也不一样，管理及日常事务处理岗位（A类）每月根据领导及同事间的评议得分计算奖金，销售岗位（B类）则根据销售额发放提成。税金则根据奖金和底薪的数额进行计算。由此看出该工资的计算方式是比较稳定的构建算法，但对工资的每一部分都会根据不同的情况产生不同的算法，如何将客户端与变化巨烈的底薪、奖金和税金计算方式分离呢，这也比较适合用建造者模式。
> ------------------------------------------------
> 原文链接：https://blog.csdn.net/hguisu/article/details/7518060

```java
public interface CalculateWagesBuilder {
    double calculateBaseWages();
    double calculateBonus();
    default double calculateTax(){
        return (calculateBaseWages() + calculateBonus()) * 0.3;
    }
}
```

* 不管是哪种类型的员工，计算工资的方式都是先计算基本工资，再计算奖金，最后计算税款

```java
public interface ClassA extends CalculateWagesBuilder {

    // 模拟评分
    default float getScore() {
        return new Random().nextFloat();
    }

    @Override
    default double calculateBonus() {
        return 1000 * getScore();
    }
}

public interface ClassB extends CalculateWagesBuilder{
    //......
}

public interface FirstLevel extends CalculateWagesBuilder{
    //......
}

public interface SecondLevel extends CalculateWagesBuilder{
    //......
}

public class FirstLevelAClass implements FirstLevel, ClassA{}
public class FirstLevelBClass implements FirstLevel, ClassB{}
public class SecondLevelAClass implements SecondLevel, ClassA{}
public class SecondLevelBClass implements SecondLevel, ClassB{}
```

* 分别实现A类， B类，一级， 二级员工具体工资的计算方法（ConcreteBuilder）

```java
public class Director {
    private CalculateWagesBuilder cwb;
    Director(CalculateWagesBuilder cwb){
        this.cwb = cwb;
    }

    public double calculate(){
        double baseWages = cwb.calculateBaseWages();
        System.out.println("基本工资： " + baseWages + " 元");
        double bonus = cwb.calculateBonus();
        System.out.println("奖金： " + bonus + " 元");
        double tax = cwb.calculateTax();
        System.out.println("税款： " + tax + " 元");
        return baseWages + bonus - tax;
    }
}
```

* 指挥者，根据用户需求计算最终工资

```java
public class Client {
    public static void main(String[] args) {
        double finalWages = new Director(new FirstLevelAClass()).calculate();
        System.out.println("一级A类员工 xxx 的最终工资为： " + finalWages + " 元");
    }
}
/*
基本工资： 8000.0 元
奖金： 545.5223999023438 元
税款： 2622.01669921875 元
一级A类员工 xxx 的最终工资为： 5923.505700683594 元
 */
```



### 建造者与工厂模式

建造者模式相比工厂模式多了指挥者，适用于创建比工厂创建的对象更加的对象，且工厂创建的对象之间不存在直接的联系，建造者创建的对象要求构建步骤相同。