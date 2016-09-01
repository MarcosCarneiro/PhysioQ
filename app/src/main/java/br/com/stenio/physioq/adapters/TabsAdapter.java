package br.com.stenio.physioq.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Arrays;
import java.util.List;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.fragments.QueriesMadeFragment;
import br.com.stenio.physioq.fragments.QuestionariesFragment;

public class TabsAdapter extends FragmentPagerAdapter {
    private List<String> tabTitles;

    public TabsAdapter(FragmentManager fm, Context context) {
        super(fm);
        tabTitles = Arrays.asList(context.getResources().getStringArray(R.array.tabs));
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragmentClicekd = null;

        switch (position) {
            case 0:
                fragmentClicekd = new QuestionariesFragment();
                break;
            case 1:
                fragmentClicekd = new QueriesMadeFragment();
                break;




        }

        Bundle fragmentPosition = new Bundle();
        fragmentPosition.putInt("position", position);

        fragmentClicekd.setArguments(fragmentPosition);

        return fragmentClicekd;
    }

    @Override
    public int getCount() {
        return tabTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }
}