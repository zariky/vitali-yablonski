package jmp.module15.services;

import jmp.module15.clients.fifa.ArrayOftPlayersWithCards;
import jmp.module15.clients.fifa.Info;
import jmp.module15.clients.fifa.InfoSoapType;
import jmp.module15.clients.fifa.TPlayersWithCards;
import jmp.module15.clients.fifa.TTeamInfo;
import jmp.module15.clients.weather.GlobalWeather;
import jmp.module15.clients.weather.GlobalWeatherSoap;
import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.ArrayList;
import java.util.List;

@WebService
public class SportGameService {

    private InfoSoapType fifaSoap;
    private GlobalWeatherSoap weatherSoap;

    public SportGameService() {
        Info footballService = new Info();
        GlobalWeather weatherService = new GlobalWeather();
        fifaSoap = footballService.getInfoSoap();
        weatherSoap = weatherService.getGlobalWeatherSoap();
    }

    @WebMethod
    public String[] weathers() {
        List<String> weathers = new ArrayList<String>();

        for (String city : fifaSoap.cities().getString()) {
            weathers.add(weatherSoap.getWeather(city, ""));
        }

        return weathers.toArray(new String[weathers.size()]);
    }

    @WebMethod
    public String[] teams() {
        List<String> teams = new ArrayList<String>();

        for (TTeamInfo teamInfo : fifaSoap.teams().getTTeamInfo()) {
            teams.add(teamInfo.getSName());
        }

        return teams.toArray(new String[teams.size()]);
    }

    @WebMethod
    public String[] players(final String team) {
        List<String> players = new ArrayList<String>();

        ArrayOftPlayersWithCards allPlayers = fifaSoap.allPlayersWithYellowOrRedCards(false, false, false);
        for (TPlayersWithCards player : allPlayers.getTPlayersWithCards()) {
            if (player.getSTeamName().equals(team)) {
                players.add("Player = " + player.getSName() + ", YellowCards = " + player.getIYellowCards() + ", RedCards = " + player.getIRedCards());
            }
        }

        return players.toArray(new String[players.size()]);
    }

}