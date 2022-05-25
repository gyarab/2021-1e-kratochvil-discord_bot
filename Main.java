package Main;

import Main.command.commands;
import Main.listener.onJoinListener;
import Main.listener.onLeaveListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDABuilder jda = JDABuilder.createDefault("TOKEN"); //Spojení s API Discordu přes TOKEN
        jda.setActivity(Activity.watching("Made by Prach#9333")); //Nastavení aktivity robota
        jda.setStatus(OnlineStatus.DO_NOT_DISTURB); 
        jda.addEventListeners(new commands(), new onJoinListener(), new onLeaveListener()); //Připojení ostatních tříd
        jda.setChunkingFilter(ChunkingFilter.ALL); //Nastavení filtrování
        jda.setMemberCachePolicy(MemberCachePolicy.ALL); //Nastavení vnímání uživatelů
        jda.enableIntents(GatewayIntent.GUILD_MEMBERS);
        jda.build(); //Spuštění kompletního programu
    }
}

