package android.and06.einsendeaufgabe.mapfragment;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

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
        // Call the method getMapAsync, providing it as parameter an object of the class MapsCallback.
        // We have to define this class as an INNERCLASS of our class-activity NoteMapActivity.
        // We have to make this INNERCLASS implement the interface OnMapReadyCallback, defining its
        // method onMapReady(GogleMap map), which will be automatically called when the map is
        // ready. We can then actuate on the zoom, tilt, beating, markers... of this map in the
        // method getMapAsync
        mapFragment.getMapAsync(new MapsCallback());
    }

    class MapsCallback implements OnMapReadyCallback {

        @Override
        public void onMapReady(GoogleMap map) {
            // Define an object of the class com.google.android.gms.maps.model.LatLng, that
            // fixes the Latitude and Longitude of the point we want to center the map on
            LatLng position = new LatLng(28.4874009, -16.315906);
            // Initialize a CameraPosition object in order to be able to show a given position in
            // the map with a given level of zoom.
            // This can be done in two ways:
            // 1st: Specifying position, zoom, tilt and bearing. In that case we use the constructor
            //      of the class CameraPosition:
            //      CameraPosition cameraPosition = new CameraPosition(position, 10.0f, 0.0f,0.0f);

            // 2nd: Using the factory method fromLatLngZoom() of the class CameraPosition.Builder.
            // In that case there is no use of a constructor (it is a factory method that
            // automatically returns an object of the class CamerPosition). In this case it is only
            // possible to specify position and zoom (this second way is commented. Uncomment it
            // and comment the first way to go that way.
            CameraPosition cameraPosition = CameraPosition.fromLatLngZoom(position, 10.0f);
            // Generate a CameraUpdate object with the factory method newCameraPosition present in the
            // class CameraUpdateFactory. This object will be passed as parameter to the method
            // moveCamera, that the object map of the class GoogleMap knows.
            CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);
            map.moveCamera(update);
        }
    }
}
