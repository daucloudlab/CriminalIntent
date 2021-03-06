package kz.abcsoft.criminalintent;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CrimeListFragment extends ListFragment {

    private static final String TAG = "CrimeListFragment";
    private ArrayList<Crime> mCrimes;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
//        Crime c = (Crime)l.getItemAtPosition(position) ; // Бұл да жұмыс істейді!
        Crime c = ((CrimeAdapter)(getListAdapter())).getItem(position);
        Log.d(TAG, c.getTitle() + " was clicked");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);

        mCrimes = CrimeLab.get(getActivity()).getCrimes();
       CrimeAdapter adapter = new CrimeAdapter(mCrimes) ;
        setListAdapter(adapter);

    }


    private class CrimeAdapter extends ArrayAdapter<Crime>
    {
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            return super.getView(position, convertView, parent);
            if (convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null) ;
            }
            Crime c = getItem(position) ;

            TextView titleTextView = (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getTitle()) ;

            TextView dateTextView = (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView) ;
            dateTextView.setText(c.getDate().toString()) ;

            CheckBox solvedCheckBox = (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox) ;
            solvedCheckBox.setChecked(c.isSolved());

            return convertView ;
        }

        public CrimeAdapter(ArrayList<Crime> crimes){
            super(getActivity(), 0, crimes) ;


        }

    }
}