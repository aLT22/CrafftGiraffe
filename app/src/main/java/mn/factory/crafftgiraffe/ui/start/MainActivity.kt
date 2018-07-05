package mn.factory.crafftgiraffe.ui.start

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.ui.categories.CategoriesActivity
import mn.factory.crafftgiraffe.utils.ext.setRegularFont

class MainActivity :
        AppCompatActivity(),
        TextView.OnEditorActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFonts()
    }

    override fun onStart() {
        super.onStart()

        setUpListeners()
    }

    override fun onStop() {
        super.onStop()

        removeListeners()
    }

    private fun setFonts() {
        search.setRegularFont(this)
        searchCity.setRegularFont(this)
        login.setRegularFont(this)
        register.setRegularFont(this)
    }

    private fun setUpListeners() {
        searchCity.setOnEditorActionListener(this)
    }

    private fun removeListeners() {
        searchCity.setOnEditorActionListener(null)
    }

    private fun startCategoriesActivity(): Boolean {
        val bundle = Bundle()
        bundle.putString(KEY_CITY, searchCity.text.toString())

        val intent = Intent(this, CategoriesActivity::class.java)
        intent.putExtras(bundle)

        startActivity(intent)
        return true
    }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        when (v?.id) {
            R.id.searchCity -> {
                if (
                        actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_SEND ||
                        actionId == EditorInfo.IME_ACTION_GO ||
                        actionId == EditorInfo.IME_ACTION_DONE
                ) {
                    startCategoriesActivity()
                }

                return false
            }
            else -> return false
        }
    }

    companion object {
        const val TAG = "MainActivity"

        const val KEY_CITY = "KEY_CITY"
    }
}
