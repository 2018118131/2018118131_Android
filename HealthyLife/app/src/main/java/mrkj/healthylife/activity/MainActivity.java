package mrkj.healthylife.activity;

import android.view.View;
import android.widget.RadioGroup;

import java.util.Map;

import mrkj.healthylife.base.BaseActivity;
import mrkj.library.wheelview.pickerView.PickerView;
import mrkj.library.wheelview.utils.DateViewHelper;

/**
 * 完善信息界面
 * -->主界面是FunctionActivity
 */
public class MainActivity extends BaseActivity implements View.OnClickListener,PickerView.onSelectListener,RadioGroup.OnCheckedChangeListener,DateViewHelper.OnResultMessageListener,View.OnFocusChangeListener{


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }

    @Override
    public void onSelect(String s) {

    }

    @Override
    public void getMessage(Map<String, Object> map) {

    }
}
