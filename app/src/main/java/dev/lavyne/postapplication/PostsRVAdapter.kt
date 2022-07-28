package dev.lavyne.postapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.lavyne.postapplication.databinding.PostlistBinding

class PostsRVAdapter (var context:Context, var postlist:List<Post>):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
      var binding=PostlistBinding
          .inflate(LayoutInflater.from(context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPosts=postlist.get(position)
        with(holder.binding){
            tvUserIds.text=currentPosts.userId.toString()
            tvIds.text=currentPosts.id.toString()
            tvTitles.text=currentPosts.title
            tvBodies.text=currentPosts.body
        }

    }

    override fun getItemCount(): Int {
        return  postlist.size
    }
}
class PostViewHolder( var binding: PostlistBinding):RecyclerView.ViewHolder(binding.root){

}