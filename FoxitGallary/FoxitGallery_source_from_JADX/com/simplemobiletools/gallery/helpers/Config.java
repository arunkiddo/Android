package com.simplemobiletools.gallery.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import com.simplemobiletools.gallery.BuildConfig;
import com.simplemobiletools.gallery.C1333R;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import p000a.p005e.p007b.C0036f;

public final class Config {
    public static final Companion Companion;
    private final Context context;
    private final SharedPreferences mPrefs;

    public static final class Companion {
        private Companion() {
        }

        public final Config newInstance(Context context) {
            C0036f.m62b(context, "context");
            return new Config(null);
        }
    }

    static {
        Companion = new Companion();
    }

    private Config(Context context) {
        this.context = context;
        Object sharedPreferences = this.context.getSharedPreferences(ConstantsKt.getPREFS_KEY(), 0);
        C0036f.m59a(sharedPreferences, "context.getSharedPrefere\u2026EY, Context.MODE_PRIVATE)");
        this.mPrefs = sharedPreferences;
    }

    public final void addHiddenFolder(String str) {
        C0036f.m62b(str, "path");
        addHiddenFolders(new HashSet(Arrays.asList(new String[]{str})));
    }

    public final void addHiddenFolders(Set<String> set) {
        C0036f.m62b(set, "paths");
        HashSet hashSet = new HashSet(getHiddenFolders());
        hashSet.addAll(set);
        setHiddenFolders(hashSet);
    }

    public final void addPinnedFolders(Set<String> set) {
        C0036f.m62b(set, "paths");
        HashSet hashSet = new HashSet(getPinnedFolders());
        hashSet.addAll(set);
        setPinnedFolders(hashSet);
    }

