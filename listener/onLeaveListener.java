package Main.listener;

import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class onLeaveListener extends ListenerAdapter {

    @Override

    public void onGuildMemberRemove(GuildMemberRemoveEvent event) { //Metoda Listeneru
        event.getGuild().getTextChannelById(664847658585686044L).sendMessage
                ("Pápá " + event.getMember().getUser().getAsMention()).queue(); //Odeslání zprávy
    }
}
