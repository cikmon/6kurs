package sample;

import com.bulletphysics.linearmath.Transform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

import javax.swing.*;
import javax.vecmath.Matrix4f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Controller {
    public TextField namesform;
    public TextField widthform;
    public TextField haightform;
    public ComboBox<String> combobox1;
    public ComboBox<String> combobox2;
    public ComboBox<String> combobox3;
    public ComboBox<String> combobox4;
    public TextField coordYform;
    public TextField coordXform;
    public TextField angleform;

    @FXML
    ProgressBar p1 = new ProgressBar();
    @FXML
    Text tt1=new Text();
    @FXML
    Button bt1;
    @FXML
    Button bt2;

    private int WrazmerKorpusa = 0;
    private int HrazmerKorpusa = 0;
    private int LrazmerKorpusa = 0;
    private int ThicknessRrazmerKorpusa = 0;

    private Bd[] bd;
    private Ploskosti[] osnovnoi;
    private Ploskosti[] ryadom;
    private Ploskosti[] ostalnie;


    private int kolvosnaclonom = 0;

    private int n = 0;
    private int nustnovl = 0;
    private int scetchikprogress = 0;


    private JFXPanel primaryStage;
    private ObservableList<String> list = FXCollections.observableArrayList("Cоздание обьекта №1");
    private ObservableList<String> list2 = FXCollections.observableArrayList("свободное размещение");
    private ObservableList<String> list3 = FXCollections.observableArrayList("Передняя", "Задняя", "Слева", "Справа", "Нижняя", "Верхняя");

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML

    private void handleOpen() throws IOException {
        //String fileName = "/Users/prologistic/source.txt";
        // readUsingFiles(fileName);
        String[] open1 = new String[10000];
        String[][] openrazb = new String[10000][15];
        int rrr = 0;
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            FileReader fr = new FileReader(file);

            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                open1[rrr] = line;
                // считываем остальные строки в цикле
                line = reader.readLine();

                rrr++;
            }
            fr.close();
        }


        for (int i = 0; i < rrr; i++) openrazb[i] = (open1[i]).split(";");

        WrazmerKorpusa = Integer.parseInt(openrazb[1][0]);
        HrazmerKorpusa = Integer.parseInt(openrazb[1][1]);
        LrazmerKorpusa = Integer.parseInt(openrazb[1][2]);
        ThicknessRrazmerKorpusa = Integer.parseInt(openrazb[1][3]);

        n = rrr - 3;
        bd = new Bd[n];
        osnovnoi = new Ploskosti[n];
        for (int i = 3; i < rrr; i++) {
            int mmm[] = new int[7];
            if (openrazb[i][4].trim().length() == 0|Integer.parseInt(openrazb[i][4])==0) mmm[0] = -1000;
            else mmm[0] = Integer.parseInt(openrazb[i][4]);
            if (openrazb[i][5].trim().length() == 0|Integer.parseInt(openrazb[i][5])==0) mmm[1] = -1000;
            else mmm[1] = Integer.parseInt(openrazb[i][5]);
            if (openrazb[i][6].trim().length() == 0|Integer.parseInt(openrazb[i][6])==0) mmm[2] = -1000;
            else mmm[2] = Integer.parseInt(openrazb[i][6]);
            if (openrazb[i][7].trim().length() == 0|Integer.parseInt(openrazb[i][7])==0) mmm[3] = -1000;
            else mmm[3] = Integer.parseInt(openrazb[i][7]);
            if (openrazb[i][8].trim().length() == 0) mmm[4] = 0;
            else mmm[4] = Integer.parseInt(openrazb[i][8]);
            if (openrazb[i][9].trim().length() == 0) mmm[5] = 0;
            else mmm[5] = Integer.parseInt(openrazb[i][9]);
            if (openrazb[i][10].trim().length() == 0) mmm[6] = 0;
            else mmm[6] = Integer.parseInt(openrazb[i][10]);

            try {
                bd[i - 3] = new Bd("№" + (i - 2) + " " + openrazb[i][0], Integer.parseInt(openrazb[i][1]),
                        Integer.parseInt(openrazb[i][2]), Integer.parseInt(openrazb[i][3]), mmm[0],
                        mmm[1], mmm[2], mmm[3], mmm[4], mmm[5], mmm[6]);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("Неверный формат строк!");
                alert.showAndWait();
            }
        }

