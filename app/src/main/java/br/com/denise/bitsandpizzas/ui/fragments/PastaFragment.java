package br.com.denise.bitsandpizzas.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.denise.bitsandpizzas.R;
import br.com.denise.bitsandpizzas.ui.CaptionedImagesAdapter;
import br.com.denise.bitsandpizzas.ui.Pasta;
import br.com.denise.bitsandpizzas.ui.activity.PastaDetailActivity;

/**
 * A fragment representing a list of Items.
 */
public class PastaFragment extends Fragment {

    public PastaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView pastaRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_pasta, container, false);

        //Array de string para os nomes das pastas
        String[] pastaNames = new String[Pasta.pastas.length];
        for(int i = 0; i < pastaNames.length; i++) {
            pastaNames[i] = Pasta.pastas[i].getName();
        }

        //Array de ints para as imagens das pastas
        int[] pastaImages = new int[Pasta.pastas.length];
        for(int i = 0; i < pastaImages.length; i++) {
            pastaImages[i] = Pasta.pastas[i].getImageResourceId();
        }

        //Transmitindo os arrays ao adapter
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pastaNames, pastaImages);
        pastaRecycler.setAdapter(adapter);
        //Exibir os cardViews
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pastaRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PastaDetailActivity.class);
                intent.putExtra(PastaDetailActivity.EXTRA_PASTA_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return pastaRecycler;
    }
}