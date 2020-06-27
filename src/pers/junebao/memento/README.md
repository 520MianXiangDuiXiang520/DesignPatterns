## 备忘录模式

> **备忘录模式**是一种行为设计模式， 允许在不暴露对象实现细节的情况下保存和恢复对象之前的状态。

备忘录模式又叫**快照模式**，用于在**不破坏原对象封装**的条件下保存对象某一时刻的 “状态” ，作为一个 “备忘录（或快照）” ，并且可以在原对象改变后通过备忘录恢复 原来的状态，最典型的例子是游戏存档。

> 通过直接拷贝对象也可以保存状态，但保存的是整个对象的所有状态，恢复时也会把对象完全恢复到原来状态。备忘录模式只保存对象状态，不保存对象本身，所以可以选择保存和恢复部分属性，更灵活，性能也更好。

备忘录模式涉及到的成员角色包括：

* 发起者（Originator）：发起者负责生成备忘录并根据备忘录恢复对象状态
* 备忘录（Memento）：备忘录对象应该只能被发起者创建和修改
* 负责人（Caretaker）：只负责存储备忘录对象，甚至不应该读备忘录

![image-20200531233400236](image/README/image-20200531233400236.png)

**代码：**

```java
public class Originator {
    private String state = "OFF";
    /**
     * 创建备忘录，保存当前状态
     * @return 返回保存了当前对象状态的备忘录对象
     */
    public Memento createMemento(){
        return new Memento(this.state);
    }

    /**
     * @param memento 恢复 memento 中保存的对象状态
     */
    public void restoreByMemento(Memento memento){
        this.state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
```

```java
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
```

管理者只负责保存备忘录对象，不会去修改或查看

```java
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        System.out.println(originator.getState());

        // 保存状态
        Memento memento = originator.createMemento();
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(memento);

        // 修改状态
        originator.setState("ON");
        System.out.println(originator.getState());

        // 恢复状态
        originator.restoreByMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }
}

```

### 黑盒模式

在上面的结构中对象状态被保存在备忘录中，备忘录保存在管理者中，这样存在的问题是备忘录中的状态信息对所有人透明，管理者和客户端其实都可以修改备忘录中的状态，存在一定的风险，也并没有很好的实现封装，这属于一种**白盒模式**，除了这种模式，可以将备忘录角色 Memento 作为 发起者 Originator 的私有内部类，这样备忘录中存储的状态就只有发起者可以操纵了。管理者可以通过一个**标记接口 MementoFlag**存储备忘录，但由于是标记接口，管理者并不能操纵备忘录。

```java
public interface MementoFlag {
}
```



```java
/**
 * @author JuneBao
 * @date 2020/6/1 0:24
 */
public class Originator {
    private class Memento implements MementoFlag{
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

    private String state = "OFF";
    /**
     * 创建备忘录，保存当前状态
     * @return 返回保存了当前对象状态的备忘录对象
     */
    public MementoFlag createMemento(){
        return new Memento(this.state);
    }

    /**
     * @param memento 恢复 memento 中保存的对象状态
     */
    public void restoreByMemento(MementoFlag memento){
        this.state = ((Memento)memento).getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
```

```java
/**
 * @author JuneBao
 * @date 2020/6/1 0:28
 */
public class Caretaker {
    private MementoFlag memento;

    public MementoFlag getMemento() {
        return memento;
    }

    public void setMemento(MementoFlag memento) {
        this.memento = memento;
    }
}
```

```java
/**
 * @author JuneBao
 * @date 2020/6/1 0:30
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        System.out.println(originator.getState());

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setState("ON");
        System.out.println(originator.getState());

        originator.restoreByMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }
}
```

### 简单模式（自述历史）

如果要保存的快照（备忘录）只有一个，那就不要将负责人和发起者分开，发起者自己保存备忘录即可，这种简单的备忘录模式也叫做**自述历史模式**

```java
package pers.junebao.memento.struct.simple;


/**
 * @author JuneBao
 * @date 2020/6/1 0:42
 */
public class Originator {
    private String state = "OFF";
    private Memento memento;

    private class Memento {
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

    public void saveMemento(){
        this.memento = new Memento(this.state);
    }

    public void restoreMemento(){
        if(this.memento == null){
            System.out.println("没有保存快照！！");
        } else {
            this.state = this.memento.getState();
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

```

```java
package pers.junebao.memento.struct.simple;

/**
 * @author JuneBao
 * @date 2020/6/1 0:47
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        System.out.println(originator.getState());

        originator.saveMemento();

        originator.setState("ON");
        System.out.println(originator.getState());

        originator.restoreMemento();
        System.out.println(originator.getState());
    }
}
```

## 