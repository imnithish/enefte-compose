@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package com.imnstudios.enefte.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.imnstudios.enefte.ui.components.Button
import com.imnstudios.enefte.ui.screens.onboarding.Data.OnBoardingDataItems
import com.imnstudios.enefte.ui.util.disabledHorizontalPointerInputScroll
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController
) {

    val pagerState = rememberPagerState(initialPage = 0)
    val pagerState2 = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()
    val scope2 = rememberCoroutineScope()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
    ) {

        HorizontalPager(
            state = pagerState2,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.55f)
                .disabledHorizontalPointerInputScroll()
                .statusBarsPadding()
                .align(Alignment.TopCenter),
            count = OnBoardingDataItems.size
        ) { page ->
            Image(
                modifier = Modifier.size(207.dp),
                painter = painterResource(id = OnBoardingDataItems[page].image),
                contentDescription = ""
            )
        }

        Surface(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.45f)
                .align(Alignment.BottomCenter),
            elevation = 0.dp,
            color = MaterialTheme.colors.secondary,
            shape = RoundedCornerShape(topEnd = 32.dp, topStart = 32.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .disabledHorizontalPointerInputScroll()
                        .padding(top = 42.dp)
                        .sizeIn(maxHeight = 82.dp),
                    count = OnBoardingDataItems.size
                ) { page ->
                    Text(
                        modifier = Modifier.sizeIn(maxWidth = 277.dp),
                        textAlign = TextAlign.Center,
                        text = OnBoardingDataItems[page].text,
                        style = MaterialTheme.typography.h1
                    )
                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .sizeIn(maxWidth = 277.dp)
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    textAlign = TextAlign.Center,
                    text = "Buy and sell digital items",
                    style = MaterialTheme.typography.body1
                )

                HorizontalPagerIndicator(
                    modifier = Modifier.padding(top = 24.dp),
                    pagerState = pagerState,
                    activeColor = MaterialTheme.colors.onBackground,
                    inactiveColor = MaterialTheme.colors.background,
                    indicatorHeight = 8.dp,
                    indicatorWidth = 8.dp
                )
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 80.dp),
                    onClick = {
                        if (pagerState.currentPage == 2)
                            navController.navigate("start")
                        else {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                            scope2.launch {
                                pagerState2.animateScrollToPage(pagerState2.currentPage + 1)
                            }
                        }
                    }) {
                    Text(text = "Next", style = MaterialTheme.typography.button)
                }

                Spacer(modifier = Modifier.navigationBarsPadding())
            }
        }


    }
}