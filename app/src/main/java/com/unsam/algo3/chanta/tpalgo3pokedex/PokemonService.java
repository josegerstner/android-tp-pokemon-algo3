package com.unsam.algo3.chanta.tpalgo3pokedex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Marcos on 13/11/2017.
 */

public interface PokemonService {
    @GET("pokemon")
    public Call<PokemonFeed> getPokemon();

    @GET("pokemon/{numero}")
    public Call<PokemonDetalle> getIndividual(@Path(value = "numero", encoded = true) String numero);

}
