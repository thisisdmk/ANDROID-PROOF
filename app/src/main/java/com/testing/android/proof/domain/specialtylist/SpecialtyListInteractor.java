package com.testing.android.proof.domain.specialtylist;

import java.util.List;

import io.reactivex.Flowable;

public interface SpecialtyListInteractor {
    Flowable<List<SpecialtyItem>> loadSpecialties();
}
