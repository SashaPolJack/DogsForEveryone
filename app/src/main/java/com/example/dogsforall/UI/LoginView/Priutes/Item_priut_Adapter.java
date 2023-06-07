package com.example.dogsforall.UI.LoginView.Priutes;

public class Item_priut_Adapter {
    private String name;
    private String Image;
    private String description;
    private String count_dogs;
    private Integer count_dollars;
    private String take_dogs;

    public Item_priut_Adapter(String name, String image, String description, String count_dogs, Integer count_dollars, String take_dogs) {
        this.name = name;
        Image = image;
        this.description = description;
        this.count_dogs = count_dogs;
        this.count_dollars = count_dollars;
        this.take_dogs = take_dogs;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return Image;
    }

    public String getDescription() {
        return description;
    }

    public String getCount_dogs() {
        return count_dogs;
    }

    public Integer getCount_dollars() {
        return count_dollars;
    }

    public String getTake_dogs() {
        return take_dogs;
    }
}
