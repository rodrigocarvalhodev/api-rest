package net.rodrigocarvalho.apirest.service;

public interface Mapper<A, B> {

    B map(A input);

}
