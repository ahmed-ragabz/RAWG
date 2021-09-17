package com.ragabz.core.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.snackbar.Snackbar
import kotlin.reflect.KClass

/**
 * Starts a new activity, clearing the current task stack.
 *
 * @param intent The intent to use when starting the new activity.
 */
fun Activity.startNew(intent: Intent) {
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
}

/**
 * Starts a new activity, clearing the current task stack.
 *
 * @param activityClass The activity to be started.
 */
fun Activity.startNew(activityClass: KClass<out Activity>) {
    val intent = Intent(this, activityClass.java)
    startNew(intent)
}

/**
 * Shortcut to start a new activity on top of the current one.
 *
 * @param activityClass The activity to be started.
 */
fun Activity.startActivity(activityClass: KClass<out Activity>) =
    startActivity(Intent(this, activityClass.java))

/**
 * Shortcut to start a new activity for a result.
 *
 * @param activityClass The activity to be started.
 * @param requestCode The Request code to watch for results with.
 */
fun Activity.startActivityForResult(activityClass: KClass<out Activity>, requestCode: Int) =
    startActivityForResult(Intent(this, activityClass.java), requestCode)

/**
 * Delegate to lazily get a String Extra as a value
 */
fun Activity.stringExtra(id: String) = lazy { intent.getStringExtra(id) }

/** Default Activity Success Code */
const val RESULT_SUCCESS = 54361

/** Default Activity Failure Code */
const val RESULT_FAILURE = 47540

/**
 * Finish the current activity with a result code.
 */
fun Activity.finishResult(resultCode: Int) {
    setResult(resultCode); finish()
}

/**
 * Finish the current activity with a successful result code.
 */
fun Activity.finishSuccessful() = finishResult(RESULT_SUCCESS)

/**
 * Finish the current activity with a Failure result code.
 */
fun Activity.finishFailure() = finishResult(RESULT_FAILURE)

/**
 * Dismiss the virtual keyboard.
 */
fun Activity.dismissKeyboard() {
    if (currentFocus == null) return
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
}

/**
 * Create and immediately show an alert dialog.
 */
inline fun Activity.showAlert(body: AlertDialog.Builder.() -> Unit) {
    val builder = AlertDialog.Builder(this)
    body.invoke(builder)
    builder.create().show()
}

/**
 * Begins and commits a Fragment Transaction.
 */
inline fun FragmentActivity.fragmentTransaction(body: FragmentTransaction.() -> Unit) {
    val transaction = supportFragmentManager.beginTransaction()
    body(transaction)
    transaction.commit()
}

/**
 * Transforms static java function Snackbar.make() to an extension function on View.
 */
fun View.createSnackBar(snackbarText: String, timeLength: Int): Snackbar {
    return Snackbar.make(
        this,
        snackbarText,
        timeLength
    )
}