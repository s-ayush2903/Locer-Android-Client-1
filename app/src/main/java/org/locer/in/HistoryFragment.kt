package org.locer.`in`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.locer.`in`.databinding.FragmentHistoryBinding

/**
 * Authored by Ayush Shrivastava on 23/8/20
 */

class HistoryFragment : Fragment() {

    private lateinit var historyBoundLayout: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        historyBoundLayout =
            DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)
        val toolbar = historyBoundLayout.toolbarHistoryFrag
        val activity = activity as MainActivity
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setTitle("Laundry Fragment")
        }
        return  historyBoundLayout.root
    }

}
