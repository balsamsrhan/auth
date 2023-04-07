package com.example.lec1mcc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        analytics = Firebase.analytics
    }

fun SELECT_CONTENT(id:String , name : String , contentType : String){
    analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT) {
        param(FirebaseAnalytics.Param.ITEM_ID, id)
        param(FirebaseAnalytics.Param.ITEM_NAME, name)
        param(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)
    }
}
    fun screen_track(screenClass:String , screenName : String){
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW){
            param(FirebaseAnalytics.Param.SCREEN_CLASS , screenClass)
            param(FirebaseAnalytics.Param.SCREEN_NAME , screenName)
        }
    }
    fun custom_event(){
        analytics.logEvent("image") {
            param("name_image","b1.png")
            param("select1","selected")
        }
    }
}