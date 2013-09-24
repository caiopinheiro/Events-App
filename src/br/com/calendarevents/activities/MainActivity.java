package br.com.calendarevents.activities;

import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import br.com.calendarevents.adapters.ListViewAdapter;
import br.com.calendarevents.beans.Events;
import br.com.calendarevents.beans.Pessoa;
import br.com.calendarevents.parsers.XmlParse;

import com.example.calendarevents.R;


public class MainActivity extends Activity {
	
	private ListView lvCalendar;
	private ListViewAdapter adapter;
	private ArrayList<Events> events;
	private ArrayList<Pessoa> pessoa;
	public Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        context = this;
       
        events = new ArrayList<Events>();
        addEvents(12, events);
        
        adapter = new ListViewAdapter(this);
        adapter.setData(events);
        
        lvCalendar = (ListView) findViewById(R.id.list_view);
        lvCalendar.setAdapter(adapter);

        
        XmlParseTask();
        
        
         
    }
    
    public void XmlParseTask() {
    	new AsyncTask<Void, Void, Void>(){

			@Override
			protected Void doInBackground(Void... arg) {
				
				try {
					pessoa = XmlParse.parse(context);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
				
				imprimirLog(pessoa);
			}
			
			
    		
    	}.execute();
    	
    	
    }
    
    public void imprimirLog(ArrayList<Pessoa> pessoas){
    	for (Pessoa pessoa : pessoas) {
			Log.e ("Versão: ", pessoa.getVersao());
			Log.e ("Nome: ", pessoa.getNome());
			Log.e ("Idade: ", ""+pessoa.getIdade());
		}
    }
    
    public void addEvents(int n, ArrayList<Events> events){
    	for (int i = 0; i<n; i++){
    		
    		Events event = new Events();
    		event.setTag(""+i+1);
    		event.setnEvents(i+1);
    		events.add(event);
    	}
    	
    }

    
    public int getStatusBarHeight() {
    	   int result = 0;
    	   int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
    	   if (resourceId > 0) {
    	      result = getResources().getDimensionPixelSize(resourceId);
    	   }
    	   return result;
    }
}
