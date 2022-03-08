package Main.listener;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class onJoinListener extends ListenerAdapter {

    @Override

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        event.getGuild().getTextChannelById(664847658585686044L).sendMessage
                ("Nazdar " + event.getMember().getUser().getAsMention()).queue();
    }
}
