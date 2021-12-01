package com.example.autonomtest.src.user_logic

import android.os.Bundle
import com.example.autonomtest.app_modules.bridge.Bridge
import com.example.autonomtest.core.base.ApplicationGraph
import com.example.autonomtest.src.user_logic.di.UserComponent
import com.example.autonomtest.src.user_logic.ds.UserScope
import com.example.autonomtest.src.user_logic.login.LoginPresenter

@UserScope
class UserBridge: Bridge<UserComponent, UserNavigationStatus>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        component = (application as ApplicationGraph).applicationGraphComponent.userComponent().create()
        component.inject(this)
        super.onCreate(savedInstanceState)
        startNavigation { LoginPresenter() }
    }
}