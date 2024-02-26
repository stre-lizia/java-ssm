package org.xueyinhu.ssm.xml.ioc;

public class StaticFactory {
    private static  StaticFactory sf = new StaticFactory();
    private StaticFactory() {}
    public static StaticFactory createInstance() {
        return sf;
    }
}
