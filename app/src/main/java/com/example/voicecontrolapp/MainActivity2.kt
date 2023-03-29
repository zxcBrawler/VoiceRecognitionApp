package com.example.voicecontrolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import java.util.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var vm : ViewModelClass
    private lateinit var inputVoice: Button
    private lateinit var commandText : TextView
    private val voiceCommandsClass  = VoiceCommandsClass(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        inputVoice = findViewById(R.id.inputVoiceSecond)
        commandText = findViewById(R.id.commandTextSecond)
        vm = ViewModelProvider(this)[ViewModelClass::class.java]
        vm.getViewState().observe(this) { viewState ->
            render(viewState)
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
    }
}