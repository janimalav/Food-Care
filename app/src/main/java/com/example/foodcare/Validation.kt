package com.example.foodcare

import android.widget.EditText
import java.util.regex.Pattern

class Validation {
    private val number = Pattern.compile("[0-9]")
    private val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$"
    private val email = Pattern.compile(emailRegex)
    private val passwordLength = 6
    fun checkName(edt: EditText): Boolean {
        val name = edt.text.toString()
        if (name.isEmpty()) {
            edt.error = "fill detail"
            edt.requestFocus()
            return false
        } else if (number.matcher(name).find()) {
            edt.error = "digit not allowed"
            edt.requestFocus()
            return false
        }
        return true
    }

    fun checkEmail(edt: EditText): Boolean {
        val email = edt.text.toString()
        if (email.isEmpty()) {
            edt.error = "fill detail"
            edt.requestFocus()
            return false
        } else if (!this.email.matcher(email).find()) {
            edt.error = "invalid"
            edt.requestFocus()
            return false
        }
        return true
    }

    fun checkPhone(edt: EditText): Boolean {
        val phone = edt.text.toString()
        if (phone.isEmpty()) {
            edt.error = "fill detail"
            edt.requestFocus()
            return false
        } else if (phone.length != 10) {
            edt.error = "invalid"
            edt.requestFocus()
            return false
        } else if (!number.matcher(phone).find()) {
            edt.error = "no character allowed"
            edt.requestFocus()
            return false
        }
        return true
    }

    fun checkPassword(edt: EditText): Boolean {
        val password = edt.text.toString()
        if (password.isEmpty()) {
            edt.error = "fill detail"
            edt.requestFocus()
            return false
        } else if (!number.matcher(password).find()) {
            edt.error = "no character allowed"
            edt.requestFocus()
            return false
        } else if (password.length < passwordLength) {
            edt.error = "too short"
            edt.requestFocus()
            return false
        }
        return true
    }

    fun checkConfirmPassword(pass: EditText, cnfPass: EditText): Boolean {
        if (cnfPass.text.toString() != pass.text.toString()) {
            cnfPass.error = "password not matched"
            cnfPass.requestFocus()
            return false
        }
        return true
    }
}