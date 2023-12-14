package com.example.marsphotos.fake.api

import com.example.marsphotos.api.MarsApiService
import com.example.marsphotos.fake.data.FakeDataSource
import com.example.marsphotos.model.MarsPhoto

class FakeMarsApiService : MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }

}