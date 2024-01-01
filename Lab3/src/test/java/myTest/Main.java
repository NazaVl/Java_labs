package myTest;

import di.EnvironmentImplementation;
import org.fpm.di.Binder;
import org.fpm.di.Container;
import org.fpm.di.example.*;

public class Main {
    public static void main(String[] args) {
        EnvironmentImplementation environmentImplementation = new EnvironmentImplementation();
        Container container = environmentImplementation.configure(
                binder -> {
                    binder.bind(A.class, B.class);
                    binder.bind(B.class, C.class);
                    binder.bind(C.class);
                });
        A A = container.getComponent(A.class);
        A B = container.getComponent(A.class);
        A C = container.getComponent(A.class);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
    }
}
