package dev.lavyne.postapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.lavyne.postapplication.databinding.ActivityCommentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentActivity : AppCompatActivity() {
    lateinit var binding:ActivityCommentBinding
    var postId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityCommentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        obtainPostId()
        fetchPost()
    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID")?:0
    }
    fun fetchPost(){
        var apiClient=ApiClient.buildAPiClient(ApiIterface::class.java)
        var request=apiClient.getpostById(postId)

        request.enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                var post=response.body()
                if (post !=null){
                    binding.tvPosttitle.text=post.title
                    binding.tvPostbody.text=post.body
                    getComments()
                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {

            }
        })
    }
    fun getComments() {
        val apiclient = ApiClient.buildAPiClient(ApiIterface::class.java)
        val request = apiclient.getComments(postId)
        request.enqueue(object :Callback<List<Comment>>{
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if (response.isSuccessful){
                    val comments=response.body()
                    if (comments!=null){
                        displayComment(comments)
                    }
                    }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
    fun displayComment(commentlist:List<Comment>){
        binding.rvComments.layoutManager=LinearLayoutManager(this)
        binding.rvComments.adapter=CommentRVAdapter(commentlist)
    }


}