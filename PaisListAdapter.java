package net.infobosccoma.paisos.views.impl.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import net.infobosccoma.paisos.R;
import net.infobosccoma.paisos.models.business.entities.Pais;
import net.infobosccoma.paisos.models.persistence.daos.impl.PaisosSQliteDAO;
import net.infobosccoma.paisos.models.persistence.daos.interfaces.PaisosDAO;

import java.util.ArrayList;
import java.util.List;



public class PaisListAdapter extends ArrayAdapter<Pais> implements Filterable {
    private Context context;
    private LayoutInflater inflater;

    public PaisListAdapter(Context context, List<Pais> comments) {
        super(context, 0, comments);

        this.context = context;
        this.inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PaisHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_list, parent, false);

            holder = new PaisHolder();
            addViewsToHolder(convertView, holder);
            convertView.setTag(holder);
        } else {
            holder = (PaisHolder) convertView.getTag();
        }
        Pais pais = getItem(position);
        setDataIntoHolder(holder, pais);

        return convertView;
    }

    private void addViewsToHolder(View convertView, PaisHolder holder) {
        holder.name = (TextView) convertView.findViewById(R.id.main_txtview_name);
        //holder.area = (TextView) convertView.findViewById(R.id.main_txtview_area);
        //holder.population = (TextView) convertView.findViewById(R.id.main_txtview_population);
    }

    private void setDataIntoHolder(PaisHolder holder, Pais pais) {
        //Picasso.with(context).load(image.getUrl()).fit().into(holder.image);
        holder.name.setText(pais.getName());
        //holder.area.setText(String.valueOf(pais.getArea()));
        //holder.population.setText(String.valueOf(pais.getPopulation()));
    }

    class PaisHolder {
        TextView name;
        //TextView area;
        //TextView population;
    }

    /*@Override
    public Filter getFilter() {

        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                List<String> arrayListNames = (List<String>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults results = new FilterResults();
                ArrayList<String> FilteredArrayNames = new ArrayList<String>();

                // perform your search here using the searchConstraint String.

                constraint = constraint.toString().toLowerCase();
                for (int i = 0; i < mDatabaseOfNames.size(); i++) {
                    String dataNames = mDatabaseOfNames.get(i);
                    if (dataNames.toLowerCase().startsWith(constraint.toString()))  {
                        FilteredArrayNames.add(dataNames);
                    }
                }

                results.count = FilteredArrayNames.size();
                results.values = FilteredArrayNames;
                Log.e("VALUES", results.values.toString());

                return results;
            }
        };

        return filter;
    }*/

}