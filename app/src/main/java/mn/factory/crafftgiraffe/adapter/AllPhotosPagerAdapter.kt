package mn.factory.crafftgiraffe.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import mn.factory.crafftgiraffe.ui.photos.AllPhotosFragment

/**
 * Created by Turkin A. on 05.07.2018.
 */
class AllPhotosPagerAdapter(fragmentManager: FragmentManager)
    : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment =
            AllPhotosFragment.newInstance(position)

    override fun getCount(): Int = 3

}