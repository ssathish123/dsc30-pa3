/*
    Name: Sanjit Sathish
    PID:  A17804789
 */

/**
 *
 *
 * @author Sanjt
 * @since 2024
 */
class ProteinSynthesis {
    public static CharQueue transcribeDNA(String dna) {
        CharQueue RNA = new CharQueue(dna.length());
        if (dna.length() % 3 == 0){
            for (int i = 0; i < dna.length(); i++){
                if (dna.charAt(i) == 'T'){
                    RNA.enqueue('U');
                } else {
                    RNA.enqueue(dna.charAt(i));
                }
            }
            return RNA;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static String translateRNA(CharQueue rna) {
        String seg = "";
        CharQueue protien = new CharQueue();

        seg += rna.dequeue();
        seg += rna.dequeue();
        seg += rna.dequeue();

        while (seg != "AUG"){
            seg = "";
            if (rna.size() % 3 ==0){
                seg += rna.dequeue();
                seg += rna.dequeue();
                seg += rna.dequeue();
            } else {
                return protien.toString();
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

        return protien.toString();
    }

}
