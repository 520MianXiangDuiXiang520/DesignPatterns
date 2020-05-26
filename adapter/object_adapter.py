# @Author: Junebao
# @Time    : 2020/5/27 0:24
# @File    : object_adapter.py


class Target:
    def show(self):
        print("Target")


class Adaptee:
    def show(self):
        print("Adaptee")


class Adapter(Target):
    def __init__(self, adaptee: Adaptee):
        self.adaptee = adaptee

    def show(self):
        self.adaptee.show()


class Client:
    def test(self, target: Target):
        target.show()


if __name__ == '__main__':
    Client().test(Adapter(Adaptee()))
