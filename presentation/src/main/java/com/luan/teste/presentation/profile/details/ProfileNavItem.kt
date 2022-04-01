package com.luan.teste.presentation.profile.details

import com.luan.estar.navigation.DestinationDrawer
import com.luan.estar.navigation.Destinations

sealed class ProfileNavItem(var route:String, var title:String){
    object ProfileDetails : ProfileNavItem(Destinations.ProfileDetails, DestinationDrawer.ProfileDetails)
}
