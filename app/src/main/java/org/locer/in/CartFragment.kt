package org.locer.`in`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.locer.`in`.databinding.FragmentCartBinding

/**
 * Authored by Ayush Shrivastava on 23/8/20
 */
class CartFragment : Fragment() {
    private lateinit var cartBoundLayout: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cartBoundLayout =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
//        return inflater.inflate(R.layout.fragment_cart, container, false)
        val toolbar = cartBoundLayout.toolbarCartFrag
        val activity = activity as MainActivity
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false) // change this to true after drawer is implemented
            setTitle("CartFragment")
        }
        return cartBoundLayout.root
    }

}
