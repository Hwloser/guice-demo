package com.hwloser;

import com.google.inject.Singleton;

@Singleton
public class Cat implements Animal{

  public void run() {
    System.out.println("cat run --------");
  }
}
