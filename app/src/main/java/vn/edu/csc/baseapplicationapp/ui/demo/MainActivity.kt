package vn.edu.csc.baseapplicationapp.ui.demo

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import vn.edu.csc.baseapplicationapp.R
import vn.edu.csc.baseapplicationapp.data.repo.Status
import vn.edu.csc.baseapplicationapp.di.DaggerViewModelFactory
import vn.edu.csc.baseapplicationapp.di.module.Qualifiers
import vn.edu.csc.baseapplicationapp.ui.base.BaseActivity
import javax.inject.Inject
import javax.inject.Named

class MainActivity : BaseActivity() {
    @Named(Qualifiers.ENVIRONMENT)
    @Inject
    lateinit var environment: String

    @Inject
    lateinit var factory: DaggerViewModelFactory
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        viewModel.setLogIn()
        viewModel.user.observe(this, {
            if (it.status == Status.SUCCESS){
                toast(it.data?.name)
            }
        })
    }
}