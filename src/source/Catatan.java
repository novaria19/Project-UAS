package source;

import java.io.Serializable;

public class Catatan implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String judul;
    private String isi;

    public Catatan(String isi, String judul)
    {
        this.judul = judul;
        this.isi = isi;
    }
    
    @Override
    public String toString()
    {
        return judul;
    }
    public String getJudul(String judul)
    {
        return judul;
    }

    public void setJudul()
    {
        this.judul = judul;
    }

    public String getIsi(String isi)
    {
        return isi;
    }

    public void setIsi()
    {
        this.isi = isi;
    }
}
