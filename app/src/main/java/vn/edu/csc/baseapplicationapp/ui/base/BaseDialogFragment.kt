package vn.edu.csc.baseapplicationapp.ui.base

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.FragmentManager
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import vn.edu.csc.baseapplicationapp.utilities.AndroidUtils
import javax.inject.Inject

open class BaseDialogFragment : AppCompatDialogFragment(), HasAndroidInjector {
    private var baseActivity: BaseActivity? = null
    private val TAG = this.javaClass.name

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            baseActivity = context as BaseActivity
        } catch (exception: ClassCastException) {
            throw ClassCastException("Activity holder must extend BaseActivity")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDialogWindow()
    }

    open fun setupDialogWindow() {
        val dialog = dialog
        if (dialog != null) {
            val window = dialog.window
            if (window != null) {
                window.requestFeature(Window.FEATURE_NO_TITLE)
                window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                window.setLayout(
                    (AndroidUtils.displaySize.x * 0.9) as Int,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        }
    }

    fun showLoading() {
        baseActivity?.showLoading()
    }

    fun hideLoading() {
        baseActivity?.hideLoading()
    }

    fun show(fragmentManager: FragmentManager?) {
        if (fragmentManager != null) {
            show(fragmentManager, TAG)
        }
    }

    override fun onDetach() {
        super.onDetach()
        baseActivity = null
    }
}