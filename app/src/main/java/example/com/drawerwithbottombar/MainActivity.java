package example.com.drawerwithbottombar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mikepenz.materialdrawer.DrawerBuilder;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabClickListener;

public class MainActivity extends AppCompatActivity {

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItems(
                new BottomBarTab(R.mipmap.ic_launcher, "Recents"),
                new BottomBarTab(R.mipmap.ic_launcher, "Favorites"),
                new BottomBarTab(R.mipmap.ic_launcher, "Nearby")
        );
        mBottomBar.setOnTabClickListener(new OnTabClickListener() {
            @Override
            public void onTabSelected(int position) {
                // The user selected a tab at the specified position
                switch (position){
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, BlankFragment.newInstance("One", "Two")).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, BlankFragment.newInstance("Three", "Four"))
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, BlankFragment.newInstance("Five", "Six"))
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabReSelected(int position) {
                // The user reselected a tab at the specified position!
            }
        });
        new DrawerBuilder().withActivity(this).withTranslucentStatusBar(false).build();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, BlankFragment.newInstance("One", "Two")).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
