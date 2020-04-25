package au.edu.unsw.infs3634.assignmentui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import au.edu.unsw.infs3634.assignmentui.db.Comment;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private Context context;
    private List<Comment> mComments;
    public CommentAdapter(Context context, List<Comment> comments) {
        this.context = context;
        this.mComments = comments;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_comment, parent,false);
        return  new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Comment comment = mComments.get(position);
        holder.mtvTime.setText( comment.getTime());
        holder.mTvName.setText(comment.getContent());
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView mTvName;
        TextView mtvTime;
        public ViewHolder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_name);
            mtvTime = itemView.findViewById(R.id.tv_time);
        }
    }

}
