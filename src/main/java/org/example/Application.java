package org.example;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Application {

    public static void main(String[] args) {
        Faker faker = new Faker(Locale.ITALY);
        String f = faker.beer().hop();
        System.out.println(f);
    }
}