////        combobox4.setItems(list3);
      ////  combobox4.getSelectionModel().select(ploskostpostr);


        System.out.println(n);

////
/*        combobox4.getSelectionModel().selectedIndexProperty().
                addListener((ObservableValue<? extends Number> ov4, Number old_val4, Number new_val4) -> {
                    ploskostpostr = new_val4.intValue();
                });

*/
        for (int i = 0; i < bd.length; i++)
            System.out.println(bd[i].names() + " " + bd[i].width() + " " + bd[i].haight() + " " + bd[i].length() + " " + bd[i].coordX() + " " +
                    bd[i].coordY() + " " + bd[i].coordZ() + " " + bd[i].ryadom() + " " + bd[i].angleX() + " " + bd[i].angleY()+" "+ bd[i].angleZ());


        System.out.println("ok");

    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        //alert.setTitle("AddressApp");
        // alert.setHeaderText("About");
        // alert.setContentText("Author: Marco Jakob\nWebsite: http://code.makery.ch");
        alert.showAndWait();
    }

    @FXML
    private void handleSave() {
        SW sw=new SW(osnovnoi,n,WrazmerKorpusa,HrazmerKorpusa,LrazmerKorpusa,ThicknessRrazmerKorpusa);
        sw.save();
    }


    @FXML
    private void handleLocaterazmesh() throws IOException, InterruptedException {
/*
        metodInstalKoord();
        metodInstallingBeside();
        metodInstalOthers();


        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Расчеты завершились.");
        alert.showAndWait();

        System.out.println("ok");
*/
        p1.setVisible(true);
        tt1.setVisible(true);
        bt1.setDisable(true);
        bt2.setDisable(true);
        new Thread(() -> {
            metodInstalKoord();
            metodInstallingBeside();
            metodInstalOthers();

/*
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Расчеты завершились.");
            alert.showAndWait();
*/
            System.out.println("ok");
            bt1.setDisable(false);
            bt2.setDisable(false);
            tt1.setText("Расчеты завершились "+scetchikprogress+"/"+bd.length);
        },"TheardZ1").start();




/*
        for(int i=0;i<19;i++) {
            System.out.println(osnovnoi[i].toString());
        }
*/
    }

    public void metodproverkaustanovl() {
        for(int i=0;i<bd.length;i++){
            System.out.println(bd[i].names()+";"+bd[i].width()+";"+bd[i].haight()+";"+bd[i].length()+";"+bd[i].coordX()+";"+bd[i].coordY()+";"+
                    bd[i].coordZ()+";"+bd[i].ryadom()+";"+bd[i].angleX()+";"+bd[i].angleY()+";"+bd[i].angleZ());
        }

    }



    public void progressbar(){
        new Thread(()->{
            p1.setVisible(true);
            tt1.setVisible(true);
            p1.setProgress(0.1);
            tt1.setText(12.666+"%");

        }).start();
        bt1.setDisable(true);


    }


    public boolean proverkaa(double x, double y, double z, int width, int height, int length,int angleX, int angleY, int angleZ,int id) {
        boolean r = true;//означает что нет совпадений
        exit:
        //{
        for (int i = 0; i < nustnovl; i++) {
           // if (i != imetodinstalkoord) {
                if (osnovnoi[i].getId()!=id) {
               // System.out.println(i);
                if (osnovnoi[i].angleX() == 0 && osnovnoi[i].angleY() == 0 && osnovnoi[i].angleZ() == 0 && angleX == 0
                        && angleY == 0 && angleZ == 0) {
                    if (osnovnoi[i].coordX() >= x & osnovnoi[i].coordX() <= x + width &
                            osnovnoi[i].coordY() <= y & osnovnoi[i].coordY() + osnovnoi[i].haight() >= y &
                            osnovnoi[i].coordZ() <= z & osnovnoi[i].coordZ() + osnovnoi[i].lenght() >= z |

                            osnovnoi[i].coordX() >= x & osnovnoi[i].coordX() <= x + width &
                                    osnovnoi[i].coordY() >= y & osnovnoi[i].coordY() <= y + height &
                                    osnovnoi[i].coordZ() <= z & osnovnoi[i].coordZ() + osnovnoi[i].lenght() >= z |

                            osnovnoi[i].coordX() <= x & osnovnoi[i].coordX() + osnovnoi[i].width() >= x &
                                    osnovnoi[i].coordY() >= y & osnovnoi[i].coordY() <= y + height &
                                    osnovnoi[i].coordZ() <= z & osnovnoi[i].coordZ() + osnovnoi[i].lenght() >= z |

                            osnovnoi[i].coordX() <= x & osnovnoi[i].coordX() + osnovnoi[i].width() >= x &
                                    osnovnoi[i].coordY() <= y & osnovnoi[i].coordY() + osnovnoi[i].haight() >= y &
                                    osnovnoi[i].coordZ() <= z & osnovnoi[i].coordZ() + osnovnoi[i].lenght() >= z |

                            ///////////////////////////////
                            osnovnoi[i].coordX() >= x & osnovnoi[i].coordX() <= x + width &
                                    osnovnoi[i].coordY() <= y & osnovnoi[i].coordY() + osnovnoi[i].haight() >= y &
                                    osnovnoi[i].coordZ() >= z & osnovnoi[i].coordZ() <= z + length |

                            osnovnoi[i].coordX() >= x & osnovnoi[i].coordX() <= x + width &
                                    osnovnoi[i].coordY() >= y & osnovnoi[i].coordY() <= y + height &
                                    osnovnoi[i].coordZ() >= z & osnovnoi[i].coordZ() <= z + length |

                            osnovnoi[i].coordX() <= x & osnovnoi[i].coordX() + osnovnoi[i].width() >= x &
                                    osnovnoi[i].coordY() >= y & osnovnoi[i].coordY() <= y + height &
                                    osnovnoi[i].coordZ() >= z & osnovnoi[i].coordZ() <= z + length |

                            osnovnoi[i].coordX() <= x & osnovnoi[i].coordX() + osnovnoi[i].width() >= x &
                                    osnovnoi[i].coordY() <= y & osnovnoi[i].coordY() + osnovnoi[i].haight() >= y &
                                    osnovnoi[i].coordZ() >= z & osnovnoi[i].coordZ() <= z + length |


                            x <= ThicknessRrazmerKorpusa || x + width >= WrazmerKorpusa - ThicknessRrazmerKorpusa ||
                            y <= ThicknessRrazmerKorpusa || y + height >= HrazmerKorpusa - ThicknessRrazmerKorpusa ||
                            z <= ThicknessRrazmerKorpusa || z + length >= LrazmerKorpusa - ThicknessRrazmerKorpusa) {

/*
                System.out.println(z+" y="+y+" z="+z);
                System.out.println(width+" "+height+" "+length);
                System.out.println(WrazmerKorpusa+" "+HrazmerKorpusa+" "+LrazmerKorpusa);
                System.out.println(osnovnoi[i].coordX()+" jsn y="+osnovnoi[i].coordY()+" "+osnovnoi[i].coordZ());
                System.out.println(osnovnoi[i].width()+" "+osnovnoi[i].haight()+" "+osnovnoi[i].lenght());
*/

                        r = false;
                      //  System.out.println("prov " + i);
                        break exit;
                    }
                }

                    else {
                        Check check = new Check();
                        Ploskosti obj2 = new Ploskosti("check", width, height, length, (int) x, (int) y, (int) z, angleX, angleY, angleZ,-1000);

                        if (check.start(obj2, osnovnoi[i])) {
                            r = false;
                            break exit;

                        }
                    }



           // }
        }
       /* for (int i = 0; i < nustnovl; i++) {
            if (osnovnoi[i].angleX() != 0 || osnovnoi[i].angleY() != 0 || osnovnoi[i].angleZ() != 0 || angleX != 0
                    || angleY != 0 || angleZ != 0) {
                Check check = new Check();
                Ploskosti obj2 = new Ploskosti("check", width, height, length, (int) x, (int) y, (int) z, angleX, angleY, angleZ,-1000);
                if (check.start(obj2, osnovnoi[i])) {
                    r = false;
                    break exit;
                }
            }
        }*/
    }

        return r;
    }
