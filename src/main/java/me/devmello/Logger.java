package me.devmello;


import me.devmello.gui.GUI;
import me.devmello.gui.panels.ConsolePanel;
import me.devmello.gui.panels.ErrorPanel;
import me.devmello.gui.panels.InfoPanel;
import me.devmello.gui.panels.WarnPanel;
import me.devmello.util.ConsoleColor;
import me.devmello.util.TimeUtils;


public class Logger {
    public String prefixText;

    protected String name;
    protected boolean gui;
    protected GUI guiWindow;

    public Logger(String name, String prefixText, boolean gui) {
        System.out.println("[" + name + "] " + "Logger initialized.");
        this.name = name;
        this.prefixText = prefixText;
        this.gui = gui;
        if(gui) {
            guiWindow = new GUI();
            guiWindow.init();
        }
    }
    public void setupLog(String msg){
        System.out.println(ConsoleColor.BLUE + "[" + name + "] " + ConsoleColor.RESET + msg);
        if(gui){
            ConsolePanel.addToConsole(TimeUtils.getDate()+ "[" + prefixText + "]" + " " + msg);
        }

    }

    public void setupLog(String module, String msg){
        System.out.println(ConsoleColor.BLUE + "[" + module + "] " + ConsoleColor.RESET + msg);
        if(gui){
            ConsolePanel.addToConsole(TimeUtils.getDate()+"[" + prefixText + "]" + " " + msg);
        }

    }


    public void consoleLogInfo(String msg) {
        prefixText = name + " - Info";
        System.out.println(TimeUtils.getDate() + ConsoleColor.BLUE + "[" + prefixText + "]" + ConsoleColor.RESET + " " + msg + ConsoleColor.RESET);
        if(gui){
            InfoPanel.addToConsole(TimeUtils.getDate()+"[" + prefixText + "]" + " " + msg);
        }

    }

    public void consoleLogWarn(String msg) {
        prefixText = name + " - Warn";
        System.out.println(TimeUtils.getDate() + ConsoleColor.YELLOW + "[" + prefixText + "]" + ConsoleColor.RESET + " " + msg + ConsoleColor.RESET);
        if(gui){
            WarnPanel.addToConsole(TimeUtils.getDate()+"[" + prefixText + "]" + " " + msg);
        }

    }

    public void consoleLogError(String msg) {
        prefixText = name + " - Error";
        System.out.println(TimeUtils.getDate() + ConsoleColor.RED + "[" + prefixText + "]" + ConsoleColor.RESET + " " + msg + ConsoleColor.RESET);
        if(gui){
            ErrorPanel.addToConsole(TimeUtils.getDate()+"[" + prefixText + "]" + " " + msg);
        }


    }
}