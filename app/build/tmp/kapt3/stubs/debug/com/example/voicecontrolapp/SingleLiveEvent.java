package com.example.voicecontrolapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0005H\u0017J\u0017\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0017\u00a2\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00050\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/voicecontrolapp/SingleLiveEvent;", "T", "Landroidx/lifecycle/MutableLiveData;", "()V", "internalObserver", "Landroidx/lifecycle/Observer;", "mPending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "observers", "", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "setValue", "value", "(Ljava/lang/Object;)V", "app_debug"})
public final class SingleLiveEvent<T extends java.lang.Object> extends androidx.lifecycle.MutableLiveData<T> {
    private java.util.concurrent.atomic.AtomicBoolean mPending;
    private java.util.Set<androidx.lifecycle.Observer<? super T>> observers;
    private androidx.lifecycle.Observer<T> internalObserver;
    
    public SingleLiveEvent() {
        super(null);
    }
    
    @androidx.annotation.MainThread()
    @java.lang.Override()
    public void observe(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Observer<? super T> observer) {
    }
    
    @androidx.annotation.MainThread()
    @java.lang.Override()
    public void setValue(@org.jetbrains.annotations.Nullable()
    T value) {
    }
}