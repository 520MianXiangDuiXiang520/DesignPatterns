## 状态模式

> 允许一个对象内部状态改变时改变其行为，使得这个对象看起来改变了其类。

如果一个对象的行为取决于其内部的一个或多个动态变化的属性的值，那么这些属性被称之为**状态（state）**，这类对象被称之为**有状态的对象（stateful）**，行为与状态间的转换关系可以由**状态转换图**体现，如进程间的状态转换关系

![UTOOLS1590402231508.png](http://yanxuan.nosdn.127.net/30be812bfad687c999050190fa789e67.png)

如果将进程视为一个对象，这个对象就拥有**新建**，**就绪**，**运行**，**阻塞**，**终止**五种状态，对象的具体行为就会由状态决定。如果直接使用多个`if else`来描述这个状态，就违反了**开闭原则**，所以引入了**状态模式**，状态模式**允许一个对象内部状态改变时改变其行为，使得这个对象看起来改变了其类。**

### 实现方法

状态模式包含三部分：

1. **上下文 Context**：上下文中保存了一个具体对象状态的引用，一般来说这个引用会有一个初始值表示初始状态，其次上下文还应该包含一个`setState()`方法，用来修改当前状态；最后上下文还要包含一个或多个**行为方法**，这些行为方法是开放给客户端使用的，上下文中的行为方法应该是调用具体状态对象对应的行为方法。
2. **抽象状态类 State**：抽象状态类声明了每个具体状态类应该实现的行为（方法），大多数情况下，这些方法因该有一个上下文对象的参数，用来将当前状态修改为下一个状态
3. **具体状态类 ConcreteState**。

例：

投简历找工作的过程中，存在三个状态：

![UTOOLS1590490246806.png](http://yanxuan.nosdn.127.net/73622e76ce6c573f85cc2c67eb1d49d5.png)

1. **新投递状态（NewDeliveryStare）**：这个状态对应的动作是简历审批，如果通过，进入下一个面试状态，否则进入回绝状态
2. **面试状态（InterviewState）**：这一状态对应的动作是面试，通过进入“通过状态”，否则进入回绝状态
3. **通过状态（PassState)**：一个终态
4. **回绝状态（RefuseState）**：另一个终态

首先建立抽象状态类：

```java
package pers.junebao.state.recruitment;

public interface IState {
    /**
     * 每个具体状态类应该实现的行为（方法）
     * @param context 当前的上下文对象，方便在具体实现中修改状态
     */
    void header(Context context);
}

```

* `header()`是在某个状态下，系统应该做的事（这个例子里应该分成两个：每个状态公司系统做的事和每个状态展示给应聘者的东西）

建立上下文类

```java
package pers.junebao.state.recruitment;

public class Context {
    // 初始状态为 新投递
    private IState state = new NewDeliveryStare();

    protected void setState(IState state) {
        this.state = state;
    }

    // 展示给客户端的方法，其实内部调用状态类的header方法
    public void header(){
        this.state.header(this);
    }
}

```

实现抽象状态类`IState`完成具体状态类

* 新投递状态

  ```java
  package pers.junebao.state.recruitment;
  
  import java.util.Scanner;
  
  public class NewDeliveryStare implements IState {
      private boolean resumeApproval(){
          System.out.println("简历是否合格（Y/N）：");
          String input = new Scanner(System.in).next();
          return "Y".equals(input) || "y".equals(input);
      }
  
      @Override
      public void header(Context context) {
          if(resumeApproval()){
              System.out.println("恭喜通过简历评估，请等待面试...");
              context.setState(new InterviewState());
          } else {
              System.out.println("简历评估未通过！");
              context.setState(new RefuseState());
          }
  
      }
  }
  ```

* 面试状态

  ```java
  package pers.junebao.state.recruitment;
  
  import java.util.Scanner;
  
  public class InterviewState implements IState {
      private boolean interview(){
          System.out.println("面试是否合格（Y/N）：");
          String input = new Scanner(System.in).next();
          return "Y".equals(input) || "y".equals(input);
      }
  
      @Override
      public void header(Context context) {
          if(interview()){
              System.out.println("恭喜通过面试，即将发放offer!!");
              context.setState(new PassState());
          } else {
              System.out.println("未能通过面试！！");
              context.setState(new RefuseState());
          }
      }
  }
  ```

* 通过状态

  ```java
  package pers.junebao.state.recruitment;
  
  public class PassState implements IState {
      @Override
      public void header(Context context) {
          System.out.println("恭喜您已通过所有考核！！！");
      }
  }
  
  ```

* 回绝状态

  ```java
  package pers.junebao.state.recruitment;
  
  public class RefuseState implements IState {
      @Override
      public void header(Context context) {
          System.out.println("已回绝！！");
      }
  }
  
  ```

客户端：

```java
package pers.junebao.state.recruitment;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.header();
        context.header();
        context.header();
    }
}
```

运行结果：

|                           result1                            |                           result2                            |                           result3                            |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
| ![UTOOLS1590491163528.png](http://yanxuan.nosdn.127.net/d361a166b994f9d682653718c30e9854.png) | ![UTOOLS1590491239336.png](http://yanxuan.nosdn.127.net/638449f77298e58130ce0adcd2bbc0d1.png) | ![UTOOLS1590491266196.png](http://yanxuan.nosdn.127.net/4da8df6b4f1c11101824e3a02aa7f09b.png) |

### 适用场景及优缺点

**适用场景：**

* 适用于对象行为要随可确定的状态的动态改变而改变的场景。

**优点：**

* 通过将具体的行为分装到具体状态类中，避免了使用大量`if else`，提高了代码可读性和可拓展性，一定程度上符合开闭原则。
* context里提供给客户端的方法调用的其实是具体状态类里的方法，但客户端并不能感知到这一点，对客户端来说感觉就像是更改了方法。
* 可以让多个环境对象共享一个状态对象，从而减少系统中对象的个数。

**缺点：**

* 结构和实现都比较复杂，并且会增加许多类，使用不当会导致代码混乱。
* 不同状态之间一般存在复杂的关联关系，修改或添加具体状态可能会导致 “ 牵一发而动全身 ”，并不是完全符合开闭原则。

### 状态模式与策略模式

> [状态](https://refactoringguru.cn/design-patterns/state)可被视为[策略](https://refactoringguru.cn/design-patterns/strategy)的扩展。 两者都基于组合机制： 它们都通过将部分工作委派给 “帮手” 对象来改变其在不同情景下的行为。 策略使得这些对象相互之间完全独立， 它们不知道其他对象的存在。 但*状态*模式没有限制具体状态之间的依赖， 且允许它们自行改变在不同情景下的状态。

共同点：

* 都基于组合机制
* 都是将行为划分为更小的组件来委派给 “ 帮手” 去做
* 都可以避免使用大量`if else`

不同点：

* 不同策略之间联系不大，甚至一个策略可以完全不知道其他策略的存在
* 不同状态之间一般存在复杂的联系，以允许从一个状态切换到另一个状态