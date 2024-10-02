package com.komputerkit.recyclerviewcardview;

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

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {
    private Context context;
    private List<Siswa> siswaList;

    public SiswaAdapter(Context context, List<Siswa> siswaList) {
        this.context = context;
        this.siswaList = siswaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_siswa, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Siswa siswa = siswaList.get(position);
        viewHolder.tvNama.setText(siswa.getNama());
        viewHolder.tvAlamat.setText(siswa.getAlamat());

        viewHolder.tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                popupMenu.inflate(R.menu.menu_option);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            if (menuItem.getItemId() == R.id.menu_simpan) {
                                // Handle the save action
                                Toast.makeText(context, "Data saved for " + siswa.getNama(), Toast.LENGTH_SHORT).show();
                                return true;
                            } else if (menuItem.getItemId() == R.id.menu_hapus) {
                                // Handle the delete action
                                siswaList.remove(position); // Remove the item from the list
                                notifyItemRemoved(position); // Notify the adapter that the item was removed
                                Toast.makeText(context, siswa.getNama() + " has been deleted", Toast.LENGTH_SHORT).show();
                                return true;
                            } else {
                                // Handle other menu items or return false if not handled
                                return false;
                            }
                        }


//                        switch (menuItem.getItemId()) {
//                            case R.id.menu_simpan:
//                                // Handle the save action
//                                Toast.makeText(context, "Data saved for " + siswa.getNama(), Toast.LENGTH_SHORT).show();
//                                return true;
//                            case R.id.menu_hapus:
//                                // Handle the delete action
//                                siswaList.remove(position); // Remove the item from the list
//                                notifyItemRemoved(position); // Notify the adapter that the item was removed
//                                Toast.makeText(context, siswa.getNama() + " has been deleted", Toast.LENGTH_SHORT).show();
//                                return true;
//                            default:
//                                return false;
//                        }
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return siswaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat, tvMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvMenu = itemView.findViewById(R.id.tvMenu);
        }
    }
}
