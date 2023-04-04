package com.example.voicecontrolapp
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Button
import kotlin.system.exitProcess

class VoiceCommandsClass(private val context: Context) {

    private fun buttonClick(button: Button){
        button.performClick()
    }
    fun openFirstScreen(data : String){
        if (data == context.getString(R.string.open_first_screen) ||
            data == context.getString(R.string.open_screen_one)){
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
    fun openSecondScreen(data : String){
        if (data == context.getString(R.string.open_second_screen) ||
            data == context.getString(R.string.open_screen_two)){
            val intent = Intent(context, MainActivity2::class.java)
            context.startActivity(intent)
        }
    }
    fun exit(data : String){
        if (data == context.getString(R.string.close) ||
            data == context.getString(R.string.exit)){
            exitProcess(0)
        }
    }
    fun clickButton(data: String, button: Button){
        when(data){
            context.getString(R.string.click_red_button) -> buttonClick(button)
            context.getString(R.string.click_blue_button) -> buttonClick(button)
            context.getString(R.string.click_green_button) -> buttonClick(button)
        }
    }
}