package minhhoang.fast.cleaner.batterysaver.Fragments;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import minhhoang.fast.cleaner.batterysaver.Alaram_Junk;
import minhhoang.fast.cleaner.batterysaver.MainActivity;
import com.minhhoang.fast.cleaner.batterysaver.R;
import minhhoang.fast.cleaner.batterysaver.Sacnning_Junk;

import java.util.Random;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by intag pc on 2/12/2017.
 */

public class JunkCleaner extends Fragment{

    ImageView mainbrush,cache,temp,residue,system;
    TextView maintext,cachetext,temptext,residuetext,systemtext;
    public static ImageView mainbutton;

    int checkvar=0;
    int alljunk;

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.junk_cleaner, container, false);
        mainbrush=(ImageView) view.findViewById(R.id.mainbrush);
        mainbutton=(ImageView) view.findViewById(R.id.mainbutton);
        cache=(ImageView) view.findViewById(R.id.cache);
        temp=(ImageView) view.findViewById(R.id.temp);
        residue=(ImageView) view.findViewById(R.id.residue);
        system=(ImageView) view.findViewById(R.id.system);


        maintext=(TextView) view.findViewById(R.id.maintext);
        cachetext=(TextView) view.findViewById(R.id.cachetext);
        temptext =(TextView) view.findViewById(R.id.temptext);
        residuetext =(TextView) view.findViewById(R.id.residuetext);
        systemtext =(TextView) view.findViewById(R.id.systemtext);

        try {

            sharedpreferences = getActivity().getSharedPreferences("waseem", Context.MODE_PRIVATE);


            if (sharedpreferences.getString("junk", "1").equals("1")) {
                mainbrush.setImageResource(R.drawable.junk_red);
                mainbutton.setImageResource(R.drawable.clean12);
                cache.setImageResource(R.drawable.cache4);
                temp.setImageResource(R.drawable.tem4);
                residue.setImageResource(R.drawable.res4);
                system.setImageResource(R.drawable.sys4);

                Random ran1 = new Random();
                final int proc1 = ran1.nextInt(20) + 5;

                Random ran2 = new Random();
                final int proc2 = ran2.nextInt(15) + 10;

                Random ran3 = new Random();
                final int proc3 = ran3.nextInt(30) + 15;

                Random ran4 = new Random();
                final int proc4 = ran4.nextInt(25) + 10;

                alljunk = proc1 + proc2 + proc3 + proc4;

                maintext.setText(alljunk + " MB");
                maintext.setTextColor(Color.parseColor("#000000"));

                cachetext.setText(proc1 + " MB");
                cachetext.setTextColor(Color.parseColor("#000000"));

                temptext.setText(proc2 + " MB");
                temptext.setTextColor(Color.parseColor("#000000"));

                residuetext.setText(proc3 + " MB");
                residuetext.setTextColor(Color.parseColor("#000000"));

                systemtext.setText(proc4 + " MB");
                systemtext.setTextColor(Color.parseColor("#000000"));

            } else {
                mainbrush.setImageResource(R.drawable.junk_blue12);
                mainbutton.setImageResource(R.drawable.cleaned2);
                cache.setImageResource(R.drawable.cache4);
                temp.setImageResource(R.drawable.tem4);
                residue.setImageResource(R.drawable.res4);
                system.setImageResource(R.drawable.sys4);


                maintext.setText("CRYSTAL CLEAR");
                maintext.setTextColor(Color.parseColor("#000000"));

                cachetext.setText(0 + " MB");
                cachetext.setTextColor(Color.parseColor("#000000"));

                temptext.setText(0 + " MB");
                temptext.setTextColor(Color.parseColor("#000000"));

                residuetext.setText(0 + " MB");
                residuetext.setTextColor(Color.parseColor("#000000"));

                systemtext.setText(0 + " MB");
                systemtext.setTextColor(Color.parseColor("#000000"));
            }


            mainbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (sharedpreferences.getString("junk", "1").equals("1")) {

                        Intent i = new Intent(getActivity(), Sacnning_Junk.class);
                        i.putExtra("junk", alljunk + "");
                        startActivity(i);

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Do something after 100ms


                                mainbrush.setImageResource(R.drawable.junk_blue12);
                                mainbutton.setImageResource(R.drawable.cleaned2);
                                cache.setImageResource(R.drawable.cache4);
                                temp.setImageResource(R.drawable.tem4);
                                residue.setImageResource(R.drawable.res4);
                                system.setImageResource(R.drawable.sys4);


                                maintext.setText("CRYSTAL CLEAR");
                                maintext.setTextColor(Color.parseColor("#000000"));

                                cachetext.setText(0 + " MB");
                                cachetext.setTextColor(Color.parseColor("#000000"));

                                temptext.setText(0 + " MB");
                                temptext.setTextColor(Color.parseColor("#000000"));

                                residuetext.setText(0 + " MB");
                                residuetext.setTextColor(Color.parseColor("#000000"));

                                systemtext.setText(0 + " MB");
                                systemtext.setTextColor(Color.parseColor("#000000"));


                                editor = sharedpreferences.edit();
                                editor.putString("junk", "0");
                                editor.commit();


                                Intent intent = new Intent(getActivity(), Alaram_Junk.class);

                                PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 0,
                                        intent, PendingIntent.FLAG_ONE_SHOT);

                                AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
                                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (600 * 1000), pendingIntent);

                            }
                        }, 2000);
                    } else {
//                        Toast.makeText(getActivity(), "No Junk Files ALready Cleaned.", Toast.LENGTH_LONG).show();

                        @SuppressLint("RestrictedApi") LayoutInflater inflater = getLayoutInflater(getArguments());
                        View layout = inflater.inflate(R.layout.my_toast, null);

                        ImageView image = (ImageView) layout.findViewById(R.id.image);

                        TextView text = (TextView) layout.findViewById(R.id.textView1);
                        text.setText("No Junk Files ALready Cleaned.");

                        Toast toast = new Toast(getActivity());
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 70);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(layout);
                        toast.show();
                    }
                }
            });


//            Random ran1 = new Random();
//            final int proc1 = ran1.nextInt(20) + 5;
//
//            Random ran2 = new Random();
//            final int proc2 = ran2.nextInt(15) + 10;
//
//            Random ran3 = new Random();
//            final int proc3 = ran3.nextInt(30) + 15;
//
//            Random ran4 = new Random();
//            final int proc4 = ran4.nextInt(25) + 10;
//
//            alljunk=proc1+proc2+proc3+proc4;
//
//            maintext.setText(alljunk+" MB");
//            maintext.setTextColor(Color.parseColor("#F22938"));
//
//            cachetext.setText(proc1+" MB");
//            cachetext.setTextColor(Color.parseColor("#F22938"));
//
//            temptext.setText(proc2+" MB");
//            temptext.setTextColor(Color.parseColor("#F22938"));
//
//            residuetext.setText(proc3+" MB");
//            residuetext.setTextColor(Color.parseColor("#F22938"));
//
//            systemtext.setText(proc4+" MB");
//            systemtext.setTextColor(Color.parseColor("#F22938"));

        }
        catch (Exception e)
        {

        }

        return view;
    }


    @Override
    public boolean getUserVisibleHint() {

       //MainActivity.name.setText("Junk Cleaner");
        return getUserVisibleHint();

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);


        if (isVisibleToUser) {
            MainActivity.name.setText("Junk Cleaner");

        } else {

        }
    }
}
