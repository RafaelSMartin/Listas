package com.rafaels.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = new ArrayList<>();

        for(int i = 0; i < 266; i++){
            list.add(String.valueOf(i));
        }

        List<List<String>> newList =  chopped(list, 256);

        // Lista Original
        Log.d("ListasLog0", list.toString());
        Log.d("ListasLog0", list.size()+"");//266
        // Lista entera separada en 256 elmentos
        Log.d("ListasLog1", newList.toString());
        Log.d("ListasLog1", newList.size()+"");//2
        Log.d("ListasLog1", newList.get(0).size()+"");//256
        Log.d("ListasLog1", newList.get(0).toString()+"");
        Log.d("ListasLog1", newList.get(1).size()+"");//10
        Log.d("ListasLog1", newList.get(1).toString()+"");

        for(int i = 0; i < newList.size(); i++){
            for(int j = 0; j < newList.get(i).size(); j++){
                Log.d("ListasLog2", "Pos List: "+i+" Pos dentro de List: "+j+" "
                        +newList.get(i).get(j));
            }
        }


    }

    // chops a list into non-view sublists of length L
    static <T> List<List<T>> chopped(List<T> list, final int L) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }
}
