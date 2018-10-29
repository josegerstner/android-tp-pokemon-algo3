package com.unsam.algo3.chanta.tpalgo3pokedex;

import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
/**
 * Created by Marcos on 13/11/2017.
 */

public class Pokemon implements Serializable {
            String url;
            String name;
            String results;

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public  Pokemon(String url, String name){
                this.url = url;
                this.name = name;

    }
    public Pokemon(){}

    @Override
    public String toString() {
        return url + " (" + name + ")";
    }


    public void validar() {
        assertNotEmpty(this.url, "Url es requerido");
        assertNotEmpty(this.name, "name es requerido");
    }

    protected static void assertNotEmpty(String fieldValue, String message) {
        if (StringUtils.isEmpty(fieldValue)) try {
            throw new UserException(message);
        } catch (UserException e) {
            e.printStackTrace();
        }
    }
}
