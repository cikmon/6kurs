package sample;

import javax.vecmath.Matrix4f;

public class Ploskosti {


    private String names;
    private int width;
    private int haight;
    private int lenght;

    private double coordX;
    private double coordY;
    private double coordZ;

    private int angleX;
    private int angleY;
    private int angleZ;
    private int id;
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


    public Ploskosti(
            String names,int width, int haight,int lenght, double coordX, double coordY,double coordZ,
            int angleX,int angleY,int angleZ,int id){
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
        this.id=id;

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

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "Ploskosti{" +
                "names='" + names + '\'' +
                ", width=" + width +
                ", haight=" + haight +
                ", lenght=" + lenght +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", coordZ=" + coordZ +
                ", angleX=" + angleX +
                ", angleY=" + angleY +
                ", angleZ=" + angleZ +
                '}';
    }
}