    public final boolean getAutoplayVideos() {
        return this.mPrefs.getBoolean(ConstantsKt.getAUTOPLAY_VIDEOS(), false);
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getDirColumnCnt() {
        return this.mPrefs.getInt(ConstantsKt.getDIR_COLUMN_CNT(), this.context.getResources().getInteger(C1333R.integer.directory_columns));
    }

    public final int getDirectorySorting() {
        return this.mPrefs.getInt(ConstantsKt.getDIRECTORY_SORT_ORDER(), ConstantsKt.getSORT_BY_DATE_MODIFIED() | ConstantsKt.getSORT_DESCENDING());
    }

    public final boolean getDisplayFileNames() {
        return this.mPrefs.getBoolean(ConstantsKt.getDISPLAY_FILE_NAMES(), false);
    }

    public final Set<String> getHiddenFolders() {
        Object stringSet = this.mPrefs.getStringSet(ConstantsKt.getHIDDEN_FOLDERS(), new HashSet());
        C0036f.m59a(stringSet, "mPrefs.getStringSet(HIDD\u2026LDERS, HashSet<String>())");
        return stringSet;
    }

    public final boolean getIsFolderHidden(String str) {
        C0036f.m62b(str, "path");
        return getHiddenFolders().contains(str);
    }

    public final int getMediaColumnCnt() {
        return this.mPrefs.getInt(ConstantsKt.getMEDIA_COLUMN_CNT(), this.context.getResources().getInteger(C1333R.integer.media_columns));
    }

    public final Set<String> getPinnedFolders() {
        Object stringSet = this.mPrefs.getStringSet(ConstantsKt.getPINNED_FOLDERS(), new HashSet());
        C0036f.m59a(stringSet, "mPrefs.getStringSet(PINN\u2026LDERS, HashSet<String>())");
        return stringSet;
    }

    public final boolean getShowAll() {
        return this.mPrefs.getBoolean(ConstantsKt.getSHOW_ALL(), false);
    }

    public final boolean getShowHiddenFolders() {
        return this.mPrefs.getBoolean(ConstantsKt.getSHOW_HIDDEN_FOLDERS(), false);
    }

    public final int getShowMedia() {
        return this.mPrefs.getInt(ConstantsKt.getSHOW_MEDIA(), ConstantsKt.getIMAGES_AND_VIDEOS());
    }

    public final int getSorting() {
        return isSameSorting() ? getDirectorySorting() : this.mPrefs.getInt(ConstantsKt.getSORT_ORDER(), ConstantsKt.getSORT_BY_DATE_MODIFIED() | ConstantsKt.getSORT_DESCENDING());
    }

    public final String getTreeUri() {
        Object string = this.mPrefs.getString(ConstantsKt.getTREE_URI(), BuildConfig.FLAVOR);
        C0036f.m59a(string, "mPrefs.getString(TREE_URI, \"\")");
        return string;
    }

    public final boolean isDarkTheme() {
        return this.mPrefs.getBoolean(ConstantsKt.getIS_DARK_THEME(), true);
    }

    public final boolean isFirstRun() {
        return this.mPrefs.getBoolean(ConstantsKt.getIS_FIRST_RUN(), true);
    }

    public final boolean isSameSorting() {
        return this.mPrefs.getBoolean(ConstantsKt.getIS_SAME_SORTING(), true);
    }

    public final void removeHiddenFolder(String str) {
        C0036f.m62b(str, "path");
        removeHiddenFolders(new HashSet(Arrays.asList(new String[]{str})));
    }

    public final void removeHiddenFolders(Set<String> set) {
        C0036f.m62b(set, "paths");
        HashSet hashSet = new HashSet(getHiddenFolders());
        hashSet.removeAll(set);
        setHiddenFolders(hashSet);
    }

    public final void removePinnedFolders(Set<String> set) {
        C0036f.m62b(set, "paths");
        HashSet hashSet = new HashSet(getPinnedFolders());
        hashSet.removeAll(set);
        setPinnedFolders(hashSet);
    }

    public final void setAutoplayVideos(boolean z) {
        this.mPrefs.edit().putBoolean(ConstantsKt.getAUTOPLAY_VIDEOS(), z).apply();
    }

    public final void setDarkTheme(boolean z) {
        this.mPrefs.edit().putBoolean(ConstantsKt.getIS_DARK_THEME(), z).apply();
    }

    public final void setDirColumnCnt(int i) {
        this.mPrefs.edit().putInt(ConstantsKt.getDIR_COLUMN_CNT(), i).apply();
    }

    public final void setDirectorySorting(int i) {
        this.mPrefs.edit().putInt(ConstantsKt.getDIRECTORY_SORT_ORDER(), i).apply();
    }

    public final void setDisplayFileNames(boolean z) {
        this.mPrefs.edit().putBoolean(ConstantsKt.getDISPLAY_FILE_NAMES(), z).apply();
    }

    public final void setFirstRun(boolean z) {
        this.mPrefs.edit().putBoolean(ConstantsKt.getIS_FIRST_RUN(), z).apply();
    }

    public final void setHiddenFolders(Set<String> set) {
        C0036f.m62b(set, "hiddenFolders");
        this.mPrefs.edit().remove(ConstantsKt.getHIDDEN_FOLDERS()).putStringSet(ConstantsKt.getHIDDEN_FOLDERS(), set).apply();
    }

    public final void setMediaColumnCnt(int i) {
        this.mPrefs.edit().putInt(ConstantsKt.getMEDIA_COLUMN_CNT(), i).apply();
    }

    public final void setPinnedFolders(Set<String> set) {
        C0036f.m62b(set, "pinnedFolders");
        this.mPrefs.edit().putStringSet(ConstantsKt.getPINNED_FOLDERS(), set).apply();
    }

    public final void setSameSorting(boolean z) {
        this.mPrefs.edit().putBoolean(ConstantsKt.getIS_SAME_SORTING(), z).apply();
    }

    public final void setShowAll(boolean z) {
        this.mPrefs.edit().putBoolean(ConstantsKt.getSHOW_ALL(), z).apply();
    }

    public final void setShowHiddenFolders(boolean z) {
        this.mPrefs.edit().putBoolean(ConstantsKt.getSHOW_HIDDEN_FOLDERS(), z).apply();
    }

    public final void setShowMedia(int i) {
        this.mPrefs.edit().putInt(ConstantsKt.getSHOW_MEDIA(), i).apply();
    }

    public final void setSorting(int i) {
        if (isSameSorting()) {
            setDirectorySorting(i);
        } else {
            this.mPrefs.edit().putInt(ConstantsKt.getSORT_ORDER(), i).apply();
        }
    }

    public final void setTreeUri(String str) {
        C0036f.m62b(str, "uri");
        this.mPrefs.edit().putString(ConstantsKt.getTREE_URI(), str).apply();
    }
}
