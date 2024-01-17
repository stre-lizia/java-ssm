package org.xueyinhu.ssm.xml;

public class NonStaticFactory {
    private static Helper nsf = new Helper();
    public Helper createHelperInstance() {
        return nsf;
    }
}
