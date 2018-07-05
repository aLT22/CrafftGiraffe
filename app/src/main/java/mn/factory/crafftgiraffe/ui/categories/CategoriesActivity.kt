package mn.factory.crafftgiraffe.ui.categories

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import kotlinx.android.synthetic.main.activity_categories.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.ui.start.MainActivity
import mn.factory.crafftgiraffe.utils.ext.setRegularFont

class CategoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        obtainOuterBundle()

        setFonts()
    }

    private fun obtainOuterBundle() {
        intent?.let {
            it.extras?.let {
                titleCity.text = Editable.Factory.getInstance().newEditable(it[MainActivity.KEY_CITY].toString())
            }
        }
    }

    private fun setFonts() {
        titleCity.setRegularFont(this)
    }

    companion object {
        const val TAG = "CategoriesActivity"
    }
}
