package top.stores.sportssearch.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import top.stores.sportssearch.R
import top.stores.sportssearch.model.SportPojo
import top.stores.sportssearch.viewmodel.SportsViewModel


class SportFragment : Fragment() {

    private lateinit var viewModel : SportsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get<SportsViewModel>(SportsViewModel::class.java)


        viewModel.getSports()?.observe(this, object : Observer<List<SportPojo?>?> {
           override fun onChanged(@Nullable sportList: List<SportPojo?>?) {
               Log.d("Response", "$sportList" )
//                adapter = HeroesAdapter(this@MainActivity, heroList)
//                recyclerView.setAdapter(adapter)
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sport, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = SportFragment()
    }
}