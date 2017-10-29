package co.negitoromaki.fosscarina;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import in.excogitation.zentone.library.ToneStoppedListener;
import in.excogitation.zentone.library.ZenTone;

/**
 * Created by csculley on 10/28/17.
 */

public class Ocarina4HoleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

        return inflater.inflate(R.layout.ocarina_4_hole, container, false);
    }

    @Override

    public void onStart() {
        super.onStart();
        ImageButton b1 = (ImageButton) getActivity().findViewById(R.id.button1);
        ImageButton b2 = (ImageButton) getActivity().findViewById(R.id.button2);
        ImageButton b3 = (ImageButton) getActivity().findViewById(R.id.button3);
        ImageButton b4 = (ImageButton) getActivity().findViewById(R.id.button4);
        ImageButton b5 = (ImageButton) getActivity().findViewById(R.id.button5);
        ImageButton b6 = (ImageButton) getActivity().findViewById(R.id.button6);
        ImageButton b7 = (ImageButton) getActivity().findViewById(R.id.button7);
        ImageButton b8 = (ImageButton) getActivity().findViewById(R.id.button8);
        //Buttons 9 and 10 are volume buttons
        ImageButton b11 = (ImageButton) getActivity().findViewById(R.id.button11);
        ImageButton b12 = (ImageButton) getActivity().findViewById(R.id.button12);

        b1.setOnTouchListener(MainActivity.getTouchListener());
        b2.setOnTouchListener(MainActivity.getTouchListener());
        b3.setOnTouchListener(MainActivity.getTouchListener());
        b4.setOnTouchListener(MainActivity.getTouchListener());
    }

}