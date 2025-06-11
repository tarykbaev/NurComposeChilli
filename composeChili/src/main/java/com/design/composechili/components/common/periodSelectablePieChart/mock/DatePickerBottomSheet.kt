package com.design.composechili.components.common.periodSelectablePieChart.mock

import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetContent
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetParams
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.common.periodSelectablePieChart.PeriodType
import com.design.composechili.components.common.periodSelectablePieChart.model.DetalizationUiState
import com.design.composechili.components.common.pieChart.model.OModels.DetalizationInfo
import com.design.composechili.utils.DATE_PATTERN
import com.design.composechili.utils.formatByRegex
import com.design.composechili.utils.getFirstDayOfMonth
import com.design.composechili.utils.getFirstDayOfWeek
import com.design.composechili.utils.getLastDayOfMonthNotInFuture
import com.design.composechili.utils.getLastDayOfWeekNotInFuture
import com.design.composechili.utils.hide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerBottomSheet(
    coScope: CoroutineScope,
    sheetState: BottomSheetScaffoldState,
    onStateChange: (DetalizationUiState) -> Unit
) {
    ActionBottomSheetContent(
        buttons = listOf(
            ActionBottomSheetParams(
                title = "Today",
                buttonStyle = ChiliButtonStyle.Primary
            ) {
                coScope.launch {
                    sheetState.hide()
                    //todo will be implemented vm logic to get info from server
                    onStateChange(
                        DetalizationUiState().copy(
                            detalizationInfo = DetalizationInfo(
                                totalAmount = 0.0,
                                category = emptyList()
                            ),
                            dateRange = Pair(
                                LocalDateTime.now().formatByRegex(DATE_PATTERN),
                                LocalDateTime.now().formatByRegex(DATE_PATTERN),
                            ),
                            periodType = PeriodType.DAY
                        )
                    )
                }
            },
            ActionBottomSheetParams(
                title = "One week",
                buttonStyle = ChiliButtonStyle.Primary
            ) {
                coScope.launch {
                    sheetState.hide()
                    onStateChange(
                        DetalizationUiState().copy(
                            detalizationInfo = DetalizationInfo(
                                totalAmount = 450.44,
                                category = DetalizationUiState().detalizationInfo.category?.takeLast(5)
                            ),
                            dateRange = Pair(
                                LocalDate.now().getFirstDayOfWeek(),
                                LocalDate.now().getLastDayOfWeekNotInFuture()
                            ),
                            periodType = PeriodType.WEEK
                        )
                    )
                }
            },
            ActionBottomSheetParams(
                title = "One Month",
                buttonStyle = ChiliButtonStyle.Primary
            ) {
                coScope.launch {
                    sheetState.hide()
                    onStateChange(
                        DetalizationUiState().copy(
                            detalizationInfo = DetalizationInfo(
                                totalAmount = 450.0,
                                category = DetalizationUiState().detalizationInfo.category?.take(5)
                            ),
                            dateRange = Pair(
                                LocalDateTime.now().getFirstDayOfMonth(),
                                LocalDateTime.now().getLastDayOfMonthNotInFuture(),
                            ),
                            periodType = PeriodType.MONTH
                        )
                    )
                }
            },
            ActionBottomSheetParams(
                title = "Choose period manually",
                buttonStyle = ChiliButtonStyle.Primary
            ) {
                coScope.launch {
                    sheetState.hide()
                    onStateChange(DetalizationUiState().copy(showDatePicker = true))
                }
            },
        )
    )
}