package br.com.denise.bitsandpizzas.ui;

import br.com.denise.bitsandpizzas.R;

import static br.com.denise.bitsandpizzas.R.drawable.lasagne;

public class Pasta {

    private String name;
    private int imageResourceId;

    public static final Pasta[] pastas = new Pasta[]{
            new Pasta("Spaghetti Bolognese", R.drawable.spaghetti_bolognese),
            new Pasta("Lasagne", lasagne)
    };

    public Pasta(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
