package Similarity;

import Vectors.SemanticVector;

import java.util.Map;

/**
 *
 */
public class NormEuclideanDist extends SimilarityFunction {

    /**
     * @param main_vector
     * @param comp_vector
     * @return
     */
    @Override
    public double calculateSimilarity(SemanticVector main_vector, SemanticVector comp_vector) {
        Double sum = 0.0;
        if (main_vector.getMagnitude() == 0 || comp_vector.getMagnitude() == 0) {
            return sum;
        }
        for (Map.Entry<String, Double> entry : main_vector.getVector().entrySet()) {
            if (entry.getValue() != 0) {
                if (comp_vector.getVector().containsKey(entry.getKey()) && comp_vector.getVector().get(entry.getKey()) != 0) {
                    sum += Math.pow(
                            entry.getValue() / Math.sqrt(main_vector.getMagnitude()) -
                                    comp_vector.getVector().get(entry.getKey()) / Math.sqrt(comp_vector.getMagnitude()),
                            2);
                }
            }
        }
        return -1 * Math.sqrt(sum);
    }

    /**
     * @return
     */
    @Override
    public String getMethodName() {
        return "negative euclidean distance between norms";
    }

    /**
     * @return
     */
    @Override
    public Double getUnrelatedValue() {
        return Double.NEGATIVE_INFINITY;
    }

}
