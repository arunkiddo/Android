package android.support.v4.p030j;

/* renamed from: android.support.v4.j.i */
public final class C0394i {

    /* renamed from: android.support.v4.j.i.a */
    public interface C0392a<T> {
        T m1455a();

        boolean m1456a(T t);
    }

    /* renamed from: android.support.v4.j.i.b */
    public static class C0393b<T> implements C0392a<T> {
        private final Object[] f754a;
        private int f755b;

        public C0393b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f754a = new Object[i];
        }

        private boolean m1457b(T t) {
            for (int i = 0; i < this.f755b; i++) {
                if (this.f754a[i] == t) {
                    return true;
                }
            }
            return false;
        }

        public T m1458a() {
            if (this.f755b <= 0) {
                return null;
            }
            int i = this.f755b - 1;
            T t = this.f754a[i];
            this.f754a[i] = null;
            this.f755b--;
            return t;
        }

        public boolean m1459a(T t) {
            if (m1457b(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f755b >= this.f754a.length) {
                return false;
            } else {
                this.f754a[this.f755b] = t;
                this.f755b++;
                return true;
            }
        }
    }
}
