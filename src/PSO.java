import java.util.Random;

public class PSO {

    private ParticleSwarm particleSwarm;
    private int iteration;
    private double w;
    private double c1, c2;

    PSO(int size, int dimension, int iteration, double w, double c1, double c2, double boundmin, double boundmax, double vmax) {
        this.particleSwarm = new ParticleSwarm(size, boundmin, boundmax, dimension, vmax);
        this.iteration = iteration;
        this.w = w;
        this.c1 = c1;
        this.c2 = c2;
    }

    public void searchSolution() {
        for (int i = 0; i < this.iteration; i++) {
            for (int j = 0; j < particleSwarm.getSize(); j++) {
                updateVelocity(particleSwarm.getParticles()[j]);
                updatePosition(particleSwarm.getParticles()[j]);
                updateFitness(particleSwarm.getParticles()[j]);

                if (particleSwarm.getParticles()[j].getFitness() > particleSwarm.getParticles()[j].getBestfitness()) {
                    particleSwarm.getParticles()[j].setBestfitness(particleSwarm.getParticles()[j].getFitness());
                    particleSwarm.getParticles()[j].setBestPosition(particleSwarm.getParticles()[j].getPosition());

                    if (particleSwarm.getParticles()[j].getFitness() > particleSwarm.getGlobalbestparticle().getFitness()) {
                        particleSwarm.setGlobalbestparticle(particleSwarm.getParticles()[j]);
                    }
                }
            }
            System.out.println(particleSwarm.getGlobalbestparticle().getFitness());
        }
    }

    private void updateFitness(Particle particle) {
        particle.calcuFitness();
    }

    public void updatePosition(Particle particle) {
        for (int i = 0; i < particle.getDimension(); i++) {

            double xi = particle.getPosition()[i]+particle.getVelocity()[i];

            if (xi > particle.getBoundmax()) {
                xi = particle.getBoundmax();
            }
            if (xi < particle.getBoundmin()) {
                xi = particle.getBoundmin();
            }

            particle.setPosition(i, xi);
        }
    }

    public void updateVelocity(Particle particle) {
        double r1 = new Random().nextDouble();
        double r2 = new Random().nextDouble();
        double[] v = particle.getVelocity();
        double[] x = particle.getPosition();
        double[] pbestPosition = particle.getBestPosition();
        double[] gbestPosition = particleSwarm.getGlobalbestparticle().getPosition();

        double[] nv = new double[particle.getDimension()];
        for (int i = 0; i < particle.getDimension(); i++) {
            double nvi = w*v[i]+c1*r1*(pbestPosition[i]-x[i])+c2*r2*(gbestPosition[i]-x[i]);
            if (nvi > particle.getVmax()) {
                nvi = particle.getVmax();
            }
            nv[i] = nvi;
        }

        particle.setVelocity(nv);
    }
}
