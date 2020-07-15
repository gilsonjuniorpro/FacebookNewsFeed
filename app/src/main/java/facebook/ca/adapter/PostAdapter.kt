package facebook.ca.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import facebook.ca.R
import facebook.ca.model.Post
import kotlinx.android.synthetic.main.feed_item.view.*

class PostAdapter (
    private var items: List<Post>,
    private val onItemClick: (Post) -> Unit
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_item, parent, false)
        return PostViewHolder(layout)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = items[position]
        holder.ivUser.setImageResource(post.imageUser!!)
        holder.tvTime.text = post.time
        holder.tvUserName.text = post.userName
        holder.tvSubtitle.text = post.subtitle
        holder.ivImage.setImageResource(post.imagePost!!)
        if(post.postTitle == null){
            holder.itemView.containerDescription.visibility = View.GONE
            var constraintSet = ConstraintSet()
            constraintSet.clone(holder.itemView as ConstraintLayout)
            constraintSet.setDimensionRatio(R.id.ivImage, "1:1")
            constraintSet.applyTo(holder.itemView as ConstraintLayout)
        }else{
            holder.itemView.containerDescription.visibility = View.VISIBLE
            holder.tvPostTitle.text = post.postTitle
            holder.tvPostSubtitle.text = post.postSubtitle

            var constraintSet = ConstraintSet()
            constraintSet.clone(holder.itemView as ConstraintLayout)
            constraintSet.setDimensionRatio(R.id.ivImage, "16:9")
            constraintSet.applyTo(holder.itemView as ConstraintLayout)
        }

        holder.itemView.setOnClickListener{ onItemClick(post) }
    }

    class PostViewHolder(rootView: View): RecyclerView.ViewHolder(rootView){
        val ivUser: ImageView = rootView.ivUser
        val tvTime: TextView = rootView.tvTime
        val tvUserName: TextView = rootView.tvUserName
        val tvSubtitle: TextView = rootView.tvSubtitle
        val ivImage: ImageView = rootView.ivImage
        val tvPostTitle: TextView = rootView.tvPostTitle
        val tvPostSubtitle: TextView = rootView.tvPostSubtitle
    }
}