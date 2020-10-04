package org.locer.`in`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.locer.`in`.databinding.FragmentWishlistBinding

/**
 * Authored by Ayush Shrivastava on 23/8/20
 */
class WishlistFragment : Fragment() {

    private lateinit var wishlistBoundLayout: FragmentWishlistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        wishlistBoundLayout =
            DataBindingUtil.inflate(inflater, R.layout.fragment_wishlist, container, false)
        val toolbar = wishlistBoundLayout.toolbarWishlistFrag
        val activity = activity as MainActivity
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setTitle("Wishlist Fragment")
        }
        return wishlistBoundLayout.root
    }
}
