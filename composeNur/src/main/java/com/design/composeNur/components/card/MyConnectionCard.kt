package com.design.composeNur.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.common.AnimatedProgressLine
import com.design.composeNur.components.shimmer.ShimmerOrContent
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H7
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H8
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H9
import com.design.composenur.R

// TODO: Transfer to MyO project for better usability
@Composable
fun MyConnectionCard(
    modifier: Modifier = Modifier,
    title: String = "Моя связь",
    alienTitle: String = "Стать абонентом О!",
    alienSubtitle: String = "Просто, выгодно, удобно.\nА также бонусы за общение.",
    alienImage: Painter = painterResource(R.drawable.test_image),
    isWithPackages: Boolean,
    isOSubscriber: Boolean = true,
    isShimmering: Boolean = false
) {

    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(20.dp)
            )
            .background(NurTheme.Colors.NurCardViewBackground)
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .padding(
                    top = dimensionResource(R.dimen.padding_10dp),
                    end = dimensionResource(R.dimen.padding_12dp)
                )
                .align(Alignment.TopEnd),
            painter = painterResource(R.drawable.nur_ic_chevron_right_24dp),
            contentDescription = "Chevron Icon",
        )
        if (isOSubscriber || isShimmering) {
            MyConnectionSubscriberCard(
                title = title,
                isWithPackages = isWithPackages,
                isShimmering = isShimmering
            )
        } else {
            MyConnectionAlienCard(alienTitle, alienSubtitle, alienImage)
        }
    }
}

@Composable
private fun RowScope.MyConnectionCardPackages(
    isWithPackages: Boolean,
    isShimmering: Boolean
) {
    if (isWithPackages || isShimmering) {
        MyConnectionCardLeftover(
            remainText = "10 Gb",
            limitText = "from 100 Gb",
            progressPercent = 20,
            progressColor = colorResource(R.color.green_1)
        )
        MyConnectionCardLeftover(
            remainText = "10 мин",
            limitText = "from 100 мин",
            progressPercent = 80,
            progressColor = colorResource(R.color.blue_1)
        )
    } else {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "Ваш тариф: Оной+",
                style = H8.Marked.Medium
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.view_8dp)))
            Text(
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.view_2dp)),
                text = "Тарификация поминутная",
                style = H9.Value.Medium
            )
        }
    }
}

@Composable
private fun RowScope.MyConnectionCardLeftover(
    remainText: String,
    limitText: String,
    progressPercent: Int,
    isShimmering: Boolean = false,
    isInfinitePackage: Boolean = false,
    progressColor: Color = colorResource(R.color.green_1),
) {
    Column(
        modifier = Modifier.weight(1f),
    ) {
        ShimmerOrContent(
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_10dp)),
            isShimmering = isShimmering,
            shimmerWidth = dimensionResource(R.dimen.view_60dp)
        ) {
            Row {
                if (isInfinitePackage) {
                    Image(
                        modifier = Modifier
                            .heightIn(max = dimensionResource(R.dimen.view_16dp)),
                        painter = painterResource(R.drawable.nur_ic_invisible),
                        contentDescription = "Infinite Icon",
                    )
                } else {
                    Text(
                        text = remainText,
                        style = H8.Marked.Medium
                    )
                }
            }
        }
        ShimmerOrContent(
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_12dp)),
            isShimmering = isShimmering,
            shimmerWidth = dimensionResource(R.dimen.view_82dp),
        ) {
            Text(
                text = limitText,
                style = H9.Value.Medium
            )
        }
        if (!isShimmering) {
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.view_4dp)))
            AnimatedProgressLine(
                progressPercent = progressPercent,
                backgroundHeight = dimensionResource(R.dimen.view_4dp),
                trackHeight = dimensionResource(R.dimen.view_6dp),
                progressColor = progressColor
            )
        }
    }
}

@Composable
private fun MyConnectionAlienCard(
    alienTitle: String,
    alienSubtitle: String,
    alienImage: Painter
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterStart)
                .padding(dimensionResource(R.dimen.padding_12dp))
        ) {
            Text(
                text = alienTitle,
                style = H7.Marked.Bold
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.view_10dp)))
            Text(
                text = alienSubtitle,
                style = H9.Secondary.Regular
            )
        }
        Image(
            modifier = Modifier
                .width(dimensionResource(R.dimen.view_96dp))
                .height(dimensionResource(R.dimen.view_76dp))
                .align(Alignment.BottomEnd)
                .padding(
                    end = dimensionResource(R.dimen.padding_32dp),
                    top = dimensionResource(R.dimen.padding_18dp)
                ),
            painter = alienImage,
            contentDescription = "Alien Card Image",
        )
    }
}

@Composable
private fun MyConnectionSubscriberCard(
    title: String = "MyConnection",
    isWithPackages: Boolean = true,
    isShimmering: Boolean = false
) {
    Column(
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_12dp))
    ) {
        ShimmerOrContent(
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_6dp)),
            isShimmering = isShimmering,
            shimmerWidth = dimensionResource(R.dimen.view_82dp)
        ) {
            Text(
                text = title,
                style = H7.Primary.Bold
            )
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.view_8dp)))
        Row {
            Row(
                modifier = Modifier.weight(1f)
                    .height(IntrinsicSize.Min)
            ) {
                Column(
                    modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_16dp))
                ) {
                    ShimmerOrContent(
                        modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_10dp)),
                        isShimmering = isShimmering,
                        shimmerWidth = dimensionResource(R.dimen.view_60dp)
                    ) {
                        Text(
                            text = "Баланс номера",
                            style = H9.Value.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.view_8dp)))
                    ShimmerOrContent(
                        modifier = Modifier.padding(
                            top = dimensionResource(R.dimen.padding_4dp),
                            bottom = dimensionResource(R.dimen.padding_8dp)
                        ),
                        isShimmering = isShimmering,
                        shimmerWidth = dimensionResource(R.dimen.view_82dp)
                    ) {
                        Text(
                            text = "100 c",
                            style = H8.Marked.Medium
                        )
                    }
                }
                VerticalDivider(
                    color = NurTheme.Colors.NurDividerColor,
                    thickness = NurTheme.Attribute.NurDividerHeightSize
                )
            }
            Row(
                modifier = Modifier.weight(2f),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_16dp))
            ) {
                MyConnectionCardPackages(isWithPackages, isShimmering)
            }
        }
    }
}

@Preview
@Composable
fun MyConnectionCardPreview() {
    NurTheme {
        Column {
            MyConnectionCard(
                modifier = Modifier,
                isWithPackages = true,
                isShimmering = false
            )
            Spacer(modifier = Modifier.height(16.dp))
            MyConnectionCard(
                modifier = Modifier,
                isWithPackages = false,
                isShimmering = false
            )
            Spacer(modifier = Modifier.height(16.dp))
            MyConnectionCard(
                modifier = Modifier,
                isWithPackages = false,
                isOSubscriber = false,
            )
        }
    }
}