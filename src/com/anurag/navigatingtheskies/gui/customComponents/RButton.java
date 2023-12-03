/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anurag.navigatingtheskies.gui.customComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author guler
 */
public class RButton extends JButton {
    private boolean over;
    private Color fill;
    private Font btnFont;
    
    private Color fillOriginal;
    private Color fillOver;
    private Color fillClick;
    private int strokeWidth;

    public RButton() {
        fillOriginal = new Color(52,152,219);
        fillOver = new Color(41,128,185);
        fillClick = new Color(212,84,0);
        fill = fillOriginal;
        strokeWidth = 2;
        setOpaque(false);
        setBorder(null);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBackground(fillOriginal);
        setForeground(Color.white);
        
        btnFont = new Font(getFont().getName(),Font.PLAIN,20);
        setFont(btnFont);
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseExited(MouseEvent e) {
                fill = fillOriginal;
                over = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                 fill = fillOver;
                 over = true;
            }
            
        });
    }

    public Font getBtnFont() {
        return btnFont;
    }

    public void setBtnFont(Font btnFont) {
        this.btnFont = btnFont;
    }
    
    public Color getFillOriginal() {
        return fillOriginal;
    }

    public void setFillOriginal(Color fillOriginal) {
        this.fillOriginal = fillOriginal;
    }

    public Color getFillOver() {
        return fillOver;
    }

    public void setFillOver(Color fillOver) {
        this.fillOver = fillOver;
    }

    public Color getFillClick() {
        return fillClick;
    }

    public void setFillClick(Color fillClick) {
        this.fillClick = fillClick;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        if(!isOpaque()){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            int s = strokeWidth;
            int w = getWidth() - (2*s);
            int h = getHeight() - (2*s);
            g2d.setColor(fill);
            g2d.fillRoundRect(s,s,w,h,h,h);
        }
        super.paintComponent(g);
    }
}
