package vn.edu.csc.baseapplicationapp.ui.base

import android.content.Context
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity
import vn.edu.csc.baseapplicationapp.ui.dialog.LoadingDialog

abstract class BaseActivity : DaggerAppCompatActivity() {
    private var loadingDialog: LoadingDialog? = null

    private fun isLoadingShowing(): Boolean {
        return loadingDialog != null && loadingDialog!!.dialog != null && loadingDialog!!.dialog!!.isShowing
    }

    //Base method
    open fun showLoading(): Unit {
        if (loadingDialog == null) {
            loadingDialog = LoadingDialog()
        }
        if (isLoadingShowing()) {
            return
        }
        loadingDialog!!.show(supportFragmentManager)
    }

    open fun hideLoading() {
        if (loadingDialog != null) {
            loadingDialog!!.dismiss()
        }
    }

    open fun Context.toast(message: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }
}