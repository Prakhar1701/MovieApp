package prakhar.udemy.jetpackcompose.movieapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation
import prakhar.udemy.jetpackcompose.movieapp.model.Movie
import prakhar.udemy.jetpackcompose.movieapp.model.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onItemClick(movie.id) },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {

//                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image")
//--------------------------------------------------------------------------------------------------
/* From:
  https://coil-kt.github.io/coil/compose/  */

                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.images[0]) //Using Image-1 as poster as Poster link is not working :(
                        .crossfade(true)
                        .transformations(CircleCropTransformation())
                        .size(Size.ORIGINAL) // Set the target size to load the image at.
                        .build()
                )

                if (painter.state is AsyncImagePainter.State.Success) {
                    // This will be executed during the first composition if the image is in the memory cache.
                }

                Image(
                    painter = painter,
                    contentDescription = "Movie Poster"
                )
//--------------------------------------------------------------------------------------------------
            }
            Column(modifier = Modifier.padding(4.dp)) {

                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(
                    text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = "Released: ${movie.year}",
                    style = MaterialTheme.typography.caption
                )

            }
        }
    }
}
