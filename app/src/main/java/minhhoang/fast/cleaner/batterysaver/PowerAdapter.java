package minhhoang.fast.cleaner.batterysaver;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import minhhoang.fast.cleaner.batterysaver.Classes.power_item;

import com.minhhoang.fast.cleaner.batterysaver.R;

import java.util.List;

/**
 * Created by intag pc on 2/16/2017.
 */

public class PowerAdapter extends RecyclerView.Adapter<PowerAdapter.MyViewHolder> {

    public List<power_item> apps;

    public PowerAdapter(List<power_item> getapps)
    {
        apps=getapps;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.powe_itemlist, parent, false);
        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        power_item app= apps.get(position);
        holder.size.setText(app.getText());
        holder.check.setChecked(true);
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView size;
        public CheckBox check;


        public MyViewHolder(View view) {
            super(view);
            size = (TextView) view.findViewById(R.id.items);
            check = (CheckBox) view.findViewById(R.id.check);
        }
    }
}
