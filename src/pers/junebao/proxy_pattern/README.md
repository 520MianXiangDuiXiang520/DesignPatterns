## 代理模式

> 代理模式( Proxy)：为其他对象提供一种代理以控制对这个对象的访问。
>
> 参考：[refactoringguru | proxy](https://refactoringguru.cn/design-patterns/proxy)

### 什么是代理模式

有时候如果想要访问某个对象，但又没办法直接访问或不方便直接访问，可以使用代理模式，代理模式为想要访问的那个真实对象提供一种“替身”，将客户端直接对服务端的访问转换为客户端只与代理交互，由代理处理具体的和服务端的交互，代理模式有四种角色，分别是：

1. 客户端
2. 服务端
3. 代理
4. 抽象服务接口

<img src="http://yanxuan.nosdn.127.net/6abf9bf54ece17a87a468f3622f5283f.png" alt="UTOOLS1589610468487.png" style="zoom:50%;" />

代理中保留一个真实Server的对象，并且代理和真实Server实现同一个接口，这样对客户端来说Proxy就可以代替Server了，客户端想要调用Server的某个方法时，直接与代理交互，再由代理去调用Server的具体方法。

### 代理的优缺点

优点：

> *  你可以在客户端毫无察觉的情况下控制服务对象。
> *  如果客户端对服务对象的生命周期没有特殊要求， 你可以对生命周期进行管理。
> *  即使服务对象还未准备好或不存在， 代理也可以正常工作。
> *  [开闭原则](https://refactoringguru.cn/didp/principles/solid-principles/ocp)。 你可以在不对服务或客户端做出修改的情况下创建新代理。

缺点：

> *  代码可能会变得复杂， 因为需要新建许多类。
> *  服务响应可能会延迟。

### 代理的类型和使用场景

#### 1. 远程代理

当我们需要一个**远程对象**时，可以通过一个本地代理去访问，所谓远程对象是指远程的资源，包括可能不同命名空间，不同机器的资源等，如果客户端直接访问远程资源，可能涉及到复杂的数据交互和传输，通过代理，我们可以把这些数据交互和传输的过程隐藏在代理里面，由代理去与远程资源交互，并返回客户端需要的数据，这样对客户端来说，访问远程资源就和访问本地资源一样了。以此简化客户端代码。

#### 2. 虚拟代理

虚拟代理的主要作用是**延迟初始化**：

> 如果你有一个偶尔使用的重量级服务对象，一直保持该对象运行会消耗系统资源, 时可使用代理模式.
>
> 你无需在程序启动时就创建该对象， 可将对象的初始化延迟到真正有需要的时候。

比如网站图片的加载, 真实的图片可能很大,如果在构造的时候就直接加载真实的图片,就会导致加载时间过长,所以可以使用代理,用很小的缩略图来代替真实的图片,直到用户点机缩略图时再异步的加载大图.

虚拟代理应该使用缓存避免重量级对象多次重复加载.

#### 3. 保护代理

如果只有拥有特定权限的用户才能访问特定对象,就可以在代理中对用户权限进行判断,并根据权限返回不同的结果.