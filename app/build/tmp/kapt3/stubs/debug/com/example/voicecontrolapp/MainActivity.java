package com.example.voicecontrolapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J-\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f2\u0006\u0010%\u001a\u00020&H\u0016\u00a2\u0006\u0002\u0010\'J\b\u0010(\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/example/voicecontrolapp/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/voicecontrolapp/databinding/ActivityMainBinding;", "<set-?>", "", "permissionToRecordAudio", "getPermissionToRecordAudio", "()Z", "setPermissionToRecordAudio", "(Z)V", "permissionToRecordAudio$delegate", "Lkotlin/properties/ReadWriteProperty;", "permissons", "", "", "[Ljava/lang/String;", "recognizerSpeech", "Lcom/example/voicecontrolapp/RecognizerSpeech;", "vm", "Lcom/example/voicecontrolapp/ViewModelClass;", "getVm", "()Lcom/example/voicecontrolapp/ViewModelClass;", "setVm", "(Lcom/example/voicecontrolapp/ViewModelClass;)V", "voiceCommandsClass", "Lcom/example/voicecontrolapp/VoiceCommandsClass;", "checkAudioRecordingPermission", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "viewModelCallback", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.voicecontrolapp.databinding.ActivityMainBinding binding;
    public com.example.voicecontrolapp.ViewModelClass vm;
    private final java.lang.String[] permissons = {"android.permission.RECORD_AUDIO"};
    private final com.example.voicecontrolapp.RecognizerSpeech recognizerSpeech = null;
    private final kotlin.properties.ReadWriteProperty permissionToRecordAudio$delegate = null;
    private final com.example.voicecontrolapp.VoiceCommandsClass voiceCommandsClass = null;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.voicecontrolapp.ViewModelClass getVm() {
        return null;
    }
    
    public final void setVm(@org.jetbrains.annotations.NotNull()
    com.example.voicecontrolapp.ViewModelClass p0) {
    }
    
    private final boolean getPermissionToRecordAudio() {
        return false;
    }
    
    private final void setPermissionToRecordAudio(boolean p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void viewModelCallback() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final boolean checkAudioRecordingPermission() {
        return false;
    }
}