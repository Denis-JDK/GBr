package ru.geekbrains.home_Java_Chat_History;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Msg {

    private static String USER_NAME = " ";
    private  static int CLIENT_ID;

    static Map<String, String> censor = new HashMap<>();
    static {
        censor.put("спб", "СПБ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String massage = reader.readLine();

        String censMassage = isCens(massage);


        if (authUser(massage)) {
            USER_NAME = massage;
            CLIENT_ID = getUserId(massage);
            startChat(USER_NAME, reader);
        }

    }

    private static String isCens(String massage) {
        return censor.containsKey(massage) ? censor.get(massage) : massage;
    }


    private static void startChat(String clientId, BufferedReader reader) {
        String fileName = prepareFileName(clientId);
        readerLastMSG(fileName);
    }

    private static String prepareFileName(String clientId) {
        String fileName = clientId + ".txt";
        return fileName;
    }

    private static void readerLastMSG( String fileName) {

      //  if () {
            try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String str;
                List<String> msgList = new ArrayList<>();
                while ((str = reader.readLine()) != null) {
                    msgList.add(str);
                }
                if (msgList.size()>=100) {
                    msgList = msgList.subList(msgList.size() - 100, msgList.size());
                } else {
                    msgList = msgList.subList(0, msgList.size() -1);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        //} else
    }
    private static boolean authUser(String username) {
        return true;
      /*  try {
            statement.executeUpdate("INSERT INTO users (login, password, nickname) VALUES ('" + login + "','" + password + "','" + nickname + "')");
            return true;
        } catch (SQLException e) {
            return false;
        }*/

    }

    private static int getUserId(String username) {
        return 1234;

      /*  try {
            ResultSet rs = statement.executeQuery("SELECT nickname FROM users WHERE login ='" + login + "' AND password = '" + password + "'");
            if (rs.next()) {
                return rs.getString("nickname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;*/
    }


}
