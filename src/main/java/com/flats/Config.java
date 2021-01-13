/*
        package com.flats;

import javax.xml.ws.Endpoint;

import com.flats.Repositiries.Flats_Repository;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.cxf.jaxws.EndpointImpl;

public class Config {
    @Autowired
    private Flats_Repository mFR;

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new Flats_Repository());
        endpoint.publish("/");
        return (Endpoint) endpoint;
    }
}
*/