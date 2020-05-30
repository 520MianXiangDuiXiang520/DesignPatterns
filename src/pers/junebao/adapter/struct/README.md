## 适配器模式

> **适配器模式( Adapter)**,将一个类的接口转换成客户希望的另外一个接口。 Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。

适配器模式包括**类适配器**和**对象适配器**两种，类适配器是适配器类同时实现目标抽象类和适配者类，这样需要编程语言支持多继承。

```python
class Target:
    def show(self):
        print("Target")


class Adaptee:
    def show(self):
        print("Adaptee")


class Adapter(Target, Adaptee):
    def show(self):
        Adaptee().show()


class Client:
    def test(self, target: Target):
        target.show()


if __name__ == '__main__':
    Client().test(Adapter())
```

对象适配器实现了其中一个对象的接口， 并对另一个对象进行封装。

如客户端必须需要一个`Target`类型的对象

```java
public interface Target {
}

public class Client {
    public void test(Target target){
        System.out.println(target);
    }
}
```

但却只能提供一个`Give`类型对象(**`Target`和`Give` 只是类型不同，数据和行为都相同**)

```java
public class Give {
    void show(){
        System.out.println(" Give ");
    }
}
```

为了可以让让`Give`正常工作，使用**适配器模式**，定义一个适配器类（或接口），实现目标接口，封装提供的接口对象

```java
public class Adapter implements Target {
    private Give give;

    Adapter(Give give){
        this.give = give;
    }

    public void show() {
        give.show();
    }
}
```

这样先把`Give`对象传递给`Adapter`再把`Adapter`对象传给`Client`就可以让`Give`和`Client`一起正常工作了。

```txt
public static void main(String[] args) {
    new Client().test(new Adapter(new Give()));
}
```

![UTOOLS1590507358421.png](http://yanxuan.nosdn.127.net/cf4f638ffe842e987a6d66ace6c36c3a.png)

### 适用环境

1. 系统需要使用现有的类，而这些类的接口不符合系统的需要。
   * 适配器模式是接口不符且无法修改的情况下的无奈之举，例如在使用第三方模块时，无需为此修改自己的系统，这时可以选择使用适配器模式，但如果是由于前期设计不好导致接口不符，且二者其一的代码允许修改，应该尽量选择重构来统一接口而不是适配器。
2. 想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类一起工作。

### 优缺点

**优点：**

> * 将目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，而无须修改原有代码。
> * 增加了类的透明性和复用性，将具体的实现封装在适配者类中，对于客户端类来说是透明的，而且提高了适配者的复用性。
> * 灵活性和扩展性都非常好，通过使用配置文件，可以很方便地更换适配器，也可以在不修改原有代码的基础上增加新的适配器类，完全符合“开闭原则”。

**缺点：**

* > 对于类适配器，并不能很好支持 Java 这种只支持单继承的语言。

* > 对于对象适配器，要想置换适配者类的方法就不容易。如果一定要置换掉适配者类的一个或多个方法，就只好先做一个适配者类的子类，将适配者类的方法置换掉，然后再把适配者类的子类当做真正的适配者进行适配，实现过程较为复杂。