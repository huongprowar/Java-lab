package asm1;

import LinkedList.Node;
import LinkedList.SongLinkedList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    SongLinkedList songs = new SongLinkedList();

    public void readFromFile(String filename) {
        try {
            try (FileInputStream fis = new FileInputStream(filename)) {
                Scanner sc = new Scanner(fis);

                while (sc.hasNext()) {
                    String[] tokens = sc.nextLine().split("\\|");
                    if (tokens.length == 3) {
                        Song song = new Song(tokens[0].trim(), tokens[1].trim(), Integer.parseInt(tokens[2]));

                        if (!song.getName().startsWith("F") && song.getRated() > 1) {
                            songs.addTail(song);
                        }
                    }
                }

                sc.close();
            }
        } catch (IOException e) {
        } catch (NumberFormatException e) {
        }
    }

    public void writeToFile(String filename) {
        try {
            try (FileWriter writer = new FileWriter(filename)) {
                Node node = songs.getHead();
                while (node != null) {
                    writer.append(node.info + "\n");
                    node = node.next;
                }
            }
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();

        // 1
        obj.readFromFile("songs.txt");

        // 2
        obj.songs.traverse();

        // 3
        float average = 0.0f;

        Node node = obj.songs.getHead();
        while (node != null) {
            average += node.info.getRated();
            node = node.next;
        }

        average /= obj.songs.size();

        System.out.println("Average: " + average);

        // 4
        node = obj.songs.getHead();
        while (node != null) {
            if (node.info.getRated() < average) {
                obj.songs.remove(node);
            }
            node = node.next;
        }

        // 5
        obj.writeToFile("output.txt");

        // 6
        obj.songs.sortByName();

        // 7
        obj.songs.traverse();
    }
}
