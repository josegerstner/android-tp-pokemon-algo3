package com.unsam.algo3.chanta.tpalgo3pokedex;

/**
 * Created by Marcos on 21/11/2017.
 */

public class Type
{
    private String name;

    private String url;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", url = "+url+"]";
    }
}
