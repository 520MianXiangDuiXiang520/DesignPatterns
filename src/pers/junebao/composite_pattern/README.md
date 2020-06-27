## 组合模式（树）

> 组合模式( Composite),将对象组合成树形结构以表示‘部分整体’的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。

组合模式类似于数据结构中的**树形结构**，如果某个对象可以由多个同类对象组合形成，那么他们之间就形成了一个数形结构，比如多级菜单：

![N6Rye1.png](https://s1.ax1x.com/2020/06/27/N6Rye1.png)

### 组合模式的实现

组合模式包含三类角色：

1. 同类对象抽象出的公共接口**Component**，如所有的菜单抽象出的 InterMenu
2. 实现了**Component**的叶子节点**Leaf**，如第一个二级菜单和下面的三级菜单，这些对象不再由其他同类对象组合而成。
3. 实现了**Component**的枝干节点**Composite**，如一级菜单，它一方面拥有 InterMenu 接口定义的菜单应该具有的功能，另一方面还应该**维持一个用来保存子节点的容器**和**操作容器中子节点的相关方法**

组合模式有两种不同的具体实现，分别为

1. **透明模式**：如果将操作子节点的相关方法也放在接口 **Component**中，因此不管是叶子节点还是枝干节点都yo能够了完全一致的行为接口，客户端可以无差别的使用这两种对象，但由于Leaf本身没有子节点，这些方法对它而言是冗余的，甚至是不安全的。

   ![NctZRK.png](https://s1.ax1x.com/2020/06/27/NctZRK.png)

2. **安全模式**：**Component**中只定义单个菜单的行为，操作子节点的相关方法放在**Composite**中声明，这样Leaf就可以不用实现多余的方法，但Leaf和Composite就有了不同的接口，客户端需要在使用时加以判断才行

   ![NctnMD.png](https://s1.ax1x.com/2020/06/27/NctnMD.png)

### 应用场景

1. 需要实现树状结构时，如多级菜单，部门结构，复杂UI等
2. 希望客户端以相同的方式处理简单和复杂的元素时

### 例

一个评论系统，某条评论可以设置允许回复和不允许回复，不允许回复的评论对象可以看作Leaf，允许回复的评论可以看作Composite

```java
package pers.junebao.composite_pattern.demo;

/**
 * @author Junebao
 */
public interface InterComment {
    /**
     * 展示评论
     */
    void showComment();

    /**
     * 回复评论
     * @param comment: 回复的 InterComment 对象
     */
    void reply(InterComment comment);
}
```

* 相当于 Component

  

```java
package pers.junebao.composite_pattern.demo;

import java.util.ArrayList;

/**
 * @author JuneBao
 * @date 2020/6/27 23:13
 */
public class CanReplyComment implements InterComment {
    private String content;
    private String date;
    private ArrayList<InterComment> comments = new ArrayList<>();

    public CanReplyComment(String str, String date) {
        this.content = str;
        this.date = date;
    }
    @Override
    public void showComment() {
        System.out.println(this.content + "(" + this.date + ")");
        System.out.print("  ");
        for (InterComment comment : comments) {
            comment.showComment();
        }
    }

    @Override
    public void reply(InterComment comment) {
        comments.add(comment);
    }
}

```

* 可以回复的评论，相当于Composite



```java
package pers.junebao.composite_pattern.demo;

/**
 * @author JuneBao
 * @date 2020/6/27 23:20
 */
public class BanReplyComment implements InterComment {
    private String content;
    private String date;

    public BanReplyComment(String str, String date){
        this.content = str;
        this.date = date;
    }

    @Override
    public void showComment() {
        System.out.println(this.content + "(" + this.date + ")");
    }

    @Override
    public void reply(InterComment comment) {
        System.err.println("This comment is not allowed to reply");
    }
}

```

* 不可以回复的评论（透明模式），相当于Leaf



```java
package pers.junebao.composite_pattern.demo;

/**
 * @author JuneBao
 * @date 2020/6/27 23:23
 */
public class Client {
    public static void main(String[] args) {
        InterComment firstComment = new CanReplyComment("This comment allows reply", "2020-6-20");
        InterComment canReply = new CanReplyComment("This reply can reply", "2020-6-23");
        firstComment.reply(canReply);
        InterComment banReply = new BanReplyComment("This reply can not reply", "2020-6-24");
        firstComment.reply(banReply);
        InterComment canReply2 = new CanReplyComment("I can reply", "2020-6-24");
        canReply.reply(canReply2);
        banReply.reply(canReply2);
        firstComment.showComment();

        InterComment secondComment = new BanReplyComment("This comment can not reply", "2020-6-27");
        secondComment.reply(new CanReplyComment("xxx", "2020-6-27"));
        secondComment.showComment();

    }
}

```

![](https://s1.ax1x.com/2020/06/28/NcDCUe.png)