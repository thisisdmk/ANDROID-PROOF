package com.testing.android.proof.presentation.specialtylist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.testing.android.proof.R;
import com.testing.android.proof.domain.specialtylist.SpecialtyItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


public final class SpecialtyListAdapter extends ListAdapter<SpecialtyItem, SpecialtyListAdapter.SpecialtyViewHolder> {

    private final OnSpecialtyClickListener clickListener;

    public SpecialtyListAdapter(@NonNull OnSpecialtyClickListener clickListener) {
        super(new SpecialtyItemDiffCallback());
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public SpecialtyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SpecialtyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_specialty, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialtyViewHolder specialtyViewHolder, int position) {
        specialtyViewHolder.bind(getItem(position));
    }

    class SpecialtyViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewSpecialtyName;
        private final View.OnClickListener onClickListener = view -> clickListener.onSpecialtyClicked(getItem(getAdapterPosition()));

        SpecialtyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSpecialtyName = itemView.findViewById(R.id.text_view_specialty_item_name);
            itemView.setOnClickListener(onClickListener);
        }

        void bind(@Nullable final SpecialtyItem specialtyItem) {
            if (specialtyItem != null) {
                textViewSpecialtyName.setText(specialtyItem.getName());
            } else {
                textViewSpecialtyName.setText("");
            }
        }
    }

    public interface OnSpecialtyClickListener {
        void onSpecialtyClicked(@NonNull SpecialtyItem specialtyItem);
    }
}
