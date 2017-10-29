package co.negitoromaki.fosscarina;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.KeyEvent;
import android.app.Activity;

import in.excogitation.zentone.library.ToneStoppedListener;
import in.excogitation.zentone.library.ZenTone;

/**
 * Created by csculley on 10/28/17.
 */

public class Ocarina12HoleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

        return inflater.inflate(R.layout.ocarina_12_hole, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        boolean[] savedState = OcarinaTouchListener.getButtons();

        while (true) {
            if (!OcarinaTouchListener.getButtons().equals(savedState)) {
                savedState = OcarinaTouchListener.getButtons();
                ZenTone.getInstance().generate((int) OcarinaTouchListener.getNote("12Hole").freq(), 10, 1, new ToneStoppedListener() {
                    @Override
                    public void onToneStopped() {
                    }
                });
            }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        ZenTone.getInstance().stop();
    }

    @Override
    public void onPause() {
        super.onPause();
        ZenTone.getInstance().stop();
    }
}