package mn.factory.crafftgiraffe.ui.profile

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.ui.categories.CategoriesActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val fromProfileIntent = Intent(this, CategoriesActivity::class.java)

        startActivity(fromProfileIntent)
        finish()
    }

    companion object {
        const val TAG = "ProfileActivity"

        const val KEY_FROM_PROFILE = "KEY_FROM_PROFILE"
    }
}
