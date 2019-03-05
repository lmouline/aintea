package comlan.validation.expressiveness;

public class Gaussian {
    private double value;
    private double mean;
    private double variance;

    public Gaussian(double value, double mean, double variance) {
        this.mean = mean;
        this.variance = variance;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getVariance() {
        return variance;
    }

    public void setVariance(double variance) {
        this.variance = variance;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Gaussian add(Gaussian other) {
        return new Gaussian(this.value + other.value,
                this.mean + other.mean,
                this.variance + other.variance);
    }

    public Gaussian minus(Gaussian other) {
        return new Gaussian(this.value - other.value,
                this.mean - other.mean,
                this.variance + other.variance);
    }

    public Gaussian times(Gaussian other) {
        return new Gaussian(this.value * other.value,
                this.mean * other.mean,
                Math.pow(other.mean, 2) * this.variance + Math.pow(this.mean, 2) * other.variance);
    }

    public Gaussian divideBy(Gaussian other) {
        return new Gaussian(this.value / other.value,
                (this.mean / other.mean) + ((this.mean*other.variance) / (Math.pow(other.mean, 3))),
                (this.variance / other.mean) + ((Math.pow(this.mean, 2)*other.variance) / (Math.pow(other.mean, 4))));
    }

    @Override
    public String toString() {
        return "Gaussian(v=" + value + ", m=" + mean + ", var=" + variance + ")";
    }
}
