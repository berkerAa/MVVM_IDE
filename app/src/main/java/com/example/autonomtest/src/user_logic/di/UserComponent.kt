package com.example.autonomtest.src.user_logic.di
import com.example.autonomtest.src.user_logic.ds.UserScope
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.autonomtest.app_modules.presenter.Presenter
import dagger.Subcomponent
import com.example.autonomtest.core.dm.ViewBindingModule
import com.example.autonomtest.core.dm.RouterModule
import com.example.autonomtest.core.dm.CompositeModule
import com.example.autonomtest.src.user_logic.UserBridge
import com.example.autonomtest.src.user_logic.forgetpassword.ForgetPasswordPresenter
import com.example.autonomtest.src.user_logic.forgetpassword.ForgetPasswordViewModel
import com.example.autonomtest.src.user_logic.forgetpassword.ForgetPasswordViewModel_Factory
import com.example.autonomtest.src.user_logic.login.LoginPresenter
import com.example.autonomtest.src.user_logic.login.LoginViewModel
import com.example.autonomtest.src.user_logic.model.ForgetPasswordModel
import com.example.autonomtest.src.user_logic.model.LoginModel
import com.example.autonomtest.src.user_logic.model.VerifyCodeModel
import com.example.autonomtest.src.user_logic.register.RegisterPresenter
import com.example.autonomtest.src.user_logic.resetpassword.ResetPasswordPresenter
import com.example.autonomtest.src.user_logic.verifycode.VerifyCodePresenter
import com.example.autonomtest.src.user_logic.verifycode.VerifyCodeViewModel
import com.example.autonomtest.src.user_logic.welcomescreen.WelcomeScreenPresenter

//@EndLibraryImport
@UserScope
@Subcomponent(modules = [ViewBindingModule::class, RouterModule::class, CompositeModule::class])
interface UserComponent {
    @Subcomponent.Factory
    interface Factory
    {
        fun create(): UserComponent
    }
    fun inject(activity: UserBridge)

    fun inject(fragment: LoginPresenter)

    fun inject(fragment: RegisterPresenter)

    fun inject(fragment: VerifyCodePresenter)

    fun inject(fragment: ForgetPasswordPresenter)

    fun inject(fragment: ResetPasswordPresenter)

    fun inject(fragment: WelcomeScreenPresenter)



}