 package maturita.maturita;
/**
 *
 * @author Marek Novák 
 * Maturtní práce na téma SPINET GUI 
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 
import com.teknikindustries.yahooweather.WeatherDisplay;
import com.teknikindustries.yahooweather.WeatherDoc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.round;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.xml.bind.DatatypeConverter;

public class GUI extends javax.swing.JFrame implements KeyListener {
    int xMouse;
    int yMouse;
    int value_trim1 = 0;
    int value_trim2 = 0;
    int slider;
    boolean clicked = false;
    int port = 2345;
    DatagramSocket udpSocket;
    int i;
    int hex = 0x00;
    int hex_1 = 0x00;
    int hex_2 = 0x00;
    int hex_3 = 0x00;
    int hex_4 = 0x00;
    boolean performed_checkbox = false;
    DatagramSocket sock = null; 
    String s;
    String hostname_string;
    
    public GUI() { 
        initComponents();
        initGUI();
        
    }
       
    private void initGUI() {
     /* 
      * Určení teploty dle Yahoo.com pro Liberec
      * Designation temparature according to Yahoo.com for Liberec
      */
       WeatherDoc doc = new WeatherDoc("20070498", "c"); 
       WeatherDisplay disp = new WeatherDisplay();
       temp_disp.setText(disp.getTemperature() + "°" + disp.getTemperatureUnit());
    }

    private void client () 
    {
        try {
            //Využívám nejdelší možné délky packetu.
            byte[] packetData = new byte[512];
            DatagramPacket packet = new DatagramPacket(packetData, 512); //vytvoří packet
            System.out.println(performed_checkbox);
            if (performed_checkbox == false) {
            //Zjistí hodnotu řetězce zadného pro název
            //Got value of string 
            hostname_string = hostname.getText();
            } else {
            hostname_string = "spinet";
            }
            sock = new DatagramSocket();
            InetAddress host = InetAddress.getByName(hostname_string);
            //Vyresetování hodnot poslaných
            //Reset of sent values
            sock = new DatagramSocket();
            sock.setSoTimeout( 1000 );
            packet.setSocketAddress(new InetSocketAddress(hostname_string, port));
            sock.send(packet);
            System.out.println("Packet odeslan");
                    String message = display.getText();
                    String messages = message.toUpperCase();
                    hex = hex + 0x1;

                    //Naše abeceda
                    int disp_char[]=
                    {
                      0x77,0x7c,0x39,0x5e,0x79,0x71,
                      0x3d,0x74,0x30,0x1e,0x00,0x38,
                      0x37,0x54,0x5c,0x73,0x00,0x50,
                      0x6d,0x78,0x3e,0x1c,0x00,0x00,
                      0x6e,0x5b
                    };

                    //Naše čísla
                    int disp_num []=
                    {
                        0x3f,0x06,0x5b,0x4f,0x66,0x6d,0x7d,0x07,0x7f,0x6f
                    };

                    /*
                    TODO: Abstrakce přeměny znaku na číslo
                    První pokus přes switch
                    Done
                    */

                    int hexp[]= {0,0,0,0}; 
                    for (i=0;i<4;i++) {
                    char ch = messages.charAt(i);

                        switch (ch) {

                            case 'A':
                                hexp[i] = disp_char[0];

                                break;
                            case 'B':
                                hexp[i] = disp_char[1];
                                break;
                            case 'C':
                                hexp[i] = disp_char[2];
                                break;    
                            case 'D':
                                hexp[i] = disp_char[3];
                                break;
                            case 'E':
                                hexp[i] = disp_char[4];
                                break;
                            case 'F':
                                hexp[i] = disp_char[5];
                                break;
                            case 'G':
                                hexp[i] = disp_char[6];
                                break;
                            case 'H':
                                hexp[i] = disp_char[7];
                                break;
                            case 'I':
                                hexp[i] = disp_char[8];
                                break;
                            case 'J':
                                hexp[i] = disp_char[9];
                                break;
                            case 'L':
                                hexp[i] = disp_char[11];
                                break;
                            case 'M':
                                hexp[i] = disp_char[12];
                                break;
                            case 'N':
                                hexp[i] = disp_char[13];
                                break;    
                            case 'O':
                                hexp[i] = disp_char[14];
                                break;
                            case 'P':
                                hexp[i] = disp_char[15];
                                break;
                            case 'R':
                                hexp[i] = disp_char[17];
                                break;
                            case 'S':
                                hexp[i] = disp_char[18];
                                break;
                            case 'T':
                                hexp[i] = disp_char[19];
                                break;
                            case 'U':
                                hexp[i] = disp_char[20];
                                break;
                            case 'V':
                                hexp[i] = disp_char[21];
                                break;     
                            case 'Y':
                                hexp[i] = disp_char[22];
                                break;
                            case 'Z':
                                hexp[i] = disp_char[23];
                                break; 
                             /*   
                                Teď přijdou na řadu čísla
                                Now will come numbers   
                             */   
                            case '1':
                                hexp[i] = disp_num[1];

                                break;
                            case '2':
                                hexp[i] = disp_num[2];
                                break;
                            case '3':
                                hexp[i] = disp_num[3];
                                break;    
                            case '4':
                                hexp[i] = disp_num[4];
                                break;
                            case '5':
                                hexp[i] = disp_num[5];
                                break;
                            case '6':
                                hexp[i] = disp_num[6];
                                break;
                            case '7':
                                hexp[i] = disp_num[7];
                                break;
                            case '8':
                                hexp[i] = disp_num[8];
                                break;
                            case '9':
                                hexp[i] = disp_num[9];
                                break;
                            case '0':
                                hexp[i] = disp_num[0];
                                break;
                            default:
                                hexp[i] = disp_num[10];
                                break;
                        }
                    }

                    hex_1 = hexp[0];
                    hex_2 = hexp[1]; 
                    hex_3 = hexp[2];
                    hex_4 = hexp[3];
                if (performed_checkbox == false) {
                    byte[] bytes = new byte[] { (byte) slider, (byte) hex_1, (byte) hex_2, (byte) hex_3, (byte) hex_4};
                    DatagramPacket  dp = new DatagramPacket(bytes , bytes.length , host , port);
                    sock.setSoTimeout(1000);
                    sock.send(dp);
                } else {
                    String hexadecimal = hostname.getText();
                    float hex_count = hexadecimal.length();
                    int devider = round((hex_count/5));
                    String devided_1 = hexadecimal.substring(0, devider);
                    int int_devided_1 = Integer.parseInt(devided_1, 16);
                    int devider_2 = 2*devider;
                    String devided_2 = hexadecimal.substring(devider, devider_2);
                    int int_devided_2 = Integer.parseInt(devided_2, 16);
                    int devider_3 = 3*devider;
                    String devided_3 = hexadecimal.substring(devider, devider_3);
                    int int_devided_3 = Integer.parseInt(devided_3, 16);
                    int devider_4 = 4*devider;
                    String devided_4 = hexadecimal.substring(devider, devider_4);
                    int int_devided_4 = Integer.parseInt(devided_4, 16);
                    int devider_5 = 5*devider;
                    String devided_5 = hexadecimal.substring(devider, devider_5);
                    int int_devided_5 = Integer.parseInt(devided_5, 16);
                    byte[] bytes = new byte[] { (byte) int_devided_1, (byte) int_devided_2, (byte) int_devided_3, (byte) int_devided_4, (byte) int_devided_5};
                    DatagramPacket  dp = new DatagramPacket(bytes , bytes.length , host , port);
                    sock.setSoTimeout(1000);
                    sock.send(dp);
                    status.setText("Sent hexadecimal in bytes:" +int_devided_1 + int_devided_2 + int_devided_3 + int_devided_4 + int_devided_5);
                }    

                /*
                Tak co třeba něco na zápis jakékoliv šestnáctkopvé hodnoty
                TODO: Posibility to transmit any hexadecimal number
                Done
                 */

                    System.out.println(messages);

                    System.out.println(hex_1);System.out.println(hex_2);System.out.println(hex_3);System.out.println(hex_4);
                    
                    //buffer to receive incoming data
                    byte[] buffer = new byte[65536];
                    DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                    sock.receive(reply);
                    byte[] data = reply.getData();
                    String str = new String(data, 0, reply.getLength());    
                    //Printing the details of incoming data - client ip : client port - client message
                    System.out.println(reply.getAddress().getHostAddress() + " : " + reply.getPort() + " - " + str.getBytes());
                    String received_hex = DatatypeConverter.printHexBinary(data);
                    System.out.println(received_hex); // prints some hex, which has been received
                    
                    if (performed_checkbox == false) {
                        //Prints data into status line
                        status.setText("Sent hexadecimal in bytes:" +hex_1 + hex_2 + hex_3 + hex_4 ); 
                        status2.setText("Received hexadecimal number:" +received_hex);
                    } else {
                        status2.setText("Received hexadecimal number:" +received_hex);
                    }
                    
                    String received_hex1 = received_hex.substring(0, 4); 
                    String received_hex2 = received_hex.substring(4, 8);
                    String received_hex3 = received_hex.substring(8, 12);
                    String received_hex4 = received_hex.substring(12, 16);
                    String received_hex5 = received_hex.substring(16, 18);
                    
                    System.out.println(received_hex1); // prints first part of hex, which has been received
                    System.out.println("    " + received_hex2); // prints second part of hex, which has been received
                    System.out.println("        " + received_hex3); // prints third part of hex, which has been received
                    System.out.println("            " + received_hex4); // prints fourth part of hex, which has been received

            String sub_received_hex2 = received_hex2.substring(2, 4);        
            float hex_trim1 = Integer.parseInt(sub_received_hex2, 16);
            
            System.out.println(hex_trim1);
            float value_trim11 = (hex_trim1/255)*100;
            value_trim1 = round(value_trim11);
            System.out.println(value_trim11);
            String Value = Integer.toString(value_trim1);
            trim1_disp.setText(Value + "%");
            trim1_bar.setValue(value_trim1);
            
            value_trim2 = 100;
            String Value2 = Integer.toString(value_trim2);
            trim2_disp.setText(Value2 + "%");
            trim2_bar.setValue(value_trim2);
            
            if (received_hex5.contains("00")) {
                
            }
            if (received_hex5.contains("01")) {
                BT0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT0.png")));
            }
            else {
                BT0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT0.png")));
            }
            if (received_hex5.contains("02")) {
                BT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT1.png")));
            }
            else {
                BT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT1.png")));
            }
            if (received_hex5.contains("04")) {
                BT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT2.png")));
            }
            else {
                BT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT2.png")));
            }
            if (received_hex5.contains("08")) {
                BT3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT3.png")));
            }
            else {
                BT3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT3.png")));
            }
            if (received_hex5.contains("10")) {
                BT4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT4.png")));
            }
            else {
                BT4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT4.png")));
            }
            if (received_hex5.contains("20")) {
                BT5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT5.png")));
            }
            else {
                BT5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT5.png")));
            }
            if (received_hex5.contains("40")) {
                BT6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT6.png")));
            }
            else {
                BT6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT6.png")));
            }
            if (received_hex5.contains("80")) {
                BT7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT7.png")));
            }
            else {
                BT7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT7.png")));
            }
        }
        catch (IOException e) {
            e.printStackTrace(System.err);
        }
          
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hexa_checkbox = new javax.swing.JCheckBox();
        status = new javax.swing.JLabel();
        status2 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        cursor = new javax.swing.JLabel();
        host_cursor = new javax.swing.JLabel();
        display = new javax.swing.JLabel();
        bargraf_slider = new javax.swing.JSlider();
        bargraf = new javax.swing.JLabel();
        green_diode = new javax.swing.JLabel();
        red_diode = new javax.swing.JLabel();
        hostname = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        trim1_disp = new javax.swing.JLabel();
        trim2_disp = new javax.swing.JLabel();
        trim1_bar = new javax.swing.JProgressBar();
        trim2_bar = new javax.swing.JProgressBar();
        temp_disp = new javax.swing.JLabel();
        TEMP = new javax.swing.JLabel();
        TRIM1 = new javax.swing.JLabel();
        TRIM2 = new javax.swing.JLabel();
        PORTA_label = new javax.swing.JLabel();
        PORTB_label = new javax.swing.JLabel();
        PORTC_label1 = new javax.swing.JLabel();
        PORTD_label = new javax.swing.JLabel();
        PORTA = new javax.swing.JLabel();
        PORTB = new javax.swing.JLabel();
        PORTC = new javax.swing.JLabel();
        PORTD = new javax.swing.JLabel();
        PORTA_arrow = new javax.swing.JLabel();
        PORTB_arrow = new javax.swing.JLabel();
        PORTC_arrow = new javax.swing.JLabel();
        PORTD_arrow = new javax.swing.JLabel();
        ports_background = new javax.swing.JLabel();
        top_background = new javax.swing.JLabel();
        BT0 = new javax.swing.JLabel();
        BT1 = new javax.swing.JLabel();
        BT2 = new javax.swing.JLabel();
        BT3 = new javax.swing.JLabel();
        BT4 = new javax.swing.JLabel();
        BT5 = new javax.swing.JLabel();
        BT6 = new javax.swing.JLabel();
        BT7 = new javax.swing.JLabel();
        trims_background = new javax.swing.JLabel();
        buttons_background = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hexa_checkbox.setBackground(java.awt.Color.darkGray);
        hexa_checkbox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        hexa_checkbox.setText("hexadecimal number in hostname?");
        hexa_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hexa_checkboxActionPerformed(evt);
            }
        });
        getContentPane().add(hexa_checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 86, -1, -1));

        status.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 24, 330, 14));

        status2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        getContentPane().add(status2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 38, 320, 14));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/cross.png"))); // NOI18N
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitMouseReleased(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 0, 24, 20));

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/button_minimize.gif"))); // NOI18N
        minimize.setAutoscrolls(true);
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                minimizeMouseReleased(evt);
            }
        });
        getContentPane().add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(668, 0, 21, 21));
        getContentPane().add(cursor, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 25, 3, 73));
        getContentPane().add(host_cursor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 3, 40));

        display.setBackground(java.awt.Color.darkGray);
        display.setFont(new java.awt.Font("Cambria", 0, 72)); // NOI18N
        display.setForeground(java.awt.Color.red);
        display.setText("1234");
        display.setToolTipText("");
        display.setVerifyInputWhenFocusTarget(false);
        display.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                displayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                displayFocusLost(evt);
            }
        });
        display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayMouseClicked(evt);
            }
        });
        display.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                displayKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                displayKeyTyped(evt);
            }
        });
        getContentPane().add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 25, 200, 80));

        bargraf_slider.setMajorTickSpacing(1);
        bargraf_slider.setMaximum(10);
        bargraf_slider.setMinimum(1);
        bargraf_slider.setOrientation(javax.swing.JSlider.VERTICAL);
        bargraf_slider.setValue(1);
        bargraf_slider.setOpaque(false);
        bargraf_slider.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                bargraf_sliderMouseWheelMoved(evt);
            }
        });
        bargraf_slider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bargraf_sliderMouseClicked(evt);
            }
        });
        bargraf_slider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bargraf_sliderKeyPressed(evt);
            }
        });
        getContentPane().add(bargraf_slider, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 17, -1, 100));

        bargraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/bargraf_1.png"))); // NOI18N
        getContentPane().add(bargraf, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 22, 20, 86));

        green_diode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/green_diode.png"))); // NOI18N
        getContentPane().add(green_diode, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 40, 40));

        red_diode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/red_diode.png"))); // NOI18N
        red_diode.setText("jLabel1");
        getContentPane().add(red_diode, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 40, 40));

        hostname.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        hostname.setForeground(java.awt.Color.white);
        hostname.setText("spinet");
        hostname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hostnameMouseClicked(evt);
            }
        });
        hostname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hostnameKeyPressed(evt);
            }
        });
        getContentPane().add(hostname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 40));

        jButton1.setText("Connect");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        trim1_disp.setBackground(java.awt.Color.white);
        trim1_disp.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        trim1_disp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trim1_disp.setOpaque(true);
        trim1_disp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                trim1_dispMouseReleased(evt);
            }
        });
        trim1_disp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                trim1_dispFocusGained(evt);
            }
        });
        trim1_disp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                trim1_dispKeyPressed(evt);
            }
        });
        getContentPane().add(trim1_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, 60));

        trim2_disp.setBackground(java.awt.Color.white);
        trim2_disp.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        trim2_disp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trim2_disp.setOpaque(true);
        trim2_disp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                trim2_dispMouseReleased(evt);
            }
        });
        trim2_disp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                trim2_dispKeyPressed(evt);
            }
        });
        getContentPane().add(trim2_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 120, 60));
        getContentPane().add(trim1_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 120, -1));
        getContentPane().add(trim2_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 120, -1));

        temp_disp.setBackground(java.awt.Color.white);
        temp_disp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        temp_disp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temp_disp.setOpaque(true);
        getContentPane().add(temp_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, 40));

        TEMP.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        TEMP.setForeground(java.awt.Color.white);
        TEMP.setText("TEMP");
        getContentPane().add(TEMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 24));

        TRIM1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        TRIM1.setForeground(java.awt.Color.white);
        TRIM1.setText("TRIM1");
        getContentPane().add(TRIM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 24));

        TRIM2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        TRIM2.setForeground(java.awt.Color.white);
        TRIM2.setText("TRIM2");
        getContentPane().add(TRIM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, 24));

        PORTA_label.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        PORTA_label.setForeground(java.awt.Color.darkGray);
        PORTA_label.setText("PORT A:");
        getContentPane().add(PORTA_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 50, 20));

        PORTB_label.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        PORTB_label.setForeground(java.awt.Color.darkGray);
        PORTB_label.setText("PORT B:");
        getContentPane().add(PORTB_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 50, 20));

        PORTC_label1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        PORTC_label1.setForeground(java.awt.Color.darkGray);
        PORTC_label1.setText("PORT C:");
        getContentPane().add(PORTC_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 50, 20));

        PORTD_label.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        PORTD_label.setForeground(java.awt.Color.darkGray);
        PORTD_label.setText("PORT D:");
        getContentPane().add(PORTD_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 50, 20));

        PORTA.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        PORTA.setForeground(java.awt.Color.darkGray);
        PORTA.setText("IN");
        PORTA.setToolTipText("");
        PORTA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PORTAMouseReleased(evt);
            }
        });
        PORTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PORTAKeyPressed(evt);
            }
        });
        getContentPane().add(PORTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 130, 80, 34));

        PORTB.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        PORTB.setForeground(java.awt.Color.darkGray);
        PORTB.setText("IN");
        PORTB.setToolTipText("");
        PORTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PORTBMouseReleased(evt);
            }
        });
        getContentPane().add(PORTB, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 180, 80, 34));

        PORTC.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        PORTC.setForeground(java.awt.Color.darkGray);
        PORTC.setText("IN");
        PORTC.setToolTipText("");
        PORTC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PORTCMouseReleased(evt);
            }
        });
        getContentPane().add(PORTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 230, 80, 34));

        PORTD.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        PORTD.setForeground(java.awt.Color.darkGray);
        PORTD.setText("IN");
        PORTD.setToolTipText("");
        PORTD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PORTDMouseReleased(evt);
            }
        });
        getContentPane().add(PORTD, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 280, 80, 34));

        PORTA_arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/left_arrow.png"))); // NOI18N
        PORTA_arrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PORTA_arrowMouseReleased(evt);
            }
        });
        getContentPane().add(PORTA_arrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 32, 32));

        PORTB_arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/left_arrow.png"))); // NOI18N
        PORTB_arrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PORTB_arrowMouseReleased(evt);
            }
        });
        getContentPane().add(PORTB_arrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 32, 32));

        PORTC_arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/left_arrow.png"))); // NOI18N
        PORTC_arrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PORTC_arrowMouseReleased(evt);
            }
        });
        getContentPane().add(PORTC_arrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 32, 32));

        PORTD_arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/left_arrow.png"))); // NOI18N
        PORTD_arrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PORTD_arrowMouseReleased(evt);
            }
        });
        getContentPane().add(PORTD_arrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 32, 32));

        ports_background.setBackground(new java.awt.Color(0, 29, 16));
        ports_background.setOpaque(true);
        getContentPane().add(ports_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 230, 205));

        top_background.setBackground(java.awt.Color.darkGray);
        top_background.setOpaque(true);
        getContentPane().add(top_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 720, 90));

        BT0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT0.PNG"))); // NOI18N
        BT0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BT0MouseReleased(evt);
            }
        });
        getContentPane().add(BT0, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 56, 55));

        BT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT1.PNG"))); // NOI18N
        BT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BT1MouseReleased(evt);
            }
        });
        getContentPane().add(BT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 56, 55));

        BT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT2.PNG"))); // NOI18N
        BT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BT2MouseReleased(evt);
            }
        });
        getContentPane().add(BT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 56, 55));

        BT3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT3.PNG"))); // NOI18N
        BT3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BT3MouseReleased(evt);
            }
        });
        getContentPane().add(BT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 56, 55));

        BT4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT4.PNG"))); // NOI18N
        BT4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BT4MouseReleased(evt);
            }
        });
        getContentPane().add(BT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 56, 55));

        BT5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT5.PNG"))); // NOI18N
        BT5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BT5MouseReleased(evt);
            }
        });
        getContentPane().add(BT5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 56, 55));

        BT6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT6.PNG"))); // NOI18N
        BT6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BT6MouseReleased(evt);
            }
        });
        getContentPane().add(BT6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 56, 55));

        BT7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT7.PNG"))); // NOI18N
        BT7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BT7MouseReleased(evt);
            }
        });
        getContentPane().add(BT7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, 56, 55));

        trims_background.setBackground(new java.awt.Color(2, 0, 35));
        trims_background.setOpaque(true);
        getContentPane().add(trims_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 310, 205));

        buttons_background.setBackground(new java.awt.Color(29, 0, 0));
        buttons_background.setOpaque(true);
        getContentPane().add(buttons_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 720, 80));

        header.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        header.setForeground(java.awt.Color.white);
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("SPINET GUI - Maturitní práce - Marek Novák ");
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 25));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/galaxy-720_405.jpg"))); // NOI18N
        background.setPreferredSize(new java.awt.Dimension(725, 405));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 405));

        getAccessibleContext().setAccessibleName("SPINET GUI");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayMouseClicked
        cursor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/display5.png")));
        display.addKeyListener(this);
        display.requestFocus();
    }//GEN-LAST:event_displayMouseClicked

    private void displayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_displayKeyTyped
        
    }//GEN-LAST:event_displayKeyTyped

    private void displayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_displayKeyPressed
        
    }//GEN-LAST:event_displayKeyPressed

    private void bargraf_sliderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bargraf_sliderKeyPressed
        // Zatím jediný ovládací prvek na práci s bargrafem
        slider = bargraf_slider.getValue();
        System.out.println(slider);
        switch (slider){ 
            /* 
                switch, rozhodující dle hodnoty novou grafickou podobobu bargrafu
                switch, which is decides by value new graphical view of bagraf
            */
            case 1:
                bargraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/bargraf_1.png")));
                break;
            case 2:
                bargraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/bargraf_2.png")));
                break;
            case 3:
                bargraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/bargraf_3.png")));
                break;
            case 4:
                bargraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/bargraf_4.png")));
                break;
            case 5:
                bargraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/bargraf_5.png")));
                break;
            case 6:
                bargraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/bargraf_6.png")));
                break;
            case 7:
                bargraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/bargraf_7.png")));
                break;
            case 8:
                bargraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/bargraf_8.png")));
                break;
            case 9:
                bargraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/bargraf_9.png")));
                break;
            case 10:    
                bargraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/bargraf_10.png")));
                break;
            default:
                break;
        }
    }//GEN-LAST:event_bargraf_sliderKeyPressed
