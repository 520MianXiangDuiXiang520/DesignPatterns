# @Author: Junebao
# @Time    : 2020/5/27 0:08
# @File    : class_adapter.py


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


