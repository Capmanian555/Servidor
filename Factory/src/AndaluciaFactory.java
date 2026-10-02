public class AndaluciaFactory extends ElementoAndaluzFactory {
    @Override
    public ElementoAndaluz createElementoAndaluz(String tipo) {

        switch (tipo.toLowerCase()) {
            case "flamenco":
                return new Flamenco();

            case "gazpacho":
                return new Gazpacho();

            case "feria":
            case "feriadeabril":
            case "feria de abril":
                return new FeriaDeAbril();

            default:
                throw new IllegalArgumentException(
                        "Tipo de elemento andaluz no válido: " + tipo
                );
        }
    }
}
