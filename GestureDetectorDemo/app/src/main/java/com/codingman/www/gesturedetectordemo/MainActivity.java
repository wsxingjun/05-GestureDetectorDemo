package com.codingman.www.gesturedetectordemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener
{

    private GestureDetector mGestureDetector;

    private GestureDetectorDemo gestureDetectorDemo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mGestureDetector =new GestureDetector(new GestureDetectorDemo(getApplicationContext()));
        mGestureDetector =new GestureDetector(
                new GestureDetectorSimpleOnGestureListenerDemo());

        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setOnTouchListener(this);
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);

    }

    /*
    * 在onTouch()方法中，调用GestureDetector的onTouchEvent()方法，
    * 将捕捉到的MotionEvent交给GestureDetector
    * 来分析是否有合适的callback函数来处理用户的手势
    */

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }



    private class GestureDetectorSimpleOnGestureListenerDemo extends GestureDetector.SimpleOnGestureListener{



        final int FLING_MIN_DISTANCE = 100;
        final int FLING_MIN_VELOCITY = 200;


        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d("kk","onSingleTapUp");
            Toast.makeText(getApplicationContext(),"onSingleTapUp",Toast.LENGTH_SHORT).show();
            return super.onSingleTapUp(e);

        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.d("kk","onLongPress");
            Toast.makeText(getApplicationContext(),"onLongPress",Toast.LENGTH_SHORT).show();
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            Log.d("kk","onScroll"+distanceX+":"+distanceY);
            Toast.makeText(getApplicationContext(),"onScroll",Toast.LENGTH_SHORT).show();
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        /**
         * // 参数解释：
          // e1：第1个ACTION_DOWN MotionEvent
          // e2：最后一个ACTION_MOVE MotionEvent
          // velocityX：X轴上的移动速度，像素/秒
          // velocityY：Y轴上的移动速度，像素/秒
         * @param e1
         * @param e2
         * @param velocityX
         * @param velocityY
         * @return
         */
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//            Log.d("kk","onFling"+velocityX+":"+velocityY);
            Toast.makeText(getApplicationContext(),"onFling",Toast.LENGTH_SHORT).show();

            if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY){
                Log.d("kk","左左左");
                Toast.makeText(getApplicationContext(),"左左左",Toast.LENGTH_SHORT).show();
            }

            if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY){
                Log.d("kk","右右右");
                Toast.makeText(getApplicationContext(),"右右右",Toast.LENGTH_SHORT).show();
            }

            if (e1.getY() - e2.getY() > FLING_MIN_DISTANCE && Math.abs(velocityY) > FLING_MIN_VELOCITY){
                Log.d("kk","上上上");
                Toast.makeText(getApplicationContext(),"上上上",Toast.LENGTH_SHORT).show();
            }

            if (e2.getY() - e1.getY() > FLING_MIN_DISTANCE && Math.abs(velocityY) > FLING_MIN_VELOCITY){
                Log.d("kk","下下下");
                Toast.makeText(getApplicationContext(),"下下下",Toast.LENGTH_SHORT).show();
            }


            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.d("kk","onShowPress");
            Toast.makeText(getApplicationContext(),"onShowPress",Toast.LENGTH_SHORT).show();
            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d("kk","onDown");
            Toast.makeText(getApplicationContext(),"onDown",Toast.LENGTH_SHORT).show();
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d("kk","onDoubleTap");
            Toast.makeText(getApplicationContext(),"onDoubleTap",Toast.LENGTH_SHORT).show();
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d("kk","onDoubleTapEvent");
            Toast.makeText(getApplicationContext(),"onDoubleTapEvent",Toast.LENGTH_SHORT).show();
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.d("kk","onSingleTapConfirmed");
            Toast.makeText(getApplicationContext(),"onSingleTapConfirmed",Toast.LENGTH_SHORT).show();
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onContextClick(MotionEvent e) {
            Log.d("kk","onContextClick");
            Toast.makeText(getApplicationContext(),"onContextClick",Toast.LENGTH_SHORT).show();
            return super.onContextClick(e);
        }
    }










}
