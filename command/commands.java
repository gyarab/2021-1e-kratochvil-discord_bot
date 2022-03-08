package Main.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.Permission;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Random;
import javax.annotation.Nonnull;

public class commands extends ListenerAdapter {
    public String prefix = "p!";

    public void onReady(@Nonnull ReadyEvent event) {
        System.out.printf("%#s pripraven", event.getJDA().getSelfUser());
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);
        String[] args = event.getMessage().getContentRaw().split(" ");


        if (args[0].equalsIgnoreCase(prefix + "ban")) {
            if (event.getMember().hasPermission(Permission.BAN_MEMBERS)) {
                Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
                event.getGuild().ban(member, 0).queue();

                EmbedBuilder ban = new EmbedBuilder();
                ban.setColor(Color.GREEN);
                ban.setTitle("Ban");
                ban.setDescription("Výpis banu");
                ban.addField("Autor Banu : ", event.getMessage().getAuthor().getName(), true);
                ban.addField("Ban : ", member.getUser().getName(), true);
                ban.setFooter("Made by Prach#9333 <3");

                event.getChannel().sendMessageEmbeds(ban.build()).queue();

                ban.clear();

            } else {
                Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));

                EmbedBuilder ban = new EmbedBuilder();
                ban.setColor(Color.RED);
                ban.setTitle("Ban ERROR");
                ban.setDescription("Nikdo nebyl zabanován, MISSING PERMISSIONS");
                ban.addField("Autor Banu : ", event.getMessage().getAuthor().getName(), true);
                ban.addField("Ban : ", member.getUser().getName(), true);
                ban.setFooter("Made by Prach#9333 <3");

                event.getChannel().sendMessageEmbeds(ban.build()).queue();

                ban.clear();
            }
        }
        if (args[0].equalsIgnoreCase(prefix + "kick")) {
            if (event.getMember().hasPermission(Permission.KICK_MEMBERS)) {
                Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
                event.getGuild().kick(member).queue();

                EmbedBuilder kick = new EmbedBuilder();
                kick.setColor(Color.GREEN);
                kick.setTitle("Kick");
                kick.setDescription("Výpis vyhození");
                kick.addField("Autor : ", event.getMessage().getAuthor().getName(), true);
                kick.addField("Kick : ", member.getUser().getName(), true);
                kick.setFooter("Made by Prach#9333 <3");

                event.getChannel().sendMessageEmbeds(kick.build()).queue();

                kick.clear();

            } else {
                Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
                EmbedBuilder kick = new EmbedBuilder();
                kick.setColor(Color.RED);
                kick.setTitle("Kick ERROR");
                kick.setDescription("Nikdo nebyl vyhozen, MISSING PERMISSIONS");
                kick.addField("Autor : ", event.getMessage().getAuthor().getName(), true);
                kick.addField("Kick : ", member.getUser().getName(), true);
                kick.setFooter("Made by Prach#9333 <3");

                event.getChannel().sendMessageEmbeds(kick.build()).queue();

                kick.clear();
            }
        }
        if (args[0].equalsIgnoreCase(prefix + "kocka")) {

            String[] kocek = {"https://tenor.com/view/crazy-cat-dancing-crazy-cat-dance-moves-too-cool-i-got-this-gif-14504785", "https://tenor.com/view/cat-weird-weird-cat-beurk-hugojv-gif-17865869", "https://tenor.com/view/cat-shaking-head-funny-cat-face-cat-gif-24056868", "https://tenor.com/view/catjam-cat-jamming-dexlore-status-unknown-cat-gif-21401174", "https://tenor.com/view/catjam-cat-dancing-cat-music-music-cat-cute-cat-gif-23392229", "https://tenor.com/view/cat-cute-adorable-punch-gif-17822730","https://tenor.com/view/kitten-cat-typing-typing-cat-gif-5751430", "https://tenor.com/view/cool-cat-gif-18199666", "https://tenor.com/view/smiling-cat-creepy-cat-cat-zoom-kitty-gif-12199043", "https://tenor.com/view/suspense-suspicious-evil-look-evillook-gif-20187691", "https://tenor.com/view/funny-silly-wtf-crazy-kitty-gif-12896137", "https://tenor.com/view/cat-broken-cat-cat-drinking-cat-licking-cat-air-gif-20661740"};

            Random kocka = new Random();
            int k = kocka.nextInt(kocek.length);

            event.getMessage().reply(kocek[k]).queue();
        }
        if (args[0].equalsIgnoreCase(prefix + "pes")) {

            String[] psu = {"https://tenor.com/view/la-creatura-dog-dog-hat-hat-dog-cute-dog-dog-gif-21005657", "https://tenor.com/view/chill-bro-sorry-dog-hair-gif-16673678", "https://tenor.com/view/doge-doge-meme-dog-tich-tich-lemur-gif-23480074", "https://tenor.com/view/dog-serious-gif-15276483", "https://tenor.com/view/happy-happy-dog-dog-happiest-dog-super-happy-gif-17885812", "https://tenor.com/view/soheb-saucelessss-gif-23665203", "https://tenor.com/view/emojify-gif-23955079"};

            Random pes = new Random();
            int p = pes.nextInt(psu.length);

            event.getMessage().reply(psu[p]).queue();
        }

    }
}
