package com.diamoncode.artspace.model

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.platform.LocalContext


fun getStringResource(textId: String, context: Context): Int {
    return context.resources.getIdentifier(textId, "string", context.packageName)
}

fun getImageResource(textId: String, context: Context): Int {
    return context.resources.getIdentifier(textId, "drawable", context.packageName)
}


class ResourcesData constructor(idValue: Int = 1, context: Context) {
    val id: Int = idValue

    @StringRes
    val mainTextId: Int = getStringResource("mainText_$idValue", context)

    @StringRes
    val subTextId: Int = getStringResource("subText_$idValue", context)

    @StringRes
    val yearTextId: Int = getStringResource("year_$idValue", context)


    @DrawableRes
    val imageResourceId: Int = getImageResource(textId = "img$idValue", context)


}