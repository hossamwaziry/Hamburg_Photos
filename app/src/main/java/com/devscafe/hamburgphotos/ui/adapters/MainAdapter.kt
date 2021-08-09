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

package com.devscafe.hamburgphotos.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devscafe.hamburgphotos.data.HitsItem
import com.devscafe.hamburgphotos.databinding.ItemPhotoListBinding
import com.devscafe.hamburgphotos.interfaces.ItemClickListener
import com.devscafe.hamburgphotos.ui.fragments.MainFragmentDirections
import javax.inject.Inject

class MainAdapter constructor(
    private val context: Context?,
    private var dataList: List<HitsItem>,
    private val onItemClickListener: ItemClickListener
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private lateinit var binding: ItemPhotoListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = ItemPhotoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        binding.apply {
            Glide
                .with(context!!)
                .load(dataList[position].largeImageURL)
                .centerCrop()
                .into(binding.imagePostLayout);

            Glide
                .with(context)
                .load(dataList[position].userImageURL)
                .centerCrop()
                .into(binding.imageUserItem);

            binding.namePostLayout.text = dataList[position].user

            binding.postContainer.setOnClickListener {
                onItemClickListener.onItemClickListener(dataList[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class MainViewHolder(private val binding: ItemPhotoListBinding) :
        RecyclerView.ViewHolder(binding.root)
}