package DomainSource_Package;

public class Istoric {
    private int idIstoric;
    private int idPacient;
    private String nume;
    private String boli;
    private String medicamente;
    private int varsta;

    public int getIdIstoric() {
        return idIstoric;
    }

    public int setIdIstoric(int idIstoric) {
        this.idIstoric = idIstoric;
        return idIstoric;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public int setIdPacient(int idPacient) {
        this.idPacient = idPacient;
        return idPacient;
    }

    public String getNume() {
        return nume;
    }

    public String setNume(String nume) {
        this.nume = nume;
        return nume;
    }

    public String getBoli() {
        return boli;
    }

    public String setBoli(String boli) {
        this.boli = boli;
        return boli;
    }

    public String getMedicamente() {
        return medicamente;
    }

    public String setMedicamente(String medicamente) {
        this.medicamente = medicamente;
        return medicamente;
    }

    public int getVarsta() {
        return varsta;
    }

    public int setVarsta(int varsta) {
        this.varsta = varsta;
        return varsta;
    }
}
