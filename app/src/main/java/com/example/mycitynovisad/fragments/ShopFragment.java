package com.example.mycitynovisad.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycitynovisad.R;
import com.example.mycitynovisad.adapters.ShopAdapter;
import com.example.mycitynovisad.objects.Attraction;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ShopFragment extends Fragment {

    private List<Attraction> attractions;

    private static final int SHOP = 3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_item, container, false );

        Objects.requireNonNull(getActivity()).setTitle( getString( R.string.shop ) );

        RecyclerView recyclerView = rootView.findViewById( R.id.recyclerview );
        int numberOfColumns = 2;
        GridLayoutManager layoutManager = new GridLayoutManager( getActivity(), numberOfColumns );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( layoutManager );

        attractions = new ArrayList<>();

        addAttractions();

        recyclerView.setAdapter( new ShopAdapter( getActivity(), attractions, SHOP ) );

        return rootView;
    }


    private void addAttractions() {
        attractions.add( new Attraction( R.drawable.promenada,
                getString( R.string.promenada ),
                getString( R.string.promenada_opis ),
                getString( R.string.promenada_adresa ),
                getString( R.string.promenada_transport ),
                getString( R.string.promenada_rVreme ) ) );
        attractions.add( new Attraction( R.drawable.merkator,
                getString( R.string.merkator ),
                getString( R.string.merkator_opis ),
                getString( R.string.merkator_adresa ),
                getString( R.string.merkator_transport ),
                getString( R.string.merkator_rVreme ) ) );
        attractions.add( new Attraction( R.drawable.big,
                getString( R.string.big ),
                getString( R.string.big_opis ),
                getString( R.string.big_adresa ),
                getString( R.string.big_transport ),
                getString( R.string.big_rVreme ) ) );
        attractions.add( new Attraction( R.drawable.bazar,
                getString( R.string.bazar ),
                getString( R.string.bazar_opis ),
                getString( R.string.bazar_adresa ),
                getString( R.string.bazar_transport ),
                getString( R.string.bazar_rVreme ) ) );
        attractions.add( new Attraction( R.drawable.nork,
                getString( R.string.nork ),
                getString( R.string.nork_opis ),
                getString( R.string.nork_adresa ),
                getString( R.string.nork_transport ),
                getString( R.string.nork_rVreme ) ) );
        attractions.add( new Attraction( R.drawable.elephant,
                getString( R.string.elephant ),
                getString( R.string.elephant_opis ),
                getString( R.string.elephant_adresa ),
                getString( R.string.elephant_transport ),
                getString( R.string.elephant_rVreme ) ) );
        attractions.add( new Attraction( R.drawable.pariski_magazin,
                getString( R.string.pariski_magazin ),
                getString( R.string.pariski_magazin_opis ),
                getString( R.string.pariski_magazin_adresa ),
                getString( R.string.pariski_magazin_transport ),
                getString( R.string.pariski_magazin_rVreme ) ) );
    }
}
