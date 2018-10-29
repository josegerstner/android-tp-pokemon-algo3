package com.unsam.algo3.chanta.tpalgo3pokedex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.*;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.unsam.algo3.chanta.tpalgo3pokedex.dummy.DummyContent;

import java.util.List;

/**
 * Created by marcos on 13/11/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.PokemonViewHolder> {

    private List<Result> listaPokemon;
    private int rowLayout;

    private Context context;



    public MainAdapter(List<Result> results, int rowLayout, Context context) {
        this.listaPokemon = results;

        this.rowLayout = rowLayout;

        this.context = context;
    }

    public void swap(List<Result> newList) {
        listaPokemon.clear();
        listaPokemon.addAll(newList);
        notifyDataSetChanged();

    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pokedex_list_content, parent, false));
    }

    @Override
    public void onBindViewHolder(final PokemonViewHolder holder, final int position) {
        final Result pokemon = listaPokemon.get(position);
        holder.nombrePokemonTextView.setText(pokemon.getName());
        holder.mContentView.setText(String.format("%03d", position+1) );

        Picasso.with(context)
                .load("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"+String.format("%03d", position+1) +".png")
                .into(holder.imagenPokemon);

         final PokedexListActivity mParentActivity;

        holder.nombrePokemonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Context context = v.getContext();
                    Intent intent = new Intent(context, PokedexDetailActivity.class);
                    intent.putExtra(PokedexDetailFragment.ARG_ITEM_ID, holder.mContentView.getText() );

                    context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPokemon.size();
    }
    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView nombrePokemonTextView;
        ImageView imagenPokemon;
        final TextView mContentView;
        public PokemonViewHolder(View itemView) {
            super(itemView);
            nombrePokemonTextView = (TextView)itemView.findViewById(R.id.id_text);
            imagenPokemon = (ImageView)itemView.findViewById(R.id.id_imagenPokemon);
            mContentView = (TextView) itemView.findViewById(R.id.content);

        }
    }
}