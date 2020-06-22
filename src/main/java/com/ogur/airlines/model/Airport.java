package com.ogur.airlines.model;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    private Integer id ;

    @Column(name = "airport_name")
    private String name;

    @Column(name = "airport_code")
    private String code;

    @Column(name = "airport_city")
    private String city;

    public Airport( )
    {

    }

    public Integer getId( )
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName( )
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCode( )
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCity( )
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @Override
    public String toString( )
    {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
