package com.example.spy_support.remindmetocook;

import android.app.ProgressDialog;
import android.content.ContentUris;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private FloatingActionButton mAddReminderButton;
    private Toolbar mToolbar;
    AlarmCursorAdapter alarmCursorAdapter;
    AlarmReminderDbHelper alarmReminderDbHelper = new AlarmRemniderDbHelper (this);
    Listview reminderListView;
    ProgressDialog prgDialog;

    private static final int VEHICLE_LOADER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mToolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( mToolbar );
        mToolbar.setTitle( "AlarmReminder" );

        reminderListView = (ListView) findViewById( R.id.List );
        View emptyview = findViewById( R.id.empty_view );
        reminderListView.setEmptyView( emptyview );

        mCursorAdapter = new AlarmCursorAdapter( this, null );
        reminderListView.setAdapter( mCursorAdapter );

        reminderListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterview, View view, int position, long id) {

                Intent intent = new intent( MainActivity.this, AddReminderActivity.class );

                Uri currentVehicleUri = ContentUris.withAppendedId( AlarmReminderContract.AlarmReminderEntry.CONTENT_URI, id );

                intent.setData( currentVehicleUri );

                startActivity( intent );
            }
        } );

        mAddReminderButton = (FloatingActionButton) findViewById( R.id.fab );

        mAddReminderButton.setOnClickListener( (v) {
                Intent intent = new Intent( v.getContext(), AddReminderActivity.class );
        startActivity( intent );
        });

        getLoaderManager().initLoader( VEHICLE_LOADER, null, this );
    }
    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
    String[] projection = {
            AlarmReminderContract.AlarmReminderEntry._ID,
            AlarmReminderContract.AlarmReminderEntry.KEY_TITLE,
            AlarmReminderContract.AlarmReminderEntry.KEY_DATE,
            AlarmReminderContract.AlarmReminderEntry.KEY_TIME,
            AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT,
            AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT_NO,
            AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT_TYPE,
            AlarmReminderContract.AlarmReminderEntry.KEY_ACTIVE
        );

        return new CursorLoader (this,
                AlarmReminderContract.AlarmReminderEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);
        }
        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor){
            mCursorAdapter.swapCursor(cursor);
        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {
            mCursorAdapter.swapCursor(null);
    }
}

    private class Listview {
    }

    private class AlarmReminderDbHelper {
    }

    private class AlarmRemniderDbHelper extends AlarmReminderDbHelper {
        public AlarmRemniderDbHelper(MainActivity mainActivity) {
            super();
        }
    }