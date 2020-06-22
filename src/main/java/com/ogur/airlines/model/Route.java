package com.ogur.airlines.model;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Integer id ;

    @Column(name = "route_from")
    private String from ;

    @Column(name = "route_to")
    private String to ;

    public Route()
    {

    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public String getTo()
    {
        return to;
    }

    public void setTo(String to)
    {
        this.to = to;
    }

    @Override
    public String toString( )
    {
        return "Route{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
