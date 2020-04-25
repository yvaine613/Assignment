package au.edu.unsw.infs3634.assignmentui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import au.edu.unsw.infs3634.assignmentui.db.Question;


public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {
    private Context context;
    private List<Question> lessons;
    public ResultAdapter(Context context, List<Question> lessons) {
        this.context = context;
        this.lessons = lessons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_question, parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        holder.tv_title.setText(lessons.get(position).getName());
        holder.tv_collect.setText(lessons.get(position).getAnswer());
        if (lessons.get(position).getAnswer().equals(lessons.get(position).getEnglish())){
            holder.cardview.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        }else{
            holder.cardview.setBackgroundColor(ContextCompat.getColor(context,R.color.red));
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_collect;
        TextView tv_title;
        CardView cardview;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_collect = itemView.findViewById(R.id.tv_collect);tv_title = itemView.findViewById(R.id.tv_title);
            cardview = itemView.findViewById(R.id.cardview);
        }
    }

}
