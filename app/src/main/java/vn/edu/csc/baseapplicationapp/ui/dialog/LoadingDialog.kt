package vn.edu.csc.baseapplicationapp.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import vn.edu.csc.baseapplicationapp.ui.base.BaseDialogFragment

class LoadingDialog : BaseDialogFragment() {

    override fun setupDialogWindow() {
        super.setupDialogWindow()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            val window = dialog.window
            window?.setLayout(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
        }
        isCancelable = false
    }

}