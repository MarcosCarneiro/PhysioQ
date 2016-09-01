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
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.liulishuo.magicprogresswidget.MagicProgressBar;
import com.liulishuo.magicprogresswidget.MagicProgressCircle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.Date;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.activities.HomeActivity;
import br.com.stenio.physioq.activities.date.Dados;

public class ResultadoAofas extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_aofas);



        TextView nomea = (TextView) findViewById(R.id.nomeaofas);
        nomea.setText(Dados.ednome.getText());

        TextView pontosa = (TextView) findViewById(R.id.pontosaofas);
        pontosa.setText(Aofas.edresultotal.getText());

        TextView pdor = (TextView) findViewById(R.id.pdor);
        pdor.setText(Aofas.edresuldor.getText() + " pontos");

        TextView pfuncional = (TextView) findViewById(R.id.pfuncional);
        pfuncional.setText(Aofas.edresulfuncional.getText() + " pontos");

        TextView palinhamento = (TextView) findViewById(R.id.palinhamento);
        palinhamento.setText(Aofas.edresulalinhamento.getText() + " pontos");

        String stotal = Aofas.edresultotal.getText().toString();
        int itotal = new Integer(stotal).intValue();
        MagicProgressCircle mgpc = (MagicProgressCircle) findViewById(R.id.raofas);
        mgpc.setPercent(itotal / 100f);

        String sdor = Aofas.edresuldor.getText().toString();
        int idor = new Integer(sdor).intValue();
        MagicProgressBar mdor = (MagicProgressBar) findViewById(R.id.pgdor);
        mdor.setPercent(idor/40f);

        String sfuncional = Aofas.edresulfuncional.getText().toString();
        int ifuncional = new Integer(sfuncional).intValue();
        MagicProgressBar mfuncional = (MagicProgressBar) findViewById(R.id.pgfuncional);
        mfuncional.setPercent(ifuncional/50f);

        String salinhamento = Aofas.edresulalinhamento.getText().toString();
        int ialinhamento = new Integer(salinhamento).intValue();
        MagicProgressBar malinhamento = (MagicProgressBar) findViewById(R.id.alinhamento);
        malinhamento.setPercent(ialinhamento / 10f);

        FrameLayout fm = (FrameLayout) findViewById(R.id.novo);
        fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ResultadoAofas.this, HomeActivity.class);
                startActivity(it);

                finish();

            }
        });



    FrameLayout fp = (FrameLayout) findViewById(R.id.apdf);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ita = new Intent(ResultadoAofas.this, HomeActivity.class);
                startActivity(ita);
                geraPDF();
                Toast.makeText(ResultadoAofas.this, "PDF criado com sucesso!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });






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


            String dor =Aofas.edresuldor.getText().toString();
            String funcional =Aofas.edresulfuncional.getText().toString();
            String alinhamento =Aofas.edresulalinhamento.getText().toString();
            String total =Aofas.edresultotal.getText().toString();





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
            ColumnText.showTextAligned(cb1,Element.ALIGN_LEFT, new Phrase(cirurgia, chapterFont),85,651,0);


            //Questionário
            PdfContentByte cb = writer.getDirectContent();
            String strrb1 = (new StringBuilder().append("X")).toString();
            //Dor
            //nenhuma
            if ( Aofas.rbd1.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,508,0);}
            //leve
            if ( Aofas.rbd2.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,494,0);}
            //moderada
            if ( Aofas.rbd3.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,474,0);}
            //intensa
            if ( Aofas.rbd4.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,455,0);}

            //Funcional
            //Sem
            if ( Aofas.rbf1.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,365,0);}
            //Sem
            if ( Aofas.rbf2.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,348,0);}
            //limitação
            if ( Aofas.rbf3.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,293,0);}
            //limitação
            if ( Aofas.rbf4.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,258,0);}
 //distancia
            //mais
            if ( Aofas.rbdm1.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,148,0);}
            //de
            if ( Aofas.rbdm2.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,130,0);}
            //de
            if ( Aofas.rbdm3.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,114,0);}

            //superfícies
            //sem
            if ( Aofas.rbsc1.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,568,0);}
            //algumas
            if ( Aofas.rbsc2.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,548,0);}
            //dificuldades
            if ( Aofas.rbsc3.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,495,0);}
//anormalidades
            //nenhuma
            if ( Aofas.rbam1.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,424,0);}
            //evidente
            if ( Aofas.rbam2.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,403,0);}
            //acentuada
            if ( Aofas.rbam3.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,387,0);}
             //normal
            if ( Aofas.rbms1.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,350,0);}
            //restrição
            if ( Aofas.rbms2.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,314,0);}
             //restrição
            if ( Aofas.rbms3.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,295,0);}
            //normal
            if ( Aofas.rbmr1.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,260,0);}
            //restrição
            if ( Aofas.rbmr2.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,225,0);}
            //restrição
            if ( Aofas.rbmr3.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,188,0);}

            //estável
            if ( Aofas.rbe1.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,117,0);}
            //instavel
            if ( Aofas.rbe2.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),308,98,0);}


            //Paragrafo da html

            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(HtmlAofas.htmlaofas));


            //alinhamento
            //bom
            if ( Aofas.rba1.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,767,0);}
            //regular
            if ( Aofas.rba2.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,730,0);}
            //ruim
            if ( Aofas.rba3.isChecked()) {ColumnText.showTextAligned(cb,Element.ALIGN_LEFT, new Phrase(strrb1, chapterFont),47,677,0);}


            //dor
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(dor, chapterFont), 319, 530, 0);
            //funcional
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(funcional, chapterFont), 319, 505, 0);
            //alinhamento
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(alinhamento, chapterFont), 321, 480, 0);

            //total
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(total, chapterFont), 330, 429, 0);

            document.close();
        } catch (Exception e) {
            Log.i("PDFcreation", e.toString());
        }


        }





}
