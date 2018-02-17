package p000a.p005e.p007b;

/* renamed from: a.e.b.j */
public class C0044j {
    public String m66a(C0037g c0037g) {
        String obj = c0037g.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring("kotlin.jvm.functions.".length()) : obj;
    }
}
