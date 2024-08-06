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

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder{
    private Context context;
    private List<Siswa>siswaList;
    public SiswaAdapter(Context context, List<Siswa> siswaList) {
        this.context = context;
        this.siswaList = siswaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_siswa,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i){
    Siswa siswa=siswaList.get((i));
    viewHolder.tvNama.setText(siswa.getNama());
    viewHolder.tvAlamat.setText(siswa.getAlamat());


//    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Toast.makeText(context, "nama:"+siswa.getNama()+"alamat:"+siswa.getAlamat(),Toast.LENGTH_SHORT);
//        }
//    });
//    }
    viewHolder.tvMenu.setOnclickListener(new View.OnClickListener()){
        public void onClick(View view){
                PopupMenu popupMenu=new PopupMenu(context.viewHolder.tvMenu);
                popupMenu.inflate(R.menu.menu_option);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.menu_simpan) {
                            // Handle the save action
                            Toast.makeText(context, "Data saved for " + siswa.getNama(), Toast.LENGTH_SHORT).show();
                        } else if (menuItem.getItemId() == R.id.menu_hapus) {
                            // Handle the delete action
                            siswaList.remove(i); // Remove the item from the list
                            notifyDataSetChanged(); // Notify the adapter that the data set has changed
                            Toast.makeText(context, siswa.getNama() + " has been deleted", Toast.LENGTH_SHORT).show();
                        }
// Add additional else-if blocks for other menu items if necessary

//                        switch (menuItem.getItemId()){
//                            case R.id.menu_simpan:
//                                Toast.makeText(context, "simpan data"+siswa.getNama(),Toast.LENGTH_SHORT).show();
//                                break;
//                            case R.id.menu_hapus:
//                                siswaList.remove(i);
//                                notifyDataSetChanged();
//                                Toast.makeText(context, siswa.getNama()+"sudah di hapus",Toast.LENGTH_SHORT).show();
//                        }

                        return false;
                    }
                });
                };

                popupMenu.show();
            }
        }
    public int getItemCount() {
        return siswaList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNama, tvAlamat ,tvMenu;

        public ViewHolder(@NonNull View itemView){
            super (itemView);
            tvNama=itemView.findViewById(R.id.tvNama);
            tvAlamat=itemView.findViewById(R.id.tvAlamat);
            tvMenu=itemView.findViewById(R.id.tvMenu);
        }
    }
}
