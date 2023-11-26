package com.diamoncode.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val courseTitle: Int,
    val relatedCourse: Int,
    @DrawableRes val idImage: Int

)

