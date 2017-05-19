package fit.cvut.cz.ambiant.presenter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.MimeTypeMap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import fit.cvut.cz.ambiant.R;
import fit.cvut.cz.ambiant.ar.DemonstrationActivity;
import fit.cvut.cz.ambiant.model.Interactor;
import fit.cvut.cz.ambiant.model.MyFirebaseInstanceIdService;
import fit.cvut.cz.ambiant.model.OpenFileUtility;
import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.view.interfaces.RecentProjectsView;
import fit.cvut.cz.ambiant.view.interfaces.SubscriptionsView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RecentProjectsView.OpenNewFileListener {

    private static final int FILE_OPEN_CODE = 1;
    private static final int FILE_SIZE_LIMIT = 35;
    private static final int PROJECT_DETAILS = 777;
    static final String EXTRA_PROJECT = "EXTRA_PROJECT";
    public static final String EXTRA_PROJECT_PATH = "EXTRA_PROJECT_PATH";
    public static final String EXTRA_PROJECT_NAME = "EXTRA_NAME";
    public static final String EXTRA_PROJECT_EXAMPLE = "EXTRA_EXAMPLE";
    public static final String EXTRA_PROJECT_TEXTURES = "EXTRA_TEXTURES";

    private int selectedNavItem = 0;
    final String LOG_TAG = "myLogs, MainActivity: ";
    Interactor mInteractor;
    BaseFragment currentFragment;
    DrawerLayout mDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "onCreate()");
        MyFirebaseInstanceIdService.logToken();
        mInteractor = new Interactor(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        if (savedInstanceState == null) {
            setFragment(R.id.nav_recentprojects, "Ambiant #");
            navigationView.setCheckedItem(R.id.nav_recentprojects);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "OnStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(LOG_TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy()");
        mInteractor.destroy();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        setFragment(id, String.valueOf(item.getTitle()));
        if (id != R.id.nav_newproject) {
            selectedNavItem = id;
        }


        return true;
    }

    private void setFragment(int id, String title) {
        BaseFragment f = null;
        setTitle(title);

        if (title != null && title.equals("Details")) {
            f = ProjectDetailsFragment.newInstance(id);
        }
        if (id == R.id.nav_newproject) {
            openNewFile();
            mDrawer.closeDrawer(GravityCompat.START);
            return;
        } else if (id == R.id.nav_recentprojects) {
            f = RecentProjectsFragment.newInstance();
        } else if (id == R.id.nav_about) {
            f = AboutFragment.newInstance();
        } else if (id == R.id.nav_subscriptions) {
            f = SubscriptionsFragment.newInstance();
        }


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_main, f).commit();

        currentFragment = f;

        mDrawer.closeDrawer(GravityCompat.START);
    }

    public void readRecentProjects(Interactor.RecentProjectsLoadedListener listener) {
        mInteractor.getRecentProjects(listener);
    }

    Interactor getInteractor() {
        return mInteractor;
    }

    @Override
    public void openNewFile() {

// Just example, you should parse file name for extension
        String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension("zip");

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(mime);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        //intent.putExtra("browseCoa", itemToBrowse);
        //Intent chooser = Intent.createChooser(intent, "Select a File to Upload");
        try {
//            startActivityForResult(intent, FILE_OPEN_CODE);
            startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), FILE_OPEN_CODE);
        } catch (Exception ex) {
            System.out.println("browseClick :" + ex);//android.content.ActivityNotFoundException ex
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_OPEN_CODE) {
            if (resultCode == RESULT_OK) {
                Project p = new Project(0, "","","","", null);
                String path = OpenFileUtility.openFile(data, this, p);
                Log.d(LOG_TAG, "Extracted here: " + path);

                Intent intent = new Intent(this, DemonstrationActivity.class);
                intent.putExtra(EXTRA_PROJECT_PATH, path);
                intent.putExtra(EXTRA_PROJECT_EXAMPLE, false);
                intent.putExtra(EXTRA_PROJECT_TEXTURES, p.getTexturesPath());
                startActivity(intent);
            }
        }
    }

    public void openProjectDetails(int id) {
        setFragment(id, "Details");
    }
}
