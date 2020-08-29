package com.example.padcx_podcast_monthly_assignment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padcx_podcast_monthly_assignment.R
import com.example.padcx_podcast_monthly_assignment.adapter.DownloadPodcastAdapter
import com.example.padcx_podcast_monthly_assignment.adapter.UpNextPodcastAdapter
import com.example.shared.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : BaseFragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mUpNextPodcastAdapter: UpNextPodcastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        mUpNextPodcastAdapter = UpNextPodcastAdapter()
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        rv_upNext.layoutManager=linearLayoutManager
        rv_upNext.adapter=mUpNextPodcastAdapter

        mUpNextPodcastAdapter.setNewData(mutableListOf(1,2,3,4,5,6,7))
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}