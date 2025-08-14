package com.design.composeNur.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.cell.NurAdditionalDoubleButtons
import com.design.composeNur.components.cell.actionCell.NurActionCell
import com.design.composeNur.components.cell.actionCell.NurActionCellParams
import com.design.composeNur.components.cell.additionalText.AdditionalTextCell
import com.design.composeNur.components.cell.additionalText.AdditionalTextCellParams
import com.design.composeNur.components.cell.baseCell.NurBaseCell
import com.design.composeNur.components.cell.baseCell.NurBaseCellParams
import com.design.composeNur.components.cell.endIconCell.NurEndIconCell
import com.design.composeNur.components.cell.expandableCell.ExpandableCell
import com.design.composeNur.components.cell.model.CellCornerMode
import com.design.composeNur.components.cell.model.CellIconSize
import com.design.composeNur.components.cell.toggle.ToggleCell
import com.design.composeNur.components.common.switch.NurSwitch
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder
import com.design.composeNur.utils.showToast
import com.design.composeNur.utils.softLayerShadow
import com.design.composenur.R

@Composable
fun CellsScreen() {

    val scrollState = rememberScrollState()
    var isShimmering by remember { mutableStateOf(false) }

    Column(
        Modifier
            .background(NurTheme.Colors.NurSurfaceBackground)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.size(32.dp))
        NurSwitch(
            description = "Shimmer effect",
            checkedState = isShimmering,
        ) { isShimmering = it }
        Spacer(modifier = Modifier.size(32.dp))
        RegularCellsGroup(isShimmering)
        Spacer(modifier = Modifier.size(32.dp))
        SmallIconSizeGroup(isShimmering)
        Spacer(modifier = Modifier.size(32.dp))
        MediumIconSizeGroup(isShimmering)
        Spacer(modifier = Modifier.size(32.dp))
        LargeIconSizeGroup(isShimmering)
        Spacer(modifier = Modifier.size(32.dp))
        CustomIconSizeGroup(isShimmering)
        Spacer(modifier = Modifier.size(32.dp))
        MaxCharGroup(isShimmering)
        Spacer(modifier = Modifier.size(32.dp))
        ToggleCellGroup()
        Spacer(modifier = Modifier.size(32.dp))
        AdditionalTextCellGroup()
        Spacer(modifier = Modifier.size(32.dp))
        ExpandableCellGroup()
        Spacer(modifier = Modifier.size(32.dp))
        AdditionalDoubleButtonsGroup()
        Spacer(modifier = Modifier.size(32.dp))
        NurEndIconCellGroup()
        Spacer(modifier = Modifier.size(32.dp))
        NurActionCellGroup()

        Spacer(modifier = Modifier.size(32.dp))
    }
}

@Composable
fun NurActionCellGroup() {
    Column(
        modifier = Modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            style = NurTextStyleBuilder.H8.Primary.Default,
            text = "ActionCellView разные состояния"
        )
        NurActionCell(
            modifier = Modifier.softLayerShadow(),
            title = "Заголовок",
            actionTitle = "Action"
        )
        NurActionCell(
            modifier = Modifier.softLayerShadow(),
            title = "Заголовок",
            actionTitle = "Action no chevron"
        )
        NurActionCell(
            modifier = Modifier.softLayerShadow(),
            title = "Заголовок",
            actionTitle = "Action icon",
            isChevronVisible = true,
            startIcon = painterResource(R.drawable.ic_cat),
            params = NurActionCellParams.Default.copy(startIconSize = CellIconSize.MEDIUM),
        )
        Column(Modifier.softLayerShadow()) {
            NurActionCell(title = "Simple", actionTitle = "Value", cellCornerMode = CellCornerMode.Top)
            NurActionCell(title = "Simple", actionTitle = "Value", cellCornerMode = CellCornerMode.Middle)
            NurActionCell(title = "Simple", actionTitle = "Value", cellCornerMode = CellCornerMode.Bottom, isActionEnabled = false)
        }

    }
}

