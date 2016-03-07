package net.infobosccoma.paisos.views.impl.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.infobosccoma.paisos.R;
import net.infobosccoma.paisos.models.business.entities.Pais;

import java.util.List;

/**
 * Created by alumne on 3/4/2016.
 */
public class SearchAdapter extends ArrayAdapter<Pais> {
    private Context context;
    private LayoutInflater inflater;

    public SearchAdapter(Context context, List<Pais> comments) {
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
}
