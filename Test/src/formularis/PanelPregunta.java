/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularis;

import model.Pregunta;
import controller.Controller;
import javax.swing.JRadioButton;
import model.Resposta;

/**
 *
 * @author informaticos
 */
public class PanelPregunta extends javax.swing.JPanel {
    private Pregunta pregunta;
    
    /**
     * Creates new form Pregunta
     */
    public PanelPregunta(Pregunta pregunta) {
        initComponents();
        this.pregunta = pregunta;
        this.text.setText(pregunta.getText());
        this.r1.setText("a. " + pregunta.getRespostes().get(0).getText());
        this.r2.setText("b. " + pregunta.getRespostes().get(1).getText());
        this.r3.setText("c. " + pregunta.getRespostes().get(2).getText());
        this.r4.setText("d. " + pregunta.getRespostes().get(3).getText());
    }

    
    public JRadioButton getR1() {
        return r1;
    }

    public void setR1(JRadioButton r1) {
        this.r1 = r1;
    }

    public JRadioButton getR2() {
        return r2;
    }

    public void setR2(JRadioButton r2) {
        this.r2 = r2;
    }

    public JRadioButton getR3() {
        return r3;
    }

    public void setR3(JRadioButton r3) {
        this.r3 = r3;
    }

    public JRadioButton getR4() {
        return r4;
    }

    /*Getters i setters*/
    public void setR4(JRadioButton r4) {
        this.r4 = r4;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public void setLabelpregunta(String labelpregunta) {
        this.labelpregunta.setText(labelpregunta);
    }

    public void setR1(String r1) {
        this.r1.setText(r1);
    }

    public void setR2(String r2) {
        this.r2.setText(r2);
    }

    public void setR3(String r3) {
        this.r3.setText(r3);
    }

    public void setR4(String r4) {
        this.r4.setText(r4);
    }

    public void setText(String text) {
        this.text.setText(text);
    }
    
    public boolean esCorrecta(){
        Resposta resposta = Controller.getAnswer(pregunta.getCodi());
        if(pregunta.getRespostes().get(0).getText().equals(resposta.getText()) && r1.isSelected()){
            System.out.println("HOLA1");
            System.out.println(r1.isSelected());

            return true;
        }else if(pregunta.getRespostes().get(1).getText().equals(resposta.getText()) && r2.isSelected()){
                        System.out.println("HOLA2");
                                    System.out.println(r2.isSelected());


            return true;
        }else if(pregunta.getRespostes().get(2).getText().equals(resposta.getText()) && r3.isSelected() ){
                        System.out.println("HOLA3");

            return true;
        }else if(pregunta.getRespostes().get(3).getText().equals(resposta.getText()) && r4.isSelected()){
                        System.out.println("HOLA4");

            return true;
        }else{
                        System.out.println("HOLA5");

            return false;
        }
    }
    
    public String getRespostaMarcada(){
        String resposta = null;
        if(r1.isSelected()){
            return r1.getText();
        }else if(r2.isSelected()){
            return r2.getText();
        }else if(r3.isSelected()){
            return r3.getText();
        }else if(r4.isSelected()){
            return r4.getText();
        }else{
            return resposta;
        }
    }
    
    
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        labelpregunta = new javax.swing.JLabel();
        text = new javax.swing.JLabel();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        r4 = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(610, 200));
        setMinimumSize(new java.awt.Dimension(610, 200));
        setPreferredSize(new java.awt.Dimension(610, 200));

        labelpregunta.setText("Pregunta: ");

        buttonGroup1.add(r1);
        r1.setText("jRadioButton1");
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(r2);
        r2.setText("jRadioButton2");

        buttonGroup1.add(r3);
        r3.setText("jRadioButton3");

        buttonGroup1.add(r4);
        r4.setText("jRadioButton4");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r4)
                            .addComponent(r3)
                            .addComponent(r2)
                            .addComponent(r1)
                            .addComponent(labelpregunta)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 302, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelpregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        
    }//GEN-LAST:event_r1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelpregunta;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
