public class Main {

    public static void main(String[] args) {
        FiguraFactory factory = new FiguraFactory();

        // Un objeto de cada clase que se pueda crear (Figura es abstracta, no se crea)
        Figura triangulo = factory.crearFigura("triangulo", "rojo");
        Figura rectangulo = factory.crearFigura("rectangulo", "azul");
        Figura circulo = factory.crearFigura("circulo", "verde");
        Figura cuadrado = factory.crearFigura("cuadrado", "amarillo");

        triangulo.dibujarFigura();
        rectangulo.dibujarFigura();
        circulo.dibujarFigura();
        cuadrado.dibujarFigura();
    }
}
