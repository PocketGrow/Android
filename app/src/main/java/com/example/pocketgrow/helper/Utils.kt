package com.example.pocketgrow.helper

import android.text.TextUtils

fun String.ifEmailValid(): Boolean  {
    return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}