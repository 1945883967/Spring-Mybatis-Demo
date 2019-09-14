package com.minghai1.staticProxy;

/**
 * 静态代理举例
 *
 * 特点：代理类和被代理类在编译期间，就确定下来了。
 */
interface ClothFactory{
    void produceCloth();
}
// 代理类
class ProxyClothFactory implements  ClothFactory{

    private ClothFactory factory; // 用被代理对象进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些准备工作");
    }
}
// 被代理类
class NikeClothFactory implements  ClothFactory{

    public void produceCloth() {
        System.out.println("Nike 工厂生产一批运动服");
    }
}

public class StaticProxyTest {

    public static void main(String[] args) {
        // 创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        // 创建代理类的对象
        ProxyClothFactory proxy =   new ProxyClothFactory(nike);

        proxy.produceCloth();
    }
}
