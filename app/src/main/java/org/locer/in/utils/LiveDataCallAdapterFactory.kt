package org.locer.`in`.utils

import androidx.lifecycle.LiveData
import retrofit2.CallAdapter
import retrofit2.CallAdapter.Factory
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Authored by Ayush Shrivastava on 1/10/20
 */

class LiveDataCallAdapterFactory : Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (Factory.getRawType(returnType) != LiveData::class.java) {
            return null
        }
        val observableType = Factory.getParameterUpperBound(0, returnType as ParameterizedType)
        val rawObservableType = Factory.getRawType(observableType)
        // TODO: 1/10/20  Add the GenericApiResponse class
//        if (rawObservableType != GenericApiResponse::class.java) {
//            throw IllegalArgumentException("type must be a resource")
//        }
        if (observableType !is ParameterizedType) {
            throw IllegalArgumentException("resource must be parameterized")
        }
        // TODO: 1/10/20 Add the LiveDataCallAdapter class
        val bodyType = Factory.getParameterUpperBound(0, observableType)
//        return LiveDataCallAdapter<Any>(bodyType)
    }
}
