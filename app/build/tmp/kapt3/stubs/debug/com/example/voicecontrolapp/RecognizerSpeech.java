package com.example.voicecontrolapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/example/voicecontrolapp/RecognizerSpeech;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "recognizerIntent", "Landroid/content/Intent;", "recognizerSpeech", "Landroid/speech/SpeechRecognizer;", "getRecognizerSpeech", "()Landroid/speech/SpeechRecognizer;", "startListening", "", "stopListening", "app_debug"})
@javax.inject.Singleton()
public final class RecognizerSpeech {
    @org.jetbrains.annotations.NotNull()
    private final android.speech.SpeechRecognizer recognizerSpeech = null;
    private final android.content.Intent recognizerIntent = null;
    
    @javax.inject.Inject()
    public RecognizerSpeech(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.speech.SpeechRecognizer getRecognizerSpeech() {
        return null;
    }
    
    public final void startListening() {
    }
    
    public final void stopListening() {
    }
}