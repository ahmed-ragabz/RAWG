package com.ragabz.rawg.data.datasource.local.entities


import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.ragabz.rawg.models.Game

@Entity
class GameEntity  {
    var added: Int = 0

    @Ignore
    var addedByStatus: AddedByStatusEntity? = null
    var backgroundImage: String = ""

    @Ignore
    var esrbRating: EsrbRatingEntity? = null

    @PrimaryKey
    var id: Int = 0
    var metacritic: Int = 0
    var name: String = ""

    @Ignore
    var platforms: List<ParentPlatformEntity>? = null
    var playtime: Int = 0
    var rating: Float = 0F
    var ratingTop: Int = 0

    @Ignore
    var ratings: RatingsEntity? = null
    var ratingsCount: Int = 0
    var released: String = ""
    var reviewsTextCount: String = ""
    var slug: String = ""
    var suggestionsCount: Int = 0
    var tba: Boolean = false
    var updated: String = ""

    companion object {
        fun fromNetwork(game: Game): GameEntity {
            val entity = GameEntity()
            entity.added = game.added
            entity.addedByStatus = null
            entity.backgroundImage = game.backgroundImage ?: ""
            entity.esrbRating = null
            entity.id = game.id
            entity.metacritic = game.metacritic ?: 0
            entity.name = game.name ?: ""
            entity.platforms = listOf()
            entity.playtime = game.playtime ?: 0
            entity.rating = game.rating ?: 0F
            entity.ratingTop = game.ratingTop ?: 0
            entity.ratings = null
            entity.ratingsCount = game.ratingsCount ?: 0
            entity.released = game.released ?: ""
            entity.reviewsTextCount = game.reviewsTextCount ?: ""
            entity.slug = game.slug ?: ""
            entity.suggestionsCount = game.suggestionsCount ?: 0
            entity.tba = game.tba ?: false
            entity.updated = game.updated ?: ""
            return entity
        }

        fun fromNetwork(gamesList: List<Game>): List<GameEntity> {
            val entitiesList = mutableListOf<GameEntity>()
            gamesList.forEach {
                entitiesList.add(fromNetwork(it))
            }
            return entitiesList
        }
    }
}