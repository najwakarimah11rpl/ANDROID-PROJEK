package com.komputerkit.sqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder> {
    private Context context;
    private List<Barang> barangList;

    public BarangAdapter(Context context, List<Barang> barangList) {
        this.context = context;
        this.barangList = barangList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_barang, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Barang barang = barangList.get(position);
        holder.tvBarang.setText(barang.getBarang());
        holder.tvStok.setText(barang.getStok());
        holder.tvHarga.setText(barang.getHarga());

        holder.tvMenu.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(context, holder.tvMenu);
            popupMenu.inflate(R.menu.menu_item);

            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.ubah:
                        ((MainActivity) context).selectUpdate(barang.getIdbarang());
                        return true;
                    case R.id.hapus:
                        ((MainActivity) context).deleteData(barang.getIdbarang());
                        return true;
                    default:
                        return false;
                }
            });

            popupMenu.show();
        });
    }

    @Override
    public int getItemCount() {
        return barangList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBarang, tvStok, tvHarga, tvMenu;

        public ViewHolder(View itemView) {
            super(itemView);
            tvBarang = itemView.findViewById(R.id.tvBarang);
            tvStok = itemView.findViewById(R.id.tvStok);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            tvMenu = itemView.findViewById(R.id.tvMenu);
        }
    }
}
