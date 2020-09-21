package top.stores.sportssearch.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import top.stores.sportssearch.R
import top.stores.sportssearch.model.LeaguePojo
import top.stores.sportssearch.model.SearchPojo
import top.stores.sportssearch.view.adapters.LeagueweAdapter
import top.stores.sportssearch.view.adapters.SearchAdapter
import top.stores.sportssearch.view.adapters.SportsAdapter
import top.stores.sportssearch.viewmodel.LeagueViewModel
import top.stores.sportssearch.viewmodel.SearchViewModel

class SearchFragment : Fragment() {

    private lateinit var viewModel : SearchViewModel
    private lateinit var leagueAdapter : SearchAdapter
    private lateinit var recyclerView : RecyclerView
    private lateinit var searchView : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get<SearchViewModel>(SearchViewModel::class.java)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sport, container, false)
        recyclerView = view.findViewById(R.id.sportRecyclerView)
        searchView = view.findViewById(R.id.searchView)
        searchView.visibility = View.VISIBLE
        searchView.queryHint = "Please enter a player name.."

        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.getPlayers(query)?.observe(viewLifecycleOwner, object : Observer<List<SearchPojo>?> {
                    override fun onChanged(@Nullable leagueList: List<SearchPojo>?) {
                        setUpAdapterWithList(recyclerView, leagueList)
                        leagueAdapter = SearchAdapter( activity, leagueList)
                        recyclerView.adapter = leagueAdapter
                        Log.d("Response", "$leagueList" )
                    }
                })

                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // leagueAdapter.getFilter().filter(newText)
                return false
            }
        })

        return view
    }


    fun setUpAdapterWithList(recyclerView: RecyclerView, leagueList: List<SearchPojo>?){
        leagueAdapter = SearchAdapter(activity, leagueList)
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.stackFromEnd =true
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = leagueAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = SportFragment()
    }
}