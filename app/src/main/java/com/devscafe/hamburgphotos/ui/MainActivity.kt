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

package com.devscafe.hamburgphotos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.devscafe.hamburgphotos.R
import com.devscafe.hamburgphotos.databinding.ActivityMainBinding
import com.devscafe.hamburgphotos.interfaces.ActivityHelper
import com.devscafe.hamburgphotos.network.ConstantLinks
import com.devscafe.hamburgphotos.network.PhotosApi
import com.devscafe.hamburgphotos.ui.fragments.MainFragment
import com.devscafe.hamburgphotos.viewmodels.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainFragment: MainFragment
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
//        val api = Retrofit
//            .Builder()
//            .baseUrl(ConstantLinks.apiLink)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(PhotosApi::class.java)
//
//        GlobalScope.launch(Dispatchers.IO) {
//            val response = photosApi.getPhotosApi("hamburg", "photo").awaitResponse()
//            if (response.isSuccessful) {
//                for (response in response.body()?.hits!!) {
//                    Log.d("AppRepository", response.toString())
//                }
//            } else {
//                Log.d("AppRepository", response.message())
//            }
//
//        }
    }

}