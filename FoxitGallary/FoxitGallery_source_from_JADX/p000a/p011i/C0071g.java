package p000a.p011i;

import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0037g;

/* renamed from: a.i.g */
public final class C0071g {

    /* renamed from: a.i.g.a */
    public static final class C0070a extends C0037g implements C0029b<T, Boolean> {
        final /* synthetic */ int f42a;

        C0070a(int i) {
            this.f42a = i;
            super(1);
        }

        public final boolean m95a(T t) {
            return (((C0067e) t).m93b() & this.f42a) == ((C0067e) t).m92a();
        }

        public /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(m95a((Enum) obj));
        }
    }
}
