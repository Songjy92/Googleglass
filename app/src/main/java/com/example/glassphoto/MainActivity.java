package com.example.glassphoto;

import android.os.Bundle;
import android.view.KeyEvent;

import com.example.glass.ui.GlassGestureDetector;

/**
 * Main activity of the application. It creates instance of {@link CameraFragment} and passes
 * gestures to it.
 */
public class MainActivity extends BaseActivity {

    private CameraFragment cameraFragment;

    String mCurrentPhotoPaht;
    static final int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraFragment = (CameraFragment) getSupportFragmentManager()
                .findFragmentById(R.id.camera_fragment);
    }

    @Override
    public boolean onGesture(GlassGestureDetector.Gesture gesture) {
        return cameraFragment.onGesture(gesture) || super.onGesture(gesture);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return cameraFragment.onKeyUp(keyCode) || super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return cameraFragment.onKeyLongPress(keyCode) || super.onKeyLongPress(keyCode, event);
    }
}
