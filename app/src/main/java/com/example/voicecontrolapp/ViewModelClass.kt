package com.example.voicecontrolapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import javax.inject.Inject

class ViewModelClass (application: Application) : AndroidViewModel(application) {
    var msg = SingleLiveEvent<String>()

    fun getMessage(): SingleLiveEvent<String> {
        return msg
    }
    fun listeningMessage() : SingleLiveEvent<String>{
        msg.value = "Listening..."
        return msg
    }
    fun redButtonClicked() :  SingleLiveEvent<String> {
        msg.value = "Red button clicked"
        return msg
    }

    fun greenButtonClicked() :  SingleLiveEvent<String>{
        msg.value = "Green button clicked"
        return msg
    }

    fun blueButtonClicked() : SingleLiveEvent<String>  {
        msg.value = "Blue button clicked"
        return msg
    }
}