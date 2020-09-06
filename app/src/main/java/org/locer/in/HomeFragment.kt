package org.locer.`in`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.locer.`in`.databinding.FragmentHomeBinding

/**
 * Authored by Ayush Shrivastava on 23/8/20
 */
class HomeFragment : Fragment() {

    private lateinit var homeBoundLayout: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBoundLayout =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val toolbar = homeBoundLayout.toolbarHomeFrag
        val activity = activity as MainActivity
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setTitle("Home Fragment")
        }
        return homeBoundLayout.root
    }

}
