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
        JDABuilder jda = JDABuilder.createDefault("TOKEN");
        jda.setActivity(Activity.watching("Made by Prach#9333"));
        jda.setStatus(OnlineStatus.DO_NOT_DISTURB);
        jda.addEventListeners(new commands(), new onJoinListener(), new onLeaveListener());
        jda.setChunkingFilter(ChunkingFilter.ALL);
        jda.setMemberCachePolicy(MemberCachePolicy.ALL);
        jda.enableIntents(GatewayIntent.GUILD_MEMBERS);
        jda.build();
    }
}

