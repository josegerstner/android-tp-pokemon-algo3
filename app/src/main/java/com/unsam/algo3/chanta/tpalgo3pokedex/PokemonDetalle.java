package com.unsam.algo3.chanta.tpalgo3pokedex;

import java.util.List;

/**
 * Created by Marcos on 21/11/2017.
 */

public class PokemonDetalle {

    private Types[] types;

    public Types[] getTypes() {
        return types;
    }

    public void setTypes(Types[] types) {
        this.types = types;
    }

    public Stats[] getStats() {
        return stats;
    }

    public void setStats(Stats[] stats) {
        this.stats = stats;
    }

    private Stats[] stats;
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
