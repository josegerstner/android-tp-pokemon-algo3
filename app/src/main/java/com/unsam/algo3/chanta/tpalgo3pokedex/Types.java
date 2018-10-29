package com.unsam.algo3.chanta.tpalgo3pokedex;

import java.util.List;

/**
 * Created by Marcos on 21/11/2017.
 */

public class Types
{
    private Type type;

    private String slot;

    public Type getType ()
    {
        return type;
    }

    public void setType (Type type)
    {
        this.type = type;
    }

    public String getSlot ()
    {
        return slot;
    }

    public void setSlot (String slot)
    {
        this.slot = slot;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [type = "+type+", slot = "+slot+"]";
    }
}