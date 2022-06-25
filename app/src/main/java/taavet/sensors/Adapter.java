package taavet.sensors;

import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<SensorViewHolder> {

    List<Sensor> arlSensors;

    public Adapter(List<Sensor> arlSensors){
        this.arlSensors = arlSensors;
    }

    @NonNull
    @Override
    public SensorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new SensorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorViewHolder holder, int position) {
        holder.setSensor(arlSensors.get(position));
    }

    @Override
    public int getItemCount() {
        return arlSensors.size();
    }

}
