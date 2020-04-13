package com.zeeshan.dynamictabs.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.zeeshan.dynamictabs.R;
import com.zeeshan.dynamictabs.data.TestFragmentModel;
import com.zeeshan.dynamictabs.genricadapter.GenericViewPagerGridAdapter;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyViewHolder> {

    private List<TestFragmentModel> mItemsList;
    private Fragment mFragment;
    private int splitCount;

    public TestAdapter(List<TestFragmentModel> itemList, Fragment fragment, int splitCount) {
        this.mItemsList = itemList;
        this.mFragment = fragment;
        this.splitCount = splitCount == 0 ? 2 : splitCount;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindView(mItemsList.get(position), mFragment);
    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //        private TextView headerTitle;
//        private TextView tvTwo;
//        private TextView tvThree;
//        private TextView tvFour;
        private ViewPager2 viewPager2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            headerTitle = itemView.findViewById(R.id.one);
//            tvTwo = itemView.findViewById(R.id.two);
//            tvThree = itemView.findViewById(R.id.three);
//            tvFour = itemView.findViewById(R.id.four);
            viewPager2 = itemView.findViewById(R.id.view_pager2);
        }

        public void bindView(TestFragmentModel testFragmentModel, Fragment context) {
//            headerTitle.setText(testFragmentModel.getName());
//            tvTwo.setText(testFragmentModel.getAmount());
//            tvThree.setText(testFragmentModel.getBalance());
//            tvFour.setText(testFragmentModel.getMonth());
            viewPager2.setAdapter(new GenericViewPagerGridAdapter(context, testFragmentModel, splitCount));
        }
    }
}
