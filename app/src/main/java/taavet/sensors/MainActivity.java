package taavet.sensors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "APPMSG(" + getClass().getSimpleName() + ")";
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
        RecyclerView recyclerView = findViewById(R.id.rvSensors);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(new Adapter(sensorManager.getSensorList(Sensor.TYPE_ALL)));
    }

}