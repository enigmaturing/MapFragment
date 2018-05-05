package android.and06.einsendeaufgabe.mapfragment;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.MapFragment;

public class NoteMapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content to the layout defined on activity_note_map.xml, that contains a MapFragment.
        // The map will be centered on the point where the Ecuador crosses the Prime Meridian.
        setContentView(R.layout.activity_note_map);
        // Create an object of the class com.google.android.gms.maps.MapFragment. This object is
        // necessary in order to be able to call its method getMapAsync as the next step to be able
        // to modify the contents and the aspect of the map shown on the mapFragment.
        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.mapfragment);
    }
}
