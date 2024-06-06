package zkd.codes.domain;

public abstract class Vehicle {
    private String brandName;
    private String modelName = getClass().getSimpleName();
    private String color;
    private Long licensePlateNumber;
    private Long horsePower;
    private Integer seatsNumber;

    public Vehicle(String brandName, String color, Long licensePlateNumber, Long horsePower, Integer seatsNumber){
        this.brandName = brandName;
        this.color = color;
        this.licensePlateNumber = licensePlateNumber;
        this.horsePower = horsePower;
        this.seatsNumber = seatsNumber;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public String getColor() {
        return color;
    }

    public Long getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public Long getHorsePower() {
        return horsePower;
    }

    public Integer getSeatsNumber() {
        return seatsNumber;
    }

    public void informations(){
        System.out.println("**************************************");
        System.out.println("Modelo: " + getModelName() + " - Marca: " + getBrandName());
        System.out.println("Cor: " + getColor());
        System.out.println("Potência: " + getHorsePower() + " Cavalos");
        System.out.println("N° Assentos: " + getSeatsNumber());
        System.out.println("N° Placa: " + getLicensePlateNumber());


    }
}
