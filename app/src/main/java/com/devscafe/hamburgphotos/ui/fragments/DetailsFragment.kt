/*
 *
 *
 *   Created Hossam Waziry on 8/8/21, 5:13 AM
 *   Copyright Ⓒ 2021. All rights reserved Ⓒ  2021 7ossam.gamal@gmail.com
 *   Last modified: 8/8/21, 5:12 AM
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied. See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 *
 */

package com.devscafe.hamburgphotos.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.devscafe.hamburgphotos.R
import com.devscafe.hamburgphotos.data.HitsItem
import com.devscafe.hamburgphotos.databinding.FragmentDetailsBinding
import com.devscafe.hamburgphotos.interfaces.FragmentHelper
import com.devscafe.hamburgphotos.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.security.auth.callback.Callback


@AndroidEntryPoint
class DetailsFragment @Inject constructor() : Fragment(R.layout.fragment_details), FragmentHelper {

    private lateinit var binding: FragmentDetailsBinding
    private val model: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingFragment(view)
        initUi()
    }

    override fun bindingFragment(view: View) {
        binding = FragmentDetailsBinding.bind(view)
    }

    override fun initUi() {

        model.hitsLiveData.observe(viewLifecycleOwner) {

            Glide
                .with(this)
                .load(it.largeImageURL)
                .centerCrop()
                .into(binding.imagePostDetails)

            binding.usernamePostDetails.text = it.user

        }
    }

}