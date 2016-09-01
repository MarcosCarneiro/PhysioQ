package br.com.stenio.physioq.activities.ankle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.liulishuo.magicprogresswidget.MagicProgressCircle;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.activities.HomeActivity;
import br.com.stenio.physioq.activities.date.Dados;

public class ResultadoLefs extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_lefs);

        TextView tvname = (TextView) findViewById(R.id.namelefs);
        tvname.setText(Dados.ednome.getText());

        TextView tvpontos = (TextView) findViewById(R.id.pontoslefs);
        tvpontos.setText(Lefs.tv.getText());

        String stg = Lefs.tv.getText().toString();
        int nIntFromET = new Integer(stg).intValue();

        MagicProgressCircle mgpc = (MagicProgressCircle) findViewById(R.id.demo_mpc);
        mgpc.setPercent(nIntFromET / 80f);


        FrameLayout fm = (FrameLayout) findViewById(R.id.novo);
        fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ResultadoLefs.this, HomeActivity.class);
                startActivity(it);
            }
        });

        FrameLayout fp = (FrameLayout) findViewById(R.id.lfpdf);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ita = new Intent(ResultadoLefs.this, HomeActivity.class);
                startActivity(ita);
                geraPDF();
                Toast.makeText(ResultadoLefs.this, "PDF criado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });




//on
    }


    public void geraPDF(){


        try {
            //O ENDEREÇO DA PASTA QUE SERÁ CRIADA NO SMARTPHONE
            File root = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/PhysioQ");

            if (!root.exists()){// SE A PASTA NÃO EXISTIR SERÁ CRIADA
                root.mkdirs();
            }

            //STRINGS QUE IRÃO PRO PDF

            ;
            String nome = Dados.ednome.getText().toString();
            String email =Dados.edemail.getText().toString();
            String tto =Dados.edtto.getText().toString();
            String membro =Dados.txtdominate.getText().toString();
            String data =Dados.eddata.getText().toString();
            String cirurgia =Dados.edcirurgia.getText().toString();





            String titulo = this.getString(R.string.titulo_aofas);
            String autor = this.getString(R.string.app_name);
            String separator = this.getString(R.string.separator);






            Date hora = new Date();//PEGA A DATE E HORA ATUAL.


            //NOME DO PDF
            String sdcardhtmlpath = root.getPath() + File.separator +nome+" - "+ titulo + " - "+hora + ".pdf";
            Log.i("endereco", sdcardhtmlpath);

            //ABRE O PDF
            Document document = new Document();
            PdfWriter writer =  PdfWriter.getInstance(document,
                    new FileOutputStream(sdcardhtmlpath));
            document.addAuthor(autor);
            document.addTitle(titulo);

            document.open();
            //add o font
            Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLDITALIC);
            Font red = FontFactory.getFont(FontFactory.HELVETICA, 24, Font.BOLDITALIC, BaseColor.RED);



            //Respostas do dados do pct
            PdfContentByte cb1 = writer.getDirectContent();
            //nome
            ColumnText.showTextAligned(cb1, Element.ALIGN_LEFT, new Phrase(nome, chapterFont), 78, 705, 0);
            //email
            ColumnText.showTextAligned(cb1,Element.ALIGN_LEFT, new Phrase(email, chapterFont),78,687,0);
            //data
            ColumnText.showTextAligned(cb1,Element.ALIGN_LEFT, new Phrase(data, chapterFont),154,669,0);
            //membro
            ColumnText.showTextAligned(cb1,Element.ALIGN_LEFT, new Phrase(membro, chapterFont),397,679,0);
            //tto
            ColumnText.showTextAligned(cb1,Element.ALIGN_LEFT, new Phrase(tto, chapterFont),424,664,0);
            //cirurgia
            ColumnText.showTextAligned(cb1, Element.ALIGN_LEFT, new Phrase(cirurgia, chapterFont),85,651,0);










            document.close();
        } catch (Exception e) {
            Log.i("PDFcreation", e.toString());
        }


    }






}
