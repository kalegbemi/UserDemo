package com.UserDemo.UserDemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/userdemo")
public class RestController {

    static int messageCount = 0;

    File messagefile = new File("message.txt");
    File logfile = new File("log.txt");

    @PostMapping("/message")
    public String postMessage(@RequestBody String user) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(messagefile, true))) {
            bufferedWriter.write(user + "*");
        } catch (IOException e) {
            e.getStackTrace();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logfile, true
        ))) {

            String logMessage = "New message created";
            bufferedWriter.write(logMessage + "\n");
            messageCount++;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "message saved to message file successfully";
    }

    @GetMapping("/message")
    public String getMessage() {
        StringBuilder messageSB = new StringBuilder();
        String message;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(messagefile))) {
            while ((message = bufferedReader.readLine()) != null) {
                messageSB.append(message);
            }
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        return messageSB.toString();
    }

//    @GetMapping("/message-count")
//    public String getMessageCount() {
//        return String.format("Total of %d messages has been posted", messageCount);
//    }
    @GetMapping("/message-count")
    public String getMessageCount(){
        try(BufferedReader bf = new BufferedReader(new FileReader(logfile))){
            while (bf.readLine() != null)
                messageCount++;
        }catch (IOException io){
            io.getStackTrace();
        }
        return String.format("Total of %d message has been posted",messageCount);
    }

    @GetMapping("/log-message")
    public String getLogMessage() {
        StringBuilder logMessageSB = new StringBuilder();
        String logMessage;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(logfile))) {
            while ((logMessage = bufferedReader.readLine()) != null) {
                logMessageSB.append(logMessage);
            }
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        return logMessageSB.toString();
    }

}
