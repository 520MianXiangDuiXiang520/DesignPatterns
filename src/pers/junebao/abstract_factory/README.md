## 抽象工厂模式

> 抽象工厂模式( Abstract Factory),提供一个创建一系列相关或相互依赖对象的接口,而无需指定它们具体的类。
>
> 参考:
>
> * [refactoringguru | abstract-factory](https://refactoringguru.cn/design-patterns/abstract-factory)
> * [readthedocs | 抽象工厂模式(Abstract Factory)](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html)

工厂方法中每一个工厂只提供一种产品，为此，抽象工厂将工厂方法中的所用工厂向上抽象出一个**抽象工厂**，将所有产品向上抽象出**抽象产品**，这样抽象工厂模式中的角色就包括：

* AbstractFactory：抽象工厂
* ConcreteFactory：具体工厂
* AbstractProduct：抽象产品
* Product：具体产品

![UTOOLS1590241213944.png](http://yanxuan.nosdn.127.net/1e3cd1a0768c113467218f72e1324419.png)

### 简单工厂，工厂方法，抽象工厂

对比三种工厂模式，简单工厂直接在一个**静态工厂**中返回产品实例，没有对产品或工厂做任何抽象，是最简单粗暴的工厂模式，但每次添加新的产品都要修改工厂类，违反**开闭原则**，后来工厂方法将工厂类向上抽象出一个**“抽象工厂接口”**，让每一个具体的工厂类只返回一种产品，这样添加新产品时只需要给“抽象工厂接口”添加新的实现类即可，但工厂方法的问题在于每个具体工厂只能生产一种产品，因此，在抽象工厂中，把一系列产品进一步分装为**抽象产品**，具体工厂就可以产生产生多个产品了。

> 当抽象工厂模式中每一个具体工厂类只创建一个产品对象，也就是只存在一个产品等级结构时，抽象工厂模式退化成工厂方法模式；当工厂方法模式中抽象工厂与具体工厂合并，提供一个统一的工厂来创建产品对象，并将创建对象的工厂方法设计为静态方法时，工厂方法模式退化成简单工厂模式。

### 实现方法

> 模拟在 MySQL 或 SQLServer 数据库中对用户信息（User）和部门信息（Department）的查询（select）和插入（insert）功能。（假设MySQL 和 SQLServer 中的查询和插入语句不同），同时希望客户端对数据库的变更不敏感。

要实现的功能是在 MySQL 或 SQL Server 中实现对 User 和 Department 的插入和查询，把 SQL Server 的插入和查询看作 MySQL 插入查询的变体，那么就可以把系统功能抽象为对 User 的操作和对 Department 的操作，分别建立两个接口表示：

```java
public interface IUserDao {
    void insert(User user);
    void select(String name);
}
```

```java
public interface IDepartDao {
    Department select(String name);
    void insert(Department department);
}
```

由于 MySQL 和 SQLServer 中的查询和插入语句不同， 所以他们分别实现这两个接口，表示两种数据库具体的操作细节。

```java
public class MySQLUserDao implements IUserDao {
    @Override
    public void insert(User user) {
        System.out.println("使用MySQL的插入方法把User插入表中");
    }

    @Override
    public void select(String name) {
        System.out.println("使用MySQL中的查询方法查询name");
    }
}

public class MySQLDepartDao implements IDepartDao {
    // ......
}

public class SQLServerUserDao implements IUserDao {
    // ......
}

public class SQLServerDepartDao implements IDepartDao {
    // ......
}
```

然后就需要一个工厂来产生具体的用来操作数据的对象，如果采用工厂方法，就要建立四个工厂类，产品更多时，显然不合适，但其实`MySQLUserDao`和`MySQLDepartDao`可以看作是一类对象（MySQL处理数据的对象），`SQLServerUserDao`和`SQLServerDepartDao`可以看作是一类对象（SQL Server处理数据的对象），这样只需要建立两个工厂类就可以了，这两个工厂类又可以向上抽象（他们都是返回一个`IUserDao`对象， 一个`IDepartDao`）对象，所以最终为：

```java
public interface IFactor {
    IUserDao getUserDao();
    IDepartDao getDepartDao();
}
```

```java
public class MySQLFactory implements IFactor {
    @Override
    public IDepartDao getDepartDao() {
        return new MySQLDepartDao();
    }

    @Override
    public IUserDao getUserDao() {
        return new MySQLUserDao();
    }
}
```

```java
public class SQLServerFactory implements IFactor {
    @Override
    public IDepartDao getDepartDao() {
        return new SQLServerDepartDao();
    }

    @Override
    public IUserDao getUserDao() {
        return new SQLServerUserDao();
    }
}
```

客户端代码：

```java
public class Client {
    public static void main(String[] args) {
        IFactor factor = new MySQLFactory();
        IUserDao userDao = factor.getUserDao();
        IDepartDao departDao = factor.getDepartDao();
        userDao.insert(new User("1", "张三"));
        userDao.select("张三");
    }
}
```

![UTOOLS1590249752897.png](http://yanxuan.nosdn.127.net/574f6896e4e9902de4d8a42e79d76422.png)

#### 实现方法总结

1. 判断要实现的多个功能是否存在 “变体” 的情况，**找出抽象产品**（对User 和 Department的操作）并**定义抽象产品接口**（IUserDao， IDepartDao）
2. 实现每个变体的具体产品
3. 声明抽象工厂接口， 并且在接口中为所有抽象产品提供一组构建方法。
4. 实现具体工厂

### 反射改进抽象工厂

如果抽象工厂中加入了新的产品，那首先必须改变抽象工厂接口,其次所有的具体工厂类也要跟着修改，为此可以选择放弃工厂方法的思想，改用简单工厂的思想。

```java
public class DaoFactory {
    private static String db = "MySQL";
//    private static String db = "SQLServer";
    
    public static IUserDao getUserDao(){
        switch (db){
            case "MySQL":
                return new MySQLUserDao();
            case "SQLServer":
                return new SQLServerUserDao();
            default:
                return null;
        }
    }
    
    public static IDepartDao getDepartDao(){
        switch (db){
            case "MySQL":
                return new MySQLDepartDao();
            case "SQLServer":
                return new SQLServerDepartDao();
            default:
                return null;
        }
    }
}
```

![UTOOLS1590249958754.png](http://yanxuan.nosdn.127.net/d0de9cbfedfa09847952381150c3c0e5.png)

放弃抽象工厂接口以及具体工厂类后，如果要添加新产品，只要修改`DaoFactory`一个类就可以了，并且由于在`DaoFactory`中定义了要使用的数据库的类型（变体），换数据库时，就只需要改变`DaoFactory`就可以了，进一步降低了与客户端的耦合度。但简单工厂“从工厂内看”不符合开闭原则，如果要新添加一个数据库（新添加一种变体）如Oricle, 使用工厂方法时只需要添加一个抽象工厂接口的实现类（满足开闭原则），现在需要修改`DaoFactory`（不符合开闭原则），为此可以使用反射。

```java
package pers.junebao.abstract_factory.db;

public class DaoFactory {
    private static String db = "MySQL";
//    private static String db = "SQLServer";

    public static IUserDao getUserDao(){
        try {
            try {
                return (IUserDao) Class.forName("pers.junebao.abstract_factory.db.SQLServer" + db + "UserDao").newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static IDepartDao getDepartDao(){
        try {
            try {
                return (IDepartDao) Class.forName("pers.junebao.abstract_factory.db." + db + "DepartDao").newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

```

完整类名，选择的数据库名这些都可以放到配置文件中，进一步降低修改成本

### 使用场景和优缺点

适用场景：

1. 客户端不应该关心产品具体的创建细节时（所有工厂方法适用）
2. 系统中存在多个“变种”，并且同一时刻只使用其中一个。

优点：

> * 抽象工厂模式隔离了具体类的生成，使得客户并不需要知道什么被创建。由于这种隔离，更换一个具体工厂就变得相对容易。所有的具体工厂都实现了抽象工厂中定义的那些公共接口，因此只需改变具体工厂的实例，就可以在某种程度上改变整个软件系统的行为。另外，应用抽象工厂模式可以实现高内聚低耦合的设计目的，因此抽象工厂模式得到了广泛的应用。
> * 当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象。这对一些需要根据当前环境来决定其行为的软件系统来说，是一种非常实用的设计模式。
> * 增加新的具体工厂和产品族很方便，无须修改已有系统，符合“开闭原则”。

缺点:

> * 在添加新的产品对象时，难以扩展抽象工厂来生产新种类的产品，这是因为在抽象工厂角色中规定了所有可能被创建的产品集合，要支持新种类的产品就意味着要对该接口进行扩展，而这将涉及到对抽象工厂角色及其所有子类的修改，显然会带来较大的不便。
> * 开闭原则的倾斜性（增加新的工厂和产品族容易，增加新的产品等级结构麻烦）。