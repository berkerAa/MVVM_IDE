package com.example.autonomtest.app_modules.presenter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.autonomtest.app_modules.view_binding.ViewBinding
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject



abstract class Presenter<T: Any, E>: Fragment() {

    @Inject
    lateinit var viewModel: T

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    @Inject
    lateinit var viewBinding: ViewBinding<E>





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return viewBinding.view
    }

    protected fun setView(layoutId: Int, container: ViewGroup?, inflater: LayoutInflater)
    {
        viewBinding.view = inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }



    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    fun observeOn(){}

    fun initUI(){}
}