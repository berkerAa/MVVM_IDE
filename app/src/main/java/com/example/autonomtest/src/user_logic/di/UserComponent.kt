package com.example.autonomtest.src.user_logic.di
import com.example.autonomtest.src.user_logic.ds.UserScope
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.Subcomponent
import com.example.autonomtest.core.dm.ViewBindingModule
import com.example.autonomtest.core.dm.RouterModule
import com.example.autonomtest.core.dm.CompositeModule

//@EndLibraryImport
@UserScope
@Subcomponent(modules = [ViewBindingModule::class, RouterModule::class, CompositeModule::class])
interface UserComponent {
    @Subcomponent.Factory
    interface Factory
    {
        fun create(): UserComponent
    }
    fun inject(activity: AppCompatActivity)
    fun inject(fragment: Fragment)
}