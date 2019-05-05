# PreferenceFragment
Lab4
## 实验四：扩展的Activity
### 使用PrefereceFragment实现设置页面
### 设置项说明
总共四组设置项     
In-line preferences   
CheckBoxPreference   
Dialog-based preferences:   
EditTextPreference   
ListPreference   
Launch preferences   
PreferenceScreen: 跳转到另一个  
PreferenceScreen PreferenceScreen: 启动一个网页  
Preference attributes   
CheckBox: 父选项   
CheckBox: 子选项，当父选项勾选时呈现  

## 代码及截图
### 主要代码：
#### MainActivity.java
```
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content,new PreFragment()).commit();
    }
}
```
#### PreFragment.java
```
public class PreFragment extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //从xml文件中加载选项
        addPreferencesFromResource(R.xml.preferencefragment);
    }
}
```
#### preferencefragment.xml
```
<?xml version="1.0" encoding="utf-8"?>
<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">
    <PreferenceCategory android:title="In-line preferences">
        <CheckBoxPreference
            android:key="checkbox_preference"
            android:summary="This a checkbox"
            android:title="Checkbox_preference"/>
    </PreferenceCategory>
    <PreferenceCategory android:title="Dialog-based preferences">
        <EditTextPreference
            android:dialogTitle="Enter your favorite animal"
            android:title="EditTextPreference"
            android:key="edittext_preference"
            android:summary="An example that uses an edit text dialog"/>
        <ListPreference
            android:entries="@array/setting"
            android:entryValues="@array/settingvalue"
            android:dialogTitle="Choose one"
            android:summary="An example that use a list dialog"
            android:title="List prefernce"
            android:key="list_preference"/>
        <!--需要补充列表项的数据来源-->
    </PreferenceCategory>
    <PreferenceCategory android:title="Launch preferences">
        <PreferenceScreen
            android:key="screen_preference"
            android:summary="Shows another screen of preferences"
            android:title="Screen preference">
            <CheckBoxPreference
                android:key="next_scrren_checkbox_preference"
                android:summary="Preference that is on the next screen but same hierarchy"
                android:title="Toggle preference"/>
        </PreferenceScreen>
        <PreferenceScreen
            android:summary="Launches an Activity from an intent"
            android:title="Intent preference"/>
        <intent
            android:action="android.intent.action.VIEW"
            android:data="http://www.baidu.com"/>
    </PreferenceCategory>
    <!--设置项关联，选中父选项时，子选项才显示。使用dependency属性-->
    <PreferenceCategory android:title="Preference attributes">
        <CheckBoxPreference
            android:key="parent_checkbox_preference"
            android:summary="This is visually parent"
            android:title="Parent checkbox preference" />
        <!-- 子类的可见类型是由样式属性定义的 -->
        <CheckBoxPreference
            android:dependency="parent_checkbox_preference"
            android:key="child_checkbox_preference"
            android:summary="This is visually a child"
            android:title="Child checkbox preference" />
    </PreferenceCategory>
</PreferenceScreen>
```
### 结果截图：
![image](https://github.com/Magicpanda-orz/PreferenceFragment/blob/master/img/lab4_1.PNG)  
![image](https://github.com/Magicpanda-orz/PreferenceFragment/blob/master/img/lab4_2.PNG)  
![image](https://github.com/Magicpanda-orz/PreferenceFragment/blob/master/img/lab4_3.PNG)  
![image](https://github.com/Magicpanda-orz/PreferenceFragment/blob/master/img/lab4_4.PNG)  
![image](https://github.com/Magicpanda-orz/PreferenceFragment/blob/master/img/lab4_5.PNG)  
##  
