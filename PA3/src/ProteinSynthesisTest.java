import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProteinSynthesisTest {

    @Test
    public void transcribeDNATest(){
        String dna = "GTA";
        CharQueue rna = ProteinSynthesis.transcribeDNA(dna);

        assertEquals('G', rna.dequeue());
        assertEquals('U', rna.dequeue());
        assertEquals('A', rna.dequeue());

    }

    @Test
    public void translateRNATest(){
        String dna = "AUGUAA";
        CharQueue rna = ProteinSynthesis.transcribeDNA(dna);
        CharQueue empty = new CharQueue(dna.length());

        assertEquals(empty, ProteinSynthesis.translateRNA(rna));

        String dna2 = "AUGUUUUAA";
        CharQueue rna2 = ProteinSynthesis.transcribeDNA(dna2);
        assertEquals("F", ProteinSynthesis.translateRNA(rna2).peek());


        String dna3 = "AUGUUUUCCUAA";
        CharQueue rna3 = ProteinSynthesis.transcribeDNA(dna3);
        assertEquals("FS", ProteinSynthesis.translateRNA(rna3));

    }
}