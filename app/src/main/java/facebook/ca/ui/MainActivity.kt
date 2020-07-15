package facebook.ca.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import facebook.ca.R
import facebook.ca.adapter.PostAdapter
import facebook.ca.model.Post
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items = getItems()

        val layoutManager = LinearLayoutManager(this)
        rvPost.layoutManager = layoutManager

        var divider = DividerItemDecoration(rvPost.context, DividerItemDecoration.VERTICAL)
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider)!!)

        rvPost.addItemDecoration(divider)
        rvPost.adapter = PostAdapter(items, this::openDetail)
    }

    private fun getItems(): List<Post> {
        var posts: MutableList<Post> = ArrayList()

        var post1 = Post(
            R.drawable.user_jon,
            "3 min",
            "Jon Snow",
             getString(R.string.text_subtitle),
            R.drawable.jon_snow,
            "blog.google.com",
            getString(R.string.text_sutitle_post)
        )

        var post2 = Post(
            R.drawable.user_jon,
            "3 min",
            "Jon Snow",
            getString(R.string.text_subtitle),
            R.drawable.jon_snow2
        )
        posts.add(post1)
        posts.add(post2)
        for (i in 1..10) {
            posts.add(post1)
        }

        return posts
    }

    private fun openDetail(post: Post) {

    }
}