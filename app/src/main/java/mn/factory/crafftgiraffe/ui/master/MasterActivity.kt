package mn.factory.crafftgiraffe.ui.master

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_master.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.ui.photos.AllPhotosActivity

class MasterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master)

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

        arrowBack.setOnClickListener {
            onBackPressed()
        }

        address.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ADDRESS))

            startActivity(intent)
        }
    }

    private fun setFonts() {

    }

    companion object {
        const val TAG = "MasterActivity"

        const val KEY_EMAIL = "KEY_EMAIL"

        private const val LOCATION = "Calle Conde Duque, 11, 28015, Madrid, Spain"
        const val ADDRESS = "http://maps.google.co.in/maps?q=$LOCATION"
    }
}
