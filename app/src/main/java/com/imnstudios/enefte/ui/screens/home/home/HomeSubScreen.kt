@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.imnstudios.enefte.ui.screens.home.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.imnstudios.enefte.R
import com.imnstudios.enefte.ui.components.BalanceLayout
import com.imnstudios.enefte.ui.components.Button
import com.imnstudios.enefte.ui.screens.home.ArtPage
import com.imnstudios.enefte.ui.screens.home.GamingPage
import com.imnstudios.enefte.ui.screens.home.TrendingPage
import com.imnstudios.enefte.ui.util.disabledHorizontalPointerInputScroll
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeSubScreen() {
    val pagerState = rememberPagerState()

    val tagsCategories by remember {
        mutableStateOf(listOf("Trending", "Art", "Gaming"))
    }

    var selectedTopCategory by remember {
        mutableStateOf(tagsCategories[0])
    }

    val scope = rememberCoroutineScope()


    Scaffold(topBar = {
        Card(
            Modifier
                .fillMaxWidth()
                .statusBarsPadding(),
            backgroundColor = MaterialTheme.colors.background,
            elevation = 0.dp
        ) {
            Row(
                Modifier
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BalanceLayout(
                    balance = "26,031",
                    modifier = Modifier
                        .size(width = 93.dp, height = 43.dp)
                        .padding(top = 4.dp)
                )

                Image(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.profile_pic),
                    contentDescription = ""
                )
            }
        }
    }) {
        Column(modifier = Modifier.padding(it)) {
            FlowRow(
                modifier = Modifier
                    .padding(top = 32.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth(),
                mainAxisSpacing = 16.dp,
                crossAxisSpacing = 16.dp,
                mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly
            ) {
                tagsCategories.forEachIndexed { i, s ->
                    Button(
                        modifier = Modifier
                            .requiredHeightIn(max = 41.dp)
                            .requiredWidthIn(min = 82.dp),
                        onClick = {
                            selectedTopCategory = s
                            scope.launch {
                                pagerState.animateScrollToPage(i)
                            }
                        },
                        backGroundColor = if (selectedTopCategory == s) MaterialTheme.colors.primary else MaterialTheme.colors.secondary
                    ) {
                        Text(text = s, style = MaterialTheme.typography.button)
                    }
                }
            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .disabledHorizontalPointerInputScroll()
                    .padding(top = 31.dp),
                count = tagsCategories.size
            ) { page ->
                when (page) {
                    0 -> TrendingPage()
                    1 -> ArtPage()
                    2 -> GamingPage()
                }
            }

        }

    }


}
