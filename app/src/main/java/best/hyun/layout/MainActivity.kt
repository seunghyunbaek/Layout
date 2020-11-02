package best.hyun.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {

    var isShown: Boolean = false

    var constraintSetShow = ConstraintSet()
    var constraintSetHide = ConstraintSet()

    lateinit var layout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keyframe_one)

        layout = findViewById(R.id.layout)

        constraintSetHide.clone(layout)
        constraintSetShow.clone(this, R.layout.keyframe_two)
    }

    fun handleShowDetail(view: View) {
        TransitionManager.beginDelayedTransition(layout)

        if(isShown) {
            // hide details
            constraintSetHide.applyTo(layout)
        } else {
            // how details
            constraintSetShow.applyTo(layout)
        }

        isShown = !isShown
    }
}
