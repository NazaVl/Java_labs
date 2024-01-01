package org.fpm.di.example;

import javax.inject.Singleton;

@Singleton
public class MySingleton {
    int i = 0;
    public void inc(){
        i++;
    }
    public int getI(){
        return i;
    }
}
