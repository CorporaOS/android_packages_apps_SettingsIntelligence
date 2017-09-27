/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.service.settings.suggestions;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;

public class Suggestion {
    private final String mId;
    private final CharSequence mTitle;
    private final CharSequence mSummary;
    private final PendingIntent mPendingIntent;

    /**
     * Gets the id for the suggestion object.
     */
    public String getId() {
        return mId;
    }

    /**
     * Title of the suggestion that is shown to the user.
     */
    public CharSequence getTitle() {
        return mTitle;
    }

    /**
     * Optional summary describing what this suggestion controls.
     */
    public CharSequence getSummary() {
        return mSummary;
    }

    /**
     * The Intent to launch when the suggestion is activated.
     */
    public PendingIntent getPendingIntent() {
        return mPendingIntent;
    }

    private Suggestion(Builder builder) {
        mTitle = builder.mTitle;
        mSummary = builder.mSummary;
        mPendingIntent = builder.mPendingIntent;
        mId = builder.mId;
    }

    /**
     * Builder class for {@link Suggestion}.
     */
    public static class Builder {
        private final String mId;
        private CharSequence mTitle;
        private CharSequence mSummary;
        private PendingIntent mPendingIntent;

        public Builder(String id) {
            if (TextUtils.isEmpty(id)) {
                throw new IllegalArgumentException("Suggestion id cannot be empty");
            }
            mId = id;
        }

        /**
         * Sets suggestion title
         */

        public Builder setTitle(CharSequence title) {
            mTitle = title;
            return this;
        }

        /**
         * Sets suggestion summary
         */
        public Builder setSummary(CharSequence summary) {
            mSummary = summary;
            return this;
        }

        /**
         * Sets suggestion intent
         */
        public Builder setPendingIntent(PendingIntent pendingIntent) {
            mPendingIntent = pendingIntent;
            return this;
        }

        /**
         * Builds an immutable {@link Suggestion} object.
         */
        public Suggestion build() {
            return new Suggestion(this /* builder */);
        }
    }
}