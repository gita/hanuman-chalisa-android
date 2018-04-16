package com.nandi.hanuman.chalisa.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nandi.hanuman.chalisa.R;


public class MainFragment extends Fragment {

    public static final int GANESH_JI = 1;
    public static final int HANUMAN_JI = 2;
    public static final int GAYATRI_MANTRA = 3;
    public static final int MAHA_MRITYUNJAYA = 4;
    public static final int SHIV_JI = 5;
    public static final int KRISHAN_JI = 6;
    public static final int LAXMI_JI = 7;
    public static final int KUBERA_JI = 8;
    public static final int SAI_BABA_JI = 9;
    public static final int MAHA_KALI = 10;
    public static final int SHANI_DEV = 11;

    private ImageView ganeshJiImage, hanumanJiImage, gayatriMantraImage, mahaMrityunjayaMantraImage,
            shivJiImage, krishanJiImage, laxmiJiImage, kuberaJiImage, saiBabaJiImage, mahaKaliImage, shaniDevImage;

    private static final String DRAWABLE = "DRAWABLE";

    public static MainFragment newInstance(int drawableID) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(DRAWABLE, drawableID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ganeshJiImage = (ImageView) view.findViewById(R.id.ganeshJiImage);
        Glide.with(this)
                .load(R.drawable.hanuman_1)
                .into(ganeshJiImage);
        hanumanJiImage = (ImageView) view.findViewById(R.id.hanumanJiImage);
        Glide.with(this)
                .load(R.drawable.hanuman)
                .into(hanumanJiImage);
        gayatriMantraImage = (ImageView) view.findViewById(R.id.gayatriMantraImage);
        Glide.with(this)
                .load(R.drawable.hanuman_7)
                .into(gayatriMantraImage);
        mahaMrityunjayaMantraImage = (ImageView) view.findViewById(R.id.mahaMrityunjayaMantraImage);
        Glide.with(this)
                .load(R.drawable.hanuman_3)
                .into(mahaMrityunjayaMantraImage);
        shivJiImage = (ImageView) view.findViewById(R.id.shivJiImage);
        Glide.with(this)
                .load(R.drawable.hanuman)
                .into(shivJiImage);
        krishanJiImage = (ImageView) view.findViewById(R.id.krishanJiImage);
        Glide.with(this)
                .load(R.drawable.hanuman)
                .into(krishanJiImage);
        laxmiJiImage = (ImageView) view.findViewById(R.id.laxmiJiImage);
        Glide.with(this)
                .load(R.drawable.hanuman_2)
                .into(laxmiJiImage);
        kuberaJiImage = (ImageView) view.findViewById(R.id.kuberaJiImage);
        Glide.with(this)
                .load(R.drawable.hanuman_5)
                .into(kuberaJiImage);
        saiBabaJiImage = (ImageView) view.findViewById(R.id.saiBabaJiImage);
        Glide.with(this)
                .load(R.drawable.hanuman)
                .into(saiBabaJiImage);
        mahaKaliImage = (ImageView) view.findViewById(R.id.mahaKaliImage);
        Glide.with(this)
                .load(R.drawable.hanuman_4)
                .into(mahaKaliImage);
        shaniDevImage = (ImageView) view.findViewById(R.id.shaniDevImage);
        Glide.with(this)
                .load(R.drawable.hanuman)
                .into(shaniDevImage);

        int godImage = getArguments().getInt(DRAWABLE, 0);
        switch (godImage) {
            case GANESH_JI:
                ganeshJiImage.setVisibility(View.VISIBLE);
                break;

            case HANUMAN_JI:
                hanumanJiImage.setVisibility(View.VISIBLE);
                break;
            case GAYATRI_MANTRA:
                gayatriMantraImage.setVisibility(View.VISIBLE);
                break;
            case MAHA_MRITYUNJAYA:
                mahaMrityunjayaMantraImage.setVisibility(View.VISIBLE);
                break;
            case SHIV_JI:
                shivJiImage.setVisibility(View.VISIBLE);
                break;
            case KRISHAN_JI:
                krishanJiImage.setVisibility(View.VISIBLE);
                break;
            case LAXMI_JI:
                laxmiJiImage.setVisibility(View.VISIBLE);
                break;
            case KUBERA_JI:
                kuberaJiImage.setVisibility(View.VISIBLE);
                break;
            case SAI_BABA_JI:
                saiBabaJiImage.setVisibility(View.VISIBLE);
                break;
            case MAHA_KALI:
                mahaKaliImage.setVisibility(View.VISIBLE);
                break;
            case SHANI_DEV:
                shaniDevImage.setVisibility(View.VISIBLE);
                break;
            default:
                ganeshJiImage.setVisibility(View.VISIBLE);
                break;
        }

        return view;
    }
}
