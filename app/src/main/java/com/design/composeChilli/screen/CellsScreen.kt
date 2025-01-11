package com.design.composeChilli.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.cell.AdditionalDoubleButtons
import com.design.composechili.components.cell.additionalText.AdditionalTextCell
import com.design.composechili.components.cell.additionalText.AdditionalTextCellParams
import com.design.composechili.components.cell.baseCell.NurChiliBaseCell
import com.design.composechili.components.cell.baseCell.BaseCellParams
import com.design.composechili.components.cell.expandableCell.ExpandableCell
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.components.cell.model.CellIconSize
import com.design.composechili.components.cell.toggle.ToggleCell
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder
import com.design.composechili.utils.softLayerShadow

@Composable
fun CellsScreen() {

    val scrollState = rememberScrollState()

    Column(
        Modifier
            .background(ChiliTheme.Colors.ChiliSurfaceBackground)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.size(32.dp))
        RegularCellsGroup()
        Spacer(modifier = Modifier.size(32.dp))
        SmallIconSizeGroup()
        Spacer(modifier = Modifier.size(32.dp))
        MediumIconSizeGroup()
        Spacer(modifier = Modifier.size(32.dp))
        LargeIconSizeGroup()
        Spacer(modifier = Modifier.size(32.dp))
        CustomIconSizeGroup()
        Spacer(modifier = Modifier.size(32.dp))
        MaxCharGroup()
        Spacer(modifier = Modifier.size(32.dp))
        ToggleCellGroup()
        Spacer(modifier = Modifier.size(32.dp))
        AdditionalTextCellGroup()
        Spacer(modifier = Modifier.size(32.dp))
        ExpandableCellGroup()
        Spacer(modifier = Modifier.size(32.dp))
        AdditionalDoubleButtonsGroup()

        Spacer(modifier = Modifier.size(32.dp))
    }
}

@Composable
fun RegularCellsGroup() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top
            )

            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top
            )

            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle
            )

            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top
            )

            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle
            )

            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom
            )
        }
    }
}

@Composable
fun SmallIconSizeGroup() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            style = ChiliTextStyleBuilder.H8.Primary.Default,
            text = "BaseCellView iconSize = SMALL (32dp)"
        )

        Spacer(modifier = Modifier.size(8.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top
            )

            NurChiliBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle
            )

            NurChiliBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top
            )

            NurChiliBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle
            )

            NurChiliBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom
            )
        }
    }
}

@Composable
fun MediumIconSizeGroup() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            style = ChiliTextStyleBuilder.H8.Primary.Default,
            text = "BaseCellView iconSize = MEDIUM (46dp)"
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )

            NurChiliBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )

            NurChiliBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )

            NurChiliBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )

            NurChiliBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )
        }
    }
}

@Composable
fun LargeIconSizeGroup() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.size(8.dp))

        Text(
            style = ChiliTextStyleBuilder.H8.Primary.Default,
            text = "BaseCellView iconSize = LARGE (48dp)"
        )

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )

            NurChiliBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )

            NurChiliBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )

            NurChiliBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )

            NurChiliBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )
        }
    }
}

@Composable
fun CustomIconSizeGroup() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {

        Text(
            style = ChiliTextStyleBuilder.H8.Primary.Default,
            text = "BaseCellView iconSize = CUSTOM (72dp)"
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_cat),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize(72.dp, 14.dp, 12.dp))
            )

            Spacer(modifier = Modifier.size(8.dp))

            NurChiliBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize(72.dp, 14.dp, 12.dp))
            )
        }
    }
}

@Composable
fun MaxCharGroup() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            style = ChiliTextStyleBuilder.H8.Primary.Default,
            text = "BaseCell max char"
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurChiliBaseCell(
                title = "Заголовок максимальное кол-во строк 2, строк строк строк строк строк строк строк строк строк строк строк строк строк строк строк",
                subtitle = "Подзаголовок максимальное кол-во строк 2, строк строк строк строк строк строк строк строк строк строк строк строк строк строк строк",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )
        }
    }
}

