package src;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

// Classe principal que contém a janela inicial para iniciar o jogo
public class SpaceInvaders extends JFrame {
    // Botão para iniciar o jogo
    private JButton iniciar;
    private JLabel imagemFundo, logo;
    private Font space_invaders;

    // Criação do JFrame
    public SpaceInvaders() {
        setTitle("Space Invaders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(1920, 1080);
     
        try {
            space_invaders = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/humanoid.regular.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/humanoid.regular.ttf")));
        } catch (FontFormatException | IOException e) {
            System.out.println("Erro ao carregar fontes!");
        } catch (Exception e) {
            System.out.println("Erro inesperado!");;
        }
        
        logo = new JLabel();
        logo.setIcon(new ImageIcon("C:\\Users\\mathe\\Downloads\\SpaceInvaders\\assets\\Logo.png")); // NOI18N
        getContentPane().add(logo);
        logo.setBounds(500, 100, 1100, 530);

        imagemFundo = new JLabel();
        imagemFundo.setIcon(new ImageIcon("C:\\Users\\mathe\\Downloads\\SpaceInvaders\\assets\\Fundo.png"));
        getContentPane().add(imagemFundo);
        imagemFundo.setBounds(0, 0, 1920, 1080);

        iniciar = new JButton("INICIAR");
        iniciar.setFont(space_invaders);
        iniciar.setForeground(Color.RED);
        iniciar.setBackground(Color.YELLOW);
        iniciar.setBounds(820, 740, 300, 30);
        iniciar.setHorizontalAlignment(SwingConstants.CENTER);
        iniciar.setFocusPainted(false); 
        getContentPane().add(iniciar);
        iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarJogo();
            }
        });
    
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }

    public void iniciarJogo() {
        JFrame janela = new JFrame("Space Invaders");
        janela.setTitle("Space Invaders");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(1920, 1080);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setUndecorated(true);
        janela.add(new Gameplay());
        janela.setVisible(true);
        setVisible(false);
    }
    public static void main(String[] args) {
        new SpaceInvaders();
    }
}
