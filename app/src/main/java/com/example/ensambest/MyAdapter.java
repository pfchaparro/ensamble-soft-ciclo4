package com.example.ensambest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<ProductosCar> prodArrayList;

    public MyAdapter(Context context, ArrayList<ProductosCar> prodArrayList) {
        this.context = context;
        this.prodArrayList = prodArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.items_layout,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        ProductosCar productosCar = prodArrayList.get(position);
        holder.nombre.setText(productosCar.nombre);
        holder.descripcion.setText(productosCar.descripcion);
        holder.cantidad.setText(String.valueOf(productosCar.cantidad));
        holder.precio.setText(String.valueOf(productosCar.precio));
    }

    @Override
    public int getItemCount() {
        return prodArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nombre,cantidad,precio, descripcion;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.producto_nombreIL);
            cantidad = itemView.findViewById(R.id.producto_cantidad);
            precio = itemView.findViewById(R.id.producto_precio);
            descripcion = itemView.findViewById(R.id.producto_descripcion);
        }
    }
}
