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

















//
//fun comparepost(post1:Post,post2:Post):Post{
////    do some comparison
//    return post1
//}
//fun comparepost(comment1:Comment,comment2:Comment):Comment{
////    do some comparison
//    return comment1
//}
//fun<T> comparedItems(item1:T,item2: T):T{
////    preform comparison
//    return item1
//}
//fun main(){
//    var post1=Post(1,2,"DSHJKD","DSKSDDLJ")
//    var post2=Post(1,2,"DSHJKD","DSKSDDLJ")
//
//    var comment1=Comment(1,2,"wruoier","djfdksjoi")
//    var comment2=Comment(1,2,"wruoier","djfdksjoi")
//
//    comparedItems(post1,post2)
//    comparedItems(comment1,comment2)
//}


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