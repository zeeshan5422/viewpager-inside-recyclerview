package com.zeeshan.dynamictabs.data;

import com.zeeshan.dynamictabs.genricadapter.IGenericAdapterObjectMapper;
import com.zeeshan.dynamictabs.genricadapter.KeyValueModel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestFragmentModel implements IGenericAdapterObjectMapper {

    private String name;
    private String month;
    private String Amount;
    private String balance;
    private String name2;
    private String month2;
    private String Amount2;
    private String balance2;

    public TestFragmentModel(String name, String month, String amount, String balance, String name2, String month2, String amount2, String balance2) {
        this.name = name;
        this.month = month;
        Amount = amount;
        this.balance = balance;
        this.name2 = name2;
        this.month2 = month2;
        this.Amount2 = amount2;
        this.balance2 = balance2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }


    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getMonth2() {
        return month2;
    }

    public void setMonth2(String month2) {
        this.month2 = month2;
    }

    public String getAmount2() {
        return Amount2;
    }

    public void setAmount2(String amount2) {
        Amount2 = amount2;
    }

    public String getBalance2() {
        return balance2;
    }

    public void setBalance2(String balance2) {
        this.balance2 = balance2;
    }

    public static List<TestFragmentModel> getListOfTestItems() {

        List<TestFragmentModel> fragmentModelList = new ArrayList<>();
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz ", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz ", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz ", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz ", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz ", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz ", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz ", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz", "2nd Name", "Oct", "15,000.00", "asdf"));
        fragmentModelList.add(new TestFragmentModel("Abc name", "Feb", "1000.00", "Xyz", "2nd Name", "Oct", "15,000.00", "asdf"));

        return fragmentModelList;
    }

    // below is by smart way, but it has one problem
    public HashMap<String, Object> getBySmartWay(TestFragmentModel model) {
        HashMap<String, Object> myObjectAsDict = new HashMap<>();
        try {
            Field[] allFields = TestFragmentModel.class.getDeclaredFields();
            for (Field field : allFields) {
                Class<?> targetType = field.getType();
                Object objectValue = targetType.newInstance();
                Object value = field.get(objectValue);
                myObjectAsDict.put(field.getName(), value);
            }

        } catch (Exception e) {
        }
        return myObjectAsDict;
    }

    @Override
    public List<KeyValueModel> getMappedModel(Object model) {

        List<KeyValueModel> mappedModelList = new ArrayList<>();

        mappedModelList.add(new KeyValueModel("A", ((TestFragmentModel) model).getName()));
        mappedModelList.add(new KeyValueModel("B", ((TestFragmentModel) model).getMonth()));
        mappedModelList.add(new KeyValueModel("C", ((TestFragmentModel) model).getAmount()));
        mappedModelList.add(new KeyValueModel("D", ((TestFragmentModel) model).getBalance()));
        mappedModelList.add(new KeyValueModel("E", ((TestFragmentModel) model).getName2()));
        mappedModelList.add(new KeyValueModel("F", ((TestFragmentModel) model).getMonth2()));
        mappedModelList.add(new KeyValueModel("G", ((TestFragmentModel) model).getAmount2()));
        mappedModelList.add(new KeyValueModel("H", ((TestFragmentModel) model).getBalance2()));

        return mappedModelList;
    }
}
