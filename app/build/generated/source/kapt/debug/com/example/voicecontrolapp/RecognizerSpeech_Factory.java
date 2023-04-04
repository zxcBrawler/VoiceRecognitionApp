// Generated by Dagger (https://dagger.dev).
package com.example.voicecontrolapp;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import utils.RecognizerSpeech;

import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RecognizerSpeech_Factory implements Factory<RecognizerSpeech> {
  private final Provider<Context> contextProvider;

  public RecognizerSpeech_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public RecognizerSpeech get() {
    return newInstance(contextProvider.get());
  }

  public static RecognizerSpeech_Factory create(Provider<Context> contextProvider) {
    return new RecognizerSpeech_Factory(contextProvider);
  }

  public static RecognizerSpeech newInstance(Context context) {
    return new RecognizerSpeech(context);
  }
}
