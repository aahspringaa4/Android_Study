import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewpractice.MainActivity
import com.example.recyclerviewpractice.ProfileData
import com.example.recyclerviewpractice.R

class ProfileAdapter(val mainList: ArrayList<ProfileData>):RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        holder.have.text = mainList.get(position).have
        holder.name.text = mainList.get(position).name
        holder.talent.text = mainList.get(position).talent
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val have = itemView.findViewById<TextView>(R.id.have)
        val name = itemView.findViewById<TextView>(R.id.name)
        val talent = itemView.findViewById<TextView>(R.id.talent)
    }


}