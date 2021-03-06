package com.fallllllll.lipperwithkotlin.data.local.user

import com.fallllllll.lipperwithkotlin.core.constants.KEY_CREATED_AT
import com.fallllllll.lipperwithkotlin.core.constants.KEY_TOKEN_SCOPE
import com.fallllllll.lipperwithkotlin.core.constants.KEY_TOKEN_TYPE
import com.fallllllll.lipperwithkotlin.core.constants.KEY_USER_TOKEN
import com.fallllllll.lipperwithkotlin.data.local.datatank.DelegatesExt

/**
 * Created by fallllllll on 2017/6/2/002.
 * GitHub :  https://github.com/348476129/Lipper
 */
class UserManager private constructor() {
    var access_token: String by DelegatesExt.valuePreference(KEY_USER_TOKEN, "")
    var token_type: String by DelegatesExt.valuePreference(KEY_TOKEN_TYPE, "")
    var scope: String by DelegatesExt.valuePreference(KEY_TOKEN_SCOPE, "")
    var created_at: Int by DelegatesExt.valuePreference(KEY_CREATED_AT, -1)

    lateinit var lipperUser: LipperUser

    fun updateUser(lipperUser: LipperUser) {
        this.lipperUser = lipperUser
    }

    fun updateToken(userToken: UserToken) {
        with(userToken) {
            this@UserManager.access_token = access_token ?: ""
            this@UserManager.scope = scope ?: ""
            this@UserManager.created_at = created_at ?: -1
            this@UserManager.token_type = token_type ?: ""
        }
    }

    fun isLogin() = !access_token.isEmpty()

    fun logOut() {
        access_token = ""
        scope = ""
        created_at = -1
        token_type = ""
    }

    companion object {
        fun get(): UserManager = Inner.userManager
    }

    private object Inner {
        val userManager = UserManager()
    }
}