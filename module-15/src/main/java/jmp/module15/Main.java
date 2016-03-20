package jmp.module15;

import jmp.module15.clients.fifa.ArrayOftPlayersWithCards;
import jmp.module15.clients.fifa.Info;
import jmp.module15.clients.fifa.InfoSoapType;
import jmp.module15.clients.fifa.TPlayersWithCards;
import jmp.module15.clients.fifa.TTeamInfo;
import jmp.module15.clients.weather.GlobalWeather;
import jmp.module15.clients.weather.GlobalWeatherSoap;

/**
 * The main class
 */
public class Main {

    /**
     * The main method
     * @param vmArguments a array of programm arguments
     */
    public static void main(String[] vmArguments) {
        Info footballService = new Info();
        InfoSoapType fifaSoap = footballService.getInfoSoap();

        GlobalWeather weatherService = new GlobalWeather();
        GlobalWeatherSoap weatherSoap = weatherService.getGlobalWeatherSoap();

        findWeathers(weatherSoap, fifaSoap);
        findTeams(fifaSoap);
        findInfoPlayers(fifaSoap, "Uruguay");
    }

    private static void findWeathers(GlobalWeatherSoap weatherSoap, InfoSoapType fifaSoap) {
        System.out.println("Weathers:");

        for (String city : fifaSoap.cities().getString()) {
            System.out.println(weatherSoap.getWeather(city, ""));
        }
    }

    private static void findTeams(InfoSoapType fifaSoap) {
        System.out.println("FIFA teams:");

        for (TTeamInfo teamInfo : fifaSoap.teams().getTTeamInfo()) {
            System.out.println(teamInfo.getSName());
        }
    }

    private static void findInfoPlayers(InfoSoapType fifaSoap, String team) {
        System.out.println("Players(" + team + "):");

        ArrayOftPlayersWithCards allPlayers = fifaSoap.allPlayersWithYellowOrRedCards(false, false, false);
        for (TPlayersWithCards player : allPlayers.getTPlayersWithCards()) {
            if (player.getSTeamName().equals(team)) {
                System.out.println("Player = " + player.getSName()  + ", YellowCards = " + player.getIYellowCards() + ", RedCards = " + player.getIRedCards());
            }
        }
    }

}