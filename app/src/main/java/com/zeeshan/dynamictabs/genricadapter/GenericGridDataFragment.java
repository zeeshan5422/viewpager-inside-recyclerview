package com.zeeshan.dynamictabs.genricadapter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zeeshan.dynamictabs.R;

import java.util.List;

public class GenericGridDataFragment extends Fragment {


    private LinearLayout itemHolder;
    private List<KeyValueModel> itemsList;

    public GenericGridDataFragment(List<KeyValueModel> itemList) {
        this.itemsList = itemList;

        for (int i = 0; i < itemList.size(); i++) {
            Log.e("Final Values: ", " Map key is " + itemList.get(i).getKeyName() + " Map value is " + itemList.get(i).getKeyValue());
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.card_view_pager_view, container);
        itemHolder = view.findViewById(R.id.item_holder);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindValues();
    }

    private void bindValues() {
        itemHolder.removeAllViews();

        for (int i = 0; i < itemsList.size(); i += 2) {

            if (itemsList.get(i) != null) {
                final View keyValueItem = LayoutInflater.from(getContext()).inflate(R.layout.item_two_key_value, null);
                TextView keyItem1 = keyValueItem.findViewById(R.id.key_item1);
                TextView valueItem1 = keyValueItem.findViewById(R.id.value_item1);
                TextView keyItem2 = keyValueItem.findViewById(R.id.key_item2);
                TextView valueItem2 = keyValueItem.findViewById(R.id.value_item2);

                keyItem1.setText(itemsList.get(i).getKeyName());
                valueItem1.setText(itemsList.get(i).getKeyValue());

                if (i != itemsList.size() - 1 && itemsList.get(i + 1) != null) {
                    keyItem2.setText(itemsList.get(i + 1).getKeyName());
                    valueItem2.setText(itemsList.get(i + 1).getKeyValue());
                } else {
                    keyItem2.setVisibility(View.INVISIBLE);
                    valueItem2.setVisibility(View.INVISIBLE);
                }
                itemHolder.addView(keyValueItem);
            }
        }
    }

}
