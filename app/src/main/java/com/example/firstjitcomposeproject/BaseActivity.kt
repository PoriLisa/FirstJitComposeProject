package com.example.firstjitcomposeproject
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle


abstract class BaseActivity : AppCompatActivity() {

    @Composable
    fun appBar(title: String) {
       /* FlexColumn {
           *//* inflexible {
                TopAppBar(title = {
                    Center {
                        // add text in center
                        Text(
                            text = title,
                            style = TextStyle(color = Color.White)
                        )
                    }
                })
            }
            setupView()
        }*/
    }

    abstract fun FlexColumn(function: () -> Unit)


    /**
     * @author https://developer.android.com/reference/kotlin/androidx/ui/layout/package-summary.html#FlexColumn(androidx.ui.core.Modifier,%20androidx.ui.layout.MainAxisAlignment,%20androidx.ui.layout.LayoutSize,%20androidx.ui.layout.CrossAxisAlignment,%20androidx.ui.layout.LayoutSize,%20kotlin.Function1)
    inflexible -> meaning that the child is not flex, and it should be measured with loose constraints to determine its preferred height
    expanded   ->meaning that the child is flexible, and it should be assigned a height according to its flex weight relative to its flexible children. The child is forced to occupy the entire height assigned by the parent
    flexible   ->similar to expanded, but the child can leave unoccupied height.
     */
    @Composable
    abstract fun setupView()

}