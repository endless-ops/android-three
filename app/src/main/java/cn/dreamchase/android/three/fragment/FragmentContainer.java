package cn.dreamchase.android.three.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cn.dreamchase.android.three.R;

public class FragmentContainer extends Fragment {

    private int fragmentIndex;

    public static FragmentContainer getInstance(int fragmentIndex){
        FragmentContainer fragmentContainer = new FragmentContainer();
        fragmentContainer.fragmentIndex = fragmentIndex;
        return fragmentContainer;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_container,null);
        TextView textView = rootView.findViewById(R.id.tv_content);

        if (fragmentIndex == 1) {
            textView.setText("第一个Fragment");
            textView.setBackgroundResource(android.R.color.holo_red_light);
        }else if (fragmentIndex == 2) {
            textView.setText("第二个Fragment");
            textView.setBackgroundResource(android.R.color.holo_orange_light);
        }else if (fragmentIndex == 3) {
            textView.setText("第三个Fragment");
            textView.setBackgroundResource(android.R.color.holo_blue_light);
        }
        return rootView;
    }
}
