package com.testing.android.proof;

import android.content.Context;

import com.testing.android.proof.data.DataModule;
import com.testing.android.proof.domain.DomainModule;
import com.testing.android.proof.presentation.ActivityBuilder;
import com.testing.android.proof.utils.rxschedulers.AndroidSchedulersProvider;
import com.testing.android.proof.utils.rxschedulers.SchedulersProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        DomainModule.class,
        DataModule.class,
        ActivityBuilder.class
})
final class AppModule {

    @Provides
    @Singleton
    Context provideContext(ProofApplication app) {
        return app;
    }

    @Provides
    @Singleton
    SchedulersProvider provideSchedulers() {
        return new AndroidSchedulersProvider();
    }
}
