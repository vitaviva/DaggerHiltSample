package com.github.vitaviva.hilt.ui.main

import android.content.Intent
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
import com.github.vitaviva.hilt.ui.second.SecondActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_first.*
import javax.inject.Inject

@AndroidEntryPoint
class MainFirstFragment : Fragment(R.layout.fragment_first) {

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

        Log.d(TAG, "app : $appHash")
        Log.d(TAG, "activity : $activityHash")
        Log.d(TAG, "fragment : $fragmentHash")
        Log.d(TAG, "activity vm: $activityViewModel")
        Log.d(TAG, "fragment vm: $fragmentViewModel")
        Log.d(TAG, "activity vm repo: ${activityViewModel.repository}")
        Log.d(TAG, "fragment vm repo: ${fragmentViewModel.repository}")

        button_activity.setOnClickListener {
            startActivity(Intent(activity, SecondActivity::class.java));
        }
        button_fragment.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}
