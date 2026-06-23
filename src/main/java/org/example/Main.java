package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static class CommerceSystem { //프로그램 비즈니스 로직 클래스
        // 적절한 생성자 선언
        public CommerceSystem(List<Category> categories) {
            this.categories = categories;
        }

        private List<Category> categories;

        void start() {
            Scanner sc = new Scanner(System.in);
            //비즈니스 로직 작성
            int exit_switch = 1;
            while(exit_switch == 1) {

                System.out.println("Please select the action to execute");

                for(int i = 0; i<categories.size(); i++){
                    System.out.println(i+1 +
                            ". " +
                            categories.get(i).getCategoryName()
                    );
                }
                System.out.println("0. Exit");
                int main_switch = sc.nextInt();

                switch (main_switch) {
                    case 0:
                        System.out.println("Exit shopping shop");
                        exit_switch = 0;
                        break;


                    case 1: //전자제품
                        System.out.println("[Live commerce platform - Electronic Product]");
                        Category electronic = categories.get(0);
                        for (int i = 0; i < categories.size(); i++) {
                            Product products = electronic.getProducts().get(i);
                            System.out.println(i + 1 +
                                    ".  " +
                                    products.getName() +
                                    "  |  " +
                                    products.getPrice() +
                                    "  |  " +
                                    products.getDescribe());
                        }
                        System.out.println("Type 0 to return");
                        int case1_switch = sc.nextInt();
                        if (case1_switch == 0) {
                            break;
                        } else if (case1_switch>categories.size() || case1_switch<0){
                            System.out.println("Please type within the allowed range");
                            break;
                        } else{
                            Product choice = electronic.getProducts().get(case1_switch -1);
                            System.out.println("선택한 상품: " +
                                    choice.getName() +
                                    "  |  " +
                                    choice.getPrice() +
                                    "  |  " +
                                    choice.getDescribe());
                            break;
                        }
                    case 2:
                        break;
                    case 3:
                        break;
//            case 4:
//                break;
//            case 5:
//                break;
                    case 6:
                        break;
                }
            }
        }

    }

    public static class Category { //Product클래스 관리
        // Product 클래스를 List로 관리
        private String categoryName;
        private List<Product> products;

        public Category(String categoryName) {
            this.categoryName = categoryName;
            this.products = new ArrayList<>();
        }

        // 구조에 맞게 메소드 선언
        public String getCategoryName() {
            return categoryName;
        }

        public List<Product> getProducts() {
            return products;
        }

        public void addProduct(Product product) {
            products.add(product);
        }

    }

    public static class Product { //개별 상품 정보 ex) Galaxy S24, 1200000, 최신 스마트폰, 50
        // 상품명, 가격, 설명, 재고수량 필드 선언하여 관리
        private String name;
        private String describe;
        private int price;
        private int stock;
        // 구조에 맞게 메소드 선언

        public Product(String name, String describe, int price, int stock){
            this.name = name;
            this.describe = describe;
            this.price = price;
            this.stock = stock;
        }
        public String getName() {
            return name;
        }
        public String getDescribe() {
            return describe;
        }
        public int getPrice() {
            return price;
        }
        public int getStock() {
            return stock;
        }

        //세터
        public void setName(String name) {
            this.name = name;
        }
        public void setStock(int stock) {
            this.stock = stock;
        }
        public void setPrice(int price) {
            this.price = price;
        }
        public void setDescribe(String describe) {
            this.describe = describe;
        }
    }

    public class Customer { //손님
        // 고객명, 이메일, 등급 필드 선언하여 관리
        private String name;
        private String email;
        private String grade;

        public Customer(String name, String email, String grade) {
            this.name = name;
            this.email = email;
            this.grade = grade;
        }

        // 구조에 맞게 메소드 선언
        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getGrade() {
            return grade;
        }
    }

    public static void main(String[] args) {
        List<Category> categories = new ArrayList<>();

        Category electronic = new Category("Electronic Product");
        electronic.addProduct(new Product("Galaxy S24", "최신 안드로이드 스마트폰", 1200000, 50));
        electronic.addProduct(new Product("iPhone 16", "Apple의 최신 스마트폰", 1350000, 40));
        electronic.addProduct(new Product("MacBook Pro", "M3 칩셋이 탑재된 노트북", 2400000, 30));
        electronic.addProduct(new Product("Airpods Pro", "노이즈 캔슬링 무선 이어폰", 350000, 20));

        Category cloth = new Category("Cloth Product");
        Category food = new Category("Food Product");

        categories.add(electronic);
        categories.add(cloth);
        categories.add(food);

        CommerceSystem commerceSystem = new CommerceSystem(categories);
        commerceSystem.start();

    }
}

