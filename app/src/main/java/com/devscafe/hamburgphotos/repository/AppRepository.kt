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

package com.devscafe.hamburgphotos.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.devscafe.hamburgphotos.data.HitsItem
import com.devscafe.hamburgphotos.data.PhotosList
import com.devscafe.hamburgphotos.network.PhotosApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

private const val TAG = "AppRepository"

class AppRepository @Inject constructor(private val photosApi: PhotosApi) {

    fun makeCallAPI(liveDataList: MutableLiveData<List<HitsItem>>) {

        val call: Call<PhotosList> = photosApi.getPhotosApi("hamburg", "photo")

        call.enqueue(object : Callback<PhotosList> {
            override fun onResponse(call: Call<PhotosList>, response: Response<PhotosList>) {
                liveDataList.postValue(response.body()?.hits)
            }

            override fun onFailure(call: Call<PhotosList>, t: Throwable) {
                Log.e(TAG, t.message.toString())
            }
        })
    }

}