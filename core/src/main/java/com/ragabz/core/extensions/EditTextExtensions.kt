package com.ragabz.core.extensions

import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

/**
 * Shortcut for getting the text entered in the field.
 */
var EditText.value
    get() = text.toString()
    set(value) = setText(value)

/**
 * Shortcut for setting the text to empty.
 */
fun EditText.clear() = setText("")

/**
 * Check if the text entered in the field matches a specified Pattern.
 */
fun EditText.matches(pattern: Pattern): Boolean {
    return pattern.matcher(value).matches()
}

/**
 * Assert that the text entered in the field matches a specified Pattern.
 *
 * If the text does not match, display an error message on the field.
 */
fun EditText.validate(pattern: Pattern, errorMessage: Int): Boolean {
    val valid = matches(pattern)

    if (!valid) error = context.resources.getString(errorMessage)

    return valid
}

/**
 * Assert that the text entered is at least a certain amount of characters.
 *
 * If the text is too short, display an error message on the field.
 */
fun EditText.validateMinLength(minLength: Int, errorMessage: Int): Boolean {
    val valid = value.length >= minLength

    if (!valid) error = context.resources.getString(errorMessage)

    return valid
}

/**
 * Assert that the text entered is at least a certain amount of characters.
 *
 * If the text is too short, display an error message on the field.
 */
fun TextInputLayout.validateMinLength(minLength: Int, errorMessage: Int): Boolean {
    val valid = editText!!.value.length >= minLength

    if (!valid) error = context.resources.getString(errorMessage)

    return valid
}

/**
 * Assert that the text entered in the field matches a specified Pattern.
 *
 * If the text does not match, display an error message on the field.
 */
fun TextInputLayout.validate(pattern: Pattern, errorMessage: Int): Boolean {
    val valid = editText!!.matches(pattern)

    if (!valid) error = context.resources.getString(errorMessage)

    return valid
}

/**
 * Take an action when the enter key on the keyboard is pressed
 */
fun EditText.onKeyboardSubmit(onSubmit: () -> Unit) {
    setOnEditorActionListener(
        TextView.OnEditorActionListener { _, action, event ->
            if (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && action == EditorInfo.IME_ACTION_DONE) {
                onSubmit()
                return@OnEditorActionListener true
            }
            false
        }
    )
}
