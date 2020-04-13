package com.zeeshan.dynamictabs.genricadapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class GenericViewPagerGridAdapter extends FragmentStateAdapter {

    private List modelMappedListData;
    private int calculatedViews = 1;
    private int splitCount = 4;

    public GenericViewPagerGridAdapter(@NonNull Fragment fragment, IGenericAdapterObjectMapper adapterObjectMapper, int splitCount) {
        super(fragment);
        this.splitCount = splitCount;

        modelMappedListData = adapterObjectMapper.getMappedModel(adapterObjectMapper);

        calculatedViews = (modelMappedListData.size() / splitCount) + ((modelMappedListData.size() % splitCount) != 0 ? 1 : 0);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        List<KeyValueModel> currentList = calculateValues(position);
        return new GenericGridDataFragment(currentList);
    }

    private List<KeyValueModel> calculateValues(int position) {

        List<KeyValueModel> currentFragmentList = new ArrayList<>();

        for (int i = splitCount * position; i < (splitCount + (splitCount * position)); i++) {
            if (i <= modelMappedListData.size()) {
                currentFragmentList.add((KeyValueModel) modelMappedListData.get(i));
            }
            if (i == modelMappedListData.size() - 1) {
                break;
            }
        }
        return currentFragmentList;
    }

    @Override
    public int getItemCount() {
        return calculatedViews;
    }
}
