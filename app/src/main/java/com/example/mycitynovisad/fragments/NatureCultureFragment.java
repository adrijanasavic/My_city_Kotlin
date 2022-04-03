package com.example.mycitynovisad.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycitynovisad.R;
import com.example.mycitynovisad.adapters.RecyclerAdapter;
import com.example.mycitynovisad.objects.Attraction;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class NatureCultureFragment extends Fragment {

    private List<Attraction> attractions;

    private static final int NATURE_AND_CULTURE = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_item, container, false );

        Objects.requireNonNull(getActivity()).setTitle( getString( R.string.nature_and_culture ) );

        RecyclerView recyclerView = rootView.findViewById( R.id.recyclerview );
        LinearLayoutManager layoutManager = new LinearLayoutManager( getActivity() );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( layoutManager );

        attractions = new ArrayList<>();

        addAttractions();

        recyclerView.setAdapter( new RecyclerAdapter( getActivity(), attractions, NATURE_AND_CULTURE ) );

        return rootView;
    }

    private void addAttractions() {
        attractions.add( new Attraction( R.drawable.katedrala,
                getString( R.string.katedrala ),
                getString( R.string.katedrala_opis ),
                getString( R.string.katedrala_detail_opis ),
                getString( R.string.katedrala_adresa ),
                getString( R.string.katedrala_transport ),
                getString( R.string.katedrala_telefon ),
                getString( R.string.katedrala_web ),
                getString( R.string.katedrala_rVreme ),
                getString( R.string.katedrala_cena ) ) );
        attractions.add( new Attraction( R.drawable.fruska_gora,
                getString( R.string.fruska_gora ),
                getString( R.string.fruska_gora_opis ),
                getString( R.string.fruska_gora_detail_opis ),
                getString( R.string.fruska_gora_adresa ),
                getString( R.string.fruska_gora_transport ),
                getString( R.string.fruska_gora_telefon ),
                getString( R.string.fruska_gora_web ),
                getString( R.string.fruska_gora_rVreme ),
                getString( R.string.fruska_gora_cena ) ) );
        attractions.add( new Attraction( R.drawable.svetozar_miletic,
                getString( R.string.spomenik_sMiletic ),
                getString( R.string.spomenik_sMiletic_opis ),
                getString( R.string.spomenik_sMiletic_detalji_opis ),
                getString( R.string.spomenik_sMiletic_adresa ),
                getString( R.string.spomenik_sMiletic_trasport ),
                getString( R.string.spomenik_sMiletic_telefon ),
                getString( R.string.spomenik_sMiletic_web ),
                getString( R.string.spomenik_sMiletic_rVreme ),
                getString( R.string.spomenik_sMiletic_cena ) ) );
        attractions.add( new Attraction( R.drawable.srpsko_narodno_pozoriste,
                getString( R.string.srpsko_narodno_pozoriste ),
                getString( R.string.srpsko_narodno_pozoriste_opis ),
                getString( R.string.srpsko_narodno_pozoriste_detalji_opis ),
                getString( R.string.srpsko_narodno_pozoriste_adresa ),
                getString( R.string.srpsko_narodno_pozoriste_trasport ),
                getString( R.string.srpsko_narodno_pozoriste_telefon ),
                getString( R.string.srpsko_narodno_pozoriste_web ),
                getString( R.string.srpsko_narodno_pozoriste_rVreme ),
                getString( R.string.srpsko_narodno_pozoriste_cena ) ) );
        attractions.add( new Attraction( R.drawable.zrtvama_racije,
                getString( R.string.zrtvama_racije ),
                getString( R.string.zrtvama_racije_opis ),
                getString( R.string.zrtvama_racije_detalji_opis ),
                getString( R.string.zrtvama_racije_adresa ),
                getString( R.string.zrtvama_racije_trasport ),
                getString( R.string.zrtvama_racije_telefon ),
                getString( R.string.zrtvama_racije_web ),
                getString( R.string.zrtvama_racije_rVreme ),
                getString( R.string.zrtvama_racije_cena ) ) );
        attractions.add( new Attraction( R.drawable.matica_srpska,
                getString( R.string.matica_srpska ),
                getString( R.string.matica_srpska_opis ),
                getString( R.string.matica_srpska_detalji_opis ),
                getString( R.string.matica_srpska_adresa ),
                getString( R.string.matica_srpska_trasport ),
                getString( R.string.matica_srpska_telefon ),
                getString( R.string.matica_srpska_web ),
                getString( R.string.matica_srpska_rVreme ),
                getString( R.string.matica_srpska_cena ) ) );
    }
}
