package com.design.composechili.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.scale
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.withSave
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.design.composechili.R

data class ChiliShadowParams(
    val radius:Dp,
    val color:Color,
    val shape:Shape,
    val spread:Dp,
    val offset:DpOffset,
    val isAlphaContentClip:Boolean
){
    companion object{
        val Default
        @Composable
        get() = ChiliShadowParams(
            radius = 8.dp,
            color = colorResource(id = R.color.black_alpha_0_08),
            shape = RectangleShape,
            spread = 4.dp,
            offset = DpOffset(
                x = 0.dp,
                y = 3.dp
            ),
            isAlphaContentClip = false
        )
    }
}

@Composable
fun Modifier.softLayerShadow(
    params:ChiliShadowParams = ChiliShadowParams.Default
): Modifier = this then drawWithCache {
    val radiusPx = params.radius.toPx()
    val isRadiusValid = radiusPx > 0.0F
    val paint = Paint().apply {
        this.color = if (isRadiusValid) {
            Color.Transparent
        } else {
            color
        }

        asFrameworkPaint().apply {
            isDither = true
            isAntiAlias = true

            if (isRadiusValid) {
                setShadowLayer(
                    radiusPx,
                    params.offset.x.toPx(),
                    params.offset.y.toPx(),
                    params.color.toArgb()
                )
            }
        }
    }
    val shapeOutline = params.shape.createOutline(
        size = size,
        layoutDirection = LayoutDirection.Rtl,
        density = this
    )
    val shapePath = Path().apply {
        addOutline(outline = shapeOutline)
    }

    val drawShadowBlock: DrawScope.() -> Unit = {
        drawIntoCanvas { canvas ->
            canvas.withSave {
                if (isRadiusValid.not()) {
                    canvas.translate(
                        dx = params.offset.x.toPx(),
                        dy = params.offset.y.toPx()
                    )
                }

                if (params.spread.value != 0.0F) {
                    canvas.scale(
                        sx = spreadScale(
                            spread = params.spread.toPx(),
                            size = size.width
                        ),
                        sy = spreadScale(
                            spread = params.spread.toPx(),
                            size = size.height
                        ),
                        pivotX = center.x,
                        pivotY = center.y
                    )
                }

                canvas.drawOutline(
                    outline = shapeOutline,
                    paint = paint
                )
            }
        }
    }

    onDrawBehind {
        if (params.isAlphaContentClip) {
            clipShadowByPath(
                path = shapePath,
                block = drawShadowBlock
            )
        } else {
            drawShadowBlock()
        }
    }
}

fun DrawScope.clipShadowByPath(
    path: Path,
    block: DrawScope.() -> Unit
) {
    clipPath(
        path = path,
        clipOp = ClipOp.Difference,
        block = block
    )
}

internal fun spreadScale(
    spread: Float,
    size: Float
): Float = 1.0F + ((spread / size) * 2.0F)

