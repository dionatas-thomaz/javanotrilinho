package Atv2;

public class Compromisso {
    private String data; // formato dd/mm/aaaa
    private String descricao;

    public Compromisso(String data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

