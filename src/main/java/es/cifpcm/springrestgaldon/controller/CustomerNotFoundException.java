package es.cifpcm.springrestgaldon.controller;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String id){super("Could not find Customer " + id);}
}
