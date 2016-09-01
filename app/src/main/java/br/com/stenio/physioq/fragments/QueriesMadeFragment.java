package br.com.stenio.physioq.fragments;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.stenio.physioq.R;

public class QueriesMadeFragment extends Fragment {

    private ListView lv1;
    private String[] lv_arr;
    private ArrayList<String> arr;
    File sdCardRoot;
    private View rootview;





    @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){

             rootview = inflater.inflate(R.layout.fragment_queries_made, container, false);
            return rootview;
            //onCreateView
        }



    @Override
    public void onStart() {
        super.onStart();


                //ArrayList<String>

                arr = new ArrayList<String>();

                sdCardRoot = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/PhysioQ");
                Log.i("root on sd =", "" + sdCardRoot.getPath());


        if(sdCardRoot.exists()){
            File [] f = sdCardRoot.listFiles();
            if (f != null)
                for (int i = 0; i < f.length; i++) {
                    if (f[i].isFile()){
                        String name = f[i].getName();
                        arr.add(name);
                        Log.i("arr is empty?******", "" + arr.isEmpty());
                    }else {
                        Log.i("file", " no file");
                    }
                    Log.i("arr******", "" + arr.size());
                }

        }

/*

            for (File f : sdCardRoot.listFiles()) {
                if (f.isFile() ) {
                    String name = f.getName();
                    arr.add(name);
                    Log.i("arr is empty?******", "" + arr.isEmpty());
                } else {
                    Log.i("file", " no file");
                }
                Log.i("arr******", "" + arr.size());
            }
        */


                //Strings []

                lv_arr = new String[arr.size()];

                for (int i = 0; i < arr.size(); i++) {
                    lv_arr[i] = arr.get(i);
                }

                //ListView

                lv1 = (ListView) rootview.findViewById(R.id.ListView01);
                // By using setAdpater method in listview we an add string array in list.
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.item_salvos, R.id.Itemname, lv_arr);
                lv1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                lv1.setOnItemLongClickListener(deleteItem);
                lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String fileName = arr.get(position);
                        showPdf(fileName);


                    }
                });


            }



    @Override
    public void onPause() {
        super.onPause();
        if (isRemoving() && rootview != null) {
            ((ViewGroup) rootview).removeAllViews();
        }
    }


    private AdapterView.OnItemLongClickListener deleteItem =
            new AdapterView.OnItemLongClickListener()
            {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());

                    dialog.setCancelable(false);
                    dialog.setNegativeButton("Não", null);
                    dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            File[]  files = sdCardRoot.listFiles();
                            files[position].delete();
                            onStart();



                        }
                    });
                    dialog.setTitle("Atenção!");
                    dialog.setMessage("Deseija excluir esse arquivo?");
                    dialog.show();
                    return true;
                }
            };




    public void showPdf(String fileName)
    {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/PhysioQ", fileName);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

// Verify it resolves
        PackageManager packageManager = getActivity().getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        boolean isIntentSafe = activities.size() > 0;

// Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(intent);

        }
    }

//classe
}
