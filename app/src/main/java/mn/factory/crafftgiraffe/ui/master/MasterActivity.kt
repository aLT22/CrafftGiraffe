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

        share.setOnClickListener {
            val photoUri = Uri.parse("android.resource://${this.packageName}/drawable/person1_jpeg")

            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, SENDING_TEXT)
            sendIntent.putExtra(Intent.EXTRA_STREAM, photoUri)
            sendIntent.type = SEND_INTENT_TYPE
            sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(sendIntent, "Send to:"))
        }
    }

    private fun setFonts() {

    }

    companion object {
        const val TAG = "MasterActivity"

        const val KEY_EMAIL = "KEY_EMAIL"

        private const val LOCATION = "Calle Conde Duque, 11, 28015, Madrid, Spain"
        const val ADDRESS = "http://maps.google.co.in/maps?q=$LOCATION"

        const val SEND_INTENT_TYPE = "image/jpeg"
        const val SENDING_TEXT = "Посмотри на классные штуки в Craft Giraffe! Скачай приложение и ищи мастер-классы в любом городе мира! \n https://play.google.com/store/apps/details?id=ru.craftgiraffe"
    }
}