@Composable
fun ToggleCellGroup() {
    val isCheckedState = remember { mutableStateOf(false) }
    val isCheckedSwitchTextState = remember { mutableStateOf(false) }
    val isCheckedSwitchOnOffTextState = remember { mutableStateOf(false) }
    val isCheckedSubTitleState = remember { mutableStateOf(false) }
    val isCheckedSubTitleWithIconState = remember { mutableStateOf(false) }

    Text(
        modifier = Modifier
            .padding(
                horizontal = 16.dp
            ),
        style = ChiliTextStyleBuilder.H8.Primary.Default,
        text = "ToggleCells"
    )

    Spacer(modifier = Modifier.size(8.dp))

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        ToggleCell(
            modifier = Modifier.softLayerShadow(),
            title = "Заголовок",
            isChecked = isCheckedState.value,
            isSwitchEnabled = true,
            onCheckedChangeListener = {
                isCheckedState.value = it
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        ToggleCell(
            modifier = Modifier.softLayerShadow(),
            title = "Заголовок",
            isChecked = isCheckedSwitchTextState.value,
            isSwitchEnabled = true,
            switchText = "on/off",
            onCheckedChangeListener = {
                isCheckedSwitchTextState.value = it
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        ToggleCell(
            modifier = Modifier.softLayerShadow(),
            title = "Заголовок",
            isChecked = isCheckedSwitchOnOffTextState.value,
            isSwitchEnabled = true,
            switchTextOn = "on",
            switchTextOff = "off",
            onCheckedChangeListener = {
                isCheckedSwitchOnOffTextState.value = it
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        ToggleCell(
            modifier = Modifier.softLayerShadow(),
            title = "Заголовок",
            subtitle = "Подзаголовок",
            isChecked = isCheckedSubTitleState.value,
            isSwitchEnabled = true,
            onCheckedChangeListener = {
                isCheckedSubTitleState.value = it
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            ToggleCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                isChecked = isCheckedSubTitleWithIconState.value,
                isSwitchEnabled = true,
                isDividerVisible = true,
                startIcon = R.drawable.ic_cat,
                cellCornerMode = CellCornerMode.Top,
                onCheckedChangeListener = {
                    isCheckedSubTitleWithIconState.value = it
                }
            )

            ToggleCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                isChecked = isCheckedSubTitleWithIconState.value,
                isSwitchEnabled = true,
                startIcon = R.drawable.ic_cat,
                cellCornerMode = CellCornerMode.Bottom,
                onCheckedChangeListener = {
                    isCheckedSubTitleWithIconState.value = it
                }
            )
        }
    }
}

@Composable
fun AdditionalTextCellGroup() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                ),
            style = ChiliTextStyleBuilder.H8.Primary.Default,
            text = "AdditionalTextCell"
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            AdditionalTextCell(
                title = "Заголовок",
                additionalTitle = "Additional Additional Additional Additional Additional ",
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
            )

            Spacer(modifier = Modifier.size(8.dp))

            AdditionalTextCell(
                title = "Заголовок",
                additionalTitle = "Additional text no chevron",
                cellCornerMode = CellCornerMode.Single,
            )

            Spacer(modifier = Modifier.size(8.dp))

            AdditionalTextCell(
                title = "Заголовок",
                additionalTitle = "Additional icon",
                isChevronVisible = true,
                startIcon = R.drawable.chili_ic_airpods,
                cellCornerMode = CellCornerMode.Single,
                params = AdditionalTextCellParams.Default.copy(
                    baseCellParams = BaseCellParams.Default.copy(
                        iconSize = CellIconSize.MEDIUM
                    )
                )
            )

            Spacer(modifier = Modifier.size(8.dp))

            AdditionalTextCell(
                title = "Simple",
                additionalTitle = "Value",
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top,
            )

            AdditionalTextCell(
                title = "Simple",
                additionalTitle = "Value",
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle,
            )

            AdditionalTextCell(
                title = "Simple",
                additionalTitle = "Value",
                cellCornerMode = CellCornerMode.Bottom,
            )

            Spacer(modifier = Modifier.size(8.dp))

            AdditionalTextCell(
                title = "Simple",
                subtitle = "1447",
                additionalTitle = "Value",
                additionalSubTitle = "1337",
                startIcon = R.drawable.ic_bonus_new,
                cellCornerMode = CellCornerMode.Single
            )
        }
    }
}

@Composable
fun ExpandableCellGroup() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                ),
            style = ChiliTextStyleBuilder.H8.Primary.Default,
            text = "ExpandableCell"
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            ExpandableCell(
                title = "Welcome to the club Buddy",
                description = "Android Studio: Crashes when you run the app Android Studio: Crashes when you run the app Android Studio: Crashes when you run the app"
            )

            Spacer(modifier = Modifier.size(8.dp))

            ExpandableCell(
                title = "Welcome to the club Buddy",
                description = "Android Studio: Crashes when you run the app Android Studio: Crashes when you run the app Android Studio: Crashes when you run the app"
            )

            Spacer(modifier = Modifier.size(8.dp))

            ExpandableCell(
                title = "Welcome to the club Buddy",
                description = "Android Studio: Crashes when you run the app Android Studio: Crashes when you run the app Android Studio: Crashes when you run the app"
            )

            Spacer(modifier = Modifier.size(8.dp))

            ExpandableCell(
                title = "Welcome to the club Buddy",
                description = "Android Studio: Crashes when you run the app Android Studio: Crashes when you run the app Android Studio: Crashes when you run the app"
            )
        }
    }
}

@Composable
fun AdditionalDoubleButtonsGroup() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                ),
            style = ChiliTextStyleBuilder.H8.Primary.Default,
            text = "Additional double Buttons "
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            AdditionalDoubleButtons(
                title = "Заголовок",
                positiveTitle = "ОПЛАТИТЬ",
                negativeTitle = "ОТМЕНИТЬ"
            )
        }
    }
}