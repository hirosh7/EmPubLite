package com.frostycold.empublite;

import android.app.Activity;
import android.app.Fragment;
import android.support.v13.app.FragmentStatePagerAdapter;

public class ContentsAdapter extends FragmentStatePagerAdapter {

    private BookContents contents;

    public ContentsAdapter(Activity ctxt, BookContents contents) {
        super(ctxt.getFragmentManager());
        this.contents = null;
        this.contents=contents;
    }

    @Override
    public Fragment getItem(int position) {
        String path = contents.getChapterFile(position);
        String base_path = "file:///android_asset/book/";
        return(SimpleContentsFragment.newInstance(base_path + path));
    }

    @Override
    public int getCount() {
        return(contents.getChapterCount());
    }
}
