package myTest;

import javax.inject.Inject;

public class TestNestedInjection {

    private final Test1Singleton test1Singleton;

    @Inject
    public TestNestedInjection(Test1Singleton test1Singleton) {
        this.test1Singleton = test1Singleton;
    }

    public Test1Singleton getSharer() {
        return test1Singleton;
    }

}
