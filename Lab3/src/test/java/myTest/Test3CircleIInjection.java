package myTest;

import javax.inject.Inject;

public class Test3CircleIInjection {
    public Test1CircleIInjection test1CircleIInjection;
    @Inject
    public Test3CircleIInjection(Test1CircleIInjection test1CircleIInjection){
        this.test1CircleIInjection = test1CircleIInjection;
    }
}
