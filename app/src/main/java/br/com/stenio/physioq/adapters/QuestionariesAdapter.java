package br.com.stenio.physioq.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.List;

import br.com.stenio.physioq.R;
import br.com.stenio.physioq.activities.HomeActivity;
import br.com.stenio.physioq.extras.ImageHelper;
import br.com.stenio.physioq.views.MyViewHolder;

public class QuestionariesAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> questionaryItens;
    private LayoutInflater mLayoutInflater;
    private MyViewHolder mViewHolder;
    private Context mContext;



    private float scale;
    private int width;
    private int height;

    public QuestionariesAdapter(Context context, List<String> list) {
        questionaryItens = list;
        mContext = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        scale = mContext.getResources().getDisplayMetrics().density;
        width = mContext.getResources().getDisplayMetrics().widthPixels - (int)(14 * scale + 0.5f);
        height = (width / 16) * 9;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_questionary_category, parent, false);
        mViewHolder = new MyViewHolder(view);

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.item_category_textView.setText(questionaryItens.get(position));

switch (position) {

    case 0 :
    Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ankle);
    bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
    //arredonda as bordas. O false de q ativa isso onde foi arredondada
    bitmap = ImageHelper.getRoundedCornerBitmap(mContext, bitmap, 4, width, height, false, false, true, true);
    holder.ivCar.setImageBitmap(bitmap);
        break;

    case 1 :
     bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.knee);
    bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
    //arredonda as bordas. O false de q ativa isso onde foi arredondada
    bitmap = ImageHelper.getRoundedCornerBitmap(mContext, bitmap, 4, width, height, false, false, true, true);
    holder.ivCar.setImageBitmap(bitmap);
        break;

    case 2 :
     bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.lowback);
    bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
    //arredonda as bordas. O false de q ativa isso onde foi arredondada
    bitmap = ImageHelper.getRoundedCornerBitmap(mContext, bitmap, 4, width, height, false, false, true, true);
    holder.ivCar.setImageBitmap(bitmap);
        break;
    case 3 :
        bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.shoulder);
        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        //arredonda as bordas. O false de q ativa isso onde foi arredondada
        bitmap = ImageHelper.getRoundedCornerBitmap(mContext, bitmap, 4, width, height, false, false, true, true);
        holder.ivCar.setImageBitmap(bitmap);
        break;
    case 4 :
        bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.elbow);
        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        //arredonda as bordas. O false de q ativa isso onde foi arredondada
        bitmap = ImageHelper.getRoundedCornerBitmap(mContext, bitmap, 4, width, height, false, false, true, true);
        holder.ivCar.setImageBitmap(bitmap);
        break;
    case 5 :
        bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.neck);
        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        //arredonda as bordas. O false de q ativa isso onde foi arredondada
        bitmap = ImageHelper.getRoundedCornerBitmap(mContext, bitmap, 4, width, height, false, false, true, true);
        holder.ivCar.setImageBitmap(bitmap);
        break;



}




        if(mContext instanceof HomeActivity) {
            try {
                YoYo.with(Techniques.RotateInUpLeft)
                        .duration(700)
                        .playOn(mViewHolder.itemView);
            } catch (Exception e){

            }
        } else {
            try {
                YoYo.with(Techniques.RotateInDownLeft)
                        .duration(700)
                        .playOn(mViewHolder.itemView);
            } catch (Exception e){

            }
        }
    }

    @Override
    public int getItemCount() {
        return questionaryItens.size();
    }
}
