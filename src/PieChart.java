import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.util.Random;

public class PieChart {
    private double x;
    private double y;
    private double height;
    private double width;
    private  HistogramAlphaBet drawSource;

    PieChart(double x, double y, double height, double width, HistogramAlphaBet drawSource){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.drawSource = drawSource;
    }

    public void draw(GraphicsContext gc, int numArcs){
        double remainder = 1.0;
        double totalValue = 0.0;
        double startAngle;
        double arcAngle;
        int y = 50;
        int xCord = 500;
        int yCord = 30;
        gc.fillText("Legend ",580,20);

        for(int i = 0; i < numArcs; i++) {
            startAngle = ((totalValue * 360));
            arcAngle = (((drawSource.getCharMap()).get((drawSource.getCharMap()).keySet().toArray()[i]) * 360)+0.7);
            gc.setFill(getRandColor());
            gc.fillArc(getX(),getY(),getWidth(),getHeight(),startAngle,arcAngle, ArcType.ROUND);
            totalValue += (drawSource.getCharMap()).get((drawSource.getCharMap()).keySet().toArray()[i]);
            gc.fillRect(xCord,yCord,50,30);
            gc.fillText("= "+ ((drawSource.getCharMap()).keySet().toArray()[i]) + ": " +
                    (int)((drawSource.getCharMap()).get((drawSource.getCharMap()).keySet().toArray()[i])
                            * drawSource.getTotal()), 560, y);
            yCord += 50;
            y += 50;
        }
    }

    public Color getRandColor(){
        Random rand = new Random();
        return Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
