package com.imnstudios.enefte.ui.screens.home

import com.imnstudios.enefte.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_icon_home, "Home")
    object Search : NavigationItem("music", R.drawable.ic_icon_search, "Search")
    object Stats : NavigationItem("movies", R.drawable.ic_icon_stats, "Stats")
    object Profile : NavigationItem("profile", R.drawable.ic_icon_profile, "Profile")
}