package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.C0599h.C0597a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import com.simplemobiletools.gallery.BuildConfig;

/* renamed from: android.support.v4.widget.g */
public abstract class C0598g extends BaseAdapter implements C0597a, Filterable {
    protected boolean f1005a;
    protected boolean f1006b;
    protected Cursor f1007c;
    protected Context f1008d;
    protected int f1009e;
    protected C0595a f1010f;
    protected DataSetObserver f1011g;
    protected C0599h f1012h;
    protected FilterQueryProvider f1013i;

    /* renamed from: android.support.v4.widget.g.a */
    private class C0595a extends ContentObserver {
        final /* synthetic */ C0598g f1003a;

        public C0595a(C0598g c0598g) {
            this.f1003a = c0598g;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.f1003a.m2607b();
        }
    }

    /* renamed from: android.support.v4.widget.g.b */
    private class C0596b extends DataSetObserver {
        final /* synthetic */ C0598g f1004a;

        private C0596b(C0598g c0598g) {
            this.f1004a = c0598g;
        }

        public void onChanged() {
            this.f1004a.f1005a = true;
            this.f1004a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.f1004a.f1005a = false;
            this.f1004a.notifyDataSetInvalidated();
        }
    }

    public C0598g(Context context, Cursor cursor, boolean z) {
        m2602a(context, cursor, z ? 1 : 2);
    }

    public Cursor m2599a() {
        return this.f1007c;
    }

    public Cursor m2600a(CharSequence charSequence) {
        return this.f1013i != null ? this.f1013i.runQuery(charSequence) : this.f1007c;
    }

    public abstract View m2601a(Context context, Cursor cursor, ViewGroup viewGroup);

    void m2602a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f1006b = true;
        } else {
            this.f1006b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f1007c = cursor;
        this.f1005a = z;
        this.f1008d = context;
        this.f1009e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f1010f = new C0595a(this);
            this.f1011g = new C0596b();
        } else {
            this.f1010f = null;
            this.f1011g = null;
        }
        if (z) {
            if (this.f1010f != null) {
                cursor.registerContentObserver(this.f1010f);
            }
            if (this.f1011g != null) {
                cursor.registerDataSetObserver(this.f1011g);
            }
        }
    }

    public void m2603a(Cursor cursor) {
        Cursor b = m2605b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public abstract void m2604a(View view, Context context, Cursor cursor);

    public Cursor m2605b(Cursor cursor) {
        if (cursor == this.f1007c) {
            return null;
        }
        Cursor cursor2 = this.f1007c;
        if (cursor2 != null) {
            if (this.f1010f != null) {
                cursor2.unregisterContentObserver(this.f1010f);
            }
            if (this.f1011g != null) {
                cursor2.unregisterDataSetObserver(this.f1011g);
            }
        }
        this.f1007c = cursor;
        if (cursor != null) {
            if (this.f1010f != null) {
                cursor.registerContentObserver(this.f1010f);
            }
            if (this.f1011g != null) {
                cursor.registerDataSetObserver(this.f1011g);
            }
            this.f1009e = cursor.getColumnIndexOrThrow("_id");
            this.f1005a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f1009e = -1;
        this.f1005a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public View m2606b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return m2601a(context, cursor, viewGroup);
    }

    protected void m2607b() {
        if (this.f1006b && this.f1007c != null && !this.f1007c.isClosed()) {
            this.f1005a = this.f1007c.requery();
        }
    }

    public CharSequence m2608c(Cursor cursor) {
        return cursor == null ? BuildConfig.FLAVOR : cursor.toString();
    }

    public int getCount() {
        return (!this.f1005a || this.f1007c == null) ? 0 : this.f1007c.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1005a) {
            return null;
        }
        this.f1007c.moveToPosition(i);
        if (view == null) {
            view = m2606b(this.f1008d, this.f1007c, viewGroup);
        }
        m2604a(view, this.f1008d, this.f1007c);
        return view;
    }

    public Filter getFilter() {
        if (this.f1012h == null) {
            this.f1012h = new C0599h(this);
        }
        return this.f1012h;
    }

    public Object getItem(int i) {
        if (!this.f1005a || this.f1007c == null) {
            return null;
        }
        this.f1007c.moveToPosition(i);
        return this.f1007c;
    }

    public long getItemId(int i) {
        return (this.f1005a && this.f1007c != null && this.f1007c.moveToPosition(i)) ? this.f1007c.getLong(this.f1009e) : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1005a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1007c.moveToPosition(i)) {
            if (view == null) {
                view = m2601a(this.f1008d, this.f1007c, viewGroup);
            }
            m2604a(view, this.f1008d, this.f1007c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public boolean hasStableIds() {
        return true;
    }
}
