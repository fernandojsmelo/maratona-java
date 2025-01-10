package academy.devdojo.maratonajava.introducao;
/*
Prátrica

Crie variáveis para os campos descritos abaixo entre <> e imprima a seguinte mensagem:

Eu <nome>, morando no endereço <endereco>,
confirmo que recebi o salário de <salario>, na data <data>
 */
public class Aula03TiposprimitivosExercicio {
    public static void main(String[] args) {
        String nome = "Kirito";
        String endereco = "Av. João das Galileias";
        double salario = 5431.12D;
        String dataRecebimentoSalario = "20/12/2021";
        String relatorio = "Eu "+nome+" morando no endereço "+endereco+" confirmo que recebi o salário de  "+salario+", na data "+dataRecebimentoSalario;

        System.out.println(relatorio);
    }
}
