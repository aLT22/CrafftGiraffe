package mn.factory.crafftgiraffe.ui.start

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.ui.categories.CategoriesActivity
import mn.factory.crafftgiraffe.ui.login.LoginActivity
import mn.factory.crafftgiraffe.utils.ext.setRegularFont


class MainActivity :
        AppCompatActivity(),
        TextView.OnEditorActionListener {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFonts()

        login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
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
        val options: ActivityOptionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(this,
                        Pair.create(startScreenContainer, ViewCompat.getTransitionName(startScreenContainer)),
                        Pair.create(searchCity, ViewCompat.getTransitionName(searchCity)),
                        Pair.create(searchCity, ViewCompat.getTransitionName(searchCity))
                )

        val bundle = Bundle()
        bundle.putString(KEY_CITY, searchCity.text.toString())

        val intent = Intent(this, CategoriesActivity::class.java)
        intent.putExtras(bundle)

        startActivity(intent, options.toBundle())
        return true
    }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        return when (v?.id) {
            R.id.searchCity -> {
                if (
                        actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_SEND ||
                        actionId == EditorInfo.IME_ACTION_GO ||
                        actionId == EditorInfo.IME_ACTION_DONE
                ) {
                    startCategoriesActivity()
                }

                false
            }
            else -> false
        }
    }

    companion object {
        const val TAG = "MainActivity"

        const val KEY_CITY = "KEY_CITY"
    }
}
