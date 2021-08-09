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

import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devscafe.hamburgphotos.R
import com.devscafe.hamburgphotos.data.HitsItem
import com.devscafe.hamburgphotos.databinding.FragmentMainBinding
import com.devscafe.hamburgphotos.interfaces.FragmentHelper
import com.devscafe.hamburgphotos.interfaces.ItemClickListener
import com.devscafe.hamburgphotos.ui.adapters.MainAdapter
import com.devscafe.hamburgphotos.viewmodels.MainFragmentViewModel
import com.devscafe.hamburgphotos.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.nio.channels.Selector
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment @Inject constructor() : Fragment(R.layout.fragment_main), FragmentHelper,
    ItemClickListener {

    private lateinit var adapter: MainAdapter
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainFragmentViewModel by viewModels()
    private val model: SharedViewModel by activityViewModels()

    @Inject
    lateinit var detailsFragment: DetailsFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingFragment(view)
        initUi()

    }

    override fun bindingFragment(view: View) {
        binding = FragmentMainBinding.bind(view)
        binding.mainRecyclerview.layoutManager = LinearLayoutManager(activity)
    }

    override fun initUi() {

        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter = MainAdapter(this.context, it, this)
            binding.mainRecyclerview.adapter = adapter
        }

    }

    override fun onItemClickListener(hitsItem: HitsItem) {

        model.shareObject(hitsItem)

        findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailsFragment())

    }


}