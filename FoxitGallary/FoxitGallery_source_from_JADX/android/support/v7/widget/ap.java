package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.view.menu.C0768g;
import android.support.v7.view.menu.C0769h;
import android.support.v7.view.menu.ListMenuItemView;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class ap extends am implements ao {
    private static Method f2270a;
    private ao f2271d;

    /* renamed from: android.support.v7.widget.ap.a */
    public static class C0907a extends ag {
        final int f2266g;
        final int f2267h;
        private ao f2268i;
        private MenuItem f2269j;

        public C0907a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.f2266g = 22;
                this.f2267h = 21;
                return;
            }
            this.f2266g = 21;
            this.f2267h = 22;
        }

        public /* bridge */ /* synthetic */ boolean m4647a(MotionEvent motionEvent, int i) {
            return super.m4641a(motionEvent, i);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            if (this.f2268i != null) {
                int headersCount;
                C0768g c0768g;
                MenuItem a;
                MenuItem menuItem;
                C0769h a2;
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    c0768g = (C0768g) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    c0768g = (C0768g) adapter;
                }
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        headersCount = pointToPosition - headersCount;
                        if (headersCount >= 0 && headersCount < c0768g.getCount()) {
                            a = c0768g.m3415a(headersCount);
                            menuItem = this.f2269j;
                            if (menuItem != a) {
                                a2 = c0768g.m3414a();
                                if (menuItem != null) {
                                    this.f2268i.m3348a(a2, menuItem);
                                }
                                this.f2269j = a;
                                if (a != null) {
                                    this.f2268i.m3349b(a2, a);
                                }
                            }
                        }
                    }
                }
                a = null;
                menuItem = this.f2269j;
                if (menuItem != a) {
                    a2 = c0768g.m3414a();
                    if (menuItem != null) {
                        this.f2268i.m3348a(a2, menuItem);
                    }
                    this.f2269j = a;
                    if (a != null) {
                        this.f2268i.m3349b(a2, a);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f2266g) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.f2267h) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((C0768g) getAdapter()).m3414a().m3441a(false);
                return true;
            }
        }

        public void setHoverListener(ao aoVar) {
            this.f2268i = aoVar;
        }
    }

    static {
        try {
            f2270a = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public ap(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    ag m4648a(Context context, boolean z) {
        ag c0907a = new C0907a(context, z);
        c0907a.setHoverListener(this);
        return c0907a;
    }

    public void m4649a(C0769h c0769h, MenuItem menuItem) {
        if (this.f2271d != null) {
            this.f2271d.m3348a(c0769h, menuItem);
        }
    }

    public void m4650a(ao aoVar) {
        this.f2271d = aoVar;
    }

    public void m4651a(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.c.setEnterTransition((Transition) obj);
        }
    }

    public void m4652b(C0769h c0769h, MenuItem menuItem) {
        if (this.f2271d != null) {
            this.f2271d.m3349b(c0769h, menuItem);
        }
    }

    public void m4653b(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.c.setExitTransition((Transition) obj);
        }
    }

    public void m4654b(boolean z) {
        if (f2270a != null) {
            try {
                f2270a.invoke(this.c, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }
}
