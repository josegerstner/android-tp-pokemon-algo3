package com.unsam.algo3.chanta.tpalgo3pokedex;

import com.unsam.algo3.chanta.tpalgo3pokedex.Result;

import java.util.List;

/**
 * Created by Marcos on 21/11/2017.
 */

public class Stats
{
    private String base_stat;

    private String effort;

    private Stat stat;

    public String getBase_stat ()
    {
        return base_stat;
    }

    public void setBase_stat (String base_stat)
    {
        this.base_stat = base_stat;
    }

    public String getEffort ()
    {
        return effort;
    }

    public void setEffort (String effort)
    {
        this.effort = effort;
    }

    public Stat getStat ()
    {
        return stat;
    }

    public void setStat (Stat stat)
    {
        this.stat = stat;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [base_stat = "+base_stat+", effort = "+effort+", stat = "+stat+"]";
    }
}