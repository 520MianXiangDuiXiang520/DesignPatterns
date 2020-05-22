## 观察者模式

> 观察者模式又叫**发布订阅**模式，它定义了一种一对多的依赖关系,让多个观察者对象同时监听某一个主题对象。这个主题对象在状态发生变化时会通知所有观察者对象,使它们能够自动更新自己。
>
> 参考：
>
> * [design-patterns.readthedocs |观察者模式](https://design-patterns.readthedocs.io/zh_CN/latest/behavioral_patterns/observer.html#id16)
> * [refactoringguru | 观察者模式](https://refactoringguru.cn/design-patterns/observer)
> * [博客园 | 简说设计模式——观察者模式](https://www.cnblogs.com/adamjwh/p/10913660.html)
> * [CSDN | 设计模式 ( 十五 ) 观察者模式Observer（对象行为型）](http://blog.csdn.net/hguisu/article/details/7556625)

有时需要在对象和对象之间建立一种一对多的联系，使得某个对象（频道/目标）发生改变时，能够通知其他对他感兴趣的对象（订阅者/观察者）使之能够及时根据**目标**的变化更新自己的状态。

组成：

1. 目标（Subject）：它是具体目标的一个抽象，有时可以只有具体目标，一般包含一个用来保存所有订阅（观察）此目标的**容器**以及**添加删除订阅者的方法**和通知所有订阅者的**方法**。

   ```java
   public abstract class Subject {
       private Set<Observer> observers = new HashSet<>();
   
       void addObserver(Observer observer) {
           observers.add(observer);
       }
   
       void delObserver(Observer observer){
           observers.remove(observer);
       }
   
       /**
        * 通知所有订阅者
        */
       void noticeAll() {
           for (Observer observer : observers) {
               observer.update();
           }
       }
   
   }
   ```

   

2. 具体目标（ConcreteSubject）: 目标的具体实现

3. 观察者（Observer）：具体观察者的抽象，一般是一个接口，接口中至少有一个当目标发生变化后更新自己的方法。

   ```java
   public interface Observer {
       void update();
   }
   ```

   

4. 具体观察者（ConcreteObserver）：观察者的具体实现。

   ```java
   public class ConcreteObserver implements Observer {
       @Override
       public void update() {
           System.out.println("更新了");
       }
   }
   ```

<img src="http://yanxuan.nosdn.127.net/8f76afa16938cc98998834190db1ad82.png" alt="UTOOLS1590158692083.png" style="zoom:50%;" />

### 使用场景

> * 一个抽象模型有两个方面，其中一个方面依赖于另一个方面。将这些方面封装在独立的对象中使它们可以各自独立地改变和复用。
> * 一个对象的改变将导致其他一个或多个对象也发生改变，而不知道具体有多少对象将发生改变，可以降低对象之间的耦合度。
> * 一个对象必须通知其他对象，而并不知道这些对象是谁。
> * 需要在系统中创建一个触发链，A对象的行为将影响B对象，B对象的行为将影响C对象……，可以使用观察者模式创建一种链式触发机制

实例：

> MVC模式是一种架构模式，它包含三个角色：模型(Model)，视图(View)和控制器(Controller)。观察者模式可以用来实现MVC模式，观察者模式中的观察目标就是MVC模式中的模型(Model)，而观察者就是MVC中的视图(View)，控制器(Controller)充当两者之间的中介者(Mediator)。当模型层的数据发生改变时，视图层将自动改变其显示内容。

### 优缺点

优点：

1. 符合开闭原则，引入新的订阅者无需修改发布者代码
2. 可以在运行时动态建立对象之间的联系
3. 支持广播
4. 观察者模式可以实现表示层和数据逻辑层的分离，并定义了稳定的消息更新传递机制，抽象了更新接口，使得可以有各种各样不同的表示层作为具体观察者角色。
5. 观察者模式在观察目标和观察者之间建立一个抽象的耦合。

缺点：

1. 如果观察者和目标存在循环订阅，可能导致系统崩溃
2. 观察者只能知道目标变换了，不知道目标怎么变化的
3. 如果观察者和目标之间存在多个观察者，这样消息传递会很费时
4. 通知顺序可能是随机的

### Java对观察者模式的支持

Java util包中提供了 `Observer`接口和`Observable`类，前者就是观察者接口，后者相当于目标 Subject，实现具体目标时可以继承该类。

```java
public interface Observer{ 
    void update(Observable o, Object arg);
}
```

* 相比自己定义的`Observer`接口， 官方的update方法多了两个参数，第一个参数是被观察者（目标）的一个引用，第二个参数是目标发生变化时调用`notifyObservers`方法时传递过来的。

`Observable`类中定义的方法和上面的`Subject`类似,但是它做了更完整的的并发控制，并且使用了一个布尔变量`changed`标识目标是否被修改，并使用`setChanged()`和`CleanChanged()`两个方法控制这个变量，只有这个变量是`true`时，才会通知所有观察者，通知完后重新置为`false`,所以如果要让自己的方法调用时通知所有观察者，需要调用`setChanged()`

### 例

不同的顾客可以订阅不同的电视频道，电视频道发布新电视时，通知所有订阅者

```java
import java.util.Observable;

public class CCTV1 extends Observable {
    public void release(){
        this.setChanged();
        this.notifyObservers();
    }
}
```

```java
import java.util.Observable;
import java.util.Observer;

public class Customer implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println( o.getClass().getSimpleName() + " 发布新节目");
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        CCTV1 cctv1 = new CCTV1();
        Customer customer1 = new Customer();
        // 顾客1订阅CCTV1
        cctv1.addObserver(customer1);
        cctv1.release();
    }
}
```



