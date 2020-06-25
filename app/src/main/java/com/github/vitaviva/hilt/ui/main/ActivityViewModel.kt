package com.github.vitaviva.hilt.ui.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.vitaviva.hilt.repo.Repository

class ActivityViewModel @ViewModelInject constructor(
    val repository: Repository,
    @Assisted private val savedState: SavedStateHandle
) : ViewModel()
