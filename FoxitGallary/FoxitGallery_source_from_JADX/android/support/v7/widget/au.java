package android.support.v7.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

class au extends Resources {
    private final Resources f2279a;

    public au(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2279a = resources;
    }

    public XmlResourceParser getAnimation(int i) {
        return this.f2279a.getAnimation(i);
    }

    public boolean getBoolean(int i) {
        return this.f2279a.getBoolean(i);
    }

    public int getColor(int i) {
        return this.f2279a.getColor(i);
    }

    public ColorStateList getColorStateList(int i) {
        return this.f2279a.getColorStateList(i);
    }

    public Configuration getConfiguration() {
        return this.f2279a.getConfiguration();
    }

    public float getDimension(int i) {
        return this.f2279a.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) {
        return this.f2279a.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) {
        return this.f2279a.getDimensionPixelSize(i);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f2279a.getDisplayMetrics();
    }

    public Drawable getDrawable(int i) {
        return this.f2279a.getDrawable(i);
    }

    public Drawable getDrawable(int i, Theme theme) {
        return this.f2279a.getDrawable(i, theme);
    }

    public Drawable getDrawableForDensity(int i, int i2) {
        return this.f2279a.getDrawableForDensity(i, i2);
    }

    public Drawable getDrawableForDensity(int i, int i2, Theme theme) {
        return this.f2279a.getDrawableForDensity(i, i2, theme);
    }

    public float getFraction(int i, int i2, int i3) {
        return this.f2279a.getFraction(i, i2, i3);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f2279a.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i) {
        return this.f2279a.getIntArray(i);
    }

    public int getInteger(int i) {
        return this.f2279a.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) {
        return this.f2279a.getLayout(i);
    }

    public Movie getMovie(int i) {
        return this.f2279a.getMovie(i);
    }

    public String getQuantityString(int i, int i2) {
        return this.f2279a.getQuantityString(i, i2);
    }

    public String getQuantityString(int i, int i2, Object... objArr) {
        return this.f2279a.getQuantityString(i, i2, objArr);
    }

    public CharSequence getQuantityText(int i, int i2) {
        return this.f2279a.getQuantityText(i, i2);
    }

    public String getResourceEntryName(int i) {
        return this.f2279a.getResourceEntryName(i);
    }

    public String getResourceName(int i) {
        return this.f2279a.getResourceName(i);
    }

    public String getResourcePackageName(int i) {
        return this.f2279a.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i) {
        return this.f2279a.getResourceTypeName(i);
    }

    public String getString(int i) {
        return this.f2279a.getString(i);
    }

    public String getString(int i, Object... objArr) {
        return this.f2279a.getString(i, objArr);
    }

    public String[] getStringArray(int i) {
        return this.f2279a.getStringArray(i);
    }

    public CharSequence getText(int i) {
        return this.f2279a.getText(i);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        return this.f2279a.getText(i, charSequence);
    }

    public CharSequence[] getTextArray(int i) {
        return this.f2279a.getTextArray(i);
    }

    public void getValue(int i, TypedValue typedValue, boolean z) {
        this.f2279a.getValue(i, typedValue, z);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) {
        this.f2279a.getValue(str, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        this.f2279a.getValueForDensity(i, i2, typedValue, z);
    }

    public XmlResourceParser getXml(int i) {
        return this.f2279a.getXml(i);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f2279a.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i) {
        return this.f2279a.obtainTypedArray(i);
    }

    public InputStream openRawResource(int i) {
        return this.f2279a.openRawResource(i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        return this.f2279a.openRawResource(i, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i) {
        return this.f2279a.openRawResourceFd(i);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.f2279a.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.f2279a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        if (this.f2279a != null) {
            this.f2279a.updateConfiguration(configuration, displayMetrics);
        }
    }
}
