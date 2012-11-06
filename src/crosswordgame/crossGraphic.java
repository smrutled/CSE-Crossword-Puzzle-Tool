package crosswordgame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.JPanel;

public class crossGraphic extends JPanel implements ActionListener {

    GUIManager manager;
    int boardSizeX;
    int boardSizeY;
    int mouseX;
    int mouseY;
    Font boardFont;
    Font hudFont;
    Font numFont;
    FontMetrics boardFontMetrics;
    FontMetrics numFontMetrics;
    FontMetrics hudFontMetrics;
    double panelWidth;
    double panelHeight;
    double boardStart;
    double boxWidth;
    double boxHeight;
    Boolean boxSelected;
    int boxSelectedX;
    int boxSelectedY;
    int count;
    Boolean showPercent;
    Timer timer;

    public crossGraphic() {

        addKeyListener(new KAdapter());
        addMouseListener(new MAdapter());
        setFocusable(true);
        setDoubleBuffered(true);
        manager = GUIManager.getGUIManager();
        boxSelected = false;
        mouseX = -1;
        mouseY = -1;
        count = 0;
        boardSizeX = manager.currentGame.sizeX;
        boardSizeY = manager.currentGame.sizeY;
        timer = new Timer(1000, this);
        timer.start();
        showPercent = false;
    }

    public void actionPerformed(ActionEvent e) {
        count += 1;
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2.setRenderingHints(rh);
        Dimension size = getSize();
        panelWidth = size.getWidth();
        panelHeight = size.getHeight();
        boardStart = panelHeight / 22.22;
        boxWidth = panelWidth / boardSizeX;
        boxHeight = (panelHeight - boardStart) / boardSizeY;


        generateFontMetrics(g2);
        if(manager.currentGame.isAlive)
        drawBoard(g2);
        else
            drawDeadBoard(g2);
        drawHUD(g2);
    }

    public void generateFontMetrics(Graphics2D g2) {
        //Sets up font sizes
        boardFont = new Font("Serif", Font.PLAIN, 1);
        boardFontMetrics = g2.getFontMetrics(boardFont);
        for (int i = 2; boardFontMetrics.getHeight() <= boxHeight * 3 / 4; i += 1) {
            boardFont = new Font("Serif", Font.PLAIN, i);
            boardFontMetrics = g2.getFontMetrics(boardFont);
        }
        numFont = new Font("Serif", Font.PLAIN, 1);
        numFontMetrics = g2.getFontMetrics(numFont);
        for (int i = 2; numFontMetrics.getHeight() <= boxHeight * 2 / 5; i += 1) {
            numFont = new Font("Serif", Font.PLAIN, i);
            numFontMetrics = g2.getFontMetrics(numFont);
        }

        hudFont = new Font("Serif", Font.PLAIN, 1);
        hudFontMetrics = g2.getFontMetrics(hudFont);
        for (int i = 2; hudFontMetrics.getHeight() <= boardStart; i += 1) {
            hudFont = new Font("Serif", Font.PLAIN, i);
            hudFontMetrics = g2.getFontMetrics(hudFont);
        }

    }

