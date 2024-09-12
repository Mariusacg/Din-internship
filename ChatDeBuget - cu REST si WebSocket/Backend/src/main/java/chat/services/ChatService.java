package chat.services;

import chat.loggers.Loggers;
import chat.logic.Message;
import chat.tcp.Group;
import chat.utils.Usefullstuff;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.*;
import java.util.Map;
import java.util.Optional;

@Service
public class ChatService {
    //private final Server server;
    private DatagramSocket socket;
    private InetAddress address;

    public ChatService() {
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName(Usefullstuff.getINSTANCE().getHostAddress());
        } catch (SocketException | UnknownHostException e) {
            Loggers.errorLogger.error(e.getClass() + " :" + e.getMessage());
        }
    }

    public String sendDataUDP(Message message) {
        try {
            String output =  Usefullstuff.getINSTANCE().getGson().toJson(message, Message.class);
            byte[] buf = output.getBytes();
            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length, address, Usefullstuff.getINSTANCE().getPORT());
            Loggers.infoLogger.info("Sending message UDP:" + message.toString());
            socket.send(packet);
            return "Message sent.";
        } catch (IOException e) {
            Loggers.errorLogger.error(e.getClass() +" :" + e.getMessage());
            return "Failed to send message";
        }
    }

    public Optional<Group> addGroup(Group group){
        Map<String, Group> connectedGroups = Usefullstuff.getINSTANCE().getConnectedGroups();
        if (connectedGroups.containsKey(group.getName())) {
            return Optional.empty();
        }

        connectedGroups.put(group.getName(), group);
        return Optional.of(group);
    }

    public Optional<Group> getActiveGroup(){
        if(Usefullstuff.getINSTANCE().getActiveGroup() != null) {
            return Optional.of(Usefullstuff.getINSTANCE().getActiveGroup());
        }
        return Optional.empty();
    }

    public Optional<Group> switchActiveGroup(String groupName){
        Map<String, Group> connectedGroups = Usefullstuff.getINSTANCE().getConnectedGroups();
        if (connectedGroups.containsKey(groupName)) {
            Group group = connectedGroups.get(groupName);
            Usefullstuff.getINSTANCE().setActiveGroup(group);
            return Optional.of(group);
        }
        return Optional.empty();
    }

    public Optional<Message> sendMessage(Message message){
        Map<String, Group> connectedGroups = Usefullstuff.getINSTANCE().getConnectedGroups();

        if(connectedGroups.containsKey(message.getGroup())) {
            Group group = connectedGroups.get(message.getGroup());
            group.sendMessage(message);
            return Optional.of(message);
        }

        return Optional.empty();
    }
}