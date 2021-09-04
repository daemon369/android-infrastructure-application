package me.daemon.infrastructure.application.demo

import androidx.annotation.StringRes
import me.daemon.infrastructure.application.application

class Test {

    companion object {

        fun getString(@StringRes strId: Int): String {
            return application.getString(strId)
        }
    }

}