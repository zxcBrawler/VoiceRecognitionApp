package com.example.voicecontrolapp;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;
import di.MyApp;

@OriginatingElement(
    topLevelClass = MyApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface MyApp_GeneratedInjector {
  void injectMyApp(MyApp myApp);
}