/** Několik prázdných listenerů, které nejsou potřebné
 * Few of Empty Listeners which isn´t necessary.
    private void displayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DisplayKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_DisplayKeyTyped

    private void displayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DisplayKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DisplayKeyPressed

    private void displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisplayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DisplayMouseClicked
*/
    private void displayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_displayFocusGained
        
    }//GEN-LAST:event_displayFocusGained

    private void displayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_displayFocusLost
        cursor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/dark_gray.png")));
    }//GEN-LAST:event_displayFocusLost

    private void bargraf_sliderMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_bargraf_sliderMouseWheelMoved
        
    }//GEN-LAST:event_bargraf_sliderMouseWheelMoved

    private void bargraf_sliderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bargraf_sliderMouseClicked
        bargraf_slider.addKeyListener(this);
        bargraf_slider.requestFocus();
    }//GEN-LAST:event_bargraf_sliderMouseClicked

    private void PORTAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PORTAKeyPressed

    }//GEN-LAST:event_PORTAKeyPressed

    private void PORTAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PORTAMouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            String Value = "OUT";
            PORTA.setText(Value);
            clicked = true;
        }
        else {
            String Value = "IN";
            PORTA.setText(Value);
            clicked = false;
        }
    }//GEN-LAST:event_PORTAMouseReleased

    private void PORTBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PORTBMouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            String Value = "OUT";
            PORTB.setText(Value);
            clicked = true;
        }
        else {
            String Value = "IN";
            PORTB.setText(Value);
            clicked = false;
        }        
    }//GEN-LAST:event_PORTBMouseReleased

    private void PORTCMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PORTCMouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            String Value = "OUT";
            PORTC.setText(Value);
            clicked = true;
        }
        else {
            String Value = "IN";
            PORTC.setText(Value);
            clicked = false;
        } 
    }//GEN-LAST:event_PORTCMouseReleased

    private void PORTDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PORTDMouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */ 
        if (clicked == false) {
            String Value = "OUT";
            PORTD.setText(Value);
            clicked = true;
        }
        else {
            String Value = "IN";
            PORTD.setText(Value);
            clicked = false;
        }
    }//GEN-LAST:event_PORTDMouseReleased

    private void PORTA_arrowMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PORTA_arrowMouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            PORTA_arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/right_arrow.png")));
            clicked = true;
        }
        else {
            PORTA_arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/left_arrow.png")));
            clicked = false;
        }
    }//GEN-LAST:event_PORTA_arrowMouseReleased

    private void PORTB_arrowMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PORTB_arrowMouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            PORTB_arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/right_arrow.png")));
            clicked = true;
        }
        else {
            PORTB_arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/left_arrow.png")));
            clicked = false;
        }        
    }//GEN-LAST:event_PORTB_arrowMouseReleased

    private void PORTC_arrowMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PORTC_arrowMouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            PORTC_arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/right_arrow.png")));
            clicked = true;
        }
        else {
            PORTC_arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/left_arrow.png")));
            clicked = false;
        }
    }//GEN-LAST:event_PORTC_arrowMouseReleased

    private void PORTD_arrowMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PORTD_arrowMouseReleased
       /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            PORTD_arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/right_arrow.png")));
            clicked = true;
        }
        else {
            PORTD_arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/left_arrow.png")));
            clicked = false;
        } 
    }//GEN-LAST:event_PORTD_arrowMouseReleased

    private void BT0MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT0MouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            BT0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT0.png")));
            clicked = true;
        }
        else {
            BT0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT0.png")));
            clicked = false;
        } 
    }//GEN-LAST:event_BT0MouseReleased

    private void BT1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT1MouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            BT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT1.png")));
            clicked = true;
        }
        else {
            BT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT1.png")));
            clicked = false;
        } 
    }//GEN-LAST:event_BT1MouseReleased

    private void BT2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT2MouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            BT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT2.png")));
            clicked = true;
        }
        else {
            BT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT2.png")));
            clicked = false;
        }
    }//GEN-LAST:event_BT2MouseReleased

    private void BT3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT3MouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            BT3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT3.png")));
            clicked = true;
        }
        else {
            BT3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT3.png")));
            clicked = false;
        }
    }//GEN-LAST:event_BT3MouseReleased

    private void BT4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT4MouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            BT4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT4.png")));
            clicked = true;
        }
        else {
            BT4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT4.png")));
            clicked = false;
        }
    }//GEN-LAST:event_BT4MouseReleased

    private void BT5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT5MouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            BT5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT5.png")));
            clicked = true;
        }
        else {
            BT5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT5.png")));
            clicked = false;
        }
    }//GEN-LAST:event_BT5MouseReleased

    private void BT6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT6MouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            BT6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT6.png")));
            clicked = true;
        }
        else {
            BT6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT6.png")));
            clicked = false;
        }
    }//GEN-LAST:event_BT6MouseReleased

    private void BT7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT7MouseReleased
        /*
         *Stiknuto či nikoliv
         *Clicked or not clicked
         */
        if (clicked == false) {
            BT7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/toogle_BT7.png")));
            clicked = true;
        }
        else {
            BT7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/BT7.png")));
            clicked = false;
        }
    }//GEN-LAST:event_BT7MouseReleased

    private void exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseReleased
        System.exit(0);
    }//GEN-LAST:event_exitMouseReleased

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        /*
         * Určení X a Y souřadnicí pro přesunutí okna
         * According to X and Y coordinates for moving with application window
         */
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        /*
         * Posunutí okna aplikace po obrazovce  
         * Moving window application on screen
         */
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void minimizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseReleased
        /*
         * Minimalizování aplikace 
         * Minimalizing application 
        */
        this.setState(GUI.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseReleased

    private void trim1_dispKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trim1_dispKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_RIGHT) { 
        if (value_trim1 != 100) { 
        value_trim1++;
        String Value = Integer.toString(value_trim1);
        trim1_disp.setText(Value + "%");
        trim1_bar.setValue(value_trim1);
        }
       else {
       System.out.println("You have reached the 100 percent!");
       }
      }
      if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
        if (value_trim1 != 0) { 
        value_trim1--;
        String Value = Integer.toString(value_trim1);
        trim1_disp.setText(Value + "%");
        trim1_bar.setValue(value_trim1);
        }
       else {
       System.out.println("You have reached the 0 percent!");
       }  
      }
    }//GEN-LAST:event_trim1_dispKeyPressed

    private void trim2_dispKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trim2_dispKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_RIGHT) { 
        if (value_trim2 != 100) { 
        value_trim2++;
        String Value = Integer.toString(value_trim2);
        trim2_disp.setText(Value + "%");
        trim2_bar.setValue(value_trim2);
        }
       else {
       System.out.println("You have reached the 100 percent!");
       }
      }
      if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
        if (value_trim2 != 0) { 
        value_trim2--;
        String Value = Integer.toString(value_trim2);
        trim2_disp.setText(Value + "%");
        trim2_bar.setValue(value_trim2);
        }
       else {
       System.out.println("You have reached the 0 percent!");
       }  
      }
    }//GEN-LAST:event_trim2_dispKeyPressed

    private void trim1_dispFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_trim1_dispFocusGained
    }//GEN-LAST:event_trim1_dispFocusGained

    private void trim1_dispMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trim1_dispMouseReleased
        trim1_disp.addKeyListener(this);
        trim1_disp.requestFocus();
    }//GEN-LAST:event_trim1_dispMouseReleased

    private void trim2_dispMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trim2_dispMouseReleased
        trim2_disp.addKeyListener(this);
        trim2_disp.requestFocus();
    }//GEN-LAST:event_trim2_dispMouseReleased

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        client();
        if (clicked == false) {
            //PHOTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/yellow.png")));
            red_diode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/reder_diode.png")));
            green_diode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/greener_diode.png")));
            clicked = true;
        }
        else {
            //PHOTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/yellow_green.png")));
            red_diode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/red_diode.png")));
            green_diode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/green_diode.png")));
            clicked = false;
       }
    }//GEN-LAST:event_jButton1MouseReleased

    private void hostnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hostnameMouseClicked
       host_cursor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maturita/maturita/host_cursor.png")));
       hostname.requestFocus();
    }//GEN-LAST:event_hostnameMouseClicked

    private void hostnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hostnameKeyPressed
        /*
         Vypisování čísel na 7 segmentový displej, zdvojené z důvodu 2 zápisů psaní číslic na klávesnici.
         Konstrukci switch jsem nemohl využít, kvůli špatnému typu proměnné zapisované do KeyEvent (nebyl typu int).
         
         Printing numbers on 7 segmant display, double occurance bcs of 2 ways how to interpretate writting digitals on keyboard 
         I cannot use "switch" bcs of the wrong type of variable...
        */
        String ReVal = hostname.getText();
     int length_max = ReVal.length();
     boolean max_length = false;
     if (length_max == 64) {
       System.out.println("Error reached max. size!");
       max_length = true;
      }
     if (max_length == false) {
        if (evt.getKeyCode() == KeyEvent.VK_0) {
            String PreVal = hostname.getText() + "0";
            hostname.setText(PreVal);
       } 
       if (evt.getKeyCode() == KeyEvent.VK_1) {
            String PreVal = hostname.getText() + "1";
            hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_2) {
           String PreVal = hostname.getText() + "2";
           hostname.setText(PreVal);
       } 
       if (evt.getKeyCode() == KeyEvent.VK_3) {
           String PreVal = hostname.getText() + "3";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_4) {
           String PreVal = hostname.getText() + "4";
           hostname.setText(PreVal);
       } 
       if (evt.getKeyCode() == KeyEvent.VK_5) {
           String PreVal = hostname.getText() + "5";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_6) {
           String PreVal = hostname.getText() + "6";
           hostname.setText(PreVal);
       } 
       if (evt.getKeyCode() == KeyEvent.VK_7) {
           String PreVal = hostname.getText() + "7";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_8) {
           String PreVal = hostname.getText() + "8";
           hostname.setText(PreVal);
       } 
       if (evt.getKeyCode() == KeyEvent.VK_9) {
           String PreVal = hostname.getText() + "9";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_NUMPAD0) {
           String PreVal = hostname.getText() + "0";
           hostname.setText(PreVal);
       } 
       if (evt.getKeyCode() == KeyEvent.VK_NUMPAD1) {
           String PreVal = hostname.getText() + "1";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_NUMPAD2) {
           String PreVal = hostname.getText() + "2";
           hostname.setText(PreVal);
       } 
       if (evt.getKeyCode() == KeyEvent.VK_NUMPAD3) {
           String PreVal = hostname.getText() + "3";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_NUMPAD4) {
           String PreVal = hostname.getText() + "4";
           hostname.setText(PreVal);
       } 
       if (evt.getKeyCode() == KeyEvent.VK_NUMPAD5) {
           String PreVal = hostname.getText() + "5";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_NUMPAD6) {
           String PreVal = hostname.getText() + "6";
           hostname.setText(PreVal);
       } 
       if (evt.getKeyCode() == KeyEvent.VK_NUMPAD7) {
           String PreVal = hostname.getText() + "7";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_NUMPAD8) {
           String PreVal = hostname.getText() + "8";
           hostname.setText(PreVal);
       } 
       if (evt.getKeyCode() == KeyEvent.VK_NUMPAD9) {
           String PreVal = hostname.getText() + "9";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_PLUS) {
           String PreVal = hostname.getText() + "+";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_MINUS) {
           String PreVal = hostname.getText() + "-";
           hostname.setText(PreVal);
       }
       //Vypisování písmen na 7 segmentový displej
       //Printing letters on 7 segmant hostname
       if (evt.getKeyCode() == KeyEvent.VK_A) {
           String PreVal = hostname.getText() + "a";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_B) {
           String PreVal = hostname.getText() + "b";
            hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_C) {
           String PreVal = hostname.getText() + "c";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_D) {
           String PreVal = hostname.getText() + "d";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_E) {
           String PreVal = hostname.getText() + "e";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_F) {
           String PreVal = hostname.getText() + "f";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_G) {
           String PreVal = hostname.getText() + "g";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_H) {
           String PreVal = hostname.getText() + "h";
           hostname.setText(PreVal);
       }       
       if (evt.getKeyCode() == KeyEvent.VK_I) {
           String PreVal = hostname.getText() + "i";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_J) {
           String PreVal = hostname.getText() + "j";
           hostname.setText(PreVal);
       }              
       if (evt.getKeyCode() == KeyEvent.VK_K) {
           String PreVal = hostname.getText() + "k";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_L) {
           String PreVal = hostname.getText() + "l";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_M) {
           String PreVal = hostname.getText() + "m";
           hostname.setText(PreVal);
       }
       
       if (evt.getKeyCode() == KeyEvent.VK_N) {
           String PreVal = hostname.getText() + "n";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_O) {
           String PreVal = hostname.getText() + "o";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_P) {
           String PreVal = hostname.getText() + "p";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_Q) {
           String PreVal = hostname.getText() + "q";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_R) {
           String PreVal = hostname.getText() + "r";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_S) {
           String PreVal = hostname.getText() + "s";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_T) {
           String PreVal = hostname.getText() + "t";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_U) {
           String PreVal = hostname.getText() + "u";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_V) {
           String PreVal = hostname.getText() + "v";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_W) {
           String PreVal = hostname.getText() + "w";
           hostname.setText(PreVal);
       }
       if (evt.getKeyCode() == KeyEvent.VK_X) {
           String PreVal = hostname.getText() + "x";
           hostname.setText(PreVal);
       }
       
       if (evt.getKeyCode() == KeyEvent.VK_Y) {
           String PreVal = hostname.getText() + "y";
           hostname.setText(PreVal);
       }
     if (evt.getKeyCode() == KeyEvent.VK_Z) {
           String PreVal = hostname.getText() + "z";
           hostname.setText(PreVal);
       }
    
       if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
           hostname.setText("");
       }
       if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
        String PreVal = hostname.getText(); 
        int length = PreVal.length();
        length--;
        if (length > -1) {
          String Val = PreVal.substring(0, length);
          hostname.setText(Val);
        }
       }  
       if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
        String PreVal = hostname.getText(); 
        int length = PreVal.length();
        length--;
        if (length > -1) {
          String Val = PreVal.substring(0, length);
          hostname.setText(Val);
            }  
          }
     }
    }//GEN-LAST:event_hostnameKeyPressed

    private void hexa_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hexa_checkboxActionPerformed
        // TODO add your handling code here: Nope, no way!
        /*
        
        */
        performed_checkbox = true;
        hostname_string = "spinet";
    }//GEN-LAST:event_hexa_checkboxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and Display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BT0;
    private javax.swing.JLabel BT1;
    private javax.swing.JLabel BT2;
    private javax.swing.JLabel BT3;
    private javax.swing.JLabel BT4;
    private javax.swing.JLabel BT5;
    private javax.swing.JLabel BT6;
    private javax.swing.JLabel BT7;
    private javax.swing.JLabel PORTA;
    private javax.swing.JLabel PORTA_arrow;
    private javax.swing.JLabel PORTA_label;
    private javax.swing.JLabel PORTB;
    private javax.swing.JLabel PORTB_arrow;
    private javax.swing.JLabel PORTB_label;
    private javax.swing.JLabel PORTC;
    private javax.swing.JLabel PORTC_arrow;
    private javax.swing.JLabel PORTC_label1;
    private javax.swing.JLabel PORTD;
    private javax.swing.JLabel PORTD_arrow;
    private javax.swing.JLabel PORTD_label;
    private javax.swing.JLabel TEMP;
    private javax.swing.JLabel TRIM1;
    private javax.swing.JLabel TRIM2;
    private javax.swing.JLabel background;
    private javax.swing.JLabel bargraf;
    private javax.swing.JSlider bargraf_slider;
    private javax.swing.JLabel buttons_background;
    private javax.swing.JLabel cursor;
    private javax.swing.JLabel display;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel green_diode;
    private javax.swing.JLabel header;
    private javax.swing.JCheckBox hexa_checkbox;
    private javax.swing.JLabel host_cursor;
    private javax.swing.JLabel hostname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel ports_background;
    private javax.swing.JLabel red_diode;
    private javax.swing.JLabel status;
    private javax.swing.JLabel status2;
    private javax.swing.JLabel temp_disp;
    private javax.swing.JLabel top_background;
    private javax.swing.JProgressBar trim1_bar;
    private javax.swing.JLabel trim1_disp;
    private javax.swing.JProgressBar trim2_bar;
    private javax.swing.JLabel trim2_disp;
    private javax.swing.JLabel trims_background;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) { 
     /*
        Zpracovává stisk klavesy a posilá jej na displej a take nastavuje max. delku displeje na
        4 znaky. Vstupnim parametrem je KeyEvent (ke), který se nastavuje pomocí fce AddKeyListener();  
        
        This code procced key press action and sending result to display and also setting maximal length of display to 4 chararcters. 
        Input parametr is KeyEvent (ke), which has been set via function AddKeyListenet;
      */   
     String ReVal = display.getText();
     int length_max = ReVal.length();
     boolean max_length = false;
     if (length_max == 4) {
       System.out.println("Error reached max. size!");
       max_length = true;
      }
     if (max_length == false) {
       /*
         Vypisování čísel na 7 segmentový displej, zdvojené z důvodu 2 zápisů psaní číslic na klávesnici.
         Konstrukci switch jsem nemohl využít, kvůli špatnému typu proměnné zapisované do KeyEvent (nebyl typu int).
         
         Printing numbers on 7 segmant display, double occurance bcs of 2 ways how to interpretate writting digitals on keyboard 
         I cannot use "switch" bcs of the wrong type of variable...
        */
        if (ke.getKeyCode() == KeyEvent.VK_0) {
            String PreVal = display.getText() + "0";
            display.setText(PreVal);
       } 
       if (ke.getKeyCode() == KeyEvent.VK_1) {
            String PreVal = display.getText() + "1";
            display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_2) {
           String PreVal = display.getText() + "2";
           display.setText(PreVal);
       } 
       if (ke.getKeyCode() == KeyEvent.VK_3) {
           String PreVal = display.getText() + "3";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_4) {
           String PreVal = display.getText() + "4";
           display.setText(PreVal);
       } 
       if (ke.getKeyCode() == KeyEvent.VK_5) {
           String PreVal = display.getText() + "5";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_6) {
           String PreVal = display.getText() + "6";
           display.setText(PreVal);
       } 
       if (ke.getKeyCode() == KeyEvent.VK_7) {
           String PreVal = display.getText() + "7";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_8) {
           String PreVal = display.getText() + "8";
           display.setText(PreVal);
       } 
       if (ke.getKeyCode() == KeyEvent.VK_9) {
           String PreVal = display.getText() + "9";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_NUMPAD0) {
           String PreVal = display.getText() + "0";
           display.setText(PreVal);
       } 
       if (ke.getKeyCode() == KeyEvent.VK_NUMPAD1) {
           String PreVal = display.getText() + "1";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_NUMPAD2) {
           String PreVal = display.getText() + "2";
           display.setText(PreVal);
       } 
       if (ke.getKeyCode() == KeyEvent.VK_NUMPAD3) {
           String PreVal = display.getText() + "3";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_NUMPAD4) {
           String PreVal = display.getText() + "4";
           display.setText(PreVal);
       } 
       if (ke.getKeyCode() == KeyEvent.VK_NUMPAD5) {
           String PreVal = display.getText() + "5";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_NUMPAD6) {
           String PreVal = display.getText() + "6";
           display.setText(PreVal);
       } 
       if (ke.getKeyCode() == KeyEvent.VK_NUMPAD7) {
           String PreVal = display.getText() + "7";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_NUMPAD8) {
           String PreVal = display.getText() + "8";
           display.setText(PreVal);
       } 
       if (ke.getKeyCode() == KeyEvent.VK_NUMPAD9) {
           String PreVal = display.getText() + "9";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_PLUS) {
           String PreVal = display.getText() + "+";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_MINUS) {
           String PreVal = display.getText() + "-";
           display.setText(PreVal);
       }
       //Vypisování písmen na 7 segmentový displej
       //Printing letters on 7 segmant display
       if (ke.getKeyCode() == KeyEvent.VK_A) {
           String PreVal = display.getText() + "A";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_B) {
           String PreVal = display.getText() + "b";
            display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_C) {
           String PreVal = display.getText() + "C";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_D) {
           String PreVal = display.getText() + "d";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_E) {
           String PreVal = display.getText() + "E";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_F) {
           String PreVal = display.getText() + "F";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_G) {
           String PreVal = display.getText() + "G";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_H) {
           String PreVal = display.getText() + "h";
           display.setText(PreVal);
       }       
       if (ke.getKeyCode() == KeyEvent.VK_I) {
           String PreVal = display.getText() + "I";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_J) {
           String PreVal = display.getText() + "J";
           display.setText(PreVal);
       }
       // K nejde
       //K is not possible to create bcs of technical paramters of 7 segment display
       if (ke.getKeyCode() == KeyEvent.VK_L) {
           String PreVal = display.getText() + "L";
           display.setText(PreVal);
       }
      
       if (ke.getKeyCode() == KeyEvent.VK_M) {
           String PreVal = display.getText() + "M";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_N) {
           String PreVal = display.getText() + "n";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_O) {
           String PreVal = display.getText() + "o";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_P) {
           String PreVal = display.getText() + "P";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_R) {
           String PreVal = display.getText() + "R";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_T) {
           String PreVal = display.getText() + "t";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_U) {
           String PreVal = display.getText() + "U";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_V) {
           String PreVal = display.getText() + "u";
           display.setText(PreVal);
       }
       //W,Q,X a  nejdou
       //W,Q,X and  are not possible to create bcs of technical paramters of 7 segment display
       if (ke.getKeyCode() == KeyEvent.VK_X) {
           String PreVal = display.getText() + "x";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_Y) {
           String PreVal = display.getText() + "y";
           display.setText(PreVal);
       }
       if (ke.getKeyCode() == KeyEvent.VK_Z) {
           String PreVal = display.getText() + "Z";
           display.setText(PreVal);
       }
     }
    
       if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
           display.setText("");
       }
       if (ke.getKeyCode() == KeyEvent.VK_DELETE) {
        String PreVal = display.getText(); 
        int length = PreVal.length();
        length--;
        if (length > -1) {
          String Val = PreVal.substring(0, length);
          display.setText(Val);
        }
       }  
       if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
        String PreVal = display.getText(); 
        int length = PreVal.length();
        length--;
        if (length > -1) {
          String Val = PreVal.substring(0, length);
          display.setText(Val);
            }  
          }
        
    }
    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
