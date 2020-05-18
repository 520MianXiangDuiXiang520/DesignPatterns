## 原型模式

> Prototype pattern refers to creating duplicate object while keeping performance in mind. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
>
> 参考：
>
> 1. [tutorialspoint | prototype_pattern](https://www.tutorialspoint.com/design_pattern/prototype_pattern.htm)
> 2. [博客园 | 原型模式](https://www.cnblogs.com/fengyumeng/p/10646487.html)
> 3. [博客园 | Java深拷贝与序列化](https://www.cnblogs.com/NaLanZiYi-LinEr/p/9192734.html)

原型模式是通过复制已有对象来快速创建新对象的方法，它适用于创建那些实例化很慢的对象，比如数据库连接对象，在创建好这样的对象后，我们可以缓存一份，下次需要这种对象时，我们可以直接返回一个该对象的拷贝。

### 使用场景

1. 需要大量相似对象时，如果在类中需要大量相似的对象，并且这些对象中有很多属性都是一样的，只有个别属性需要定制时，可以使用原型模式，因为直接从内从中复制对象比new一个新对象的性能要高得多。
2. 如果一个对象的实例化过程很耗时耗力，可以使用原型模式。

### Java Cloneable接口

Java中提供了一个标记接口`Cloneable`，类如果实现了这个接口就可以使用`Object`类中定义的`clone`方法

> 如果没有实现Cloneable接口，直接调用`clone()`会抛出`CloneNotSupportedException`

`Object clone()`会返回当前对象的一个**浅拷贝**

### 深拷贝和浅拷贝

根据不同的对象类型，拷贝的内容也各不相同：

1. **基本数据类型**，如int，char等，直接拷贝**值**
2. 对于**字符串**，拷贝时只复制**引用**，当字符串的值改变时，会从字符串池中重新生成新的字符串，最终结果和拷贝值一样
3. 对于**对象**，拷贝时只**复制引用**，如果要复制值，需要使用**深拷贝**

```java
public class Out implements Cloneable{
    private String outName;
    private In in;

    public Out(String outName) {
        this.outName = outName;
    }

    public void setIn(In in) {
        this.in = in;
    }

    @Override
    public String toString() {
        return "Out{" +
                "outName='" + outName + '\'' +
                ", in=" + in +
                '}';
    }

    @Override
    protected Out clone() throws CloneNotSupportedException {
        return (Out) super.clone();
    }

    public static void main(String[] args) {
        Out out = new Out("out");
        In in = new In("in name");
        out.setIn(in);

        Out out1 = null;
        try {
            // in 是一个object类型，所以在调用clone()时只复制了in的引用
            out1 = out.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        assert out1 != null;
        // 改变out1.in的name也会改变out中in的name
        out1.in.setName("out1 in");
        System.out.println(out);
        System.out.println(out1);
    }
}
/*
Out{outName='out', in=In{name='out1 in'}}
Out{outName='out', in=In{name='out1 in'}}
*/
```



#### 深拷贝 DeepCopy

Java中实现深拷贝可以手动拷贝object类型的属性，但如果这个类型中还有object类型，就会很麻烦。

```java
@Override
protected DCOut clone() throws CloneNotSupportedException {
    DCOut copy = (DCOut) super.clone();
    In copyIn = (In) this.in.clone();
    copy.setIn(copyIn);
    return copy;
}
```

还可以使用`Serializable`接口，通过序列化，将堆中的对象数据信息复制一份到堆外，再反序列化成新的克隆对象

```java
import java.io.*;

public class DeepClone implements Serializable {
    private Object obj;

    public DeepClone(Object obj){
        this.obj = obj;
    }

    public Object deepClone() {
        Object result = null;
        //序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 反序列化
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream  ois = null;
        try {
            ois = new ObjectInputStream(bais);
            result = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}

```

#### python中的深拷贝和浅拷贝

```python
In [1]: import copy

In [2]: a = [i for i in range(10)]

In [3]: b = copy.copy(a)

In [4]: a is b
Out[4]: False

In [5]: c = [[1, 2], [3, 4]]

In [6]: d = copy.copy(c)

In [7]: d is c
Out[7]: False

In [8]: d[0] is c[0]
Out[8]: True

In [9]: e = copy.deepcopy(c)

In [10]: e[0] is c[0]
Out[10]: False

In [11]:
```

python内置的copy模块提供了深拷贝和浅拷贝的功能，python中浅拷贝只会拷贝父对象，不会拷贝父对象内部的子对象

> python切片属于浅拷贝
