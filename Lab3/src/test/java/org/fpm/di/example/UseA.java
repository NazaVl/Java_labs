package org.fpm.di.example;

import javax.inject.Inject;

public class UseA {
    private A dependency;
    public UseA(){

    }
    @Inject
    public UseA(A a) {
        this.dependency = a;

    public A getDependency() {
        return dependency;
    }
}
