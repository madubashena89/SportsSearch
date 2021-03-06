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
import top.stores.sportssearch.model.SportPojo

class SportsAdapter (private val context: Context?, private val sportsList: List<SportPojo>?) : RecyclerView.Adapter<SportsAdapter.SportsAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsAdapterViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return SportsAdapterViewHolder(v)
    }

    override fun getItemCount(): Int {
        return sportsList?.size!!

    }

    override fun onBindViewHolder(holder: SportsAdapterViewHolder, position: Int) {
        holder.tvSportTitle.text = sportsList?.get(position)?.sportName
        holder.tvSportFormat.text = sportsList?.get(position)?.sportFormat
        holder.tvSportDescription.text = sportsList?.get(position)?.sportDescription

        val imageUrl = sportsList?.get(position)?.sportImageUrl
        Picasso.with(context)
            .load(Uri.parse(imageUrl)) // internet path
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher_round)
            .into(holder.imageSports)

    }


    class SportsAdapterViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var tvSportTitle : TextView
        var imageSports: ImageView
        var tvSportFormat: TextView
        var tvSportDescription : TextView


        init {
            tvSportTitle = itemView.findViewById(R.id.tv_str_league)
            imageSports = itemView.findViewById(R.id.sport_image)
            tvSportFormat = itemView.findViewById(R.id.tv_str_sport)
            tvSportDescription = itemView.findViewById((R.id.tv_str_league_alternate))
        }

    }

}