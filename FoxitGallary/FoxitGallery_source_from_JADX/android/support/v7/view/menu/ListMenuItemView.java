package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0725f;
import android.support.v7.p034b.C0730a.C0726g;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.view.menu.C0114p.C0112a;
import android.support.v7.widget.bf;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements C0112a {
    private C0772j f1452a;
    private ImageView f1453b;
    private RadioButton f1454c;
    private TextView f1455d;
    private CheckBox f1456e;
    private TextView f1457f;
    private ImageView f1458g;
    private Drawable f1459h;
    private int f1460i;
    private Context f1461j;
    private boolean f1462k;
    private Drawable f1463l;
    private int f1464m;
    private LayoutInflater f1465n;
    private boolean f1466o;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        bf a = bf.m4774a(getContext(), attributeSet, C0729j.MenuView, i, 0);
        this.f1459h = a.m4777a(C0729j.MenuView_android_itemBackground);
        this.f1460i = a.m4790g(C0729j.MenuView_android_itemTextAppearance, -1);
        this.f1462k = a.m4779a(C0729j.MenuView_preserveIconSpacing, false);
        this.f1461j = context;
        this.f1463l = a.m4777a(C0729j.MenuView_subMenuArrow);
        a.m4778a();
    }

    private void m3306b() {
        this.f1453b = (ImageView) getInflater().inflate(C0726g.abc_list_menu_item_icon, this, false);
        addView(this.f1453b, 0);
    }

    private void m3307c() {
        this.f1454c = (RadioButton) getInflater().inflate(C0726g.abc_list_menu_item_radio, this, false);
        addView(this.f1454c);
    }

    private void m3308d() {
        this.f1456e = (CheckBox) getInflater().inflate(C0726g.abc_list_menu_item_checkbox, this, false);
        addView(this.f1456e);
    }

    private LayoutInflater getInflater() {
        if (this.f1465n == null) {
            this.f1465n = LayoutInflater.from(getContext());
        }
        return this.f1465n;
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.f1458g != null) {
            this.f1458g.setVisibility(z ? 0 : 8);
        }
    }

    public void m3309a(C0772j c0772j, int i) {
        this.f1452a = c0772j;
        this.f1464m = i;
        setVisibility(c0772j.isVisible() ? 0 : 8);
        setTitle(c0772j.m3484a((C0112a) this));
        setCheckable(c0772j.isCheckable());
        m3310a(c0772j.m3497f(), c0772j.m3493d());
        setIcon(c0772j.getIcon());
        setEnabled(c0772j.isEnabled());
        setSubMenuArrowVisible(c0772j.hasSubMenu());
    }

    public void m3310a(boolean z, char c) {
        int i = (z && this.f1452a.m3497f()) ? 0 : 8;
        if (i == 0) {
            this.f1457f.setText(this.f1452a.m3495e());
        }
        if (this.f1457f.getVisibility() != i) {
            this.f1457f.setVisibility(i);
        }
    }

    public boolean m3311a() {
        return false;
    }

    public C0772j getItemData() {
        return this.f1452a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f1459h);
        this.f1455d = (TextView) findViewById(C0725f.title);
        if (this.f1460i != -1) {
            this.f1455d.setTextAppearance(this.f1461j, this.f1460i);
        }
        this.f1457f = (TextView) findViewById(C0725f.shortcut);
        this.f1458g = (ImageView) findViewById(C0725f.submenuarrow);
        if (this.f1458g != null) {
            this.f1458g.setImageDrawable(this.f1463l);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1453b != null && this.f1462k) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1453b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        if (z || this.f1454c != null || this.f1456e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f1452a.m3498g()) {
                if (this.f1454c == null) {
                    m3307c();
                }
                compoundButton = this.f1454c;
                compoundButton2 = this.f1456e;
            } else {
                if (this.f1456e == null) {
                    m3308d();
                }
                compoundButton = this.f1456e;
                compoundButton2 = this.f1454c;
            }
            if (z) {
                compoundButton.setChecked(this.f1452a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f1456e != null) {
                this.f1456e.setVisibility(8);
            }
            if (this.f1454c != null) {
                this.f1454c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1452a.m3498g()) {
            if (this.f1454c == null) {
                m3307c();
            }
            compoundButton = this.f1454c;
        } else {
            if (this.f1456e == null) {
                m3308d();
            }
            compoundButton = this.f1456e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f1466o = z;
        this.f1462k = z;
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f1452a.m3500i() || this.f1466o) ? 1 : 0;
        if (i == 0 && !this.f1462k) {
            return;
        }
        if (this.f1453b != null || drawable != null || this.f1462k) {
            if (this.f1453b == null) {
                m3306b();
            }
            if (drawable != null || this.f1462k) {
                ImageView imageView = this.f1453b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1453b.getVisibility() != 0) {
                    this.f1453b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1453b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1455d.setText(charSequence);
            if (this.f1455d.getVisibility() != 0) {
                this.f1455d.setVisibility(0);
            }
        } else if (this.f1455d.getVisibility() != 8) {
            this.f1455d.setVisibility(8);
        }
    }
}
