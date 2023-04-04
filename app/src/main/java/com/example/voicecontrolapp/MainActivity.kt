package com.example.voicecontrolapp


import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.example.voicecontrolapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.properties.Delegates
@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    val vm : ViewModelClass by viewModels()

    private val permissons = arrayOf(Manifest.permission.RECORD_AUDIO)
    @Inject lateinit var recognizerSpeech : RecognizerSpeech
    private var permissionToRecordAudio by Delegates.notNull<Boolean>()
    @Inject lateinit var voiceCommandsClass : VoiceCommandsClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModelCallback()
        permissionToRecordAudio = checkAudioRecordingPermission()
        if (!permissionToRecordAudio){
            ActivityCompat.requestPermissions(this,permissons, 0)
        }

        binding.redButton.setOnClickListener {
            vm.redButtonClicked()
        }
        binding.blueButton.setOnClickListener {
            vm.blueButtonClicked()
        }
        binding.greenButton.setOnClickListener {
            vm.greenButtonClicked()
        }
        binding.inputVoice.setOnClickListener {
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
        vm.getMessage().observe(this) {
            binding.commandText.text = it.lowercase()
            when (it) {
                applicationContext.getString(R.string.click_red_button) -> {
                    voiceCommandsClass.clickButton(it.toString(),binding.redButton)
                }
                applicationContext.getString(R.string.click_green_button) -> {
                    voiceCommandsClass.clickButton(it.toString(),binding.greenButton)
                }
                applicationContext.getString(R.string.click_blue_button) -> {
                    voiceCommandsClass.clickButton(it.toString(),binding.blueButton)
                }
            }
            voiceCommandsClass.openSecondScreen(it.toString())
            voiceCommandsClass.openFirstScreen(it.toString())
            voiceCommandsClass.exit(it.toString())
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun checkAudioRecordingPermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED

}