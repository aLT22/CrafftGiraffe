package mn.factory.crafftgiraffe.ui.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import mn.factory.crafftgiraffe.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        enterToProfile.setOnClickListener {
            Toast.makeText(this, "Go to Profile", Toast.LENGTH_SHORT).show()
        }
    }
}
