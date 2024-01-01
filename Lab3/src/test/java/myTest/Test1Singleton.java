package myTest;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Test1Singleton {

    private final Test1 test1;

    @Inject
    public Test1Singleton(Test1 test1) {
        this.test1 = test1;
    }

    public Test1 shareApple() {
        return test1;
    }

}
