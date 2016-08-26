package gpslocation.wonho.example.com.postmetest.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import gpslocation.wonho.example.com.postmetest.R;

/**
 * Created by wonhochoi on 2016. 8. 4..
 */
public class MapFragment extends Fragment implements
        OnMapReadyCallback, GoogleMap.OnCameraMoveListener,
        GoogleMap.OnMapClickListener,         //맵 클릭시 이벤트 처리
        GoogleMap.OnMarkerClickListener,      //마커 클릭시 이벤트 처리
        GoogleMap.OnInfoWindowClickListener,  //Infowindow 클릭시 이벤트 처리
        GoogleMap.OnMarkerDragListener {
    String TAG = "TAG_D";
    static View view;
    LocationManager mLM;                      //로케이션매니저 변수
    String mProvider = LocationManager.GPS_PROVIDER;    //GPS기반의 위치 제공자

    public MapFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        if (view == null) {
            view = inflater.inflate(R.layout.f_map, container, false); //비어있는 layout 생성
            SupportMapFragment fragment = (SupportMapFragment) this.getChildFragmentManager()
                    .findFragmentById(R.id.map_fragment);
            fragment.getMapAsync(this);
            // Inflate the layout for this fragment

            setHasOptionsMenu(true);


            FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_click);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
        return view; //완성된 VIEW return
    }

    @Override
    public void onCameraMove() {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        GoogleMap map;                            //구글맵 변수
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Log.d(TAG, "onMapReady");
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        map.setMyLocationEnabled(true);
        map.getUiSettings().setCompassEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.setOnCameraMoveListener(this);
        map.setOnMapClickListener(this);
        map.setOnMarkerClickListener(this);
        map.setOnInfoWindowClickListener(this);
        map.setOnMarkerDragListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_map, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }
}