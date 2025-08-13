package com.design.composeNur.components.common.carousel

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import kotlinx.coroutines.delay

@Composable
fun <T> NurImageCarousel(
    modifier: Modifier,
    items: List<CarouselItem<T>>,
    enableAutoSlide: Boolean = true,
    isPagerIndicatorVisible: Boolean = true,
    isClickable: Boolean = true,
    params: NurImageCarouselParams = NurImageCarouselParams.Default,
    onClick: (T) -> Unit = {}
) {

    val pagerState = rememberPagerState(initialPage = 0) { Int.MAX_VALUE }

    LaunchedEffect(Unit) {
        while (enableAutoSlide) {
            delay(params.autoSlideDelay)
            val nextPage = (pagerState.currentPage + 1)
            if (nextPage >= Int.MAX_VALUE - 1) {
                pagerState.scrollToPage(0)
            } else {
                pagerState.animateScrollToPage(
                    page = nextPage,
                    animationSpec = tween(
                        durationMillis = params.animationDurationMillis,
                        easing = params.animationEasing
                    )
                )
            }
        }
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(params.cornerRadius))
            .background(params.backgroundColor)
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth(),
            pageSpacing = params.pageSpacing,
            state = pagerState,

        ) { page ->
            val realIndex = page % items.size
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .run {
                        if (isClickable) clickable { onClick(items[realIndex].item) }
                        else this
                    },
                model = items[realIndex].imageUrl ?: items[realIndex].imageDrawable,
                contentDescription = "Image $realIndex",
                placeholder = items[realIndex].placeholder?.let { painterResource(it) },
                contentScale = ContentScale.Crop,
            )
        }
        if (isPagerIndicatorVisible) {
            NurPagerIndicator(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(params.dotIndicatorBottomPadding),
                items = items,
                currentIndex = pagerState.currentPage % items.size,
                params = params.pagerDotIndicatorParams
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