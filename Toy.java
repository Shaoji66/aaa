
public class Toy {
    private String name;
    private String size;
    private String animalType;
    private double price;

    public Toy() {
    }

    public Toy(String name, String size, String animalType, double price) {
        this.name = name;
        setSize(size);
        setAnimalType(animalType);
        setPrice(price);
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        if (size != null)
        {
            if (size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large")) {
                this.size = size;
            }
            else
            {
                System.out.println("Invalid input! Please enter 'small', 'medium', or 'large'.");
                this.size="*";
            }
        }
        else
            System.out.println("The empty input...");
    }


    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price > 0 && price <= 500)
            this.price = price;
        else{
            System.out.println("Unable to set price...");
            System.out.println("The price must be between 1 and 500. Your price is "+price);
        System.out.println("You need to delete the wrong toy by yourself.");
        }
    }



    public String getAnimalType(){
        return animalType;
    }

    public void setAnimalType(String animalType) {
        if(animalType!=null)
        {
            this.animalType=animalType;
        }
        else
            System.out.println("The empty input...");
    }



    @Override
    public String toString() {
        return name + "  |  " + size + "  |  " + animalType + "  |  ¥" + price;
    }



}



