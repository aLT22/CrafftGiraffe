package mn.factory.crafftgiraffe.ui.lepka

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lepka.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.utils.ext.setRegularFont

class LepkaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lepka)

        back.setOnClickListener {
            onBackPressed()
        }

        setFonts()
    }

    private fun setFonts() {
        titleTextView.setRegularFont(this)
    }
}
