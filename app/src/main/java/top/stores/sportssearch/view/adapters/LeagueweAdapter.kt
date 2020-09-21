package top.stores.sportssearch.view.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import top.stores.sportssearch.R
import top.stores.sportssearch.model.LeaguePojo
import top.stores.sportssearch.model.SportPojo

class LeagueweAdapter (private val context: Context?, private val sportsList: List<LeaguePojo>?) : RecyclerView.Adapter<LeagueweAdapter.LeaguesAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaguesAdapterViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.leagues_item, parent, false)
        return LeaguesAdapterViewHolder(v)
    }

    override fun getItemCount(): Int {
        return sportsList?.size!!

    }

    override fun onBindViewHolder(holder: LeaguesAdapterViewHolder, position: Int) {
        holder.tvStrLeague.text = sportsList?.get(position)?.strLeagueL
        holder.tvStrSport.text = sportsList?.get(position)?.strSportL
        holder.tvStrLeagueAlternate.text = sportsList?.get(position)?.strLeagueAlternateL

    }


    class LeaguesAdapterViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var tvStrLeague : TextView
        var tvStrSport: TextView
        var tvStrLeagueAlternate : TextView


        init {
            tvStrLeague = itemView.findViewById(R.id.tv_str_league)
            tvStrSport = itemView.findViewById(R.id.tv_str_sport)
            tvStrLeagueAlternate = itemView.findViewById((R.id.tv_str_league_alternate))
        }

    }

}