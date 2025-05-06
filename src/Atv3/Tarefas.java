package Atv3;

public class Tarefas {
    private  String descricao;
    private  int prioridade;
    private  String status;

    public Tarefas(String descricao, int prioridade, String status){
        this.prioridade=prioridade;
        this.status=status;
        this.descricao=descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
