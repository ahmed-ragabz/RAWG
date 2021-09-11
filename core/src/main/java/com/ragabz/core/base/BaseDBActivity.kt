package com.ragabz.core.base

import android.graphics.Rect
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseDBActivity<DB : ViewDataBinding, VM : ViewModel>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity(), OnInitViewListener {

    lateinit var viewModel: VM
    lateinit var binding: DB
    var isKeyBoardVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        onInitBinding()
        onInitObserver()
    }

    fun initKeyboardListener() {
        binding.root.viewTreeObserver.addOnGlobalLayoutListener {
            val rec = Rect()
            binding.root.getWindowVisibleDisplayFrame(rec)
            //finding screen height
            val screenHeight = binding.root.rootView.height
            //finding keyboard height
            val keypadHeight = screenHeight - rec.bottom
            isKeyBoardVisible = keypadHeight > screenHeight * 0.15
        }
    }
}
