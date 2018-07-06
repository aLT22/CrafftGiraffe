package mn.factory.crafftgiraffe.ui.pletenie

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pletenie.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.utils.ext.setRegularFont

class PletenieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pletenie)

        setFonts()

        back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setFonts() {
        titleTextView.setRegularFont(this)
    }
}
