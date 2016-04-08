package net.callofdroidy.naomengisangry;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int requestCodeReceiveSMS = 101;
    final int requestCodeReadSMS = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!PermissionHandler.checkPermission(MainActivity.this, Manifest.permission.RECEIVE_SMS))
            PermissionHandler.requestPermission(MainActivity.this, Manifest.permission.RECEIVE_SMS, requestCodeReceiveSMS);
        if(!PermissionHandler.checkPermission(MainActivity.this, Manifest.permission.READ_SMS))
            PermissionHandler.requestPermission(MainActivity.this, Manifest.permission.READ_SMS, requestCodeReadSMS);
        else {
            startService(new Intent(this, MyService.class));
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case requestCodeReceiveSMS:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "no permission to run this app", Toast.LENGTH_SHORT).show();
                }
            break;

            case requestCodeReadSMS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "no permission to run this app", Toast.LENGTH_SHORT).show();
                }
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
