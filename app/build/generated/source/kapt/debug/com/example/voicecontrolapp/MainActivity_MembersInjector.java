// Generated by Dagger (https://dagger.dev).
package com.example.voicecontrolapp;

import activities.MainActivity;
import compose.MainActivity;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import utils.RecognizerSpeech;
import utils.VoiceCommandsClass;

import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<RecognizerSpeech> recognizerSpeechProvider;

  private final Provider<VoiceCommandsClass> voiceCommandsClassProvider;

  public MainActivity_MembersInjector(Provider<RecognizerSpeech> recognizerSpeechProvider,
      Provider<VoiceCommandsClass> voiceCommandsClassProvider) {
    this.recognizerSpeechProvider = recognizerSpeechProvider;
    this.voiceCommandsClassProvider = voiceCommandsClassProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<RecognizerSpeech> recognizerSpeechProvider,
      Provider<VoiceCommandsClass> voiceCommandsClassProvider) {
    return new MainActivity_MembersInjector(recognizerSpeechProvider, voiceCommandsClassProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectRecognizerSpeech(instance, recognizerSpeechProvider.get());
    injectVoiceCommandsClass(instance, voiceCommandsClassProvider.get());
  }

  @InjectedFieldSignature("compose.activities.MainActivity.recognizerSpeech")
  public static void injectRecognizerSpeech(MainActivity instance,
      RecognizerSpeech recognizerSpeech) {
    instance.recognizerSpeech = recognizerSpeech;
  }

  @InjectedFieldSignature("compose.activities.MainActivity.voiceCommandsClass")
  public static void injectVoiceCommandsClass(MainActivity instance,
      VoiceCommandsClass voiceCommandsClass) {
    instance.voiceCommandsClass = voiceCommandsClass;
  }
}
