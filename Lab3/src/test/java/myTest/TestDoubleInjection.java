package myTest;

import javax.inject.Inject;

public class TestDoubleInjection {

    private Test1 test1;
    private Test1Singleton test1Singleton;

    @Inject
    public TestDoubleInjection(Test1 test1) {
        this.test1 = test1;
    }

    @Inject
    public TestDoubleInjection(Test1Singleton test1Singleton) {
        this.test1Singleton = test1Singleton;
    }

}
