package com.consumer.bnform.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.consumer.bnform.R;
import com.consumer.bnform.databinding.LowalertsItemListBinding;
import com.consumer.bnform.dto.RecallWithInjuriesAndImagesAndProducts;
import com.consumer.bnform.network.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class LowAlertAdapter extends RecyclerView.Adapter<LowAlertAdapter.LowAlertHolder> {

    private static final String TAG = LowAlertAdapter.class.getSimpleName();
    private List<RecallWithInjuriesAndImagesAndProducts> mRecallWithInjuriesAndImagesAndProducts = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    private LowalertsItemListBinding lowalertsItemListBinding;
    private Context mContext;

    public LowAlertAdapter(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(RecallWithInjuriesAndImagesAndProducts mRecallWithInjuriesAndImagesAndProducts);
    }

    @NonNull
    @Override
    public LowAlertAdapter.LowAlertHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Set layout inflater
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        //Set Context
        mContext = parent.getContext();

        //Set Binding
        lowalertsItemListBinding = DataBindingUtil.inflate(layoutInflater, R.layout.lowalerts_item_list, parent, false);

        return new LowAlertHolder(lowalertsItemListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LowAlertHolder holder, int position) {

        RecallWithInjuriesAndImagesAndProducts recallWithInjuriesAndImagesAndProducts = mRecallWithInjuriesAndImagesAndProducts.get(position);
        holder.bind(recallWithInjuriesAndImagesAndProducts, this);
    }

    @Override
    public int getItemCount() {
        //Check for size of zero
        if (mRecallWithInjuriesAndImagesAndProducts != null) {
            return mRecallWithInjuriesAndImagesAndProducts.size();
        }
        return Constants.EMPTY_RECALL_LIST;
    }

    public void setRecallWithInjuriesAndImagesAndProducts(List<RecallWithInjuriesAndImagesAndProducts> recallWithInjuriesAndImagesAndProducts) {
        Log.d(TAG, "setRecallWithInjuriesAndImagesAndProducts: " + recallWithInjuriesAndImagesAndProducts.size());
        this.mRecallWithInjuriesAndImagesAndProducts  = recallWithInjuriesAndImagesAndProducts;
        notifyDataSetChanged();
    }

    public class LowAlertHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LowalertsItemListBinding mLowalertsItemListBinding;


        public LowAlertHolder(@NonNull LowalertsItemListBinding mLowalertsItemListBinding) {
            super(mLowalertsItemListBinding.getRoot());
            this.mLowalertsItemListBinding = mLowalertsItemListBinding;
        }


        @Override
        public void onClick(View view) {
            int index = getLayoutPosition();
            RecallWithInjuriesAndImagesAndProducts recallWithInjuriesAndImagesAndProducts = mRecallWithInjuriesAndImagesAndProducts.get(index);
        }

        public void bind(RecallWithInjuriesAndImagesAndProducts recallWithInjuriesAndImagesAndProducts, LowAlertAdapter mlistener){

            //Set Text
            mLowalertsItemListBinding.title.setText(recallWithInjuriesAndImagesAndProducts.getRecall().getMTitle());
            mLowalertsItemListBinding.dateId.setText(recallWithInjuriesAndImagesAndProducts.getRecall().getMLastPublishDate());
            mLowalertsItemListBinding.description.setText(recallWithInjuriesAndImagesAndProducts.getRecall().getMDescription());

            //TODO this is where Piscao should handle image
            Picasso.get()
                    .load(recallWithInjuriesAndImagesAndProducts.getImagesList().get(0).getUrl())
                    .into(mLowalertsItemListBinding.imageView);

            // Evaluates the pending bindings, updating any Views that have expressions bound to
            // this is ran on the UI Thread
            mLowalertsItemListBinding.executePendingBindings();


            mLowalertsItemListBinding.imageView.setOnClickListener(image -> {
                mlistener.onItemClickListener.onClick(recallWithInjuriesAndImagesAndProducts);
            });
        }
    }
}
