package com.testing.android.proof.presentation.specialtylist;

import com.testing.android.proof.domain.specialtylist.SpecialtyItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

class SpecialtyItemDiffCallback extends DiffUtil.ItemCallback<SpecialtyItem> {
    @Override
    public boolean areItemsTheSame(@NonNull SpecialtyItem specialtyItem, @NonNull SpecialtyItem anotherSpecialtyItem) {
        return specialtyItem.getName().equals(anotherSpecialtyItem.getName());
    }

    @Override
    public boolean areContentsTheSame(@NonNull SpecialtyItem specialtyItem, @NonNull SpecialtyItem anotherSpecialtyItem) {
        return specialtyItem.equals(anotherSpecialtyItem);
    }
}