//int imetodinstalkoord=0;
    public void metodInstalKoord(){

       // System.out.println(nustnovl);
        for (int i = 0; i < bd.length; i++) {
            if (bd[i].coordX() != -1000) {
            osnovnoi[i]=new Ploskosti(bd[i].names(),bd[i].width(),bd[i].haight(),bd[i].length(),bd[i].coordX(),bd[i].coordY(),bd[i].coordZ(),
                    bd[i].angleX(),bd[i].angleY(),bd[i].angleZ(),i);
                System.out.println(bd[i].coordX()+" ");
                Transform transform =new Transform();

                if(osnovnoi[i].angleX()!=0)
                transform.basis.rotX((float)Math.toRadians(osnovnoi[i].angleX()));
                else
                    if(osnovnoi[i].angleY()!=0)
                        transform.basis.rotY((float)Math.toRadians(osnovnoi[i].angleY()));
                else
                    if(osnovnoi[i].angleZ()!=0)
                        transform.basis.rotZ((float)Math.toRadians(osnovnoi[i].angleZ()));

                transform.origin.set((float) osnovnoi[i].coordX(),(float) osnovnoi[i].coordY(),(float) osnovnoi[i].coordZ());
                Matrix4f rte=new Matrix4f();
                transform.getMatrix(rte);
                System.out.print(rte.toString());
                osnovnoi[i].setMatrix4f(rte);

            nustnovl++;
            }
        }
        System.out.println(nustnovl);
        exit:
        for(int i=0;i<nustnovl;i++){
           // imetodinstalkoord=i;

              if( ! proverkaa(osnovnoi[i].coordX(), osnovnoi[i].coordY(), osnovnoi[i].coordZ(), osnovnoi[i].width(), osnovnoi[i].haight(),
                      osnovnoi[i].lenght(),osnovnoi[i].angleX(),osnovnoi[i].angleY(),osnovnoi[i].angleZ(),osnovnoi[i].getId())) {
                 /* Alert alert = new Alert(AlertType.INFORMATION);
                  alert.setContentText("Деталь №"+i+" налазит на другие детали");
                  alert.showAndWait();
                  System.out.println("pr=" +osnovnoi[i].coordX());
                  */
                  tt1.setText("Деталь №"+i+" налазит на другие детали");
                  try {
                      Thread.sleep(100000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  break exit;
              }
            {
                //System.out.println(i+" i metod inst koord");

            p1.setProgress((double) ++scetchikprogress/bd.length);
                    String tre=String.format("%.4f", (double)scetchikprogress/bd.length*100);
                 tt1.setText(tre+"% "+scetchikprogress+"/"+bd.length);
              //  p1.setProgress(0.5);
            }
           // lp1.setText(scetchikprogress/bd.length*100+"% "+scetchikprogress/bd.length);
        }
      // imetodinstalkoord=-1;
    }

    public void metodInstallingBeside() {
       // System.out.println(nustnovl+"  nustanovl");
        for (int i = 0; i < bd.length; i++) {
            if (bd[i].ryadom() != -1000&bd[i].coordX()==-1000) {
                for (int j = 0; j < nustnovl; j++) {
                    String str = osnovnoi[j].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    if (bd[i].ryadom() == Integer.parseInt(wsw)) {

                        exit:
                        for (int kz = 1; kz < 300; kz = kz + 15) {
                            for (int ky = 1; ky < 300; ky = ky + 15) {
                                for (int kx = 1; kx < 300; kx = kx + 15) {
                                    for (int cz = 0; cz < 80; cz = cz + 45) {
                                        for (int cy = 0; cy < 80; cy = cy + 45) {
                                            for (int cx = 0; cx < 80; cx = cx + 45) {

                                                //справа n
                                                if (proverkaa(osnovnoi[j].coordX() + osnovnoi[j].width() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + kz, bd[i].width(), bd[i].haight(), bd[i].length(),
                                                        0, 0, 0,i)) {
                                                    osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                            osnovnoi[j].coordX() + osnovnoi[j].width() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + kz,
                                                            0, 0, 0,i);
                                                    nustnovl++;
                                                    break exit;
                                                } else
                                                    //слева
                                                    if (proverkaa(osnovnoi[j].coordX() - bd[i].width() - kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + kz, bd[i].width(), bd[i].haight(), bd[i].length(),
                                                            0, 0, 0,i)) {
                                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                                osnovnoi[j].coordX() - bd[i].width() - kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + kz,
                                                                0, 0, 0,i);
                                                        nustnovl++;
                                                        break exit;
                                                    } else
                                                        //сверху
                                                        if (proverkaa(osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + osnovnoi[j].haight() + ky, osnovnoi[j].coordZ() + kz, bd[i].width(), bd[i].haight(), bd[i].length(),
                                                                0, 0, 0,i)) {
                                                            osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                                    osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + osnovnoi[j].haight() + ky, osnovnoi[j].coordZ() + kz,
                                                                    0, 0, 0,i);
                                                            nustnovl++;
                                                            break exit;
                                                        } else
                                                            //снизу
                                                            if (proverkaa(osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() - bd[i].haight() - ky, osnovnoi[j].coordZ() + kz, bd[i].width(), bd[i].haight(), bd[i].length(),
                                                                    0, 0, 0,i)) {
                                                                osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                                        osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() - bd[i].haight() - ky, osnovnoi[j].coordZ() + kz,
                                                                        0, 0, 0,i);
                                                                nustnovl++;
                                                                break exit;
                                                            } else
                                                                //сзади
                                                                if (proverkaa(osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + bd[i].length() + kz, bd[i].width(), bd[i].haight(), bd[i].length(),
                                                                        0, 0, 0,i)) {
                                                                    osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                                            osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() + bd[i].length() + kz,
                                                                            0, 0, 0,i);
                                                                    nustnovl++;
                                                                    break exit;
                                                                } else
                                                                    //спереди
                                                                    if (proverkaa(osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() - bd[j].length() - kz, bd[i].width(), bd[i].haight(), bd[i].length(),
                                                                            0, 0, 0,i)) {
                                                                        osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                                                                osnovnoi[j].coordX() + kx, osnovnoi[j].coordY() + ky, osnovnoi[j].coordZ() - bd[j].length() - kz,
                                                                                0, 0, 0,i);
                                                                        nustnovl++;
                                                                        break exit;
                                                                    }


                                            }
                                        }
                                    }
                                }
                            }


                        }


                    }

                }
            }


        }
       // System.out.println(nustnovl+"  nustanovl");

    }
