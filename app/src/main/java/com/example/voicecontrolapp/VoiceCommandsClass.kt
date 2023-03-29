package com.example.voicecontrolapp
import android.content.Context
import android.content.Intent
import android.widget.Button
import kotlin.system.exitProcess

class VoiceCommandsClass(private val context: Context) {
    private var command : String = ""
    fun commandManager(data : String){
        when (data) {
            "open screen one", "open first screen" -> {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }
            "open screen two", "open second screen" -> {
                val intent = Intent(context, MainActivity2::class.java)
                context.startActivity(intent)
            }
            "exit" ->{
                exitProcess(0)
            }
            else -> {
                nullCommand()
            }
        }
    }
    fun buttonClick(button: Button){
        button.performClick()
    }

    fun nullCommand() : String{
        command = "Unable to detect a command"
        return command
    }
}