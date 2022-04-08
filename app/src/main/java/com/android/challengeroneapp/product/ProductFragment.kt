package com.android.challengeroneapp.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.challengeroneapp.R
import com.android.challengeroneapp.adapter.ProducListAdapter
import com.android.challengeroneapp.model.ProductListDataModel


class ProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = view.findViewById<RecyclerView>(R.id.productListView)
        recyclerview.layoutManager = LinearLayoutManager(activity)

        val adapter = ProducListAdapter(setupData())
        recyclerview.adapter = adapter
    }

    private fun setupData() : List<ProductListDataModel> {
        val data = ArrayList<ProductListDataModel>()

        for (i in 1..5) {
            data.add(
                ProductListDataModel(
                    "Nike Sports",
                    "All weather Running Shoes",
                    "$850.00",
                    ""
                )
            )
        }
        return data
    }
}