package com.test.ahoy.core.utils

import com.test.ahoy.core.data.source.local.entity.ChargingStationEntity
import com.test.ahoy.core.data.source.remote.response.ChargingStationResponse
import com.test.ahoy.core.domain.model.ChargingStation
import kotlin.random.Random

object DataMapper {

    var cityList = arrayOf("Dubai", "Sharjah", "Ajman", "Abu Dhabi", "Fujairah","Um ul Queen")
    var coverImage = arrayOf(
        "https://yourdubaiguide.com/wp-content/uploads/2018/10/Dubai-Green-Chargers.png",
        "https://imagevars.gulfnews.com/2018/10/25/1_16a08534b77.2293575_1433897235_16a08534b77_large.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQ14yFJ5_RpygHHaAtezaKSymiubbJbygMGg&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSm2zUb2PHqFF4yLwVg1yhmFINVk2-0QT8weA&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpoaUp09OVn_nQnH2GPvyO4MF-TOhFUPDr1w&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgosdBxd0rG7TbWyODFpKqF09kuJK-DU4g8A&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7uQHoha9xdbZgf7O6SpFgk_OncHhmDW5nWQ&usqp=CAU",
        "https://techcrunch.com/wp-content/uploads/2021/07/ElectrifyAmerica-VancouverWA.jpg?w=1390&crop=1"
    )
    var posterImage = arrayOf(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmSA8OprV7lQykWjyzsi4vy6Svpr8zl9nAlg&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvTRW-xwg4eR-gaI_EjwkW_FtU4ceOk57-9A&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQelPAiYN8gVJ7KliSCnMuYV7FrUzXIIy9ohQ&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0KpWplaSUax-gB5XVHG5wGYWbLJN1V2X5Cw&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR82YfGAzVrE5qHm2VPk8hA1-ouv94nqt04LQ&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwgUR-SN5o7TqlWa35L89gLPS-2fIFJuX2bA&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJ1psUHWPayPGlDlozWXov2WYtLUqytXCttQ&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgEHGUxSbKMSBL4iG_SLro6JJXhG0ZEhH8YQ&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXa__Xryn2iUa6W3cmYAIwMEqSLypE_KJdvQ&usqp=CAU"
    )

    fun mapResponsesToEntities(input: List<ChargingStationResponse>): List<ChargingStationEntity> {
        val animeList = ArrayList<ChargingStationEntity>()
        input.map {
            val chargingStationEntity = ChargingStationEntity(
                id = it.id,
                canonicalTitle = it.attributes.canonicalTitle,
                startDate = it.attributes.startDate,
                averageRating = it.attributes.averageRating,
                synopsis = it.attributes.synopsis,
                posterImage = it.attributes.posterImage.medium,
                coverImage = it.attributes.coverImage.large,
                youtubeVideoId = it.attributes.youtubeVideoId,
                isFavorite = false
            )
            animeList.add(chargingStationEntity)
        }
        return animeList
    }

    fun mapEntitiesToDomain(input: List<ChargingStationEntity>): List<ChargingStation> =
        input.map {
            ChargingStation(
                id = it.id,
                canonicalTitle = it.canonicalTitle,
                startDate = it.startDate,
                averageRating = it.averageRating,
                synopsis = it.synopsis,
                posterImage = posterImage[Random.nextInt(0,8)],
                coverImage = coverImage[Random.nextInt(0,7)],
                youtubeVideoId = it.youtubeVideoId,
                distance = Random.nextLong(2,100).toFloat(),
                city = cityList[Random.nextInt(0,5)],
                chargingCost = Random.nextLong(1, 10).toFloat(),
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: ChargingStation) = ChargingStationEntity(
        id = input.id,
        canonicalTitle = input.canonicalTitle,
        startDate = input.startDate,
        averageRating = input.averageRating,
        synopsis = input.synopsis,
        posterImage = input.posterImage,
        coverImage = input.coverImage,
        youtubeVideoId = input.youtubeVideoId,
        isFavorite = input.isFavorite
    )
}