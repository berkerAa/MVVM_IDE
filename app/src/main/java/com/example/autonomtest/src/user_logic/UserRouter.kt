package com.example.autonomtest.src.user_logic

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.autonomtest.app_modules.router.Router
import com.example.autonomtest.src.user_logic.ds.UserScope
import com.example.autonomtest.src.user_logic.login.LoginPresenter
import com.example.autonomtest.src.user_logic.register.RegisterPresenter
import com.example.autonomtest.src.user_logic.forgetpassword.ForgetPasswordPresenter
import com.example.autonomtest.src.user_logic.verifycode.VerifyCodePresenter
import com.example.autonomtest.src.user_logic.resetpassword.ResetPasswordPresenter
import com.example.autonomtest.src.user_logic.welcomescreen.WelcomeScreenPresenter
import javax.inject.Inject

//@EndLibraryImport

sealed class UserNavigationStatus
data class Login(val LOGIN: Class<LoginPresenter> = LoginPresenter::class.java): UserNavigationStatus()
data class Register(val REGISTER: Class<RegisterPresenter> = RegisterPresenter::class.java): UserNavigationStatus()
data class ForgetPassword(val FORGETPASSWORD: Class<ForgetPasswordPresenter> = ForgetPasswordPresenter::class.java): UserNavigationStatus()
data class VerifyCode(val VERIFYCODE: Class<VerifyCodePresenter> = VerifyCodePresenter::class.java): UserNavigationStatus()
data class ResetPassword(val RESETPASSWORD: Class<ResetPasswordPresenter> = ResetPasswordPresenter::class.java): UserNavigationStatus()
data class WelcomeScreen(val WELCOMESCREEN: Class<WelcomeScreenPresenter> = WelcomeScreenPresenter::class.java): UserNavigationStatus()

@UserScope
class UserRouter @Inject constructor(): Router<UserNavigationStatus> {
    override fun navigationLogic(
        activity: AppCompatActivity,
        navigationStatus: UserNavigationStatus,
        containerViewId: Int,
    ) {
        when(navigationStatus)
        {
		is Login -> onFragmentChange(activity, containerViewId, navigationStatus.LOGIN)
		is Register -> onFragmentChange(activity, containerViewId, navigationStatus.REGISTER)
		is ForgetPassword -> onFragmentChange(activity, containerViewId, navigationStatus.FORGETPASSWORD)
		is VerifyCode -> onFragmentChange(activity, containerViewId, navigationStatus.VERIFYCODE)
		is ResetPassword -> onFragmentChange(activity, containerViewId, navigationStatus.RESETPASSWORD)
	//@EndNavigationCaseCheck
        }
    }

    override fun navigationLogicOnBackPressed(
        activity: AppCompatActivity,
        activeScreen: Fragment,
        containerViewId: Int,
    ) {
        when(activeScreen)
        {
            is LoginPresenter -> activity.finishAffinity()
            is ForgetPasswordPresenter -> onFragmentChange(activity, containerViewId, LoginPresenter::class.java)
            is RegisterPresenter -> onFragmentChange(activity, containerViewId, LoginPresenter::class.java)



        }
    }
}