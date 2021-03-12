package com.company;

public enum Country {
    RUSSIA("РОССИЯ", true),
    ENGLAND("АНГЛИЯ", false),
    USA("США", true),
    POLAND("ПОЛЬША", true);


    private final String ruName;
    private final boolean isOpen;

    Country(final String ruName, final boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        return this.name() + " (" + this.ruName + ")";
    }

    public String getRuName() {
        return ruName;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public static Country getByRuName(final String choiceCountry) throws NoSuchCountryException {
        Country[] country = Country.values();
        int count = 0;
        boolean isCountry = false;
        for (int i = 0; i < country.length; i++) {
            if (country[i].getRuName().equals(choiceCountry)) {
                count = i;
                isCountry = true;
            }

        }
        if (!isCountry) {
            throw new NoSuchCountryException("Страны " + choiceCountry + " не существует");
        }
        return country[count];

    }

}
