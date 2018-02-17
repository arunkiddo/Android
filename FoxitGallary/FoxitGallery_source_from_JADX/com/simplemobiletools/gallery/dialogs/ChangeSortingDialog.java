package com.simplemobiletools.gallery.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.helpers.Config;
import com.simplemobiletools.gallery.helpers.ConstantsKt;
import p000a.C0055f;
import p000a.p005e.p006a.C0028a;
import p000a.p005e.p007b.C0036f;

public final class ChangeSortingDialog implements OnClickListener {
    public static final Companion Companion;
    public static Config config;
    private static int currSorting;
    public static View view;
    private final Activity activity;
    private final C0028a<C0055f> callback;
    private final boolean isDirectorySorting;

    public static final class Companion {
        private Companion() {
        }

        private final int getCurrSorting() {
            return ChangeSortingDialog.currSorting;
        }

        private final void setCurrSorting(int i) {
            ChangeSortingDialog.currSorting = i;
        }

        public final Config getConfig() {
            Config config = ChangeSortingDialog.config;
            if (config == null) {
                C0036f.m63b("config");
            }
            return config;
        }

        public final View getView() {
            View view = ChangeSortingDialog.view;
            if (view == null) {
                C0036f.m63b("view");
            }
            return view;
        }

        public final void setConfig(Config config) {
            C0036f.m62b(config, "<set-?>");
            ChangeSortingDialog.config = config;
        }

        public final void setView(View view) {
            C0036f.m62b(view, "<set-?>");
            ChangeSortingDialog.view = view;
        }
    }

    static {
        Companion = new Companion();
    }

    public ChangeSortingDialog(Activity activity, boolean z, C0028a<C0055f> c0028a) {
        C0036f.m62b(activity, "activity");
        C0036f.m62b(c0028a, "callback");
        this.activity = activity;
        this.isDirectorySorting = z;
        this.callback = c0028a;
        Companion.setConfig(Config.Companion.newInstance(this.activity));
        Companion companion = Companion;
        Object inflate = LayoutInflater.from(this.activity).inflate(C1333R.layout.dialog_change_sorting, (ViewGroup) null);
        C0036f.m59a(inflate, "LayoutInflater.from(acti\u2026log_change_sorting, null)");
        companion.setView(inflate);
        AlertDialog create = new Builder(this.activity).setTitle(this.activity.getResources().getString(C1333R.string.sort_by)).setView(Companion.getView()).setPositiveButton(C1333R.string.ok, this).setNegativeButton(C1333R.string.cancel, (OnClickListener) null).create();
        create.setCanceledOnTouchOutside(true);
        create.show();
        Companion.setCurrSorting(this.isDirectorySorting ? Companion.getConfig().getDirectorySorting() : Companion.getConfig().getSorting());
        setupSortRadio();
        setupOrderRadio();
    }

    private final void setupOrderRadio() {
        RadioGroup radioGroup = (RadioGroup) Companion.getView().findViewById(C1333R.id.sorting_dialog_radio_order);
        ((Companion.getCurrSorting() & ConstantsKt.getSORT_DESCENDING()) != 0 ? (RadioButton) radioGroup.findViewById(C1333R.id.sorting_dialog_radio_descending) : (RadioButton) radioGroup.findViewById(C1333R.id.sorting_dialog_radio_ascending)).setChecked(true);
    }

    private final void setupSortRadio() {
        RadioGroup radioGroup = (RadioGroup) Companion.getView().findViewById(C1333R.id.sorting_dialog_radio_sorting);
        RadioButton radioButton = (Companion.getCurrSorting() & ConstantsKt.getSORT_BY_SIZE()) != 0 ? (RadioButton) radioGroup.findViewById(C1333R.id.sorting_dialog_radio_size) : (Companion.getCurrSorting() & ConstantsKt.getSORT_BY_DATE_MODIFIED()) != 0 ? (RadioButton) radioGroup.findViewById(C1333R.id.sorting_dialog_radio_last_modified) : (Companion.getCurrSorting() & ConstantsKt.getSORT_BY_DATE_TAKEN()) != 0 ? (RadioButton) radioGroup.findViewById(C1333R.id.sorting_dialog_radio_date_taken) : (RadioButton) radioGroup.findViewById(C1333R.id.sorting_dialog_radio_name);
        radioButton.setChecked(true);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final C0028a<C0055f> getCallback() {
        return this.callback;
    }

    public final boolean isDirectorySorting() {
        return this.isDirectorySorting;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        int sort_by_name;
        C0036f.m62b(dialogInterface, "dialog");
        switch (((RadioGroup) Companion.getView().findViewById(C1333R.id.sorting_dialog_radio_sorting)).getCheckedRadioButtonId()) {
            case C1333R.id.sorting_dialog_radio_name /*2131624126*/:
                sort_by_name = ConstantsKt.getSORT_BY_NAME();
                break;
            case C1333R.id.sorting_dialog_radio_size /*2131624127*/:
                sort_by_name = ConstantsKt.getSORT_BY_SIZE();
                break;
            case C1333R.id.sorting_dialog_radio_last_modified /*2131624128*/:
                sort_by_name = ConstantsKt.getSORT_BY_DATE_MODIFIED();
                break;
            default:
                sort_by_name = ConstantsKt.getSORT_BY_DATE_TAKEN();
                break;
        }
        if (((RadioGroup) Companion.getView().findViewById(C1333R.id.sorting_dialog_radio_order)).getCheckedRadioButtonId() == C1333R.id.sorting_dialog_radio_descending) {
            sort_by_name |= ConstantsKt.getSORT_DESCENDING();
        }
        if (this.isDirectorySorting) {
            Companion.getConfig().setDirectorySorting(sort_by_name);
        } else {
            Companion.getConfig().setSorting(sort_by_name);
        }
        this.callback.invoke();
    }
}
