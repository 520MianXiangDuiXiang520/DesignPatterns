## 装饰模式

> 装饰模式：动态的给某些对象添加额外的功能
>
> 参考：
>
> * [简书 | 装饰模式](https://www.jianshu.com/p/ff308c759f0a)
>
> * [博客园 | 简说设计模式——装饰模式](https://www.cnblogs.com/adamjwh/p/9036358.html)
>
> *  [博客园 | 装饰器模式 Decorator 结构型 设计模式 (十)](https://www.cnblogs.com/noteless/p/9603041.html)

### 什么是装饰模式

装饰模式也叫装饰器模式，python中的装饰器就是这种模式的体现，对于一个类，如果要添加一个新功能，除了修改代码外（违反开闭原则），可以使用继承，但通过继承添加新功能并不适合所有场景，如

1. 类不可见或不允许继承
2. 需要对一批类似的兄弟类添加同一个新功能时，继承会产生大量的子类
3. 希望新功能的添加和撤销是动态的
4. ......

装饰模式中的对象包括：

1. 装饰器（用来为**被装饰对象**动态添加新功能）

2. 抽象被装饰对象（所有能被装饰对象的抽象）

3. 被装饰对象

客户端如果希望给某个对象动态添加一个新功能，就可以把这个对象（被装饰对象）传递给装饰器，由装饰器实现新功能，并保存一个被装饰对象的引用，并返回给客户端一个装饰器对象，这样，被装饰对象原来的行为和属性并没有改变，甚至被装饰对象本身就没有改变，只是在外面套了一个壳子，新功能是这个壳子提供的。就像TCP/IP协议栈中，应用层的数据包到传输层通过加TCP或UDP首部来传输一样。

### 装饰模式优缺点

优点：

1. 一个装饰器可以给多个不同的类动态添加新功能
2. 新功能由装饰器实现，不需要修改被装饰对象，有一定的安全性
3. 多个装饰器可以配合嵌套使用，以此实现更复杂的功能
4. 新功能不影响原来的功能，添加和撤销都方便

缺点：

1. 过多的装饰类可能使程序变得很复杂

2. > 装饰模式是针对抽象组件（Component）类型编程。但是，如果你要针对具体组件编程时，就应该重新思考你的应用架构，以及装饰者是否合适。当然也可以改变Component接口，增加新的公开的行为，实现“半透明”的装饰者模式。在实际项目中要做出最佳选择。
   >
   > 作者：[慵懒的阳光丶](https://www.jianshu.com/p/ff308c759f0a)

### 适用场景

1. 要添加的新功能与原有类关联不大时
2. 新功能需要方便添加和撤销时
3. 不能或不方便通过继承实现新功能时

### 例

比如卖烤冷面，最基本的就是面（抽象被装饰对象）具体的就是烤冷面（被装饰对象），然后可以往面里面加各种配料（抽象装饰器），如鸡蛋，辣条等（具体装饰器），由于不同配料的加入顺序对最后的烤冷面有影响，所以如果要用继承拓展“烤冷面”，那先加鸡蛋再加辣条和先加辣条再加鸡蛋就需要写两个子类，造成冗余重复，这种场景就适合适用装饰模式。

抽象被装饰对象

```java
package pers.junebao.decorator_pattern;

public abstract class Noodles {
    public String rawMaterial;  // 配料
    public abstract void sayWhoAmI();
}
```

具体的被装饰对象：

```java
package pers.junebao.decorator_pattern;

public class BakedColdNoodles extends Noodles {

    BakedColdNoodles() {
        this.rawMaterial = "面";  // 最原始的烤冷面，配料只有面
    }

    @Override
    public void sayWhoAmI() {
        System.out.println("我是普通烤冷面！");
    }
}

```

抽象装饰器：

```java
package pers.junebao.decorator_pattern.decorator;

import pers.junebao.decorator_pattern.Noodles;

public abstract class Burden extends Noodles {
    public Noodles noodles;  // 装饰器中保留一份被装饰对象的引用，方便客户端使用
    public Burden(Noodles noodles) {
        this.noodles = noodles;
    }
}
```

* 装饰器是为某一类对象提供装饰的（这里就是实现了Noodles 的类）

具体的装饰器类：

* 加鸡蛋

  ```java
  package pers.junebao.decorator_pattern.decorator;
  
  import pers.junebao.decorator_pattern.Noodles;
  
  public class AddEggs extends Burden {
  
      public AddEggs(Noodles noodles) {
          super(noodles);
          this.rawMaterial = noodles.rawMaterial + ", 鸡蛋";
      }
  
  
      @Override
      public void sayWhoAmI() {
          System.out.println("我是加了鸡蛋的烤冷面！！");
      }
  
  }
  ```

* 加辣条

  ```java
  package pers.junebao.decorator_pattern.decorator;
  
  import pers.junebao.decorator_pattern.Noodles;
  
  public class AddSpicyStrips extends Burden{
      public AddSpicyStrips(Noodles noodles) {
          super(noodles);
          this.rawMaterial = noodles.rawMaterial + " ,辣条";
      }
  
      @Override
      public void sayWhoAmI() {
          System.out.println("我是加了辣条的烤冷面！！");
      }
  }
  ```

客户端：

```java
package pers.junebao.decorator_pattern;

import pers.junebao.decorator_pattern.decorator.AddEggs;
import pers.junebao.decorator_pattern.decorator.AddSpicyStrips;

public class Main {
    public static void main(String[] args) {
        Noodles bcn = new BakedColdNoodles();
        Noodles bcnAddEgg = new AddEggs(bcn);
        bcnAddEgg.sayWhoAmI();
        System.out.println(bcnAddEgg.rawMaterial);
        Noodles bcnEggSpicyS = new AddSpicyStrips(bcnAddEgg);
        bcnEggSpicyS.sayWhoAmI();
        System.out.println(bcnEggSpicyS.rawMaterial);
    }
}
/*
我是加了鸡蛋的烤冷面！！
面, 鸡蛋
我是加了辣条的烤冷面！！
面, 鸡蛋 ,辣条
 */
```

这样如果想先加辣条在家鸡蛋，就可以使用AddSpicyStrips先装饰BakedColdNoodles，再用AddEggs装饰AddSpicyStrips。
