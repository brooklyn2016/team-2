package net.codeforgood.sciencebehindsports.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import net.codeforgood.sciencebehindsports.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        VideoView videoView = (VideoView) rootView.findViewById(R.id.home_fragment_video);
        videoView.setVideoPath("android.resource://" + getActivity().getPackageName() + "/" + R.raw.sound_wave_demo);

        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        return rootView;
    }


    private void getProfileData(){

    }

}
