
package FlightsMashup;

import netscape.javascript.*;

import java.io.*;
import javax.script.*;
import java.applet.Applet;
import java.awt.*;

public class Da_Applet extends javax.swing.JPanel {
        public Da_Applet() {
        initComponents();
    }

  
    final float radio = 3958.755864232f;
    float distancia = 0, tiempo = 0, Velocidad_Miles = 0;
    float[] LAX_loc = { 34.35f , 119.21f }; 
    float[] DVR_loc = { 40.94f , 105.10f }; 
    float[] ATL_loc = { 34.04f ,  85.02f }; 
    float[] DLL_loc = { 33.63f ,  96.26f }; 
    float[] CHG_loc = { 42.28f ,  88.08f };
    float[] origen =  {0,0}, destino= {0,0};

   
    
    public static void main ( String [] args ) {
    
        Da_Applet da = new Da_Applet();
        
    }
    
    
    
    
    le_app LAP = new le_app(); 
    
   public class le_app extends Applet {
      
       @Override
    public void init (  ) {
        JSObject win = JSObject.getWindow(this);
        win.eval("initialize()");
        distancia = (float )win.call( "distance", new Object[] { origen, destino, radio });
    }   
   }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtxtfDuracion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtfDistancia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Origen:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LOS ANGELES, CALIFORNIA", "DENVER, COLORADO", "ALTANTA, GEORGIA", "DALLAS, TEXAS", "CHICAGO, ILLINOIS" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LOS ANGELES, CALIFORNIA", "DENVER, COLORADO", "ALTANTA, GEORGIA", "DALLAS, TEXAS", "CHICAGO, ILLINOIS" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Destino:");

        jLabel3.setText("Tipo Avion:");

        jButton1.setText("SET");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Duracion:");

        jLabel6.setText("Distancia:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BOEING 777", "BOEING 747", "MD11", "AIRBUS A-320", "DC-8", "ANTNOV AN-3" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtfDuracion)
                    .addComponent(jtxtfDistancia)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtfDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtfDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jComboBox1.getAccessibleContext().setAccessibleParent(jComboBox1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(506, 506, 506)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
     
       
        switch( jComboBox3.getSelectedIndex() ) {
            case 1:
                Velocidad_Miles = 560;
                break;
            case 2:
                Velocidad_Miles = 180;
                break;
            case 3:
                Velocidad_Miles = 544;
                break;
            case 4:
                Velocidad_Miles = 530;
                break;
            case 5:
                Velocidad_Miles = 504;
                break;
            case 6:
                Velocidad_Miles = 162;
                break;
            default:
                 break;
            
        }
        
        
        switch( jComboBox1.getSelectedIndex() ) {
            case 1:  //LAX
                switch( jComboBox2.getSelectedIndex() ) { 
                    case 2:
                        origen = LAX_loc;
                        destino = DVR_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 3:
                        origen = LAX_loc;
                        destino = ATL_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 4:
                        origen = LAX_loc;
                        destino = DLL_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 5:
                        origen = LAX_loc;
                        destino = CHG_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                }
           case 2:    //DVR
                switch( jComboBox2.getSelectedIndex() ) { 
                    case 1:
                        origen = DVR_loc;
                        destino = LAX_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 3:
                        origen = DVR_loc;
                        destino = ATL_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 4:
                        origen = DVR_loc;
                        destino = DLL_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 5:
                        origen = DVR_loc;
                        destino = CHG_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                }
            case 3:   //ATL
                switch( jComboBox2.getSelectedIndex() ) { 
                    case 1:
                        origen = ATL_loc;
                        destino = LAX_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 2:
                        origen = ATL_loc;
                        destino = DVR_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 4:
                        origen = ATL_loc;
                        destino = DLL_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 5:
                        origen = ATL_loc;
                        destino = CHG_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                }
            case 4:    //DLL
                switch( jComboBox2.getSelectedIndex() ) { 
                    case 1:
                        origen = DLL_loc;
                        destino = LAX_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 2:
                        origen = DLL_loc;
                        destino = DVR_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 3:
                        origen = DLL_loc;
                        destino = ATL_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 5:
                        origen = DLL_loc;
                        destino = CHG_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                }
            case 5:   //CHG
                switch( jComboBox2.getSelectedIndex() ) { 
                    case 1:
                        origen = CHG_loc;
                        destino = LAX_loc;
                        LAP.init(); 
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 2:
                        origen = CHG_loc;
                        destino = DVR_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 3:
                        origen = CHG_loc;
                        destino = ATL_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                    case 4:
                        origen = CHG_loc;
                        destino = DLL_loc;
                        LAP.init();
                        tiempo = distancia / Velocidad_Miles;
                        break;
                }
                
            default:
                break;
        } 
        jtxtfDuracion.setText( tiempo + " horas.");
        jtxtfDistancia.setText( distancia + " millas.");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jtxtfDistancia;
    private javax.swing.JTextField jtxtfDuracion;
    // End of variables declaration//GEN-END:variables
}
