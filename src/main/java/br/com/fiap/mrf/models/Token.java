package br.com.fiap.mrf.models;

public record Token(
    String token,
    String type,
    String prefix
) {}