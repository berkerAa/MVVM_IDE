package com.example.autonomtest.core.dm




import com.example.autonomtest.app_modules.view_binding.ViewBinding
import dagger.Binds
import com.example.autonomtest.src.user_logic.ds.UserScope
import com.example.autonomtest.src.user_logic.model.*
import com.example.autonomtest.src.user_logic.login.*
import com.example.autonomtest.src.user_logic.register.*
import com.example.autonomtest.src.user_logic.forgetpassword.*
import com.example.autonomtest.src.user_logic.registerC.RegisterView
import com.example.autonomtest.src.user_logic.verifycode.*
import com.example.autonomtest.src.user_logic.resetpassword.*
import com.example.autonomtest.src.user_logic.welcomescreen.WelcomeScreenView
import dagger.Module
//@EndImportLibraries
@Module
abstract class ViewBindingModule {


	@Binds @UserScope
 	abstract fun provideLoginView(loginView: LoginView): ViewBinding<LoginModel>
	@Binds @UserScope
 	abstract fun provideRegisterView(registerView: RegisterView): ViewBinding<RegisterModel>
	@Binds @UserScope
 	abstract fun provideForgetPasswordView(forgetpasswordView: ForgetPasswordView): ViewBinding<ForgetPasswordModel>
	@Binds @UserScope
 	abstract fun provideVerifyCodeView(verifycodeView: VerifyCodeView): ViewBinding<VerifyCodeModel>
	@Binds @UserScope
 	abstract fun provideResetPasswordView(resetpasswordView: ResetPasswordView): ViewBinding<ResetPasswordModel>
 	@Binds @UserScope
	abstract fun provideWelcomeScreenView(welcomeScreenView: WelcomeScreenView): ViewBinding<WelcomeScreenModel>

//@EndViewBinding
}