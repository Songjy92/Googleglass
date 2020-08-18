package com.example.glassphoto;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import com.example.glass.ui.GlassGestureDetector;

/**
 * Base activity for all activities in application for Glass. It hides the UI, making application
 * full screen and sets {@link GlassGestureDetector}.
 */
public abstract class BaseActivity extends AppCompatActivity
        implements GlassGestureDetector.OnGestureListener {

    private View decorView;
    private GlassGestureDetector glassGestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        decorView = getWindow().getDecorView();
        decorView
                .setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                            hideSystemUI();
                        }
                    }
                });
        glassGestureDetector = new GlassGestureDetector(this, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return glassGestureDetector.onTouchEvent(ev) || super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onGesture(GlassGestureDetector.Gesture gesture) {
        switch (gesture) {
            case SWIPE_DOWN:
                finish();
                return true;
            case SWIPE_UP:
                final Intent homeButtonIntent = new Intent(Intent.ACTION_MAIN);
                homeButtonIntent.addCategory(Intent.CATEGORY_HOME);
                homeButtonIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(homeButtonIntent);
                return true;
            default:
                return false;
        }
    }

    private void hideSystemUI() {
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}
