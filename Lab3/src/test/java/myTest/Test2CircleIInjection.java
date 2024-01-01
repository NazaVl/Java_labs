package myTest;

import javax.inject.Inject;

public class Test2CircleIInjection {
    public Test3CircleIInjection test3CircleIInjection;
    @Inject
    public Test2CircleIInjection(Test3CircleIInjection test3CircleIInjection){
        this.test3CircleIInjection = test3CircleIInjection;
    }
}
