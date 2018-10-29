package com.unsam.algo3.chanta.tpalgo3pokedex;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;
import com.unsam.algo3.chanta.tpalgo3pokedex.dummy.DummyContent;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A fragment representing a single Pokedex detail screen.
 * This fragment is either contained in a {@link PokedexListActivity}
 * in two-pane mode (on tablets) or a {@link PokedexDetailActivity}
 * on handsets.
 */
public class PokedexDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    public static  String titulo = "";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PokedexDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
           // mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            titulo = getArguments().getString(ARG_ITEM_ID);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(titulo);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
 final       View rootView = inflater.inflate(R.layout.pokedex_detail, container, false);


        if (titulo != null) {
            ((TextView) rootView.findViewById(R.id.pokedex_detail)).setText(titulo);
        }



        Picasso.with(rootView.getContext())
                .load("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"+ titulo +".png")
                .into( (ImageView) rootView.findViewById(R.id.imagenPokemon));


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PokemonService pokemonService = retrofit.create(PokemonService.class);
        Call<PokemonDetalle> call = pokemonService.getIndividual(titulo);

        call.enqueue(new Callback<PokemonDetalle>() {
            @Override
            public void onResponse(Call<PokemonDetalle> call, Response<PokemonDetalle> response) {
                Response<PokemonDetalle> hola = response;
                Stats[] pokemonStats = response.body().getStats();
                Types[] pokemonTypes = response.body().getTypes();
                String name = response.body().getName();
                String id = response.body().getId();

               ((TextView) rootView.findViewById(R.id.pokedex_stat)).setText(pokemonStats[0].getStat().getName() + ":" + pokemonStats[0].getBase_stat() ) ;

            }

            @Override
            public void onFailure(Call<PokemonDetalle> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });


        return rootView;
    }
}
