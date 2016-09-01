package br.com.stenio.physioq.provider;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by viniciusthiengo on 6/21/15.
 */

public class SearchableProvider extends SearchRecentSuggestionsProvider {
    public final static String AUTHORITY = "provider.SearchableProvider";

    public final static int MODE = DATABASE_MODE_QUERIES | DATABASE_MODE_2LINES;

    public SearchableProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}