package com.example.todo.utils

import android.content.Context
import android.widget.Toast

object ToastUtils {

    fun shortToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun longToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun customToast(context: Context, message: String, layoutResId: Int) {
        val inflater = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as android.view.LayoutInflater)
        val layout = inflater.inflate(layoutResId, null)

        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }
}
