package myTest;

import javax.inject.Inject;

public class Test1CircleIInjection {
    public Test2CircleIInjection test2CircleIInjection;
    @Inject
    public Test1CircleIInjection(Test2CircleIInjection test2CircleIInjection){
        this.test2CircleIInjection = test2CircleIInjection;
    }
}
