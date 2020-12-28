package com.yogaindra_18102180.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.yogaindra_18102180.sharedpreference.databinding.ActivitySettingPreferenceBinding
import kotlinx.android.synthetic.main.activity_main.*

class SettingPreferenceActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSettingPreference: SettingPreference
    private lateinit var settingModel: SettingModel
    private lateinit var binding: ActivitySettingPreferenceBinding

    companion object {
        const val RESULT_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener(this)
        mSettingPreference = SettingPreference(this)
        settingModel = mSettingPreference.getSetting()
        showPreferenceInForm()

        supportActionBar?.title = getString(R.string.setting_page)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_save) {
            val name = binding.edtName.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val age = binding.edtAge.text.toString().trim()
            val phoneNo = binding.edtPhone.text.toString().trim()
            val golongan = binding.edtGolongan.text.toString().trim()
            val prodi = binding.edtProdi.text.toString().trim()
            val isLoveMU = binding.rgLoveMu.checkedRadioButtonId == R.id.rb_yes

            if (name.isEmpty()) {
                binding.edtName.error = getString(R.string.field_required)
                return
            }
            if (email.isEmpty()) {
                binding.edtEmail.error = getString(R.string.field_required)
                return
            }
            if (!isValidEmail(email)) {
                binding.edtEmail.error = getString(R.string.email_is_not_valid)
                return
            }
            if (age.isEmpty()) {
                binding.edtAge.error = getString(R.string.field_required)
                return
            }
            if (phoneNo.isEmpty()) {
                binding.edtPhone.error = getString(R.string.field_required)
                return
            }
            if (golongan.isEmpty()) {
                binding.edtGolongan.error = getString(R.string.field_required)
            }
            if (prodi.isEmpty()) {
                binding.edtProdi.error = getString(R.string.field_required)
            }
            if (!TextUtils.isDigitsOnly(phoneNo)) {
                binding.edtPhone.error = getString(R.string.field_digit_only)
                return
            }
            saveSetting(name, email, age, phoneNo, isLoveMU, golongan, prodi)
            val resultIntent = Intent()
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun showPreferenceInForm() {
        binding.edtName.setText(settingModel.name)
        binding.edtEmail.setText(settingModel.email)
        binding.edtAge.setText(settingModel.age.toString())
        binding.edtPhone.setText(settingModel.phoneNumber)
        binding.edtGolongan.setText(settingModel.golonganDarah)
        binding.edtProdi.setText(settingModel.prodi)
        if (settingModel.isDarkTheme) {
            binding.rbYes.isChecked = true
        } else {
            binding.rbNo.isChecked = true
        }
    }

    private fun saveSetting(name: String, email: String, age: String, phoneNo: String, isLoveMU: Boolean, golongan: String, prodi: String) {
        val settingPreference = SettingPreference(this)
        settingModel.name = name
        settingModel.email = email
        settingModel.age = Integer.parseInt(age)
        settingModel.phoneNumber = phoneNo
        settingModel.golonganDarah = golongan
        settingModel.prodi = prodi
        settingModel.isDarkTheme = isLoveMU
        settingPreference.setSetting(settingModel)
        Toast.makeText(this, "Data tersimpan", Toast.LENGTH_SHORT).show()
    }
}