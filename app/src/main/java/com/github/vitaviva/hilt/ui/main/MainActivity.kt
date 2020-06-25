package com.github.vitaviva.hilt.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.vitaviva.hilt.R
import com.github.vitaviva.hilt.di.qualifiers.ActivityScope
import com.github.vitaviva.hilt.di.qualifiers.AppScope
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val TAG = this.javaClass.toString()

    @AppScope
    @Inject
    lateinit var appHash: String

    @ActivityScope
    @Inject
    lateinit var activityHash: String

    private val viewModel by viewModels<ActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.v(TAG, "app : $appHash")
        Log.v(TAG, "activity : $activityHash")
        Log.v(TAG, "activity vm: $viewModel")
        Log.v(TAG, "activity vm repo: ${viewModel.repository}")
    }
}
