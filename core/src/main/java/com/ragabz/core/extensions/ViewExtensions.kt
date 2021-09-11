@file:Suppress("DEPRECATION", "MagicNumber")



import android.content.Intent
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Build
import android.os.SystemClock
import android.view.View
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

fun sendIntent(text: String) = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }

fun urlIntent(url: String) = Intent(Intent.ACTION_VIEW, Uri.parse(url))

internal fun CircularProgressDrawable.style() {
    strokeWidth = 8f
    centerRadius = 45f
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        colorFilter = BlendModeColorFilter(Color.GRAY, BlendMode.SRC_ATOP)
    } else {
        this.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY)
    }
    start()
}

fun SwipeRefreshLayout.enable() {
    isEnabled = true
    setColorSchemeColors(Color.GRAY)
}

fun View.setOnDebouncedClickListener(action: () -> Unit) {
    val actionDebouncer = ActionDebouncer(action)

    // This is the only place in the project where we should actually use setOnClickListener
    setOnClickListener {
        actionDebouncer.notifyAction()
    }
}

fun View.removeOnDebouncedClickListener() {
    setOnClickListener(null)
    isClickable = false
}

private class ActionDebouncer(private val action: () -> Unit) {

    companion object {
        const val DEBOUNCE_INTERVAL_MILLISECONDS = 600L
    }

    private var lastActionTime = 0L

    fun notifyAction() {
        val now = SystemClock.elapsedRealtime()

        val millisecondsPassed = now - lastActionTime
        val actionAllowed = millisecondsPassed > DEBOUNCE_INTERVAL_MILLISECONDS
        lastActionTime = now

        if (actionAllowed) {
            action.invoke()
        }
    }
}

var View.visible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

fun View.hide(gone: Boolean = true) {
    visibility = if (gone) View.GONE else View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}
