// Generated by view binder compiler. Do not edit!
package com.widyaedu.imost.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.widyaedu.imost.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityWelcomeBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btSkip;

  @NonNull
  public final Button btnMulai;

  @NonNull
  public final LinearLayout layoutDots;

  @NonNull
  public final ViewPager viewPager;

  private ActivityWelcomeBinding(@NonNull RelativeLayout rootView, @NonNull Button btSkip,
      @NonNull Button btnMulai, @NonNull LinearLayout layoutDots, @NonNull ViewPager viewPager) {
    this.rootView = rootView;
    this.btSkip = btSkip;
    this.btnMulai = btnMulai;
    this.layoutDots = layoutDots;
    this.viewPager = viewPager;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityWelcomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_welcome, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityWelcomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btSkip;
      Button btSkip = rootView.findViewById(id);
      if (btSkip == null) {
        break missingId;
      }

      id = R.id.btn_mulai;
      Button btnMulai = rootView.findViewById(id);
      if (btnMulai == null) {
        break missingId;
      }

      id = R.id.layoutDots;
      LinearLayout layoutDots = rootView.findViewById(id);
      if (layoutDots == null) {
        break missingId;
      }

      id = R.id.view_pager;
      ViewPager viewPager = rootView.findViewById(id);
      if (viewPager == null) {
        break missingId;
      }

      return new ActivityWelcomeBinding((RelativeLayout) rootView, btSkip, btnMulai, layoutDots,
          viewPager);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}