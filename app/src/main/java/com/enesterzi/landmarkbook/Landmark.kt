package com.enesterzi.landmarkbook

import androidx.annotation.DrawableRes
import java.io.Serializable

class Landmark (val name: String, val country: String, @DrawableRes val image: Int) : Serializable {
}