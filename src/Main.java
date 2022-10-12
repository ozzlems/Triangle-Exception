public class Main {

    public static void main(String[] args) {
      Triangle[] arrayofTriangles = new Triangle[3];
      try{
          int counter = 0;
          Triangle triangle = new Triangle(2,4,5);
          arrayofTriangles[counter++] = triangle;
          triangle = new Triangle(3,4,5);
          arrayofTriangles[counter++] = triangle;
          triangle = new Triangle(3,4,6);
          arrayofTriangles[counter++] = triangle;
      } catch (IllegalTriangleException e){
          System.out.println(e.getMessage());
          e.printStackTrace();

          printTriangles(arrayofTriangles);
      }
      finally {
          System.out.println("Number of triangles : " + Triangle.getTrianglecount());
      }
    }
    static void printTriangles(Triangle[] triangles){
        for(int i = 0; i < triangles.length ; i++){
            System.out.println(triangles[i].toString());

        }
    }
}
class Triangle {
    private int side1;
    private int side2;
    private int side3;
  private static int trianglecount = 0;
    Triangle(int side1 , int side2 , int side3) throws IllegalTriangleException{
        this.side1 =  side1;
        this.side2 = side2;
        this.side3 = side3;
        isIllegalTriangle();

          trianglecount++;

    }
    Triangle() throws  IllegalTriangleException{
        this(1,1,1);
    }
    private void isIllegalTriangle() throws IllegalTriangleException{
        if(getSide1() + getSide2() <= getSide3() || getSide2() + getSide3() <= getSide1() ||  getSide1() + getSide3() <= getSide2() )
            throw new IllegalTriangleException(getSide1() , getSide2() , getSide3());
    }

    public static int getTrianglecount() {
        return trianglecount;
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public int getSide3() {
        return side3;
    }

    public  double getPerimeter(){
        if((side1 + side2) > side3 && (side2 + side3) > side1 && (side1 + 3) > side2){
            return side1 + side2 + side3;

        }
        else
            return Double.parseDouble("Invalid option");


    }
    double getArea(){
        double s = (side1 + side2 + side3) / 2;
        double area = (double) (Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)));
        return area;
    }
    public String toString(){
        return  this.getClass().getName() + " First side : " + getSide1() + " Second side : " + getSide2() + "Third side : " + getSide3();
    }

}
class IllegalTriangleException extends Exception{
    IllegalTriangleException(int side1 , int side2 , int side3){
        super("Triangle with one side length " + side1 + " cant be bigger or equal than other two sides with lengths" + side2 + " and" + side3 );

    }
}


