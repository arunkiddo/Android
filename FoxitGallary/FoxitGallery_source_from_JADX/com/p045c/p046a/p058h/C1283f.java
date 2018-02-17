package com.p045c.p046a.p058h;

/* renamed from: com.c.a.h.f */
public class C1283f implements C1268b, C1281c {
    private C1268b f3215a;
    private C1268b f3216b;
    private C1281c f3217c;

    public C1283f() {
        this(null);
    }

    public C1283f(C1281c c1281c) {
        this.f3217c = c1281c;
    }

    private boolean m6049j() {
        return this.f3217c == null || this.f3217c.m6043a(this);
    }

    private boolean m6050k() {
        return this.f3217c == null || this.f3217c.m6044b(this);
    }

    private boolean m6051l() {
        return this.f3217c != null && this.f3217c.m6046c();
    }

    public void m6052a() {
        this.f3215a.m5980a();
        this.f3216b.m5980a();
    }

    public void m6053a(C1268b c1268b, C1268b c1268b2) {
        this.f3215a = c1268b;
        this.f3216b = c1268b2;
    }

    public boolean m6054a(C1268b c1268b) {
        return m6049j() && (c1268b.equals(this.f3215a) || !this.f3215a.m5986h());
    }

    public void m6055b() {
        if (!this.f3216b.m5984f()) {
            this.f3216b.m5981b();
        }
        if (!this.f3215a.m5984f()) {
            this.f3215a.m5981b();
        }
    }

    public boolean m6056b(C1268b c1268b) {
        return m6050k() && c1268b.equals(this.f3215a) && !m6058c();
    }

    public void m6057c(C1268b c1268b) {
        if (!c1268b.equals(this.f3216b)) {
            if (this.f3217c != null) {
                this.f3217c.m6045c(this);
            }
            if (!this.f3216b.m5985g()) {
                this.f3216b.m5982d();
            }
        }
    }

    public boolean m6058c() {
        return m6051l() || m6063h();
    }

    public void m6059d() {
        this.f3216b.m5982d();
        this.f3215a.m5982d();
    }

    public void m6060e() {
        this.f3215a.m5983e();
        this.f3216b.m5983e();
    }

    public boolean m6061f() {
        return this.f3215a.m5984f();
    }

    public boolean m6062g() {
        return this.f3215a.m5985g() || this.f3216b.m5985g();
    }

    public boolean m6063h() {
        return this.f3215a.m5986h() || this.f3216b.m5986h();
    }

    public boolean m6064i() {
        return this.f3215a.m5987i();
    }
}
