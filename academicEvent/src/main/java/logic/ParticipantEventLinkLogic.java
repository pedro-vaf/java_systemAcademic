package logic;

import java.util.*;

public class ParticipantEventLinkLogic {

    // Mapeamento de participante para eventos
    private static final Map<Integer, Set<Integer>> participantEventMap = new HashMap<>();

    // Método para registrar participação
    public static void register(int participantId, int eventId) {
        participantEventMap
                .computeIfAbsent(participantId, k -> new HashSet<>())
                .add(eventId);


    }

    // Verifica se um participante já está em um evento específico
    public static boolean isParticipantRegistered(int participantId, int eventId) {
        return participantEventMap.containsKey(participantId) &&
                participantEventMap.get(participantId).contains(eventId);
    }

    public static Map<Integer, Set<Integer>> getAllLinks() {
        return participantEventMap;
    }

    public static boolean isEmpty() {
        return participantEventMap.isEmpty();
    }
}