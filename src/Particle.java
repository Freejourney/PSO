import java.util.Arrays;

public class Particle {

    private double[] position;
    private double[] velocity;
    private double vmax;
    private double fitness;
    private int dimension;
    private double boundmin, boundmax;
    private double[] bestPosition;
    private double bestfitness;

    public Particle(double[] position, double[] velocity, double fitness, int dimension,
                    double boundmin, double boundmax, double[] bestPosition, double bestfitness) {
        this.position = position;
        this.velocity = velocity;
        this.fitness = fitness;
        this.dimension = dimension;
        this.boundmin = boundmin;
        this.boundmax = boundmax;
        this.bestPosition = bestPosition;
        this.bestfitness = bestfitness;
    }

    public Particle(double boundmin, double boundmax, int dimension, double vmax) {
        this.boundmin = boundmin;
        this.boundmax = boundmax;
        this.dimension = dimension;
        this.vmax = vmax;
        this.position = new double[dimension];
        this.velocity = new double[dimension];
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public void setPosition(int i, double v) {
        this.position[i] = v;
    }

    public double[] getVelocity() {
        return velocity;
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public void setVelocity(int i, double v) {
        this.velocity[i] = v;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void calcuFitness() {
        double sum = 0;
        for (int i = 0; i < this.dimension; i++) {
            sum += position[i];
        }
        setFitness(sum);
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public double getBoundmin() {
        return boundmin;
    }

    public void setBoundmin(double boundmin) {
        this.boundmin = boundmin;
    }

    public double getBoundmax() {
        return boundmax;
    }

    public void setBoundmax(double boundmax) {
        this.boundmax = boundmax;
    }

    public double[] getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(double[] bestPosition) {
        this.bestPosition = bestPosition;
    }

    public double getBestfitness() {
        return bestfitness;
    }

    public void setBestfitness(double bestfitness) {
        this.bestfitness = bestfitness;
    }

    public double getVmax() {
        return this.vmax;
    }

    @Override
    public String toString() {
        return "Particle{" +
                "position=" + Arrays.toString(position) +
                ", velocity=" + Arrays.toString(velocity) +
                ", fitness=" + fitness +
                ", dimension=" + dimension +
                ", boundmin=" + boundmin +
                ", boundmax=" + boundmax +
                ", bestPosition=" + Arrays.toString(bestPosition) +
                ", bestfitness=" + bestfitness +
                '}';
    }
}
