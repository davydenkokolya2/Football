package com.example.football.domain


data class Comparison(
    var date: String,
    var nameFirstTeam: String,
    var goalFirstTeam: Int,
    var nameSecondTeam: String,
    var goalSecondTeam: Int,
    var scoreBlueTeam: Int,
    var scoreRedTeam: Int
)
