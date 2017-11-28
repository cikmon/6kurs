package sample;

import javax.vecmath.Matrix4f;

public class Ploskosti {


    private String names;
    private double coordX;
    private double coordY;
    private double coordZ;

    private int haight;
    private int width;
    private int lenght;

    private int angleX;
    private int angleY;
    private int angleZ;

    private Matrix4f matrix4f=new Matrix4f(
            1,0,0,0,
            0,1,0,0,
            0,0,1,0,
            0,0,0,1);

    public Matrix4f getMatrix4f() {
        return matrix4f;
    }

    public void setMatrix4f(Matrix4f matrix4f) {
        this.matrix4f = matrix4f;
    }




/*
    private short[][] pixels;
    private short[][] pixels2;
    private short[][] pixels3;
    private short[][] pixels4;
    private short[][] pixels5;
    private short[][] pixels6;

    private int lengthpix=0;
    private int lengthpix2=0;
    private int lengthpix3=0;
    private int lengthpix4=0;
    private int lengthpix5=0;
    private int lengthpix6=0;

    //0x;1y;2z
    private double tochka1[]=new double[3];
    private double tochka2[]=new double[3];
    private double tochka3[]=new double[3];
    private double tochka4[]=new double[3];
    private double tochka5[]=new double[3];
    private double tochka6[]=new double[3];
    private double tochka7[]=new double[3];
    private double tochka8[]=new double[3];

*/


    public Ploskosti(
            String names,int width, int haight,int lenght, double coordX, double coordY,double coordZ,
            int angleX,int angleY,int angleZ){
        this.names=names;
        this.coordX=coordX;
        this.coordY=coordY;
        this.coordZ=coordZ;
        this.angleX=angleX;
        this.angleY=angleY;
        this.angleZ=angleZ;

        this.width=width;
        this.haight=haight;
        this.lenght=lenght;
/*
        pixels=new short[3][haight*width];
        pixels2=new short[3][haight*lenght*2];
        pixels3=new short[3][haight*lenght*2];
        pixels4=new short[3][lenght*width];
        pixels5=new short[3][lenght*width];
        pixels6=new short[3][haight*width*2];
*/

    }

    public double coordX(){return coordX;}
    public double coordY(){return coordY;}
    public double coordZ(){return coordZ;}
    public int angleX(){return angleX;}
    public int angleY(){return angleY;}
    public int angleZ(){return angleZ;}
    public String names(){return names;}


    public int haight(){
        return haight;
    }
    public int width(){return width;}
    public int lenght(){return lenght;}

    public void setCoordX(double coordX) {this.coordX = coordX;}
    public void setCoordY(double coordY) {this.coordY = coordY;}
    public void setCoordZ(double coordZ) {this.coordZ = coordZ;}

    /*
    public short pixels(int i, int j){return pixels[i][j];}
    public short pixels2(int i, int j){return pixels2[i][j];}
    public short pixels3(int i, int j){return pixels3[i][j];}
    public short pixels4(int i, int j){return pixels4[i][j];}
    public short pixels5(int i, int j){return pixels5[i][j];}
    public short pixels6(int i, int j){return pixels6[i][j];}



    public int lengthpix(){return lengthpix;}
    public int lengthpix2(){return lengthpix2;}
    public int lengthpix3(){return lengthpix3;}
    public int lengthpix4(){return lengthpix4;}
    public int lengthpix5(){return lengthpix5;}
    public int lengthpix6(){return lengthpix6;}


    public void dobavlpixels(short pixelX,short pixelY,short pixelZ){
        this.pixels[0][lengthpix]=pixelX;
        this.pixels[1][lengthpix]=pixelY;
        this.pixels[2][lengthpix]=pixelZ;
        this.lengthpix++;
    }
    public void dobavlpixels6(short pixelX,short pixelY,short pixelZ){
        this.pixels6[0][lengthpix6]=pixelX;
        this.pixels6[1][lengthpix6]=pixelY;
        this.pixels6[2][lengthpix6]=pixelZ;
        this.lengthpix6++;
    }
    public void dobavlpixels2(short pixelX,short pixelY,short pixelZ){
        this.pixels2[0][lengthpix2]=pixelX;
        this.pixels2[1][lengthpix2]=pixelY;
        this.pixels2[2][lengthpix2]=pixelZ;
        this.lengthpix2++;
    }
    public void dobavlpixels3(short pixelX,short pixelY,short pixelZ){
        this.pixels3[0][lengthpix3]=pixelX;
        this.pixels3[1][lengthpix3]=pixelY;
        this.pixels3[2][lengthpix3]=pixelZ;
        this.lengthpix3++;
    }
    public void dobavlpixels4(short pixelX,short pixelY,short pixelZ){
        this.pixels4[0][lengthpix4]=pixelX;
        this.pixels4[1][lengthpix4]=pixelY;
        this.pixels4[2][lengthpix4]=pixelZ;
        this.lengthpix4++;
    }
    public void dobavlpixels5(short pixelX,short pixelY,short pixelZ){
        this.pixels5[0][lengthpix5]=pixelX;
        this.pixels5[1][lengthpix5]=pixelY;
        this.pixels5[2][lengthpix5]=pixelZ;
        this.lengthpix5++;
    }

    public void osntochkidobavl(double[] t1,double[] t2,double[] t3,double[] t4,double[] t5,double[] t6,double[] t7,double[] t8){
        this.tochka1=t1;this.tochka2=t2;this.tochka3=t3;this.tochka4=t4;
        this.tochka5=t5;this.tochka6=t6;this.tochka7=t7;this.tochka8=t8;
    }
    public double poluchtochka1(int i){return tochka1[i];}
    public double poluchtochka2(int i){return tochka2[i];}
    public double poluchtochka3(int i){return tochka3[i];}
    public double poluchtochka4(int i){return tochka4[i];}
    public double poluchtochka5(int i){return tochka5[i];}
    public double poluchtochka6(int i){return tochka6[i];}
    public double poluchtochka7(int i){return tochka7[i];}
    public double poluchtochka8(int i){return tochka8[i];}

*/

    @Override
    public String toString() {
        return "Ploskosti{" +
                "names='" + names + '\'' +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", coordZ=" + coordZ +
                ", haight=" + haight +
                ", width=" + width +
                ", lenght=" + lenght +
                ", angleX=" + angleX +
                ", angleY=" + angleY +
                ", angleZ=" + angleZ +
                '}';
    }
}
