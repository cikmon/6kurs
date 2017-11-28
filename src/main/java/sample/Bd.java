package sample;
public class Bd {
    private String names;
    private int haight;
    private int width;
    private int length;
    private int coordX;
    private int coordY;
    private int coordZ;
    private int ryadom;
    private int angleX;
    private int angleY;
    private int angleZ;

    public Bd(String names,int width, int haight,int length,int coordX,int coordY,int coordZ,
              int ryadom, int angleX,int angleY,int angleZ){
        this.width=width;
        this.haight=haight;
        this.length=length;
        this.names=names;
        this.coordX=coordX;
        this.coordY=coordY;
        this.coordZ=coordZ;
        this.ryadom=ryadom;
        this.angleX=angleX;
        this.angleY=angleY;
        this.angleZ=angleZ;


    }
    public String names(){
        return names;
    }
    public int haight(){
        return haight;
    }
    public int width(){return width;}
    public int length(){return length;}

    public int coordX(){
        return coordX;
    }
    public int coordY(){return coordY;}
    public int coordZ(){return coordZ;}

    public int ryadom(){return  ryadom;}

    public int angleX(){return  angleX;}
    public int angleY(){return  angleY;}
    public int angleZ(){return  angleZ;}


}