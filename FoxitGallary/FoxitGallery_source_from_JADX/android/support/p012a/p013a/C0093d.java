package android.support.p012a.p013a;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.a.a.d */
class C0093d {
    public static float m157a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !C0093d.m160a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static int m158a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0093d.m160a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static boolean m159a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !C0093d.m160a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static boolean m160a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int m161b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0093d.m160a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }
}
