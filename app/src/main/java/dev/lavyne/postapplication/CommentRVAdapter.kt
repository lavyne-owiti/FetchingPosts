package dev.lavyne.postapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.lavyne.postapplication.databinding.CommentlistBinding

class CommentRVAdapter(var commentlist:List<Comment>):RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding=CommentlistBinding.
        inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var commentlist=commentlist.get(position)
        with(holder.binding){
            tvPostIdbody.text=commentlist.postId.toString()
            tvIdBody.text=commentlist.id.toString()
            tvNamebody.text=commentlist.name
            tvEmailBody.text=commentlist.email
            tvBodycomments.text=commentlist.body
        }

    }

    override fun getItemCount(): Int {
      return commentlist.size
    }
}


class CommentViewHolder(var binding: CommentlistBinding):RecyclerView.ViewHolder(binding.root){

}