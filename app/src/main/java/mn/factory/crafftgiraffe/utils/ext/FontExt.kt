package mn.factory.crafftgiraffe.utils.ext

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView

/**
 * Created by Turkin A. on 05.07.2018.
 */
const val FONT_PATH_REGULAR = "fonts/PTMono_regular.ttf"
const val FONT_PATH_BOLD = "fonts/PTMono_bold.ttf"

fun TextView.setRegularFont(context: Context) {
    val typeface = Typeface.createFromAsset(context.assets, FONT_PATH_REGULAR)

    this.typeface = typeface
}

fun TextView.setBoldFont(context: Context) {
    val typeface = Typeface.createFromAsset(context.assets, FONT_PATH_BOLD)

    this.typeface = typeface
}