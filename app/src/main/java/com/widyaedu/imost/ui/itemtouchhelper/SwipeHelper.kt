package com.widyaedu.imost.ui.itemtouchhelper

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView

enum class ButtonState {
    GONE,
    LEFT_VISIBLE,
    RIGHT_VISIBLE,
}
class SwipeHelper : Callback() {
    companion object{
        const val buttonWidth: Float = 300.0F
    }
    private var swipeBack: Boolean = false
    private var buttonShowState = ButtonState.GONE
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(0, LEFT or RIGHT)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

    }

    override fun convertToAbsoluteDirection(flags: Int, layoutDirection: Int): Int {
        if (swipeBack){
            swipeBack = false
            return 0
        }
        return super.convertToAbsoluteDirection(flags, layoutDirection)
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        if (actionState == ACTION_STATE_SWIPE){
            setTouchListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setTouchListener(c: Canvas,
                                 recyclerView: RecyclerView,
                                 viewHolder: RecyclerView.ViewHolder,
                                 dX: Float,
                                 dY: Float,
                                 actionState: Int,
                                 isCurrentlyActive: Boolean){
        recyclerView.setOnTouchListener { p0, p1 ->
            swipeBack =
                p1?.action == MotionEvent.ACTION_CANCEL || p1?.action == MotionEvent.ACTION_UP
            if (swipeBack){
                if (dX < -buttonWidth) buttonShowState = ButtonState.RIGHT_VISIBLE
                else if (dX > buttonWidth) buttonShowState = ButtonState.LEFT_VISIBLE

                if (buttonShowState != ButtonState.GONE){
                    setTouchDownListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    setItemClickable(recyclerView, false)
                }
            }
            false
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setTouchDownListener(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        currentlyActive: Boolean
    ) {
        recyclerView.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_DOWN){
                setToucUpListener(c, recyclerView, viewHolder, dX, dY, actionState, currentlyActive)
            }
            false
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setToucUpListener(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        currentlyActive: Boolean
    ) {
        recyclerView.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_UP){
                super@SwipeHelper.onChildDraw(
                    c, recyclerView, viewHolder, dX, dY, actionState, currentlyActive
                )
            }
            false
        }
    }

    private fun setItemClickable(recyclerView: RecyclerView, b: Boolean) {

    }
}