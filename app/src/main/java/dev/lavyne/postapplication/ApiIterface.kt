package dev.lavyne.postapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiIterface {
    @GET("/posts")
    fun getPosts():Call<List<Post>>

    @GET("/posts/{id}")
    fun getpostById(@Path("id")postId:Int):Call<Post>

    @GET("/comments")
    fun getComments():Call<List<Comment>>

    @GET("/comments/{id}")
    fun getcommentById(@Path("id")commentId:Int):Call<Comment>

}


//fun main(){
//
//}
//interface  Tele {
//    fun switchon()
//    fun switchof()
//    fun adjustvolume()
//    fun switchchannel()
//
//}
//class Sumsung (tele: Tele){
//
//
//}