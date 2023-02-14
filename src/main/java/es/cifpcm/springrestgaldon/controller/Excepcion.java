package es.cifpcm.springrestgaldon.controller;


class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String id) {
        super("Could not find employee " + id);
    }

}
