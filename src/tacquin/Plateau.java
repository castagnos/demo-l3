/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tacquin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import constantes.constantes;


/**
 *
 * @author Gus
 */
public class Plateau implements Initializable {
    @FXML
    private Label score; // value will be injected by the FXMLLoader
    @FXML
    private GridPane grille;
    @FXML
    private Pane fond2; // panneau recouvrant toute la fenêtre
    
    
    //private int plateau[][] = {{1,2,3,4},{1,2,3,4}};
    private int taille = 4;
    private Tuile plateau[][] = new Tuile[taille][taille];

    // coord les coord de la tuile  deplacer [0] ligne [1] colonne
    private int coord[] = new int[2];

    
    


    
    /**
     * fonction qui initialise le jeu
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        // on cree 4 tuiles
        this.creerTuile();
        // utilisation de styles pour la grille et la tuile (voir styles.css)
        this.styles();
        // on place la tuile en précisant les coordonnées (x,y) du coin supérieur gauche
        this.placerTuiles();
    }
    
    @FXML
    public void keyPressed(KeyEvent event) {
        System.out.println("test");
    }
    
    
    @FXML
    private void handleDragAction(MouseEvent event) {
        System.out.println("Pas encore implemente");
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
        System.out.println("Pas encore implemente");
    }

    

    /**
     * fonction qui cree les tuiles
     */
    public void creerTuile(){
        int num = 0; // numero de la tuile
        // Parcours du plateau 
        for(int j =0;j<taille;j++){ 
            for(int i=0;i<taille;i++){
                //constantes = une classe parce que c'est de la merde
                // xGrille = le point (pixel) de départ de la grille
                // longTuile = taille de la tuile
                int x = constantes.xGrille + i*(500/taille);
                int y = constantes.yGrille + j*(500/taille);
                num ++;
                String s = String.valueOf(num);
                plateau[i][j]= new Tuile(x,y,s);
                plateau[i][j].setP(new Pane());
            }
        }
        plateau[taille-1][taille-1].setDisplay(false);
        Label temp = new Label("");
        plateau[taille-1][taille-1].setC(temp);
    }
    
    /**
     * grille = la grille de fxml.
     * plateau.p = panel dans Tuiles
     * plateau.c = label dans Tuiles
     */
    public void styles(){
        
        grille.getStyleClass().add("gridpane");
        for(int j=0;j<plateau.length;j++){
           for(int i=0;i<plateau.length;i++){
            plateau[i][j].getP().getStyleClass().add("pane");
            plateau[i][j].getC().getStyleClass().add("tuile");
            GridPane.setHalignment(plateau[i][j].getC(), HPos.CENTER);
            fond2.getChildren().add(plateau[i][j].getP());
            grille.add(plateau[i][j].getP(), i, j);
            plateau[i][j].getP().getChildren().add(plateau[i][j].getC());
            } 
        }
        
    }
    
    public void placerTuiles(){
        for(int j=0;j<plateau.length;j++){
           for(int i=0;i<plateau.length;i++){
            plateau[i][j].getP().setLayoutX(plateau[i][j].getX());
            plateau[i][j].getP().setLayoutY(plateau[i][j].getY());
            if(!plateau[i][j].isDisplay()){
             plateau[i][j].getP().setVisible(false);
             plateau[i][j].getC().setVisible(false);
            }   
        } 

        }
        
    }
    

        
        
    
   
    /**
     *fonction qui permet de parcourir la grille pour rechercher la tuille vide
     * on affecte ensuite sa place dans le tableau corrd i et j a l attribut corrdonne
     */
    public void trouverTuileVide(){
        boolean trouve = false;
        int j=0;
        int i=0;
        while(j<plateau.length && !trouve){
            while(i<plateau.length && !trouve){
              if(!plateau[i][j].isDisplay()){
                   coord[0]=i;
                   coord[1]=j;
                   trouve = true;
               }else{
                  i++;
              }
            }
            j++;
        }
    }
}
