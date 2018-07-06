package mn.factory.crafftgiraffe.ui.results

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_results.*
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.adapter.MastersAdapter
import mn.factory.crafftgiraffe.data.model.Master
import mn.factory.crafftgiraffe.utils.ext.setRegularFont

class ResultsActivity : AppCompatActivity() {

    val mastersAdapter = MastersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        setFonts()

        back.setOnClickListener {
            onBackPressed()
        }

        mastersAdapter.items.add(Master("Варнавская Елена", "varnavskaya@factory.mn", 5))
        mastersAdapter.items.add(Master("Ozetta Knitwear", "", 4))
        mastersAdapter.items.add(Master("Stephen West", "", 5))
        mastersAdapter.items.add(Master("Caitlin Hunter", "", 3))
        mastersAdapter.items.add(Master("Susanne Sommer", "", 5))
        mastersAdapter.items.add(Master("Etta Munoz", "", 5))

        mastersList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ResultsActivity)
            adapter = mastersAdapter
        }
    }

    private fun setFonts() {
        titleTextView.setRegularFont(this)
    }
}
