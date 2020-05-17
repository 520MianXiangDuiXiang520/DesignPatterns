## 工厂方法模式

> **define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate.**
>
> 参考：
>
> 1. [refactoringguru | factory-method](https://refactoringguru.cn/design-patterns/factory-method)
> 2. [javatpoint | factory-method-design-pattern](https://www.javatpoint.com/factory-method-design-pattern)
> 3. [博客园| 工厂方法](https://www.cnblogs.com/gdwkong/p/8413342.html)

### 简单工厂的问题

简单工厂把可能很复杂的对象创建过程分装在工厂类内部，客户端只需要给简单工厂一个“类的标志”，工厂类就能动态返回一个实例化对象，这样的好处是简化了客户端操作，从客户端按说，符合开闭原则，但每次添加新的产品，都需要修改工厂类，添加新的判断逻辑，不符合**开闭原则**。为了解决简单工厂的这个问题，工厂方法中会先定义一个创建对象的接口或抽象类，然后让子类去决定实例化哪个类。

### 工厂方法的优点

1. 客户端只需要知道产品对应的接口即可，无需关心产品的具体实现细节。
2. 比简单工厂有更好的可拓展性，添加新产品只需要实现接口即可。
3. 耦合度进一步下降。

### 适用场景

1. 如果无法预知对象确切类别及其依赖关系时
2. 需要将类的实例化过程延迟到其子类时
3. 工厂方法可以复用创建好的对象来节省资源（缓存）

### 例
![UTOOLS1589728531095.png](http://yanxuan.nosdn.127.net/f4b1d756e8bcb653606a6a4e3636d3dd.png)
所有工厂类的接口：

```java
public interface IPhoneFactory {
    BasePhone createPhone();
}
```

具体的工厂实现类中实例化产品：

```java
public class HonorFactory implements IPhoneFactory {
    @Override
    public BasePhone createPhone() {
        BaseCPU cpu = new KirinFactory().createCPU();
        BaseCamera camera = new LeicaFactory().createCamera();
        return new Honor(cpu, camera);
    }
}
```

```java
public class OnePlusFactory implements IPhoneFactory {
    @Override
    public BasePhone createPhone() {
        BaseCPU cpu = new QualcommFactory().createCPU();
        BaseCamera camera = new SonyFactory().createCamera();
        return new OnePlus(cpu, camera);
    }
}
```

客户端只需要知道相关接口或抽象类即可，无需关心产品细节

```java
public class Consumer {
    public static void main(String[] args) {
        BasePhone onePlus = new OnePlusFactory().createPhone();
        onePlus.printConfig();
        BasePhone honor = new HonorFactory().createPhone();
        honor.printConfig();
    }
}
```