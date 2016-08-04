package com.wild.matt.natureone.natureone2016.Views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wild.matt.natureone.natureone2016.Model.Event;
import com.wild.matt.natureone.natureone2016.Model.MockDB;
import com.wild.matt.natureone.natureone2016.R;

import java.util.Date;

/**
 * Created by Matze on 03.08.2016.
 */
public class EventReyclerAdapter extends RecyclerView.Adapter<EventReyclerAdapter.CustomViewHolder> {

    private Context mContext;
    SparseArray<Event> events;
    View.OnClickListener clickListener;
    public EventReyclerAdapter(Context context) {
        this.events= MockDB.getEvents();
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Event event = events.valueAt(i);
        //Download image using picasso library

        customViewHolder.txtName.setOnClickListener(clickListener);



        customViewHolder.txtName.setTag(customViewHolder);


        //Setting text view title
        customViewHolder.txtName.setText(event.getName());

        String day = event.getDay().equals("0")?"Freitag":"Samstag";
        String startHour = event.getStartHour()<10?"0"+event.getStartHour():""+event.getStartHour();
        String startMinute =  event.getStartMinute()<10?"0"+event.getStartMinute():""+event.getStartMinute();
        String endHour =  event.getEndHour()<10?"0"+event.getEndHour():""+event.getEndHour();
        String endMinute =  event.getEndMinute()<10?"0"+event.getEndMinute():""+event.getEndMinute();
        customViewHolder.txtTime.setText(day+"// "+startHour+":"+startMinute+" - "+endHour+":"+endMinute);
    }

    @Override
    public int getItemCount() {
        return (null != events ? events.size() : 0);
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView txtName;

        protected TextView txtTime;

        public CustomViewHolder(View view) {
            super(view);
            this.txtName = (TextView) view.findViewById(R.id.event_name);

            this.txtTime = (TextView) view.findViewById(R.id.event_time);
        }
    }
}