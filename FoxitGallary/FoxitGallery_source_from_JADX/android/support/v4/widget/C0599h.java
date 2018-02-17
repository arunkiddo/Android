package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* renamed from: android.support.v4.widget.h */
class C0599h extends Filter {
    C0597a f1014a;

    /* renamed from: android.support.v4.widget.h.a */
    interface C0597a {
        Cursor m2595a();

        Cursor m2596a(CharSequence charSequence);

        void m2597a(Cursor cursor);

        CharSequence m2598c(Cursor cursor);
    }

    C0599h(C0597a c0597a) {
        this.f1014a = c0597a;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1014a.m2598c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f1014a.m2596a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f1014a.m2595a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f1014a.m2597a((Cursor) filterResults.values);
        }
    }
}
