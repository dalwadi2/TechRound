package io.github.dalwadi2.techround.view.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import io.github.dalwadi2.techround.R;
import io.github.dalwadi2.techround.databinding.ActivityMapsBinding;
import io.github.dalwadi2.techround.utils.AppConfig;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    ActivityMapsBinding mBinding;

    private BottomSheetBehavior sheetBehavior;
    private GoogleMap mMap;
    private Bundle bundle;
    private double latitude;
    private double longitude;
    private String title;
    private String desc;
    private String imgeUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_maps);

        bundle = getIntent().getExtras();
        if (bundle != null) {
            latitude = bundle.getDouble(AppConfig.BUNDLE.latitude);
            longitude = bundle.getDouble(AppConfig.BUNDLE.longitude);
            title = bundle.getString(AppConfig.BUNDLE.title);
            desc = bundle.getString(AppConfig.BUNDLE.desc);
            imgeUrl = bundle.getString(AppConfig.BUNDLE.image);
        }

        sheetBehavior = BottomSheetBehavior.from(mBinding.bottomSheet);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        mBinding.tvMapTitle.setText("Location: " + title);
        mBinding.tvMapDesc.setText("Description: " + desc);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Picasso.with(this).load(imgeUrl)
                .error(R.mipmap.ic_launcher_round)
                .into(mBinding.imgMapProduct);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng newLocation = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(newLocation).title(title)).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newLocation, 15));
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
    }
}
