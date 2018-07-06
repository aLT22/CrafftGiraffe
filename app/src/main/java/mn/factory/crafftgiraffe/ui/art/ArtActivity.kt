package mn.factory.crafftgiraffe.ui.art

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_art.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.utils.ext.setRegularFont

class ArtActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art)

        setFonts()

        back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setFonts() {
        titleTextView.setRegularFont(this)
    }
}
