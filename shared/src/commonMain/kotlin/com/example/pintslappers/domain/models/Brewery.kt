package com.example.pintslappers.domain.models

import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

data class Brewery(
    @PrimaryKey
    var _id: ObjectId = ObjectId.invoke(),
    var name: String = "",
    var city: String = "",
    var state: String = "",
    var country: String = "",
    var types: String = "",
    var latitude: Double = 0.0,
    var longitude: Double = 0.0,
)
