package cn.dreamchase.android.three.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import cn.dreamchase.android.three.R;

public class FragmentOne extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i("FragmentOne","onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("FragmentOne","onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i("FragmentOne","onCreateView");
        return inflater.inflate(R.layout.fragment_one,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("FragmentOne","onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("FragmentOne","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("FragmentOne","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("FragmentOne","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("FragmentOne","onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("FragmentOne","onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("FragmentOne","onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("FragmentOne","onDetach");
    }
}
