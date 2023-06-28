package com.example.football.domain


data class LastMatches(
    var date: String,
    var nameFirstTeam: String,
    var goalFirstTeam: Int,
    var nameSecondTeam: String,
    var goalSecondTeam: Int
)
