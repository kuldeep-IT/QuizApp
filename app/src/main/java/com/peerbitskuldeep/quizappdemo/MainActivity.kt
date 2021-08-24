package com.peerbitskuldeep.quizappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btnStart.setOnClickListener {

            if (tvName.text.toString().isEmpty())
            {
                Snackbar.make(it,
                "Please Enter Your Kind Name",
                Snackbar.LENGTH_SHORT).show()
            }
            else
            {
               val i=Intent(this, QuizQuestionsActivity::class.java)
                i.putExtra(Constants.USER_NAME, tvName.text.toString())
                startActivity(i)
                finish()
            }

        }

    }
}