package top.stores.sportssearch.view.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import top.stores.sportssearch.R
import top.stores.sportssearch.model.LeaguePojo
import top.stores.sportssearch.model.SportPojo
import java.util.*

class LeagueweAdapter (private val context: Context?,private val sportsList: List<LeaguePojo>?) :
    RecyclerView.Adapter<LeagueweAdapter.LeaguesAdapterViewHolder>(), Filterable {
    private var filteredList: List<LeaguePojo>? = null

    init {
        filteredList = sportsList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaguesAdapterViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.leagues_item, parent, false)
        return LeaguesAdapterViewHolder(v)
    }

    override fun getItemCount(): Int {
        return filteredList?.size!!

    }

    override fun onBindViewHolder(holder: LeaguesAdapterViewHolder, position: Int) {
        holder.tvStrLeague.text = filteredList?.get(position)?.strLeagueL
        holder.tvStrSport.text = filteredList?.get(position)?.strSportL
        holder.tvStrLeagueAlternate.text = filteredList?.get(position)?.strLeagueAlternateL

    }


    class LeaguesAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvStrLeague: TextView
        var tvStrSport: TextView
        var tvStrLeagueAlternate: TextView


        init {
            tvStrLeague = itemView.findViewById(R.id.tv_str_league)
            tvStrSport = itemView.findViewById(R.id.tv_str_sport)
            tvStrLeagueAlternate = itemView.findViewById((R.id.tv_str_league_alternate))
        }

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filteredList = sportsList
                } else {
                    val resultList = mutableListOf<LeaguePojo>()
                    if (sportsList != null) {
                        for (row in sportsList) {
                            if (row.strLeagueL.toLowerCase(Locale.ROOT).contains(
                                    charSearch.toLowerCase(
                                        Locale.ROOT
                                    )
                                )
                            ) {
                                resultList.add(row)
                            }
                        }
                    }
                    filteredList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as List<LeaguePojo>
                notifyDataSetChanged()
            }

        }
    }
}

