package com.nicksidiropoulos.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(
     @StringRes
     val stringResource: Int,
     val lessonsNumber: Int,
     @DrawableRes
     val imageResource: Int
)
