package vistas.intervalo;

class Intervalo {

    private double superior;
    private double inferior;

    public Intervalo (double inferior, double superior) {
        this.inferior = inferior;
        this.superior = superior;
    }

    public Intervalo (double superior) {
        this(0,superior);
    }

    public Intervalo () {
        this(0,0);
    }
    
    public Intervalo (Intervalo intervalo) {
        this(intervalo.inferior, intervalo.superior);
    }

    public Intervalo clone() {
        return new Intervalo(this);

    }

    public double longitud() {
        return superior - inferior;
    }

    public void desplazar(double desplazamiento) {
        inferior = inferior + desplazamiento;
        superior = superior + desplazamiento;
    }

    public Intervalo desplazado(double desplazamiento) {

        Intervalo intervalo = this.clone();
        intervalo.desplazar(desplazamiento);
        return intervalo;
    }

    public boolean incluye(double punto) {
        return inferior <= punto && punto <= superior;
    }

    public boolean incluye(Intervalo intervalo) {

        return this.incluye(intervalo.inferior) && 
                this.incluye(intervalo.superior);
    }

    public boolean equals(Intervalo intervalo) {

        return inferior == intervalo.inferior && 
                superior == intervalo.superior;
    }

    public Intervalo interseccion(Intervalo intervalo) {

    }
    
    public boolean intersecta(Intervalo intervalo) {

        return this.incluye(intervalo.inferior) ||
                this.incluye(intervalo.superior) ||
                intervalo.incluye(this);
    }
    
    public void oponer() {
        double superiorInicial = superior;

        superior = -inferior;
        inferior = -superiorInicial;
    }

    public void doblar() {
        double longitudInicial = this.longitud();

        inferior = inferior - longitudInicial/2;
        superior = superior + longitudInicial/2;
    }


    public void mostrar() {

    }

    public void recoger() {

    }

    public Intervalo[] trocear(int numeroTrozos) {

    }
    
    public Intervalo union(Intervalo intervalo) {

    }
    
    public double puntoMedio() {

    };

}
