/*
    Name: Sanjit Sathish
    PID:  A17804789
 */

import java.util.NoSuchElementException;

/**
 *
 *
 * @author Sanjt
 * @since 2024
 */
class ProteinSynthesis {

    /**
     * This element turns the dna into a queue of RNA.
     * It changes the T chars to a U.
     * @param dna : the string representation of dna
     */
    public static CharQueue transcribeDNA(String dna) {
        CharQueue rna = new CharQueue(dna.length());
        String converted = "";
        if (dna.length() % 3 == 0){
            for (int i = 0; i < dna.length(); i++){
                char elem = dna.charAt(i);
                if (elem == 'T'){
                    converted += "U";
                } else {
                    converted += elem;
                }
            }

            for (int i = 0; i < converted.length(); i++){
                rna.enqueue(converted.charAt(i));
            }

            return rna;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method converts the CharQueue of RNA into a protien.
     * It starts and stops on specific codons and returns the
     * remaining accordingly
     * @param rna A CharQueue of rna to be convereted
     */
    public static CharQueue translateRNA(CharQueue rna) {
        String seg = "";
        CharQueue protien = new CharQueue();

        while (seg != "AUG"){
            seg = "";
            if (rna.size() % 3 == 0){
                seg += rna.dequeue();
                seg += rna.dequeue();
                seg += rna.dequeue();
            } else {
                return protien;
            }
        }

        seg += rna.dequeue();
        seg += rna.dequeue();
        seg += rna.dequeue();

        while (seg != "UAG" && seg != "UAA" && seg != "UGA"){
            seg = "";
            seg += rna.dequeue();
            seg += rna.dequeue();
            seg += rna.dequeue();

            protien.enqueue(CodonMap.getAminoAcid(seg));
        }

        return protien;
    }

}
