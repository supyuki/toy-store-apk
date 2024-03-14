import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ToyAdapter extends RecyclerView.Adapter<ToyAdapter.ToyViewHolder> {

    private List<Toy> toyList;
    private OnItemClickListener listener;

    public ToyAdapter(List<Toy> toyList, OnItemClickListener listener) {
        this.toyList = toyList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ToyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_toy, parent, false);
        return new ToyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToyViewHolder holder, int position) {
        Toy toy = toyList.get(position);
        holder.bind(toy, listener);
    }

    @Override
    public int getItemCount() {
        return toyList.size();
    }

    static class ToyViewHolder extends RecyclerView.ViewHolder {

        private ImageView toyImage;
        private TextView toyName;

        public ToyViewHolder(@NonNull View itemView) {
            super(itemView);
            toyImage = itemView.findViewById(R.id.toyImage);
            toyName = itemView.findViewById(R.id.toyName);
        }

        public void bind(final Toy toy, final OnItemClickListener listener) {
            toyImage.setImageResource(toy.getImage());
            toyName.setText(toy.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(toy);
                }
            });
        }
    }

    interface OnItemClickListener {
        void onItemClick(Toy toy);
    }
}
