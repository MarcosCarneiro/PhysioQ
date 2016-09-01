package br.com.stenio.physioq.activities.knee;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.liulishuo.magicprogresswidget.MagicProgressCircle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.Date;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.activities.HomeActivity;
import br.com.stenio.physioq.activities.date.Dados;

public class ResultadoFulkerson extends AppCompatActivity {

    private Toolbar mToolbar;
    Button btnovoq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_fulkerson);

        TextView pt = (TextView) findViewById(R.id.pontos);
        pt.setText(Fulkerson.edresul.getText());

        String stg = Fulkerson.edresul.getText().toString();
        int nIntFromET = new Integer(stg).intValue();

        MagicProgressCircle mgpc = (MagicProgressCircle) findViewById(R.id.demo_mpc);
        mgpc.setPercent(nIntFromET/100f);

        FrameLayout fm = (FrameLayout) findViewById(R.id.novo);
        fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ResultadoFulkerson.this, HomeActivity.class);
                startActivity(it);
            }
        });

        FrameLayout fp = (FrameLayout) findViewById(R.id.fpdf);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ita = new Intent(ResultadoFulkerson.this, HomeActivity.class);
                startActivity(ita);
                geraPDF();
                Toast.makeText(ResultadoFulkerson.this, "PDF criado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });








//oncreatee
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
            String sex =Dados.txtviewsex.getText().toString();
            String cirurgia =Dados.edcirurgia.getText().toString();

            String resul = Fulkerson.edresul.getText().toString();


            String titulo = this.getString(R.string.titulo_fulkerson);
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
            ColumnText.showTextAligned(cb1, Element.ALIGN_LEFT, new Phrase(nome, chapterFont), 80, 727, 0);
            //email
            ColumnText.showTextAligned(cb1,Element.ALIGN_LEFT, new Phrase(email, chapterFont),78,712,0);
            //data
            ColumnText.showTextAligned(cb1,Element.ALIGN_LEFT, new Phrase(data, chapterFont),154,694,0);
            //membro
            ColumnText.showTextAligned(cb1,Element.ALIGN_LEFT, new Phrase(membro, chapterFont),361,695,0);
            //tto
            ColumnText.showTextAligned(cb1,Element.ALIGN_LEFT, new Phrase(tto, chapterFont),164,680,0);
            //cirurgia
            ColumnText.showTextAligned(cb1,Element.ALIGN_LEFT, new Phrase(cirurgia, chapterFont),314,680,0);
            //observação
            // ColumnText.showTextAligned(cb1,Element.ALIGN_LEFT, new Phrase(notas, chapterFont),54,629,0);




            //column TEST

            PdfContentByte cb = writer.getDirectContent();


            String strrb1 = (new StringBuilder().append("X")).toString();
            //Nunca
            if ( Fulkerson.p1_rb1_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),90,483,0);}
            //Leve
            if ( Fulkerson.p1_rb2_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),80,465,0);}
            //Intenso
            if ( Fulkerson.p1_rb3_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),95,449,0);}

            //Total
            if (Fulkerson.p2_rb1_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),80,399,0);}
            //Bengala
            if (Fulkerson.p2_rb2_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),150,382,0);}
            //Impo
            if (Fulkerson.p2_rb3_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),202,365,0);}

            //nunhul
            if (Fulkerson.p3_rb1_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),150,318,0);}
            //Levemente
            if (Fulkerson.p3_rb2_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),170,300,0);}
            //Um degrau
            if (Fulkerson.p3_rb3_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),162,285,0);}
            //Possivel
            if (Fulkerson.p3_rb4_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),110,268,0);}

            //Agachamento
            if (Fulkerson.p4_rb1_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),150,235,0);}
            //Levemente
            if (Fulkerson.p4_rb2_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),175,217,0);}
            //90 graus
            if (Fulkerson.p4_rb3_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),167,199,0);}
            //Impo
            if (Fulkerson.p4_rb4_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),112,185,0);}

            //Instabilidade
            if (Fulkerson.p5_rb1_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),385,490,0);}
            //Atividade
            if (Fulkerson.p5_rb2_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),435,475,0);}
            //Ocasionalmente
            if (Fulkerson.p5_rb3_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),505,457,0);}
            //Frequentemente
            if (Fulkerson.p5_rb4_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),505,440,0);}
            //Todou
            if (Fulkerson.p5_rb5_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),363,424,0);}

            //Dor
            if (Fulkerson.p6_rb1_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),367,375,0);}
            //Leve
            if (Fulkerson.p6_rb2_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),475,358,0);}
            //Moderado
            if (Fulkerson.p6_rb3_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),505,344,0);}
            //pesado
            if (Fulkerson.p6_rb4_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),489,323,0);}
            //1. km
            if (Fulkerson.p6_rb5_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),470,308,0);}
            //0.8 km
            if (Fulkerson.p6_rb6_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),470,292,0);}
            //Constante
            if (Fulkerson.p6_rb7_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),415,277,0);}

            //Inchaço
            if (Fulkerson.p7_rb1_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),359,227,0);}
            //leve
            if (Fulkerson.p7_rb2_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),340,210,0);}
            //pesados
            if (Fulkerson.p7_rb3_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),450,194,0);}
            //comuns
            if (Fulkerson.p7_rb4_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),437,175,0);}
            //Constantes
            if (Fulkerson.p7_rb5_fulk.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),370,160,0);}







            //Paragrafo da html

            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(HtmlFulkerson.html));

            //Resultado
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(resul, red), 280, 760, 0);



            document.close();
        } catch (Exception e) {
            Log.i("PDFcreation", e.toString());
        }

    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent chooseKneeActivity = new Intent(ResultadoFulkerson.this, KneeQuestionaryActivity.class);
            startActivity(chooseKneeActivity);
        }
        return true;
    }

    public void setupToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mToolbar.setTitle(R.string.fulk_result);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}