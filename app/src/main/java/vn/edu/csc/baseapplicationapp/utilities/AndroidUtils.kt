package vn.edu.csc.baseapplicationapp.utilities

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Point
import android.os.Handler
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

open class AndroidUtils {
    companion object {
        private var density =
            Resources.getSystem().displayMetrics.density
        private var applicationHandler: Handler? = null

        var displaySize = Point()
        private val displayMetrics = DisplayMetrics()

        fun init(applicationContext: Context) {
            applicationHandler = Handler(applicationContext.mainLooper)
            density = applicationContext.resources.displayMetrics.density
            updateScreenSize(applicationContext)
        }

        private fun updateScreenSize(context: Context) {
            val configuration =
                context.resources.configuration
            val manager =
                context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = manager.defaultDisplay
            if (display != null) {
                display.getMetrics(displayMetrics)
                display.getSize(displaySize)
            }
            if (configuration.screenWidthDp != Configuration.SCREEN_WIDTH_DP_UNDEFINED) {
                val newSize = (configuration.screenWidthDp * density).toInt()
                if (Math.abs(displaySize.x - newSize) > 3) {
                    displaySize.x = newSize
                }
            }
            if (configuration.screenHeightDp != Configuration.SCREEN_HEIGHT_DP_UNDEFINED) {
                val newSize = (configuration.screenHeightDp * density).toInt()
                if (Math.abs(displaySize.y - newSize) > 3) {
                    displaySize.y = newSize
                }
            }
        }

        fun dpToPx(dp: Int): Int {
            return (dp * density).toInt()
        }

        fun dpToPx(dp: Float): Float {
            return dp * density
        }

        fun runOnUIThread(runnable: Runnable?) {
            runOnUIThread(runnable, 0)
        }

        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        fun runOnUIThread(runnable: Runnable?, delay: Long) {
            if (delay == 0L) {
                applicationHandler!!.post(runnable)
            } else {
                applicationHandler!!.postDelayed(runnable, delay)
            }
        }

        fun showSoftKeyboard(view: View) {
            if (view.requestFocus()) {
                val imm = view.context
                    .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
            }
        }

        fun hideSoftKeyboard(view: View) {
            val imm = view.context
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
            view.clearFocus()
        }

        fun getStatusBarHeight(context: Context): Int {
            var result = 0
            val resourceId =
                context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = context.resources.getDimensionPixelSize(resourceId)
            }
            return result
        }
    }
}