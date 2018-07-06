package mn.factory.crafftgiraffe.ui.cooking

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cooking.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.utils.ext.setRegularFont

class CookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cooking)

        setFonts()

        back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setFonts() {
        titleTextView.setRegularFont(this)
    }
}
