package android.support.v7.widget;

import android.support.v7.widget.C0940f.C0939b;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.List;

class aq {
    final C0908a f2272a;

    /* renamed from: android.support.v7.widget.aq.a */
    interface C0908a {
        C0939b m4655a(int i, int i2, int i3, Object obj);

        void m4656a(C0939b c0939b);
    }

    public aq(C0908a c0908a) {
        this.f2272a = c0908a;
    }

    private void m4657a(List<C0939b> list, int i, int i2) {
        C0939b c0939b = (C0939b) list.get(i);
        C0939b c0939b2 = (C0939b) list.get(i2);
        switch (c0939b2.f2436a) {
            case C1373c.View_android_focusable /*1*/:
                m4659c(list, i, c0939b, i2, c0939b2);
            case C1373c.View_paddingStart /*2*/:
                m4661a(list, i, c0939b, i2, c0939b2);
            case C1373c.View_theme /*4*/:
                m4662b(list, i, c0939b, i2, c0939b2);
            default:
        }
    }

    private int m4658b(List<C0939b> list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((C0939b) list.get(size)).f2436a != 8) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }

    private void m4659c(List<C0939b> list, int i, C0939b c0939b, int i2, C0939b c0939b2) {
        int i3 = 0;
        if (c0939b.f2439d < c0939b2.f2437b) {
            i3 = -1;
        }
        if (c0939b.f2437b < c0939b2.f2437b) {
            i3++;
        }
        if (c0939b2.f2437b <= c0939b.f2437b) {
            c0939b.f2437b += c0939b2.f2439d;
        }
        if (c0939b2.f2437b <= c0939b.f2439d) {
            c0939b.f2439d += c0939b2.f2439d;
        }
        c0939b2.f2437b = i3 + c0939b2.f2437b;
        list.set(i, c0939b2);
        list.set(i2, c0939b);
    }

    void m4660a(List<C0939b> list) {
        while (true) {
            int b = m4658b(list);
            if (b != -1) {
                m4657a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    void m4661a(List<C0939b> list, int i, C0939b c0939b, int i2, C0939b c0939b2) {
        int i3;
        C0939b c0939b3;
        int i4 = 0;
        if (c0939b.f2437b < c0939b.f2439d) {
            i3 = (c0939b2.f2437b == c0939b.f2437b && c0939b2.f2439d == c0939b.f2439d - c0939b.f2437b) ? 1 : 0;
        } else if (c0939b2.f2437b == c0939b.f2439d + 1 && c0939b2.f2439d == c0939b.f2437b - c0939b.f2439d) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (c0939b.f2439d < c0939b2.f2437b) {
            c0939b2.f2437b--;
        } else if (c0939b.f2439d < c0939b2.f2437b + c0939b2.f2439d) {
            c0939b2.f2439d--;
            c0939b.f2436a = 2;
            c0939b.f2439d = 1;
            if (c0939b2.f2439d == 0) {
                list.remove(i2);
                this.f2272a.m4656a(c0939b2);
                return;
            }
            return;
        }
        if (c0939b.f2437b <= c0939b2.f2437b) {
            c0939b2.f2437b++;
            c0939b3 = null;
        } else if (c0939b.f2437b < c0939b2.f2437b + c0939b2.f2439d) {
            c0939b3 = this.f2272a.m4655a(2, c0939b.f2437b + 1, (c0939b2.f2437b + c0939b2.f2439d) - c0939b.f2437b, null);
            c0939b2.f2439d = c0939b.f2437b - c0939b2.f2437b;
        } else {
            c0939b3 = null;
        }
        if (i3 != 0) {
            list.set(i, c0939b2);
            list.remove(i2);
            this.f2272a.m4656a(c0939b);
            return;
        }
        if (i4 != 0) {
            if (c0939b3 != null) {
                if (c0939b.f2437b > c0939b3.f2437b) {
                    c0939b.f2437b -= c0939b3.f2439d;
                }
                if (c0939b.f2439d > c0939b3.f2437b) {
                    c0939b.f2439d -= c0939b3.f2439d;
                }
            }
            if (c0939b.f2437b > c0939b2.f2437b) {
                c0939b.f2437b -= c0939b2.f2439d;
            }
            if (c0939b.f2439d > c0939b2.f2437b) {
                c0939b.f2439d -= c0939b2.f2439d;
            }
        } else {
            if (c0939b3 != null) {
                if (c0939b.f2437b >= c0939b3.f2437b) {
                    c0939b.f2437b -= c0939b3.f2439d;
                }
                if (c0939b.f2439d >= c0939b3.f2437b) {
                    c0939b.f2439d -= c0939b3.f2439d;
                }
            }
            if (c0939b.f2437b >= c0939b2.f2437b) {
                c0939b.f2437b -= c0939b2.f2439d;
            }
            if (c0939b.f2439d >= c0939b2.f2437b) {
                c0939b.f2439d -= c0939b2.f2439d;
            }
        }
        list.set(i, c0939b2);
        if (c0939b.f2437b != c0939b.f2439d) {
            list.set(i2, c0939b);
        } else {
            list.remove(i2);
        }
        if (c0939b3 != null) {
            list.add(i, c0939b3);
        }
    }

    void m4662b(List<C0939b> list, int i, C0939b c0939b, int i2, C0939b c0939b2) {
        Object obj;
        Object obj2 = null;
        if (c0939b.f2439d < c0939b2.f2437b) {
            c0939b2.f2437b--;
            obj = null;
        } else if (c0939b.f2439d < c0939b2.f2437b + c0939b2.f2439d) {
            c0939b2.f2439d--;
            obj = this.f2272a.m4655a(4, c0939b.f2437b, 1, c0939b2.f2438c);
        } else {
            obj = null;
        }
        if (c0939b.f2437b <= c0939b2.f2437b) {
            c0939b2.f2437b++;
        } else if (c0939b.f2437b < c0939b2.f2437b + c0939b2.f2439d) {
            int i3 = (c0939b2.f2437b + c0939b2.f2439d) - c0939b.f2437b;
            obj2 = this.f2272a.m4655a(4, c0939b.f2437b + 1, i3, c0939b2.f2438c);
            c0939b2.f2439d -= i3;
        }
        list.set(i2, c0939b);
        if (c0939b2.f2439d > 0) {
            list.set(i, c0939b2);
        } else {
            list.remove(i);
            this.f2272a.m4656a(c0939b2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }
}
