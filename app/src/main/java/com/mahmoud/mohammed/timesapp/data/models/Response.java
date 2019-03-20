package com.mahmoud.mohammed.timesapp.data.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.mahmoud.mohammed.timesapp.data.models.Status.ERROR;
import static com.mahmoud.mohammed.timesapp.data.models.Status.LOADING;
import static com.mahmoud.mohammed.timesapp.data.models.Status.SUCCESS;


/**
 * Response holder provided to the UI
 */
public class Response {

    public final Status status;

    @Nullable
    public final ArticlesResponse data;

    @Nullable
    public final Throwable error;

    private Response(Status status, @Nullable ArticlesResponse data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static Response loading() {
        return new Response(LOADING, null, null);
    }

    public static Response success(@NonNull ArticlesResponse data) {
        return new Response(SUCCESS, data, null);
    }

    public static Response error(@NonNull Throwable error) {
        return new Response(ERROR, null, error);
    }
}
