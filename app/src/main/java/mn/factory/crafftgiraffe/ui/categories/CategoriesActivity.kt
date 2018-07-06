package mn.factory.crafftgiraffe.ui.categories

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.text.Editable
import android.transition.ChangeBounds
import android.transition.Transition
import android.view.animation.DecelerateInterpolator
import kotlinx.android.synthetic.main.activity_categories.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.adapter.CategoriesAdapter
import mn.factory.crafftgiraffe.data.model.Category
import mn.factory.crafftgiraffe.ui.profile.ProfileActivity
import mn.factory.crafftgiraffe.ui.start.MainActivity
import mn.factory.crafftgiraffe.utils.ext.setRegularFont

class CategoriesActivity : AppCompatActivity() {

    val categoriesAdapter = CategoriesAdapter()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        window.sharedElementEnterTransition = enterTransition()
        window.sharedElementReturnTransition = returnTransition()

        categoriesAdapter.items.add(Category())
        categoriesAdapter.items.add(Category())
        categoriesAdapter.items.add(Category())
        categoriesAdapter.items.add(Category())
        categoriesAdapter.items.add(Category())
        categoriesAdapter.items.add(Category())

        listCategories
                .apply {
                    setHasFixedSize(true)
                    layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    adapter = categoriesAdapter
                }

        obtainOuterBundle()
        setFonts()
        clearFocus()
    }

    private fun obtainOuterBundle() {
        intent?.let {
            it.extras?.let {
                titleCity.text = Editable.Factory.getInstance().newEditable(it[MainActivity.KEY_CITY].toString())
            }
        }
    }

    private fun setFonts() {
        titleCity.setRegularFont(this)
    }

    private fun clearFocus() =
            window.decorView.clearFocus()

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun enterTransition(): Transition {
        val bounds = ChangeBounds()
        bounds.duration = 500

        return bounds
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun returnTransition(): Transition {
        val bounds = ChangeBounds()
        bounds.interpolator = DecelerateInterpolator()
        bounds.duration = 500

        return bounds
    }

    companion object {
        const val TAG = "CategoriesActivity"
    }
}
