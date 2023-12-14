package com.example.marsphotos.fake

import com.example.marsphotos.data.NetworkMarsPhotosRepository
import com.example.marsphotos.fake.api.FakeMarsApiService
import com.example.marsphotos.fake.data.FakeDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class NetworkMarsRepositoryTest {

    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() = runTest {

        val repository = NetworkMarsPhotosRepository(
            marsApiService = FakeMarsApiService()
        )

        Assert.assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())

    }

}