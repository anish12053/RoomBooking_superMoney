import Manager.MeetingRoomManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MeetingRoomManager manager =
                MeetingRoomManager.getInstance();

        while (sc.hasNextLine()) {

            String input = sc.nextLine();
            if (input.trim().isEmpty()) continue;

            String[] tokens = input.split(" ");
            String command = tokens[0];

            try {
                switch (command) {

                    case "ADD_ROOM":
                        manager.getRoomService()
                                .addRoom(tokens[1],
                                        tokens[2],
                                        Integer.parseInt(tokens[3]));
                        break;

                    case "BOOK":
                        manager.getBookingService()
                                .book(tokens[1], tokens[2],
                                        tokens[3], tokens[4]);
                        break;

                    case "CANCEL":
                        manager.getBookingService()
                                .cancel(tokens[1],
                                        tokens[2], tokens[3]);
                        break;

                    case "LIST_BOOKINGS":
                        manager.getBookingService()
                                .list(tokens[1]);
                        break;

                    case "SUGGEST":
                        manager.getSuggestionService()
                                .suggest(tokens[1], tokens[2],
                                        Integer.parseInt(tokens[3]));
                        break;

                    default:
                        System.out.println("Invalid Command");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
