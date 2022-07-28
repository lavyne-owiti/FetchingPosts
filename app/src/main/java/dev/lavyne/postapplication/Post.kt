package dev.lavyne.postapplication

data class Post(
    var userId:Int,
    var id:Int,
    var title:String,
    var body:String )

 data class Comment(
    var postId:Int,
    var id:Int,
    var email:String,
    var name:String,
    var body:String )





















//fun<T> comparedIds(item1:T,item2: T):T{
//    var output=(item1.toString()+item2.toString())
//    println(output)
//    return item1
//}
// fun stage(){
//     var post1=Post(1,2,"qwer","sfgg")
//     var post2=Post(1,3,"oopl","bnm")
//     comparedIds(post1,post2)
//
//     var comm1=Comment(1,2,"qwer","sfgg","bnji")
//     var comm2=Comment(1,3,"oopl","bnm","dfgh")
//     comparedIds(comm1,comm2)
//
// }