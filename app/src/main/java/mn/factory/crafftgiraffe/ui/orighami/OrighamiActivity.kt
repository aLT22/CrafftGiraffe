package mn.factory.crafftgiraffe.ui.orighami

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_orighami.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.utils.ext.setBoldFont
import mn.factory.crafftgiraffe.utils.ext.setRegularFont

class OrighamiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orighami)

        setFonts()

        back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setFonts() {
        titleTextView.setRegularFont(this)
        noMastersHere.setBoldFont(this)
    }
}
