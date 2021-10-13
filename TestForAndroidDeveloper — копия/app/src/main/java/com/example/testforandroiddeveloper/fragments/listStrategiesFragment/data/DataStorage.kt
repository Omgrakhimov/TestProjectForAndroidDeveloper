package com.example.testforandroiddeveloper.fragments.listStrategiesFragment.data

import com.example.testforandroiddeveloper.R
import com.example.testforandroiddeveloper.fragments.listStrategiesFragment.data.Item


class DataStorage {
    fun getList():List<Item> {
        return listOf(
            Item(
                0,
                "Moneyline",
                R.drawable.money,
                "The Moneyline bet is one of the most basic components in most strategies for hockey betting. You simply pick a team to win. The sportsbook sets the odds for the favorite and for the underdog. The favorite is the side generally expected to win, while the underdog is the most likely expected to lose. Bookmakers normally offer more profitable odds for the underdog."
            ),
            Item(
                1,
                "Puck line",
                R.drawable.pick,
                "With this bet type, the bookmaker asks you to predict not just who wins but the goal difference. And the point spread is +1.5 for the underdog and -1.5 for the favorite. Here, you can back the favorite to win by at least 2 goals. Alternatively, you can bet that the underdog will lose only by a goal or even win. If you can master it, this is one of the most exciting parts of strategies for hockey betting. In other sports, this is known as the points spread."
            ),
            Item(
                2,
                "Parlay",
                R.drawable.parlay,
                "Of all the betting options in our strategies for hockey, parlays are the most exciting, high-risk – high return wager. Instead of backing one team to win a game, you can pick two or more winners. The downside is that all the teams you select have to win in their respective matches or your entire bet will be lost."
            ),
            Item(
                3,
                "Regulation time",
                R.drawable.time,
                "As you might have guessed, for this bet type the punter has to predict that there will be a winner within regulation time. You are basically betting on whether or not the game will go into overtime to decide the winner. A bet on the favorite wins if they beat the underdog within regulation time. But if the game has to go to overtime, then the underdog wins regardless of the final scoreline. This makes betting on the regulation time one of the riskiest strategies for hockey betting."
            ),
            Item(
                4,
                "Futures",
                R.drawable.future,
                "In futures betting, punters predict which team will be the ultimate winner in a tournament. So, we’re looking for the overall winner who will get to walk away with the trophy. There’s a lot of suspense associated with these types of strategies for hockey. You can place your wagers way before the NHL or Stanley Cup commences."
            ),
            Item(
                5,
                "Grand salami",
                R.drawable.salami,
                "One of the most fascinating betting types for hockey is the Grand Salami, which falls into the realm of over under bets. Rather than predicting the number of goals for one match, you’ll be betting on goals that will be scored in all of the matches for a particular day. It doesn’t matter who wins or loses, all the bookmaker wants you to predict is the total number of goals."
            )
        )
    }
}