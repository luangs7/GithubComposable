package com.luan.teste.presentation.profile.details

sealed class ProfileNavItem(var route:String, var title:String){
    object ProfileDetails : ProfileNavItem("profile/details", "Details")
}
