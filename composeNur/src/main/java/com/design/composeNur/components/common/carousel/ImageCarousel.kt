package com.design.composeNur.components.common.carousel

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.delay

@Composable
fun <T> ImageCarousel(
    modifier: Modifier,
    items: List<CarouselItem<T>>,
    slideDurationMillis: Long = 3000L,
    onClick: (T) -> Unit = {}
) {

    val pagerState = rememberPagerState(initialPage = 0) { Int.MAX_VALUE }

    LaunchedEffect(Unit) {
        while (true) {
            delay(slideDurationMillis)
            val nextPage = (pagerState.currentPage + 1)
            if (nextPage >= Int.MAX_VALUE - 1) {
                pagerState.scrollToPage(0)
            } else {
                pagerState.animateScrollToPage(
                    page = nextPage,
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = FastOutLinearInEasing
                    )
                )
            }
        }
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth(),
            pageSpacing = 4.dp,
            state = pagerState,

        ) { page ->
            val realIndex = page % items.size
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { onClick(items[realIndex].item) },
                model = items[realIndex].imageUrl ?: items[realIndex].imageDrawable,
                contentDescription = "Image $realIndex",
                placeholder = items[realIndex].placeholder?.let { painterResource(it) },
                contentScale = ContentScale.Crop,
            )
        }
        PagerDotIndicator(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp),
            items = items,
            currentIndex = pagerState.currentPage % items.size
        )
    }
}

@Composable
fun PagerDotIndicator(
    modifier: Modifier,
    items: List<CarouselItem<*>>,
    currentIndex: Int,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        items.forEachIndexed { index, _ ->
            val isSelected = index == currentIndex

            Box(
                modifier = Modifier
                    .size(if (isSelected) 10.dp else 8.dp)
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) Color.Blue else Color.LightGray)
            )
        }
    }
}

data class CarouselItem<T>(
    val imageUrl: String? = null,
    @DrawableRes val imageDrawable: Int? = null,
    @DrawableRes val placeholder: Int? = null,
    val item: T
)