@Composable
fun NurEndIconCellGroup() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            style = NurTextStyleBuilder.H8.Primary.Default,
            text = "NurEndIconCell iconSize = SMALL (32dp)"
        )
        NurEndIconCell(
            modifier = Modifier.softLayerShadow(),
            title = "NurEndIconCell Title",
            subtitle = "NurEndIconCell Subtitle",
            startIcon = painterResource(R.drawable.ic_squircle_phone),
            endIcon = painterResource(R.drawable.ic_cat),
            onStartIconClick = { context.showToast("onStartIconClicked") },
            onEndIconClick = { context.showToast("onEndIconClicked") },
            onClick = { context.showToast("onClicked") },
        )
    }
}

@Composable
fun RegularCellsGroup(isShimmering: Boolean = false) {

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
            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                isChevronVisible = true,
                isDividerVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Top
            )

            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                isChevronVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Bottom
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                isChevronVisible = true,
                isDividerVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Top
            )

            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                isChevronVisible = true,
                isDividerVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Middle
            )

            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                isChevronVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Bottom
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                isChevronVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Single
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                isChevronVisible = true,
                isDividerVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Top
            )

            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                isChevronVisible = true,
                isDividerVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Middle
            )

            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                isChevronVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Bottom
            )
        }
    }
}

@Composable
fun SmallIconSizeGroup(isShimmering: Boolean = false) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            style = NurTextStyleBuilder.H8.Primary.Default,
            text = "BaseCellView iconSize = SMALL (32dp)"
        )

        Spacer(modifier = Modifier.size(8.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Single
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Top
            )

            NurBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Middle
            )

            NurBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Bottom
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Single
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Top
            )

            NurBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Middle
            )

            NurBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isShimmering = isShimmering,
                cellCornerMode = CellCornerMode.Bottom
            )
        }
    }
}

@Composable
fun MediumIconSizeGroup(isShimmering: Boolean = false) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            style = NurTextStyleBuilder.H8.Primary.Default,
            text = "BaseCellView iconSize = MEDIUM (46dp)"
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )

            NurBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )

            NurBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )

            NurBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )

            NurBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
            )
        }
    }
}

@Composable
fun LargeIconSizeGroup(isShimmering: Boolean = false) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.size(8.dp))

        Text(
            style = NurTextStyleBuilder.H8.Primary.Default,
            text = "BaseCellView iconSize = LARGE (48dp)"
        )

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )

            NurBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )

            NurBaseCell(
                title = "Заголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                modifier = Modifier,
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Top,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )

            NurBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                isDividerVisible = true,
                cellCornerMode = CellCornerMode.Middle,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )

            NurBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Bottom,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
            )
        }
    }
}

@Composable
fun CustomIconSizeGroup(isShimmering: Boolean = false) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {

        Text(
            style = NurTextStyleBuilder.H8.Primary.Default,
            text = "BaseCellView iconSize = CUSTOM (72dp)"
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_cat),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize(72.dp, 14.dp, 12.dp))
            )

            Spacer(modifier = Modifier.size(8.dp))

            NurBaseCell(
                title = "Заголовок",
                subtitle = "Подзаголовок",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize(72.dp, 14.dp, 12.dp))
            )
        }
    }
}

@Composable
fun MaxCharGroup(isShimmering: Boolean = false) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            style = NurTextStyleBuilder.H8.Primary.Default,
            text = "BaseCell max char"
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurBaseCell(
                title = "Заголовок максимальное кол-во строк 2, строк строк строк строк строк строк строк строк строк строк строк строк строк строк строк",
                subtitle = "Подзаголовок максимальное кол-во строк 2, строк строк строк строк строк строк строк строк строк строк строк строк строк строк строк",
                startIcon = painterResource(R.drawable.ic_squircle_phone),
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
                isShimmering = isShimmering,
                params = NurBaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
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
        style = NurTextStyleBuilder.H8.Primary.Default,
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
            style = NurTextStyleBuilder.H8.Primary.Default,
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
                startIcon = R.drawable.nur_ic_airpods,
                cellCornerMode = CellCornerMode.Single,
                params = AdditionalTextCellParams.Default.copy(
                    nurBaseCellParams = NurBaseCellParams.Default.copy(
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
            style = NurTextStyleBuilder.H8.Primary.Default,
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
            style = NurTextStyleBuilder.H8.Primary.Default,
            text = "Additional double Buttons "
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .softLayerShadow()
        ) {
            NurAdditionalDoubleButtons(
                title = "Заголовок",
                positiveTitle = "ОПЛАТИТЬ",
                negativeTitle = "ОТМЕНИТЬ"
            )
        }
    }
}