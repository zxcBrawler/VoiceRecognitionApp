package com.example.voicecontrolapp

import android.Manifest.permission.RECORD_AUDIO
import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.SpeechRecognizer.RESULTS_RECOGNITION
import android.speech.SpeechRecognizer.createSpeechRecognizer
import androidx.core.app.ActivityCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModelClass (application: Application) : AndroidViewModel(application), RecognitionListener {

    private var statusMessage = MutableLiveData<Event<String>>()
    data class ViewState(
        var spokenText: String,
        val isListening: Boolean,
    )
    private var viewState: MutableLiveData<ViewState>? = null
    private val speechRecognizer: SpeechRecognizer = createSpeechRecognizer(application.applicationContext).apply {
        setRecognitionListener(this@ViewModelClass)
    }
    private val recognizerIntent: Intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, application.packageName)
        putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
    }
    val message: LiveData<Event<String>>
        get() = statusMessage

    val isListening
        get() = viewState?.value?.isListening ?: false

    var permissionToRecordAudio = checkAudioRecordingPermission(context = application)
    private fun initViewState() = ViewState(spokenText = "", isListening = false)


    fun getViewState(): LiveData<ViewState> {
        if (viewState == null) {
            viewState = MutableLiveData()
            viewState?.value = initViewState()
        }

        return viewState as MutableLiveData<ViewState>
    }

    fun redButtonClicked() {
        statusMessage.value = Event("Red button clicked")
    }

    fun greenButtonClicked() {
        statusMessage.value = Event("Green button clicked")
    }

    fun blueButtonClicked() {
        statusMessage.value = Event("Blue button clicked")
    }

    private fun listeningMessage() {
        statusMessage.value = Event("Listening...")
    }

    fun startListening() {
        speechRecognizer.startListening(recognizerIntent)
        notifyListening(isRecording = true)
    }

    fun stopListening() {
        speechRecognizer.stopListening()
        notifyListening(isRecording = false)
    }
    private fun notifyListening(isRecording: Boolean) {
        viewState?.value = viewState?.value?.copy(isListening = isRecording)
    }
    private fun updateResults(speechBundle: Bundle?) {
        val userSaid = speechBundle?.getStringArrayList(RESULTS_RECOGNITION)
        viewState?.value = viewState?.value?.copy(spokenText = userSaid?.get(0) ?: "")
    }

    override fun onReadyForSpeech(params: Bundle?) {}

    override fun onBeginningOfSpeech() {
        listeningMessage()
    }

    override fun onRmsChanged(rmsdB: Float) {}

    override fun onBufferReceived(buffer: ByteArray?) {}

    override fun onEndOfSpeech() {
        notifyListening(isRecording = false)
    }

    override fun onError(error: Int) {}

    override fun onResults(results: Bundle?) = updateResults(speechBundle = results)

    override fun onPartialResults(partialResults: Bundle?) = updateResults(speechBundle = partialResults)

    override fun onEvent(eventType: Int, params: Bundle?) {}

    private fun checkAudioRecordingPermission(context: Application) =
        ActivityCompat.checkSelfPermission(context, RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
}