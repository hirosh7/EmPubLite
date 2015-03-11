package com.frostycold.empublite;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;

public class SimpleContentsFragment extends WebViewFragment {
    private static final String KEY_FILE = "file";

    protected static SimpleContentsFragment newInstance(String file) {
        SimpleContentsFragment f = new SimpleContentsFragment();
        Bundle args = new Bundle();

        args.putString(KEY_FILE, file);
        f.setArguments(args);

        return (f);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View result =
                super.onCreateView(inflater, container, savedInstanceState);

        getWebView().getSettings().setJavaScriptEnabled(true);
        getWebView().getSettings().setSupportZoom(true);
        getWebView().getSettings().setBuiltInZoomControls(true);
        getWebView().loadUrl(getPage());

        return (result);
    }

    private String getPage() {
        return (getArguments().getString(KEY_FILE));
    }
}
