package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vaga;
    private List<Desenvolvedor> desenvolvedores;

    public Integer getVaga() {
        return vaga;
    }

    public void setVaga(Integer vaga) {
        this.vaga = vaga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (getVaga() > desenvolvedores.size()) {
            desenvolvedores.add(desenvolvedor);
        }else{
            System.out.println("Não há vagas o suficiente.");
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack() == true) {
            desenvolvedores.add(desenvolvedor);
        }else{
            System.out.println("O desenvolvedor não é fullstack.");
        }
    }

    public Double getTotalSalarios() {
        double total = 0.0;

        for (Desenvolvedor dev : desenvolvedores) {
            total += dev.calcularSalario();
        }
        return total;
    }

    public Integer qtdDesenvolvedoresMobile() {
        int total = 0;
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorMobile) {
                total++;
            }
        }
        return total;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> resultado = new ArrayList<>();

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev.calcularSalario() >= salario) {
                resultado.add(dev);
            }
        }

        return resultado;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {
            return null;
        }
        Desenvolvedor menor = desenvolvedores.get(0);

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev.calcularSalario() < menor.calcularSalario()) {
                menor = dev;
            }
        }

        return menor;
    }

}
