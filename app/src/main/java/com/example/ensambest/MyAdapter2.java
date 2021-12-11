package com.example.ensambest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {

    Context context2;
    ArrayList<ProductosCar> prodArrayList2;

    public MyAdapter2(Context context, ArrayList<ProductosCar> prodArrayList) {
        this.context2 = context;
        this.prodArrayList2 = prodArrayList;
    }

    @NonNull
    @Override
    public MyAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context2).inflate(R.layout.item_layout2,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyViewHolder holder, int position) {

        ProductosCar productosCar = prodArrayList2.get(position);
        holder.nombre.setText(productosCar.nombre);
        holder.descripcion.setText(productosCar.descripcion);
        holder.cantidad.setText(String.valueOf(productosCar.cantidad));
        holder.precio.setText(String.valueOf(productosCar.precio));
    }

    @Override
    public int getItemCount() {
        return prodArrayList2.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nombre,cantidad,precio,descripcion;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.producto_nombreIL);
            cantidad = itemView.findViewById(R.id.producto_cantidad);
            precio = itemView.findViewById(R.id.producto_precio);
            descripcion = itemView.findViewById(R.id.producto_descripcion);
        }
    }
}
