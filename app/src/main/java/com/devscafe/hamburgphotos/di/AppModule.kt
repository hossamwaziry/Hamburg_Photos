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

package com.devscafe.hamburgphotos.di

import android.content.Context
import com.devscafe.hamburgphotos.data.HitsItem
import com.devscafe.hamburgphotos.network.ConstantLinks
import com.devscafe.hamburgphotos.network.PhotosApi
import com.devscafe.hamburgphotos.ui.adapters.MainAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(ConstantLinks.apiLink)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getRetrofitPhotosApiInstance(retrofit: Retrofit): PhotosApi {
        return retrofit.create(PhotosApi::class.java)
    }
}