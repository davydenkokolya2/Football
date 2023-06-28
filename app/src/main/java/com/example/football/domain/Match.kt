package com.example.football.domain


data class Match(
    var date: String,
    var nameFirstTeam: String,
    var goalFirstTeam: Int,
    var nameSecondTeam: String,
    var goalSecondTeam: Int
)
