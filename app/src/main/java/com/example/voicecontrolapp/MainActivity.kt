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
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.example.voicecontrolapp.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var vm : ViewModelClass

    private val permissons = arrayOf(Manifest.permission.RECORD_AUDIO)
    private val recognizerSpeech : RecognizerSpeech = RecognizerSpeech(this)
    private var permissionToRecordAudio by Delegates.notNull<Boolean>()
    private val voiceCommandsClass  = VoiceCommandsClass(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm = ViewModelProvider(this)[ViewModelClass::class.java]
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
            binding.commandText.text = it
            voiceCommandsClass.clickButton(it.toString(),binding.redButton)
            voiceCommandsClass.clickButton(it.toString(),binding.blueButton)
            voiceCommandsClass.clickButton(it.toString(),binding.greenButton)
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