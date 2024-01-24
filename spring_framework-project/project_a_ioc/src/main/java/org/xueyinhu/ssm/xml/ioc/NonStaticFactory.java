package org.xueyinhu.ssm.xml.ioc;

public class NonStaticFactory {
    private static Helper nsf = new Helper();
    public Helper createHelperInstance() {
        return nsf;
    }
}
