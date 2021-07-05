package com.hwloser;

import com.google.inject.AbstractModule;

public class DependencyInjectModule extends AbstractModule {

  protected void configure() {
    bind(Animal.class).to(Dog.class);
  }
}
