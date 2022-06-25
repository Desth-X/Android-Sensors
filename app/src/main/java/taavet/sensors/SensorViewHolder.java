package taavet.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class SensorViewHolder extends RecyclerView.ViewHolder implements OnClickListener, SensorEventListener {

    String TAG = "APPMSG("+getClass().getSimpleName()+")";
    TextView tvName;
    TextView tvValue;
    SensorManager sensorManager;
    Sensor sensor;
    boolean isListening;

    public SensorViewHolder(@NonNull View itemView) {
        super(itemView);
        isListening = false;
        itemView.setOnClickListener(this);
        Context context = itemView.getContext();
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        tvName = itemView.findViewById(R.id.tvName);
        tvValue = itemView.findViewById(R.id.tvValue);
        tvValue.setText("No Listening, Tap To start.");
    }

    public void setSensor(Sensor sensor){
        this.sensor = sensor;
        tvName.setText(sensor.getName());
    }

    @Override
    public void onClick(View view) {
        if(isListening){
            sensorManager.unregisterListener(this);
            tvValue.setText("No Listening, Tap To start.");
        } else{
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);
            tvValue.setText("Waiting sensor event...");
        }
        isListening = !isListening;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        tvValue.setText(Arrays.toString(sensorEvent.values));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}
