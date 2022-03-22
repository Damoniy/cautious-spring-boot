package net.damoniy.javaspringboot.utils;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class URIBuilder {
    private static String path;
    private static Long id;

    private static URIBuilder builder = new URIBuilder();

    public static URIBuilder setPath(String prefix) {
        path = prefix;
        return builder;
    }

    public URIBuilder setId(Long id) {
        this.id = id;
        return builder;
    }

    public URI build() {
        System.out.println(String.format("/s//d", path, id));
        return UriComponentsBuilder.fromPath(String.format("/s//d", path, id)).build().toUri();
    }
}
