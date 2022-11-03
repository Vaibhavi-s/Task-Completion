package com.example.taskcompletion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ViewHolder> {

//    public List<ResultsItem> resultsItems = new ArrayList<>();
    public ArrayList<ResultsItem> resultsItems = new ArrayList<>();
    public Context context;

    public ResponseAdapter(ArrayList<ResultsItem> resultsItems, Context context) {
        this.resultsItems = resultsItems;
        this.context = context;
    }

    public void updataResult(ArrayList<ResultsItem> u ){
        this.resultsItems = u;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtcontent.setText(resultsItems.get(position).getContent());
//        holder.txttags.setText(resultsItems.get(position).getTags());
        holder.txtauthorslug.setText(resultsItems.get(position).getAuthor());
        holder.txtdateadded.setText(resultsItems.get(position).getDateAdded());

    }

    @Override
    public int getItemCount() {
        return resultsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtcontent, txtauthorslug, txtdateadded;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtcontent = itemView.findViewById(R.id.txtcontent);
            txtauthorslug = itemView.findViewById(R.id.txtauthorslug);
            txtdateadded = itemView.findViewById(R.id.txtdateadded);

        }
    }
}
