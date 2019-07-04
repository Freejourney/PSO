import java.util.Random;

public class ParticleSwarm {

    private Particle[] particles;
    private int size;
    private Particle globalbestparticle;

    ParticleSwarm(int size, double boundmin, double boundmax, int dimension, double vmax) {
        this.size = size;
        particles = new Particle[size];
        int bestindex = 0;
        double max = -9999;
        for (int i = 0; i < size; i++) {
            particles[i] = new Particle(boundmin, boundmax, dimension, vmax);

            for (int j = 0; j < dimension; j++) {
                particles[i].setPosition(j, new Random().nextDouble() * (boundmax - boundmin) + boundmin);
                particles[i].setVelocity(j, new Random().nextDouble() * 2 - 1);
            }
            particles[i].calcuFitness();
            particles[i].setBestPosition(particles[i].getPosition());
            particles[i].setBestfitness(particles[i].getFitness());
            if (max < particles[i].getFitness()) {
                max = particles[i].getFitness();
                bestindex = i;
            }
        }
        setGlobalbestparticle(particles[bestindex]);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Particle[] getParticles() {
        return particles;
    }

    public void setParticles(Particle[] particles) {
        this.particles = particles;
    }

    public Particle getGlobalbestparticle() {
        return globalbestparticle;
    }

    public void setGlobalbestparticle(Particle globalbestparticle) {
        this.globalbestparticle = globalbestparticle;
    }
}
