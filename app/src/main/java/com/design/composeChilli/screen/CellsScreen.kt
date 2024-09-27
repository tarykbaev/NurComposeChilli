package com.design.composeChilli.screen

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.cell.baseCell.BaseCell
import com.design.composechili.components.cell.baseCell.BaseCellParams
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.components.cell.model.CellIconSize
import com.design.composechili.components.cell.toggle.ToggleCell
import com.design.composechili.components.cell.toggle.ToggleCellParams
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
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
    }
}

@Composable
fun RegularCellsGroup() {
    Column(
        modifier = Modifier
            .softLayerShadow()
    ) {
        BaseCell(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            title = "Заголовок",
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Top
        )

        BaseCell(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            title = "Заголовок",
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Bottom
        )
    }

    Spacer(modifier = Modifier.size(16.dp))
    Column(
        modifier = Modifier
            .softLayerShadow()
    ) {
        BaseCell(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            title = "Заголовок",
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Top
        )

        BaseCell(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            title = "Заголовок",
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Middle
        )

        BaseCell(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            title = "Заголовок",
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Bottom
        )
    }

    Spacer(modifier = Modifier.size(16.dp))
    Column(
        modifier = Modifier
            .softLayerShadow()
    ) {
        BaseCell(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            title = "Заголовок",
            subtitle = "Подзаголовок",
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Single
        )
    }

    Spacer(modifier = Modifier.size(16.dp))
    Column(
        modifier = Modifier
            .softLayerShadow()
    ) {
        BaseCell(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            title = "Заголовок",
            subtitle = "Подзаголовок",
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Top
        )

        BaseCell(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            title = "Заголовок",
            subtitle = "Подзаголовок",
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Middle
        )

        BaseCell(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            title = "Заголовок",
            subtitle = "Подзаголовок",
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Bottom
        )
    }
}

@Composable
fun SmallIconSizeGroup() {
    Text(
        modifier = Modifier
            .padding(
                horizontal = 16.dp
            ),
        style = ChiliTextStyle.get(
            textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
            color = ChiliTheme.Colors.ChiliPrimaryTextColor
        ),
        text = "BaseCellView iconSize = SMALL (32dp)"
    )

    Spacer(modifier = Modifier.size(8.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            modifier = Modifier,
            title = "Заголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Single
        )
    }

    Spacer(modifier = Modifier.size(16.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            title = "Заголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Top
        )

        BaseCell(
            title = "Заголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Middle
        )

        BaseCell(
            title = "Заголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Bottom
        )
    }

    Spacer(modifier = Modifier.size(16.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            modifier = Modifier,
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Single
        )
    }

    Spacer(modifier = Modifier.size(16.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Top
        )

        BaseCell(
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Middle
        )

        BaseCell(
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Bottom
        )
    }
}

@Composable
fun MediumIconSizeGroup() {
    Text(
        modifier = Modifier
            .padding(
                horizontal = 16.dp
            ),
        style = ChiliTextStyle.get(
            textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
            color = ChiliTheme.Colors.ChiliPrimaryTextColor
        ),
        text = "BaseCellView iconSize = MEDIUM (46dp)"
    )

    Spacer(modifier = Modifier.size(8.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            modifier = Modifier,
            title = "Заголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Single,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
        )
    }

    Spacer(modifier = Modifier.size(16.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            title = "Заголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Top,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
        )

        BaseCell(
            title = "Заголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Middle,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
        )

        BaseCell(
            title = "Заголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Bottom,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
        )
    }

    Spacer(modifier = Modifier.size(16.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            modifier = Modifier,
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Single,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
        )
    }

    Spacer(modifier = Modifier.size(16.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Top,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
        )

        BaseCell(
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Middle,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
        )

        BaseCell(
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Bottom,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
        )
    }
}

@Composable
fun LargeIconSizeGroup() {
    Text(
        modifier = Modifier
            .padding(
                horizontal = 16.dp
            ),
        style = ChiliTextStyle.get(
            textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
            color = ChiliTheme.Colors.ChiliPrimaryTextColor
        ),
        text = "BaseCellView iconSize = LARGE (48dp)"
    )

    Spacer(modifier = Modifier.size(8.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            modifier = Modifier,
            title = "Заголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Single,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
        )
    }

    Spacer(modifier = Modifier.size(16.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            title = "Заголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Top,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
        )

        BaseCell(
            title = "Заголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Middle,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
        )

        BaseCell(
            title = "Заголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Bottom,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
        )
    }

    Spacer(modifier = Modifier.size(16.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            modifier = Modifier,
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Single,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
        )
    }

    Spacer(modifier = Modifier.size(16.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Top,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
        )

        BaseCell(
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            isDividerVisible = true,
            cellCornerMode = CellCornerMode.Middle,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
        )

        BaseCell(
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Bottom,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.LARGE)
        )
    }
}

@Composable
fun CustomIconSizeGroup() {
    Text(
        modifier = Modifier
            .padding(
                horizontal = 16.dp
            ),
        style = ChiliTextStyle.get(
            textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
            color = ChiliTheme.Colors.ChiliPrimaryTextColor
        ),
        text = "BaseCellView iconSize = CUSTOM (72dp)"
    )

    Spacer(modifier = Modifier.size(8.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_cat,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Single,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize(72.dp, 14.dp, 12.dp))
        )

        Spacer(modifier = Modifier.size(8.dp))
        BaseCell(
            title = "Заголовок",
            subtitle = "Подзаголовок",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Single,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize(72.dp, 14.dp, 12.dp))
        )
    }
}

@Composable
fun MaxCharGroup() {
    Text(
        modifier = Modifier
            .padding(
                horizontal = 16.dp
            ),
        style = ChiliTextStyle.get(
            textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
            color = ChiliTheme.Colors.ChiliPrimaryTextColor
        ),
        text = "BaseCell max char"
    )

    Spacer(modifier = Modifier.size(8.dp))

    Column(
        modifier = Modifier
            .softLayerShadow()
            .padding(horizontal = 16.dp)
    ) {
        BaseCell(
            title = "Заголовок максимальное кол-во строк 2, строк строк строк строк строк строк строк строк строк строк строк строк строк строк строк",
            subtitle = "Подзаголовок максимальное кол-во строк 2, строк строк строк строк строк строк строк строк строк строк строк строк строк строк строк",
            startIcon = R.drawable.ic_squircle_phone,
            isChevronVisible = true,
            cellCornerMode = CellCornerMode.Single,
            params = BaseCellParams.Default.copy(iconSize = CellIconSize.MEDIUM)
        )
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
        style = ChiliTextStyle.get(
            textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
            color = ChiliTheme.Colors.ChiliPrimaryTextColor
        ),
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
                toggleCellParams = ToggleCellParams.Default.copy(cornerMode = CellCornerMode.Top),
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
                toggleCellParams = ToggleCellParams.Default.copy(cornerMode = CellCornerMode.Bottom),
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
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

    }
}