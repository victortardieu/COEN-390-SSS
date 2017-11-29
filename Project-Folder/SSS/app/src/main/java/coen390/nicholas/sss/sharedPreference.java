package coen390.nicholas.sss;

import android.content.Context;
import android.content.SharedPreferences;


public class sharedPreference {


    BluetoothConnectionService mBluetooth;
    private SharedPreferences sharedPreferences; //class object

    //constructor
    public sharedPreference(Context context)
    {
        sharedPreferences = context.getSharedPreferences("Preference", Context.MODE_PRIVATE);
    }

    //function to save the bluetooth connection
    public void saveConnection(Boolean connection)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("connection",connection);
        editor.apply();
    }
    //function to get the name
    public boolean getConnection()
    {
        return sharedPreferences.getBoolean("connection", false);
    }

    public void saveLanguage(int language)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("language",language);
        editor.apply();
    }

    public int getLanguage() { return sharedPreferences.getInt("language", 1);}

    public void saveBluetooth(BluetoothConnectionService mBlue) { mBluetooth = mBlue;}

    public BluetoothConnectionService getBluetooth(){return mBluetooth;}

}