    public void drawBoard(Graphics2D g2) {
        //Draw board squares and text strings
        Rectangle2D rec;
        int ix, iy;
        double hz, vt;
        for (vt = boardStart, iy = 0; iy < boardSizeY; vt += boxHeight, iy += 1) {
            for (hz = 0, ix = 0; ix < boardSizeX; hz += boxWidth, ix += 1) {
                g2.setFont(boardFont);
                AffineTransform at =
                        AffineTransform.getTranslateInstance(0, 0);
                if (manager.currentGame.board[ix][iy] == '$') {
                    rec = new Rectangle2D.Double(0, 0, boxWidth, boxHeight);
                    at.translate(hz + 1, vt + 1);
                    Shape tranrec = at.createTransformedShape(rec);
                    g2.setColor(Color.black);
                    g2.fill(tranrec);
                    g2.draw(tranrec);
                } else {
                    rec = new Rectangle2D.Double(0, 0, boxWidth - 3, boxHeight - 3);
                    at.translate(hz + 2, vt + 2);
                    Shape tranrec = at.createTransformedShape(rec);
                    if (boxSelectedX == ix && boxSelectedY == iy) {
                        if (manager.currentGame.playerTurn) {
                            g2.setColor(Color.yellow);
                        } else {
                            g2.setColor(Color.CYAN);
                        }
                    } else {
                        g2.setColor(Color.white);
                    }
                    g2.fill(tranrec);
                    g2.draw(tranrec);
                    g2.setColor(Color.black);

                    g2.drawString(Character.toString(manager.currentGame.inputboard[ix][iy]), (float) (hz + boxWidth / 2 - boardFontMetrics.charWidth(manager.currentGame.inputboard[ix][iy]) / 2), (float) (vt + (boxHeight / 2) + boardFontMetrics.getAscent() / 2));
                    g2.setFont(numFont);
                    for (int i = 0; i < manager.currentGame.wordList.length; i++) {
                        if (manager.currentGame.wordList[i].startX == ix && manager.currentGame.wordList[i].startY == iy) {
                            g2.drawString(Integer.toString(manager.currentGame.wordList[i].num), (float) (hz + boxWidth / 5 - numFontMetrics.stringWidth(Integer.toString(i + 1)) / 2), (float) (vt + boxHeight * 2 / 6));
                        }
                    }
                }


            }
        }


        //Draw board lines
        Line2D e = new Line2D.Double(0, boardStart, 0, panelHeight);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.black);
        for (hz = 0; hz < panelWidth; hz += boxWidth) {
            AffineTransform at =
                    AffineTransform.getTranslateInstance(0, 0);
            at.translate(hz, 0);
            g2.draw(at.createTransformedShape(e));
        }
        e = new Line2D.Double(0, 0, panelWidth, 0);
        for (vt = boardStart; vt < panelHeight; vt += boxHeight) {
            AffineTransform at =
                    AffineTransform.getTranslateInstance(0, 0);
            at.translate(0, vt);
            g2.draw(at.createTransformedShape(e));
        }
    }

    public void drawDeadBoard(Graphics2D g2) {
        //Draw board squares and text strings
        Rectangle2D rec;
        int ix, iy;
        double hz, vt;
        for (vt = boardStart, iy = 0; iy < boardSizeY; vt += boxHeight, iy += 1) {
            for (hz = 0, ix = 0; ix < boardSizeX; hz += boxWidth, ix += 1) {
                g2.setFont(boardFont);
                AffineTransform at =
                        AffineTransform.getTranslateInstance(0, 0);
                if (manager.currentGame.board[ix][iy] == '$') {
                    rec = new Rectangle2D.Double(0, 0, boxWidth, boxHeight);
                    at.translate(hz + 1, vt + 1);
                    Shape tranrec = at.createTransformedShape(rec);
                    g2.setColor(Color.black);
                    g2.fill(tranrec);
                    g2.draw(tranrec);
                } else {
                    rec = new Rectangle2D.Double(0, 0, boxWidth - 3, boxHeight - 3);
                    at.translate(hz + 2, vt + 2);
                    Shape tranrec = at.createTransformedShape(rec);
                    if (manager.currentGame.board[ix][iy] == manager.currentGame.inputboard[ix][iy]) {
                        g2.setColor(Color.white);
                    } else {
                        g2.setColor(Color.red);
                    }
                    g2.fill(tranrec);
                    g2.draw(tranrec);
                    g2.setColor(Color.black);
                    if (manager.currentGame.board[ix][iy] == manager.currentGame.inputboard[ix][iy]) {
                        g2.drawString(Character.toString(manager.currentGame.inputboard[ix][iy]), (float) (hz + boxWidth / 2 - boardFontMetrics.charWidth(manager.currentGame.inputboard[ix][iy]) / 2), (float) (vt + (boxHeight / 2) + boardFontMetrics.getAscent() / 2));
                    } else {
                        g2.drawString(Character.toString(manager.currentGame.board[ix][iy]), (float) (hz + boxWidth / 2 - boardFontMetrics.charWidth(manager.currentGame.board[ix][iy]) / 2), (float) (vt + (boxHeight / 2) + boardFontMetrics.getAscent() / 2));
                    }
                    g2.setFont(numFont);
                    for (int i = 0; i < manager.currentGame.wordList.length; i++) {
                        if (manager.currentGame.wordList[i].startX == ix && manager.currentGame.wordList[i].startY == iy) {
                            g2.drawString(Integer.toString(manager.currentGame.wordList[i].num), (float) (hz + boxWidth / 5 - numFontMetrics.stringWidth(Integer.toString(i + 1)) / 2), (float) (vt + boxHeight * 2 / 6));
                        }
                    }
                }


            }
        }


        //Draw board lines
        Line2D e = new Line2D.Double(0, boardStart, 0, panelHeight);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.black);
        for (hz = 0; hz < panelWidth; hz += boxWidth) {
            AffineTransform at =
                    AffineTransform.getTranslateInstance(0, 0);
            at.translate(hz, 0);
            g2.draw(at.createTransformedShape(e));
        }
        e = new Line2D.Double(0, 0, panelWidth, 0);
        for (vt = boardStart; vt < panelHeight; vt += boxHeight) {
            AffineTransform at =
                    AffineTransform.getTranslateInstance(0, 0);
            at.translate(0, vt);
            g2.draw(at.createTransformedShape(e));
        }
    }

    public void drawHUD(Graphics2D g) {
        int strmet;
        String hudstring;

        g.setFont(hudFont);
        if (showPercent) {
            g.drawString(Integer.toString(manager.currentGame.stats.wordComp) + "/"+Integer.toString(manager.currentGame.stats.wordCount), 10, (int) boardStart - 5);
        }
        if(manager.currentGame.isAlive)
        g.drawString(manager.currentGame.stats.getTimeElapsed(Calendar.getInstance()), 100, (int) boardStart - 5);
        else
           g.drawString(manager.currentGame.stats.getTimeElapsed(manager.currentGame.stats.endDate), 100, (int) boardStart - 5); 
        hudstring = "Player:" + Integer.toString((manager.currentGame.playerTurn ? 1 : 2));
        strmet = hudFontMetrics.stringWidth(hudstring);
        g.drawString(hudstring, (int) panelWidth - strmet, (int) boardStart - 5);
    }

    public void getSelectedBox(double x, double y) {
        int ix = 0, iy = 0;
        double hz = 0, vt = boardStart;
        if(y>=boardStart){
        while (hz <= x) {
            hz += boxWidth;
            ix += 1;
        }
        while (vt <= y) {
            vt += boxHeight;
            iy += 1;
        }
        if (manager.currentGame.board[ix - 1][iy - 1] != '$') {
            boxSelectedX = ix - 1;
            boxSelectedY = iy - 1;
            boxSelected = true;
        } else {
            boxSelected = false;
        }
        }
    }

    private class KAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            if (boxSelected && manager.currentGame.isAlive) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (boxSelectedX + 1 <= manager.currentGame.sizeX - 1 && manager.currentGame.board[boxSelectedX + 1][boxSelectedY] != '$') {
                        boxSelectedX += 1;
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (boxSelectedX - 1 >= 0 && manager.currentGame.board[boxSelectedX - 1][boxSelectedY] != '$') {
                        boxSelectedX -= 1;
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (boxSelectedY - 1 >= 0 && manager.currentGame.board[boxSelectedX][boxSelectedY - 1] != '$') {
                        boxSelectedY -= 1;
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (boxSelectedY + 1 <= manager.currentGame.sizeY - 1 && manager.currentGame.board[boxSelectedX][boxSelectedY + 1] != '$') {
                        boxSelectedY += 1;
                    }
                } else if (boxSelected) {
                    manager.currentGame.inputboard[boxSelectedX][boxSelectedY] = e.getKeyChar();
                    manager.currentGame.UpdatePercentCompelete();
                }
                repaint();
            }
        }

        public void keyPressed(KeyEvent e) {
        }
    }

    class MAdapter extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
            getSelectedBox(mouseX, mouseY);

        }

        public void mouseReleased(MouseEvent e) {
            repaint();
        }

        public void mouseEntered(MouseEvent e) {
            requestFocusInWindow();
        }
    }
}
