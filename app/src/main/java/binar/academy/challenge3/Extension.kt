package binar.academy.challenge3

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import java.lang.Exception
import java.util.*

fun Int.formatSepartor(): String {
    val formatter = java.text.NumberFormat.getInstance(Locale.getDefault())
    return formatter.format(this)
}

