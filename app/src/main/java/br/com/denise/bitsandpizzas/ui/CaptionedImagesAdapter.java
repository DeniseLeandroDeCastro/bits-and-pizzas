package br.com.denise.bitsandpizzas.ui;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import br.com.denise.bitsandpizzas.R;

public class CaptionedImagesAdapter extends
        RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {

    private String[] captions;
    private int[] imageIds;
    private Listener listener;

    public interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CaptionedImagesAdapter(String[] captions, int[] imageIds) {
        this.captions = captions;
        this.imageIds = imageIds;
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_image);
        Drawable drawable =
                ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        TextView textView = (TextView) cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }
}