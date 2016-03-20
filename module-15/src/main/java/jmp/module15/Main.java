package jmp.module15;

import jmp.module15.clients.fifa.*;
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

        for (String city : fifaSoap.cities().getString()) {
                   System.out.println(city + " = " + weatherSoap.getWeather(city, ""));
        }

        for (TTeamInfo teamInfo : fifaSoap.teams().getTTeamInfo()) {
            System.out.println(teamInfo.getSName());
        }

        ArrayOftPlayersWithCards allPlayers = fifaSoap.allPlayersWithYellowOrRedCards(false, false, false);
        for (TPlayersWithCards player : allPlayers.getTPlayersWithCards()) {
            if (player.getSTeamName().equals("Uruguay")) {
                System.out.println(player.getSTeamName() + " - " + player.getSName()  + " - " + player.getIYellowCards() + " - " + player.getIRedCards());
            }
        }

    }

}