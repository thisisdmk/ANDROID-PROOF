package com.testing.android.proof.domain.specialtylist;

import java.util.List;

import io.reactivex.Flowable;

public interface SpecialtyListRepository {
    Flowable<? extends List<? extends Specialty>> loadSpecialties();
}
