package mn.factory.crafftgiraffe.ui.photos


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_all_photos.*

import mn.factory.crafftgiraffe.R

class AllPhotosFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_all_photos, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            when (arguments!![KEY_PAGE_NUM]) {
                0 -> profilePhoto.setImageDrawable(ContextCompat.getDrawable(activity!!, R.drawable.allphoto1))
                1 -> profilePhoto.setImageDrawable(ContextCompat.getDrawable(activity!!, R.drawable.allphoto2))
                2 -> profilePhoto.setImageDrawable(ContextCompat.getDrawable(activity!!, R.drawable.allphoto3))
            }
        }
    }

    companion object {
        const val TAG = "AllPhotosFragment"

        const val KEY_PAGE_NUM = "KEY_PAGE_NUM"

        fun newInstance(position: Int): AllPhotosFragment {
            val bundle = Bundle()
            bundle.putInt(KEY_PAGE_NUM, position)

            val fragment = AllPhotosFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

}
