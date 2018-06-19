package com.codingman.www.gesturedetectordemo;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * @function
 */

public class GestureDetectorDemo implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    private Context mContext ;

    public GestureDetectorDemo(Context context) {
        mContext = context;
    }

    // 用户轻触触摸屏，由1个MotionEvent ACTION_DOWN触发
    @Override
    public boolean onDown(MotionEvent e) {
        Log.i("MyGesture", "onDown");
        Toast.makeText(mContext, "onDown", Toast.LENGTH_SHORT).show();
        return false;
    }

    /*
    * 用户轻触触摸屏，尚未松开或拖动，由一个1个MotionEvent ACTION_DOWN触发
    * 注意和onDown()的区别，强调的是没有松开或者拖动的状态
    *
    * 而onDown也是由一个MotionEventACTION_DOWN触发的，但是他没有任何限制，
    * 也就是说当用户点击的时候，首先MotionEventACTION_DOWN，onDown就会执行，
    * 如果在按下的瞬间没有松开或者是拖动的时候onShowPress就会执行，如果是按下的时间超过瞬间
    * （这块我也不太清楚瞬间的时间差是多少，一般情况下都会执行onShowPress），拖动了，就不执行onShowPress。
    */
    @Override
    public void onShowPress(MotionEvent e) {
        Log.i("MyGesture", "onShowPress");
        Toast.makeText(mContext, "onShowPress", Toast.LENGTH_SHORT).show();
    }

    // 用户（轻触触摸屏后）松开，由一个1个MotionEvent ACTION_UP触发
//轻击一下屏幕，立刻抬起来，才会有这个触发
//从名字也可以看出,一次单独的轻击抬起操作,当然,如果除了Down以外还有其它操作,
// 那就不再算是Single操作了,所以这个事件 就不再响应
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i("MyGesture", "onSingleTapUp");
        Toast.makeText(mContext, "onSingleTapUp", Toast.LENGTH_SHORT).show();
        return false;
    }

    // 用户按下触摸屏，并拖动，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE触发
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i("MyGesture", "onScroll");
        Toast.makeText(mContext, "onScroll", Toast.LENGTH_SHORT).show();
        return false;
    }

    // 用户长按触摸屏，由多个MotionEvent ACTION_DOWN触发
    @Override
    public void onLongPress(MotionEvent e) {
        Log.i("MyGesture", "onLongPress");
        Toast.makeText(mContext, "onLongPress", Toast.LENGTH_SHORT).show();

    }

    // 用户按下触摸屏、快速移动后松开，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个ACTION_UP触发
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i("MyGesture", "onFling");
        Toast.makeText(mContext, "onFling", Toast.LENGTH_SHORT).show();
        return false;
    }


    /**
     * 单击事件。用来判定该次点击是SingleTap而不是DoubleTap，如果连续点击两次就是DoubleTap手势，如果只点击一次，
     * 系统等待一段时间后没有收到第二次点击则判定该次点击为SingleTap而不是DoubleTap，然后触发SingleTapConfirmed事件。
       触发顺序是：OnDown->OnsingleTapUp->OnsingleTapConfirmed
       关于onSingleTapConfirmed和onSingleTapUp的一点区别： OnGestureListener有这样的一个方法onSingleTapUp，
       和onSingleTapConfirmed容易混淆。
       二者的区别是：onSingleTapUp，只要手抬起就会执行，而对于onSingleTapConfirmed来说，如果双击的话，则onSingleTapConfirmed不会执行。
     * @param e
     * @return
     */
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.i("MyGesture", "onSingleTapConfirmed");
        Toast.makeText(mContext, "onSingleTapConfirmed", Toast.LENGTH_SHORT).show();
        return false;
    }

//    双击事件
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.i("MyGesture", "onDoubleTap");
        Toast.makeText(mContext, "onDoubleTap", Toast.LENGTH_SHORT).show();
        return false;
    }

//    双击间隔中发生的动作。指触发onDoubleTap以后，在双击之间发生的其它动作，包含down、up和move事件；
    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.i("MyGesture", "onDoubleTapEvent");
        Toast.makeText(mContext, "onDoubleTapEvent", Toast.LENGTH_SHORT).show();
        return false;
    }
}
