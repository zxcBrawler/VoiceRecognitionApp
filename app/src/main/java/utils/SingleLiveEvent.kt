package utils

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean


class SingleLiveEvent<T> : MutableLiveData<T>() {
    private var mPending = AtomicBoolean(false)
    private var observers = mutableSetOf<Observer<in T>>()

    private var internalObserver = Observer<T> { t ->
        if (mPending.compareAndSet(true, false)) {
            observers.forEach { observer ->
                observer.onChanged(t)
            }
        }
    }

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) { t ->
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        }
        observers.add(observer)
        if (!hasObservers()) {
            super.observe(owner, internalObserver)
        }
    }

    @MainThread
    override fun setValue(value: T?) {
        mPending.set(true)
        super.setValue(value)
    }
}