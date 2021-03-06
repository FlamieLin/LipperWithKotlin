package com.fallllllll.lipperwithkotlin.core.presenter

import com.fall.generalrecyclerviewfragment.GeneralPresenter
import io.reactivex.disposables.CompositeDisposable
import kotlin.properties.Delegates

/**
 * Created by fallllllll on 2017/5/27/027.
 * GitHub :  https://github.com/348476129/Lipper
 */
abstract class BaseListPresenter : GeneralPresenter(), Contract.Presenter {
    protected lateinit var compositeDisposable: CompositeDisposable

    override fun attach() {
        compositeDisposable = CompositeDisposable()
    }

    override fun detach() {
        compositeDisposable.dispose()

    }
}