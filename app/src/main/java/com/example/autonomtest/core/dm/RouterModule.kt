package com.example.autonomtest.core.dm

import com.example.autonomtest.app_modules.router.Router
import dagger.Binds
import dagger.Module

import com.example.autonomtest.src.user_logic.*
import com.example.autonomtest.src.user_logic.ds.UserScope

//@EndImportLibraries
@Module
abstract class RouterModule {


	@Binds @UserScope
	abstract fun provideUserRouter(userProvider: UserRouter): Router<UserNavigationStatus>





//@EndRouterBinder
}

