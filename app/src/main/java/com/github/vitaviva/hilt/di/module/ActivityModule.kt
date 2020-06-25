package com.github.vitaviva.hilt.di.module

import com.github.vitaviva.hilt.di.qualifiers.ActivityScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {
    @ActivityScope
    @Provides
    fun provide(): String {
        return hashCode().toString()
    }
}
