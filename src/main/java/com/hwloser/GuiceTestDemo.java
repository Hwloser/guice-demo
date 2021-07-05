package com.hwloser;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Singleton;

public class GuiceTestDemo {

  @Inject
  private Animal animal;

  private void testInjector() {
    Injector injector = Guice.createInjector(new DependencyInjectModule());

    // 为当前的实例，注入容器内的对象
    injector.injectMembers(this);

    System.out.println(animal);
    System.out.println(injector.getInstance(Animal.class));
    System.out.println(injector.getInstance(Animal.class));

    animal.run();
  }

  private void testSingleton() {
    Injector injector = Guice.createInjector(new AbstractModule() {
      protected void configure() {
        bind(Animal.class)
            .to(Cat.class)
            .in(Singleton.class);
      }
    });

    injector.injectMembers(this);

    System.out.println(injector.getInstance(Animal.class));
    System.out.println(injector.getInstance(Animal.class));

    animal.run();
  }

  public static void main(String[] args) {
    GuiceTestDemo g = new GuiceTestDemo();

    g.testInjector();

    System.out.println(" -------------- ");

    g.testSingleton();
  }
}
