class Product{
    int discount;
    Product(){
        this.discount = 20;
    }

    public int getDiscount(){
        return discount;
    }

    public double calculateDiscount(){
        return discount*3.5;
    }
}

class Food extends Product{
    int discount;
    Food(){
        this.discount = 25;
    }

    public int getDiscount(){
        return discount*3;
    }

    public double calculateDiscount(){
        return super.calculateDiscount() + discount;
    }
}

class Pizza extends Food{
    int discount;
    Pizza(){
        this.discount = 5;
    }

    public int getDiscount(){
        return discount*3;
    }
}

public class temp{
    public static void main(String[] args) {
        Product food = new Food();
        System.out.println(food.discount + food.getDiscount() + food.calculateDiscount());
    }
}
