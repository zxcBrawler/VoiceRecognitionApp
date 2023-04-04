package activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import androidx.lifecycle.ViewModelProvider
import com.example.voicecontrolapp.databinding.ActivityMain2Binding
import utils.RecognizerSpeech
import utils.VoiceCommandsClass
import viewmodels.ViewModelClass

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var vm : ViewModelClass
    private val voiceCommandsClass  = VoiceCommandsClass(this)
    private val recognizerSpeech : RecognizerSpeech = RecognizerSpeech(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[ViewModelClass::class.java]
        viewModelCallback()
        binding.inputVoiceSecond.setOnClickListener {
            recognizerSpeech.startListening()
            Handler(Looper.getMainLooper()).postDelayed({
                recognizerSpeech.stopListening()
            }, 3000)
        }
        recognizerSpeech.recognizerSpeech.setRecognitionListener(object : RecognitionListener{
            override fun onReadyForSpeech(params: Bundle?) {}

            override fun onBeginningOfSpeech() {
                vm.listeningMessage()
            }

            override fun onRmsChanged(rmsdB: Float) {}

            override fun onBufferReceived(buffer: ByteArray?) {}

            override fun onEndOfSpeech() {}

            override fun onError(error: Int) {}

            override fun onResults(results: Bundle?) {
                if (results != null) {
                    val data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    vm.msg.value = data?.get(0).toString()
                }
            }

            override fun onPartialResults(partialResults: Bundle?) {
                if (partialResults != null) {
                    val data = partialResults.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    vm.msg.value = data?.get(0).toString()
                }
            }

            override fun onEvent(eventType: Int, params: Bundle?) {}
        })
    }
    private fun viewModelCallback() {
        vm.msg.observe(this) {
            binding.commandTextSecond.text = it
            voiceCommandsClass.openSecondScreen(it.toString())
            voiceCommandsClass.openFirstScreen(it.toString())
            voiceCommandsClass.exit(it.toString())
        }
    }


}