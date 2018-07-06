package mn.factory.crafftgiraffe.ui.photos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_all_photos.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.adapter.AllPhotosPagerAdapter

class AllPhotosActivity : AppCompatActivity() {

    val allPhotosPagerAdapter = AllPhotosPagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_photos)

        allPhotosViewPager.apply {
            adapter = allPhotosPagerAdapter
        }
    }
}
