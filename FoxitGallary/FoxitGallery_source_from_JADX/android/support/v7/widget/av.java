package android.support.v7.widget;

class av {
    private int f2280a;
    private int f2281b;
    private int f2282c;
    private int f2283d;
    private int f2284e;
    private int f2285f;
    private boolean f2286g;
    private boolean f2287h;

    av() {
        this.f2280a = 0;
        this.f2281b = 0;
        this.f2282c = Integer.MIN_VALUE;
        this.f2283d = Integer.MIN_VALUE;
        this.f2284e = 0;
        this.f2285f = 0;
        this.f2286g = false;
        this.f2287h = false;
    }

    public int m4718a() {
        return this.f2280a;
    }

    public void m4719a(int i, int i2) {
        this.f2282c = i;
        this.f2283d = i2;
        this.f2287h = true;
        if (this.f2286g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f2280a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f2281b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f2280a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2281b = i2;
        }
    }

    public void m4720a(boolean z) {
        if (z != this.f2286g) {
            this.f2286g = z;
            if (!this.f2287h) {
                this.f2280a = this.f2284e;
                this.f2281b = this.f2285f;
            } else if (z) {
                this.f2280a = this.f2283d != Integer.MIN_VALUE ? this.f2283d : this.f2284e;
                this.f2281b = this.f2282c != Integer.MIN_VALUE ? this.f2282c : this.f2285f;
            } else {
                this.f2280a = this.f2282c != Integer.MIN_VALUE ? this.f2282c : this.f2284e;
                this.f2281b = this.f2283d != Integer.MIN_VALUE ? this.f2283d : this.f2285f;
            }
        }
    }

    public int m4721b() {
        return this.f2281b;
    }

    public void m4722b(int i, int i2) {
        this.f2287h = false;
        if (i != Integer.MIN_VALUE) {
            this.f2284e = i;
            this.f2280a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2285f = i2;
            this.f2281b = i2;
        }
    }

    public int m4723c() {
        return this.f2286g ? this.f2281b : this.f2280a;
    }

    public int m4724d() {
        return this.f2286g ? this.f2280a : this.f2281b;
    }
}
