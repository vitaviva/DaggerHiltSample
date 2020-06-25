package com.github.vitaviva.hilt.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.vitaviva.hilt.R
import com.github.vitaviva.hilt.di.qualifiers.ActivityScope
import com.github.vitaviva.hilt.di.qualifiers.AppScope
import com.github.vitaviva.hilt.di.qualifiers.FragmentScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_second.*
import javax.inject.Inject

@AndroidEntryPoint
class MainSecondFragment : Fragment(R.layout.fragment_second) {

    private val TAG = this.javaClass.toString()

    @AppScope
    @Inject
    lateinit var appHash: String

    @ActivityScope
    @Inject
    lateinit var activityHash: String

    @FragmentScope
    @Inject
    lateinit var fragmentHash: String

    private val activityViewModel by activityViewModels<ActivityViewModel>()
    private val fragmentViewModel by viewModels<FragmentViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i(TAG, "app : $appHash")
        Log.i(TAG, "activity : $activityHash")
        Log.i(TAG, "fragment : $fragmentHash")
        Log.i(TAG, "activity view model: $activityViewModel")
        Log.i(TAG, "fragment view model: $fragmentViewModel")
        Log.i(TAG, "activity vm repository: ${activityViewModel.repository}")
        Log.i(TAG, "fragment vm repository: ${fragmentViewModel.repository}")

        button.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}
