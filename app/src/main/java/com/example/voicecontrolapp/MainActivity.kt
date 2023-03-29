package com.example.voicecontrolapp


import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import java.util.*


class MainActivity : AppCompatActivity() {
    private val permissons = arrayOf(android.Manifest.permission.RECORD_AUDIO)
    private lateinit var inputVoice: Button
    private lateinit var vm : ViewModelClass
    private lateinit var redButton : Button
    private lateinit var blueButton : Button
    private lateinit var greenButton : Button
    private lateinit var commandText : TextView
    private val voiceCommandsClass  = VoiceCommandsClass(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        commandText = findViewById(R.id.commandText)
        redButton = findViewById(R.id.redButton)
        blueButton = findViewById(R.id.blueButton)
        greenButton = findViewById(R.id.greenButton)
        inputVoice = findViewById(R.id.inputVoice)

        vm = ViewModelProvider(this)[ViewModelClass::class.java]

        vm.message.observe(this) { it ->
            it.getContentIfNotHandled()?.let {
               commandText.text = it
            }
        }
        vm.getViewState().observe(this) { viewState ->
            render(viewState)
        }
        if (!vm.permissionToRecordAudio){
            ActivityCompat.requestPermissions(this,permissons, 0)
        }

        redButton.setOnClickListener {
            vm.redButtonClicked()
        }
        blueButton.setOnClickListener {
           vm.blueButtonClicked()
        }
        greenButton.setOnClickListener {
            vm.greenButtonClicked()
        }
        inputVoice.setOnClickListener {
            if (vm.isListening){
                vm.stopListening()
            }
            else {
                vm.startListening()
            }
        }

    }

    private fun render(viewState: ViewModelClass.ViewState?) {
        if (viewState == null) return
        commandText.text = viewState.spokenText.lowercase(Locale.getDefault())
        voiceCommandsClass.commandManager(viewState.spokenText.lowercase(Locale.getDefault()))
        when (viewState.spokenText.lowercase(Locale.getDefault())) {
            "click red button" -> {
                voiceCommandsClass.buttonClick(redButton)
            }
            "click blue button" -> {
                voiceCommandsClass.buttonClick(blueButton)
            }
            "click green button" -> {
                voiceCommandsClass.buttonClick(greenButton)
            }
            else -> {
                voiceCommandsClass.nullCommand()
            }
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
}