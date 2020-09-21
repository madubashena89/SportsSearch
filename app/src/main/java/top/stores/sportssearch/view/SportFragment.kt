package top.stores.sportssearch.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import top.stores.sportssearch.R
import top.stores.sportssearch.model.SportPojo
import top.stores.sportssearch.view.adapters.SportsAdapter
import top.stores.sportssearch.viewmodel.SportsViewModel


class SportFragment : Fragment() {

    private lateinit var viewModel : SportsViewModel
    private lateinit var sportsAdapter : SportsAdapter
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this.activity!!).get(SportsViewModel::class.java)



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val view = inflater.inflate(R.layout.fragment_sport, container, false)
        viewModel = ViewModelProviders.of(this).get<SportsViewModel>(SportsViewModel::class.java)
        recyclerView = view.findViewById(R.id.sportRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel.getSports()?.observe(viewLifecycleOwner, Observer<List<SportPojo>?> {
            sportsAdapter = SportsAdapter( activity?.applicationContext, it)
            val llm = LinearLayoutManager(activity)
            llm.orientation = LinearLayoutManager.VERTICAL
            recyclerView.setLayoutManager(llm)
            recyclerView.adapter=sportsAdapter
        })
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = SportFragment()
    }
}