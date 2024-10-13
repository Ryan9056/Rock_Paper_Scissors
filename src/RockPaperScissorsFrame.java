import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {

    // Scissors = 1
    // Paper = 2
    // Rock = 3

    JPanel mainPnl;
    JPanel iconPnl;  // Top
    JPanel displayPnl; // Center
    JPanel controlPnl; // Bottom
    JPanel winsPnl;

    JTextArea displayTA;
    JScrollPane scroller;

    JTextArea winsCPU;
    JTextArea winsPlayer;
    JTextArea winsTie;

    JLabel titleLbl;

    ImageIcon rock;
    ImageIcon paper;
    ImageIcon scissors;


    JButton quitBtn;
    JButton Rock;
    JButton Paper;
    JButton Scissors;



    int playerWins = 0;
    int CPUWins = 0;
    int tie = 0;
    String player;
    String CPU;

    Random rnd = new Random();

    public RockPaperScissorsFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());



        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createWinsPanel();
        mainPnl.add(winsPnl, BorderLayout.SOUTH);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.NORTH);

        add(mainPnl);
        setSize(810, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Rock Paper Scissors Game");
        setVisible(true);
    }




    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTA = new JTextArea(10, 35);
        displayTA.setFont(new Font("Georgia", Font.PLAIN, 14));
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }

    private void createWinsPanel() {
        winsPnl = new JPanel();
        winsPnl.setLayout(new GridLayout(1, 3));

        winsCPU = new JTextArea(1, 1);
        winsCPU.setFont(new Font("Georgia", Font.PLAIN, 14));
        winsCPU.setEditable(false);
        winsCPU.append("CPU Wins: ");

        winsPlayer = new JTextArea(1, 1);
        winsPlayer.setFont(new Font("Georgia", Font.PLAIN, 14));
        winsPlayer.setEditable(false);
        winsPlayer.append("Player Wins: ");

        winsTie = new JTextArea(1, 1);
        winsTie.setFont(new Font("Georgia", Font.PLAIN, 14));
        winsTie.setEditable(false);
        winsTie.append("Ties: ");

        winsPnl.add(winsCPU);
        winsPnl.add(winsPlayer);
        winsPnl.add(winsTie);

    }


    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setPreferredSize(new Dimension(810, 400));
        controlPnl.setLayout(new GridLayout(1, 4));

        rock = new ImageIcon("D:\\Comp Prog 2 Projects\\Rock_Paper_Scissors\\src\\rock.jpg");
        paper = new ImageIcon("D:\\Comp Prog 2 Projects\\Rock_Paper_Scissors\\src\\Paper.jpg");
        scissors = new ImageIcon("D:\\Comp Prog 2 Projects\\Rock_Paper_Scissors\\src\\Scissors.jpg");


        Rock = new JButton(rock);
        Paper = new JButton(paper);
        Scissors = new JButton(scissors);

        Rock.addActionListener((ActionEvent ae) -> {
            player = "Rock";
            Game(3,rnd.nextInt(3)+1);
            winsCPU.setText("CPU Wins: " + CPUWins);
            winsPlayer.setText("Player Wins: " + playerWins);
            winsTie.setText("Ties: " + tie);
        });

        Paper.addActionListener((ActionEvent ae) -> {
            player = "Paper";
            Game(2,rnd.nextInt(3)+1);
            winsCPU.setText("CPU Wins: " + CPUWins);
            winsPlayer.setText("Player Wins: " + playerWins);
            winsTie.setText("Ties: " + tie);
        });

        Scissors.addActionListener((ActionEvent ae) -> {
            player = "Scissors";
            Game(1,rnd.nextInt(3)+1);



            winsCPU.setText("CPU Wins: " + CPUWins);
            winsPlayer.setText("Player Wins: " + playerWins);
            winsTie.setText("Ties: " + tie);
        });


        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Verdana", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));


        controlPnl.add(Rock);
        controlPnl.add(Paper);
        controlPnl.add(Scissors);
        controlPnl.add(quitBtn);


    }

    private void Game(int play, int com) {

        if (com == 1) {
            CPU = "Scissors";
        }
        if (com == 2) {
            CPU = "Paper";
        }
        if (com == 3) {
            CPU = "Rock";
        }

        if (play == com) {
            displayTA.append(player + " ties with " + CPU + "\n");
            tie++;
        }
        if (play == 1 && com == 2) {
            displayTA.append(player + " cuts " + CPU + " (Player Wins)\n");
            playerWins++;
        }
        if (play == 2 && com == 3) {
            displayTA.append(player + " covers " + CPU + " (Player Wins)\n");
            playerWins++;
        }
        if (play == 3 && com == 1) {
            displayTA.append(player + " breaks " + CPU + " (Player Wins)\n");
            playerWins++;
        }
        if (com == 1 && play == 2) {
            displayTA.append(CPU + " cuts " + player + " (CPU Wins)\n");
            CPUWins++;
        }
        if (com == 2 && play == 3) {
            displayTA.append(CPU + " covers " + player + " (CPU Wins)\n");
            CPUWins++;
        }
        if (com == 3 && play == 1) {
            displayTA.append(CPU + " breaks " + player + " (CPU Wins)\n");
            CPUWins++;
        }

    }
}
