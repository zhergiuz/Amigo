package id.sch.smktelkom_mlg.project.xirpl109182736.amigo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.R;
import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.model.Cake;

/**
 * Created by MANNAR on 25/11/2016.
 */

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.ViewHolder> {
    ArrayList<Cake> cakelist;
    ICakeAdapter mICakeAdapter;

    public CakeAdapter(Context context, ArrayList<Cake> cakelist) {
        this.cakelist = cakelist;
        mICakeAdapter = (ICakeAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cake, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cake cake = cakelist.get(position);
        holder.tvJudul.setText(cake.judul);
        holder.tvDeskripsi.setText(cake.deskripsi);
        holder.ivfoto.setImageURI(Uri.parse(cake.foto));
    }

    @Override
    public int getItemCount() {
        if (cakelist != null)
            return cakelist.size();
        return 0;
    }

    public interface ICakeAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivfoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivfoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mICakeAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
