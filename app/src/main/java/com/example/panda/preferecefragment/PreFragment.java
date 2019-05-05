package com.example.panda.preferecefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.preference.PreferenceFragment;

public class PreFragment extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //从xml文件中加载选项
        addPreferencesFromResource(R.xml.preferencefragment);
    }
}
