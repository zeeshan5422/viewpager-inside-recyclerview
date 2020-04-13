package com.zeeshan.dynamictabs.ui;

import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.zeeshan.dynamictabs.BR;
import com.zeeshan.dynamictabs.R;
import com.zeeshan.dynamictabs.databinding.ActivityMainBinding;
import com.zeeshan.dynamictabs.ui.base.MvvmBaseActivity;
import com.zeeshan.dynamictabs.vm.MainActivityViewModel;

public class MainActivity extends MvvmBaseActivity<ActivityMainBinding, MainActivityViewModel> {

    @Override
    public int getViewModelBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public MainActivityViewModel getViewModel() {
        return new ViewModelProvider(this).get(MainActivityViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);

        setSupportActionBar(mBinding.toolbar);

        loadFragment();
    }

    private void loadFragment() {

        mBinding.appBarLayout.setExpanded(true);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new TestFragment());
        transaction.commitNow();
    }

}
