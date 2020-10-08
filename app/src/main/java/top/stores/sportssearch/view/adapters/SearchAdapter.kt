package top.stores.sportssearch.view.adapters

import top.stores.sportssearch.model.SearchPojo

import android.content.Context
import android.graphics.BitmapFactory
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

class SearchAdapter (private val context: Context?, private val sportsList: List<SearchPojo>?) : RecyclerView.Adapter<SearchAdapter.SearchAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapterViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return SearchAdapterViewHolder(v)
    }

    override fun getItemCount(): Int {
        return sportsList?.size!!

    }

    override fun onBindViewHolder(holder: SearchAdapterViewHolder, position: Int) {
        holder.tvSportTitle.text = sportsList?.get(position)?.strPlayer
        holder.tvSportFormat.text = sportsList?.get(position)?.strNationality
        holder.tvSportDescription.text = sportsList?.get(position)?.strDescriptionEN

        val imageUrl = sportsList?.get(position)?.strThumb
        if(!imageUrl.isNullOrEmpty()){
            Picasso.with(context)
                .load(Uri.parse(imageUrl)) // internet path
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(holder.imageSports)
        }
        else{
           val bm = BitmapFactory.decodeResource(context?.resources, R.drawable.ic_search);
            holder.imageSports.setImageBitmap(bm)
        }


    }


    class SearchAdapterViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
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