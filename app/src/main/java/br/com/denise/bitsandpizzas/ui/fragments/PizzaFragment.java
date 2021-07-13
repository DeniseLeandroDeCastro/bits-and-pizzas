package br.com.denise.bitsandpizzas.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import br.com.denise.bitsandpizzas.R;
import br.com.denise.bitsandpizzas.ui.fragments.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 */
public class PizzaFragment extends ListFragment {

    public PizzaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                // Set the adapter
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    inflater.getContext(),
                    android.R.layout.simple_list_item_1,
                    getResources().getStringArray(R.array.pizzas));
                setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}