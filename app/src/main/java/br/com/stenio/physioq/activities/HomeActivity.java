package br.com.stenio.physioq.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.Arrays;
import java.util.List;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.adapters.TabsAdapter;
import br.com.stenio.physioq.tabs.SlidingTabLayout;

public class HomeActivity extends FragmentActivity {
   private  static final String STATE_DRAWER_ITEM_SELECTED = "itemDrawerSelected";


    private  AccountHeader.Result mHeaderNavigation;
    private Drawer.Result mNavigationDrawer;
    private int currentDrawerSelected;
    private int lastDrawerItemClicked;



    private SlidingTabLayout mSlidinTabLayout;
   private   ViewPager mViewPager;
    private Toolbar myToolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        setupToolbar();
        setupSlidingTabs();
        setTabs();
        setupNavigationDrawer(savedInstanceState);


        ImageButton btn = (ImageButton) findViewById(R.id.search_button);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onSearchRequested();
            }
        });


    }





    public void setupToolbar() {
        myToolbar = (Toolbar) findViewById(R.id.tool_barhome);
        myToolbar.setTitle(R.string.app_name);
        myToolbar.setNavigationIcon(R.drawable.dots_vertical);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.black));



    }

    protected void setupNavigationDrawer(Bundle savedInstanceState) {

        mHeaderNavigation = new AccountHeader()
                .withActivity(HomeActivity.this)
                .withCompactStyle(true)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.drawable.physio_q)
                .build();

        mNavigationDrawer = new Drawer()
                .withSavedInstance(savedInstanceState)
                .withActivity(HomeActivity.this)
                .withToolbar(myToolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withActionBarDrawerToggle(false)
                .withDrawerGravity(Gravity.LEFT)
                .withAccountHeader(mHeaderNavigation)
                .withSelectedItem(currentDrawerSelected)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {


                        switch (i) {

                            case 2:
                                Intent it = new Intent(HomeActivity.this, About.class);
                                startActivity(it);

                                break;
                        }

                        mViewPager.setCurrentItem(i);
                        changeColorItemSelected(i, iDrawerItem);


                    }
                })
                .build();
        fillDrawerItens();
        mNavigationDrawer.addItem(new SectionDrawerItem().withName(getResources().getString(R.string.about)));




    }

    public void setTabs() {
        setupViewPager();
        setupSlidingTabs();
    }

    public void setupViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.tabs_container_viewPager);
        mViewPager.setAdapter(new TabsAdapter(getSupportFragmentManager(), HomeActivity.this));
    }

    public void setupSlidingTabs() {
        mSlidinTabLayout = (SlidingTabLayout) findViewById(R.id.tabs);
        mSlidinTabLayout.setDistributeEvenly(true);
        mSlidinTabLayout.setCustomTabView(R.layout.tab_view, R.id.tab_textView);
        mSlidinTabLayout.setBackgroundColor(getResources().getColor(R.color.whitenew));
        mSlidinTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.black));
        mSlidinTabLayout.setHorizontalFadingEdgeEnabled(true);
        mSlidinTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mNavigationDrawer.setSelection(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mSlidinTabLayout.setViewPager(mViewPager);
    }

    public void fillDrawerItens() {
        List<String> drawerItensNames = Arrays.asList(getResources().getStringArray(R.array.drawer_titles));

        // Add the first item os the list in the Drawer with a icon selected
        mNavigationDrawer.addItem(new PrimaryDrawerItem().withName(drawerItensNames.get(0)).withIcon(getResources().getDrawable(R.drawable.note)));

        for(int i = 1; i < drawerItensNames.size(); i++) {
            mNavigationDrawer.addItem(new PrimaryDrawerItem().withName(drawerItensNames.get(i)).withIcon(getResources().getDrawable(R.drawable.note_grey)));
        }
    }

    public void changeColorItemSelected(int position, IDrawerItem drawerItem) {
        int numberDrawerItens = mNavigationDrawer.getDrawerItems().size();

        if(position <= numberDrawerItens) {
            // Unselecting the last item selected
            PrimaryDrawerItem selectedItem = (PrimaryDrawerItem) mNavigationDrawer.getDrawerItems().get(lastDrawerItemClicked);
            selectedItem.setIcon(getResources().getDrawable(getIconSelected(lastDrawerItemClicked, false)));

            // Selecting the current item
            ((PrimaryDrawerItem) drawerItem).setIcon(getResources().getDrawable(getIconSelected(position, true)));

            lastDrawerItemClicked = position;
            mNavigationDrawer.getAdapter().notifyDataSetChanged();
        }
    }

    public int getIconSelected(int position, boolean isSelecetd) {
        switch(position) {
            case 0:
                return isSelecetd ? R.drawable.note : R.drawable.note_grey;

            case 1:
                return isSelecetd ? R.drawable.human : R.drawable.human_grey;

            case 2:
                return isSelecetd ? R.drawable.floppy : R.drawable.floppy_grey;

            default:
                return 0;
        }
    }


    public List<String> getQuestionariesList() {
        return Arrays.asList(getResources().getStringArray(R.array.category));
    }



	// clica em voltar em baixo e sai só do NavigationDraw e não da app
    @Override
    public void onBackPressed() {
        if(mNavigationDrawer.isDrawerOpen()) {
            mNavigationDrawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        currentDrawerSelected = savedInstanceState.getInt(STATE_DRAWER_ITEM_SELECTED);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putInt(STATE_DRAWER_ITEM_SELECTED, currentDrawerSelected);
        outState = mNavigationDrawer.saveInstanceState(outState);
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