//
    public void metodInstalOthers() {

        for (int i = 0; i < bd.length; i++) {
            if(bd[i].coordX()==-1000&&bd[i].coordY()==-1000&&bd[i].coordZ()==-1000&&bd[i].ryadom()==-1000) {
                exit:
                for (int kz = ThicknessRrazmerKorpusa; kz < LrazmerKorpusa-ThicknessRrazmerKorpusa; kz = kz + 30) {
                    for (int ky = ThicknessRrazmerKorpusa; ky < HrazmerKorpusa-ThicknessRrazmerKorpusa; ky = ky + 30) {
                        for (int kx = ThicknessRrazmerKorpusa; kx < WrazmerKorpusa-ThicknessRrazmerKorpusa; kx = kx + 30) {

                            if (proverkaa(kx, ky, kz, bd[i].width(), bd[i].haight(), bd[i].length(),0,0,0,i)) {

                                osnovnoi[nustnovl] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(),
                                        kx, ky, kz, bd[i].angleX(), bd[i].angleY(), bd[i].angleZ(),i);

                                nustnovl++;
                                p1.setProgress((double)++scetchikprogress/bd.length);
                                String tre=String.format("%.4f", (double)scetchikprogress/bd.length*100);
                                tt1.setText(tre+"% "+scetchikprogress+"/"+bd.length);
                                break exit;
                            }

                        }
                    }

                }
            }


        }
    }
}