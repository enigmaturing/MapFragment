package android.and06.einsendeaufgabe.mapfragment;

import android.app.Activity;
import android.os.Bundle;

public class NoteMapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content to the layout defined on activity_note_map.xml, that contains a MapFragment.
        // The map will be centered on the point where the Ecuador crosses the Prime Meridian.
        setContentView(R.layout.activity_note_map);
    }
}
