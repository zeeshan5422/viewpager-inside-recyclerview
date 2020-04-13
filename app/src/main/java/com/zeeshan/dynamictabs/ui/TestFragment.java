package com.zeeshan.dynamictabs.ui;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zeeshan.dynamictabs.BR;
import com.zeeshan.dynamictabs.R;
import com.zeeshan.dynamictabs.data.TestFragmentModel;
import com.zeeshan.dynamictabs.ui.base.MvvmBaseFragment;
import com.zeeshan.dynamictabs.vm.TestViewModel;

public class TestFragment extends MvvmBaseFragment<ViewDataBinding, TestViewModel> {
    @Override
    public int getViewModelBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public TestViewModel getViewModel() {
        return new ViewModelProvider(this).get(TestViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_testt;
    }

    @Override
    public void subscribeUI() {
        super.subscribeUI();
    }

    @Override
    public void initViews(View parent, Bundle savedInstanceState) {
        super.initViews(parent, savedInstanceState);

        TestAdapter adapter = new TestAdapter(TestFragmentModel.getListOfTestItems(), this, 3);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
