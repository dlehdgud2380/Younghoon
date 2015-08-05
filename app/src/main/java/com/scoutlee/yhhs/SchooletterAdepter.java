package com.scoutlee.yhhs;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by scoutlee(Thanks for YoungBin) on 2015. 7. 11..
 */
public class SchooletterAdepter extends BaseAdapter{

    Activity context;
    ArrayList<String> title;
    ArrayList<String> date;
    ArrayList<String> writer;

    public SchooletterAdepter(Activity context, ArrayList<String> title,
                              ArrayList<String> date, ArrayList<String> writer) {

        super();
        this.context = context;
        this.title = title;
        this.date = date;
        this.writer = writer;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return title.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    private class ViewHolder {
        TextView txtViewTitle;
        TextView txtViewDate;
        TextView txtViewWriter;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.row_layout, null);
            holder = new ViewHolder();
            holder.txtViewTitle = (TextView) convertView.findViewById(R.id.Title);
            holder.txtViewDate = (TextView) convertView.findViewById(R.id.Date);
            holder.txtViewWriter = (TextView) convertView.findViewById(R.id.Writer);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtViewTitle.setText(title.get(position));
        holder.txtViewDate.setText(date.get(position));
        holder.txtViewWriter.setText(writer.get(position));
        return convertView;
    }

}
