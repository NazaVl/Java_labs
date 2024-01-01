package myTest;

import di.EnvironmentImplementation;
import org.fpm.di.Container;
import org.fpm.di.Environment;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class MyTest {

    private final Environment environment = new EnvironmentImplementation();

    @Test(expected = RuntimeException.class)
    public void shouldThrowBindExceptionWhenTryingToRebindWithClass() {
        environment.configure((binder) -> {
            binder.bind(TestAbstractClass.class, Test1.class);
            binder.bind(TestAbstractClass.class, Test2.class);
        });
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowBindExceptionWhenTryingToRebindWithInstance() {
        environment.configure((binder) -> {
            binder.bind(TestAbstractClass.class, Test1.class);
            binder.bind(TestAbstractClass.class, new Test2());
        });
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowBindExceptionWhenTryingToRegisterAbstractClass() {
        environment.configure((binder) -> {
            binder.bind(TestAbstractClass.class);
        });
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowBindExceptionWhenTryingToRegisterInterface() {
        environment.configure((binder) -> {
            binder.bind(TestInterface.class);
        });
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowBindExceptionWhenTryingToRegisterNull() {
        environment.configure((binder) -> {
            binder.bind(null);
        });
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowBindExceptionWhenTryingToRegisterClassWithMoreThanOneInjectionConstructor() {
        environment.configure((binder) -> {
            binder.bind(TestDoubleInjection.class);
        });
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowUnregisteredComponentExceptionWhenTryingToGetUnregisteredComponent() {
        Container container = environment.configure((binder) -> {});
        container.getComponent(Test1.class);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowUnregisteredComponentExceptionWhenTryingToGetComponentWhichDependenciesNotRegistered() {
        Container container = environment.configure((binder) -> {
            binder.bind(Test1Singleton.class);
        });
        container.getComponent(Test1Singleton.class);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowCircularInjectExceptionWhenTryingToRegisterComponentWithCircularInjectDependency() {
        environment.configure((binder) -> {
            binder.bind(Test1CircleIInjection.class);
            binder.bind(Test2CircleIInjection.class);
            binder.bind(Test3CircleIInjection.class);
        });
    }

    @Test
    public void shouldResolveSingletonWithInjection() {
        Container container = environment.configure((binder) -> {
            binder.bind(Test1.class);
            binder.bind(Test1Singleton.class);
        });
        /* @Singleton AppleSharer */
        Test1Singleton sharer1 = container.getComponent(Test1Singleton.class);
        Test1Singleton sharer2 = container.getComponent(Test1Singleton.class);
        assertSame(sharer1, sharer2);
        assertSame(sharer1.shareApple(), sharer2.shareApple());
    }

    @Test
    public void shouldResolveNestedInjectDependency() {
        Container container = environment.configure((binder) -> {
            binder.bind(TestNestedInjection.class);
            binder.bind(Test1.class);
            binder.bind(Test1Singleton.class);
        });
        TestNestedInjection c = container.getComponent(TestNestedInjection.class);
        assertSame(c.getSharer(), container.getComponent(Test1Singleton.class));
    }

}