package br.com.calendarevents.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.calendarevents.beans.Events;

import com.example.calendarevents.R;

public class ListViewAdapter extends BaseAdapter{
	
	private ArrayList<Events> events = new ArrayList<Events>();
	private Context context;
	private LayoutInflater inflater;
	private ViewGroup viewGroup= null;
	private View rowView = null;

	@Override
	public int getCount() {
		return events.size();
	}
	
	public ListViewAdapter(Context context) {
		this.context = context;
	}
	
	

	@Override
	public Object getItem(int position) {
		return events.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
			
		inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		rowView = inflater.inflate(R.layout.item_list_view_calendar, viewGroup, false);
		
		
		TextView dayWeekName = (TextView) rowView.findViewById(R.id.dayWeekName);
		TextView day = (TextView) rowView.findViewById(R.id.day);
		TextView month = (TextView) rowView.findViewById(R.id.month);
		TextView nEvents = (TextView) rowView.findViewById(R.id.nEvents);
		
		dayWeekName.setText("Segunda-Feira");
		day.setText(String.valueOf("7"));
		month.setText("SET");
		nEvents.setText(String.valueOf(events.get(position).getnEvents())+" eventos");
		
		return rowView;
	}
	
	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return super.getItemViewType(position);
	}
	
	
	public void setData(ArrayList<Events> events) {
		this.events.addAll(events);
		notifyDataSetChanged();
	}

}
