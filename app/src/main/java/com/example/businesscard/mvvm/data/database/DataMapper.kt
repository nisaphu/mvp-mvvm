package com.example.businesscard.mvvm.data.database

import com.example.businesscard.mvvm.model.Data
import com.example.businesscard.mvvm.model.FixedHeightSmallStill
import com.example.businesscard.mvvm.model.Images

fun DataEntity.toData() = Data(
    Images(FixedHeightSmallStill("100", "8021", this.images, "100")),
    this.title,
    this.type,
    this.username
)

fun List<DataEntity>.toDataList() = this.map { it.toData() }

fun Data.toDataEntity() = DataEntity(
    images = this.images.fixedHeightSmallStill.url,
    title = this.title,
    type = this.type,
    username = this.username
)

fun List<Data>.toDataEntityList() = this.map { it.toDataEntity() }
