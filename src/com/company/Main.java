package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Country[] allCountries = Country.values();
        for (Country country : allCountries) {
            System.out.println(country);
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Введите страну");
        String choiceCountry = in.next();
        Country country = null;
        try {
            country = Country.valueOf(choiceCountry);
        } catch (NullPointerException e) {
            System.out.println("Наименование страны на английском не введено, проверяем русское название...");
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование страны на английском введено некорректно, проверяем русское название...");
        }
        if (country == null) {
            try {
                country = Country.getByRuName(choiceCountry);
            } catch (NoSuchCountryException e) {
                System.out.println("Страны '" + choiceCountry + "' не существует.");
            }
        }


        if (country != null) {
            boolean isCountryOpen = country.getIsOpen();
            if (isCountryOpen) {
                System.out.println(country.toString() + " открыта для посещения");
            } else {
                System.out.println(country.toString() + "закрыта для посещения");
            }
        }

    }
}