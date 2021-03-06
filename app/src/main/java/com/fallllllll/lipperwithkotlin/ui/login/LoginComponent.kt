package com.fallllllll.lipperwithkotlin.ui.login

import android.support.v7.app.AppCompatActivity
import com.fallllllll.lipperwithkotlin.core.dagger.AppComponent
import dagger.Component

/**
 * Created by fallllllll on 2017/6/14/014.
 * GitHub :  https://github.com/348476129/Lipper
 */
@Component(dependencies =arrayOf( AppComponent::class),modules = arrayOf(LoginModule::class))
interface LoginComponent {
    fun inject(loginActivity:LoginActivity)
}