package mn.factory.crafftgiraffe.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.ui.photos.AllPhotosActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setFonts()

        allPhotos.setOnClickListener {
            startActivity(Intent(this, AllPhotosActivity::class.java))
        }

        sendMail.setOnClickListener {
            intent?.let {
                val uri = Uri.parse("mailto:${it.getStringExtra(KEY_EMAIL)}").buildUpon().build()

                val sendMailIntent = Intent(Intent.ACTION_SENDTO, uri)

                startActivity(Intent.createChooser(sendMailIntent, "Send mail to ${it.getStringExtra(KEY_EMAIL)} via:"))
            }
        }
    }

    private fun setFonts() {

    }

    companion object {
        const val TAG = "ProfileActivity"

        const val KEY_EMAIL = "KEY_EMAIL"
    }
}
