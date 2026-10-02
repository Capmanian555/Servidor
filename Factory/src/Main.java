//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ElementoAndaluzFactory factory = new AndaluciaFactory();

        ElementoAndaluz flamenco =
                factory.createElementoAndaluz("flamenco");

        ElementoAndaluz gazpacho =
                factory.createElementoAndaluz("gazpacho");

        ElementoAndaluz feria =
                factory.createElementoAndaluz("feria");

        flamenco.describir();
        gazpacho.describir();
        feria.describir();
    }
}