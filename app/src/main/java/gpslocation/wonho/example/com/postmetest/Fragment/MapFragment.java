package gpslocation.wonho.example.com.postmetest.Fragment;

import android.Manifest;
import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.internal.view.SupportMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import gpslocation.wonho.example.com.postmetest.PostMeDialog;
import gpslocation.wonho.example.com.postmetest.R;
import gpslocation.wonho.example.com.postmetest.TabActivity;

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
    Menu menu;
    MenuInflater menuInflater;
    boolean checkMenu = false;
    static View view;
    LocationManager mLM;                      //로케이션매니저 변수
    String mProvider = LocationManager.GPS_PROVIDER;    //GPS기반의 위치 제공자

    public MapFragment() {

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        if (view == null) {
            view = inflater.inflate(R.layout.f_map, container, false); //비어있는 layout 생성
            SupportMapFragment fragment =
                    (SupportMapFragment) this.getChildFragmentManager()
                            .findFragmentById(R.id.map_fragment);
            fragment.getMapAsync(this);
            setHasOptionsMenu(true);
            FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_click);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    menu.removeItem(R.id.Search);
                    menuInflater.inflate(R.menu.menu_fba, menu);

                }
            });
        }
        return view; //완성된 VIEW return
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        this.menuInflater = inflater;
        this.menu = menu;
        inflater.inflate(R.menu.menu_map, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.Search:
                Toast.makeText(getContext(), "실행됨", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ok:
                final PostMeDialog postMeDialog = new PostMeDialog(getContext());
                postMeDialog.show();
                break;
            case R.id.cancel:
                menu.removeItem(R.id.ok);
                menu.removeItem(R.id.cancel);
                menuInflater.inflate(R.menu.menu_map, menu);
                break;
        }
        return super.onOptionsItemSelected(item);
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
}