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
            this.managerSystem = new ManagerSystem(categories);
            this.cart = new Cart();
        }
        private List<Category> categories;
        private ManagerSystem managerSystem;
        private Cart cart;

        void start() {
            Scanner sc = new Scanner(System.in);
            //비즈니스 로직 작성
            int exit_switch = 1;
            int cart_choice = 0;
            while(exit_switch == 1) {
                System.out.println("");
                System.out.println("수행할 작업을 선택해주세요");
                for(int i = 0; i<categories.size(); i++){
                    System.out.println(i+1 +
                            ". " +
                            categories.get(i).getCategoryName()
                    );
                }
                if(!cart.getProducts().isEmpty()){
                    System.out.println("4. 장바구니 확인");
                    System.out.println("5. 주문 취소");
                }
                System.out.println("6. 관리자 모드");
                System.out.println("0. Exit");
                int main_switch = sc.nextInt();


                //메인문 시작
                switch (main_switch) {
                    case 0:
                        System.out.println("Exit shopping shop");
                        exit_switch = 0;
                        break;


                    case 1: //전자제품
                        System.out.println("[Live commerce platform - 전자제품]");
                        Category electronic = categories.get(0);
                        if(electronic.getProducts().isEmpty()){
                            System.out.println("상품이 없습니다");
                            break;
                        }
                        for (int i = 0; i < electronic.getProducts().size(); i++) {
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
                        } else if (case1_switch>electronic.getProducts().size() || case1_switch<0){
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

                            while(true) {
                                System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                                System.out.println("1. 확인    2. 취소");
                                cart_choice = sc.nextInt();
                                if (cart_choice == 1) {
                                    if(choice.getStock() <= 0){
                                        System.out.println("재고가 부족합니다.");
                                        break;
                                    } else{
                                        cart.addCart(choice);
                                        System.out.println(choice.getName() + "이(가) 장바구니에 추가되었습니다.");
                                        break;
                                    }
                                } else if (cart_choice == 2) {
                                    break;
                                } else {
                                    System.out.println("유효하지 않은 입력값입니다.");
                                }
                            }

                            break;
                        }
                    case 2: //의류
                        System.out.println("[Live commerce platform - 옷]");
                        Category cloth = categories.get(1);
                        if(cloth.getProducts().isEmpty()){
                            System.out.println("상품이 없습니다");
                            break;
                        }
                        for (int i = 0; i < categories.size(); i++) {
                            Product products = cloth.getProducts().get(i);
                            System.out.println(i + 1 +
                                    ".  " +
                                    products.getName() +
                                    "  |  " +
                                    products.getPrice() +
                                    "  |  " +
                                    products.getDescribe());
                        }
                        System.out.println("Type 0 to return");
                        int case2_switch = sc.nextInt();
                        if (case2_switch == 0) {
                            break;
                        } else if (case2_switch>categories.size() || case2_switch<0){
                            System.out.println("Please type within the allowed range");
                            break;
                        } else{
                            Product choice = cloth.getProducts().get(case2_switch -1);
                            System.out.println("선택한 상품: " +
                                    choice.getName() +
                                    "  |  " +
                                    choice.getPrice() +
                                    "  |  " +
                                    choice.getDescribe());

                            while(true) {
                                System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                                System.out.println("1. 확인    2. 취소");
                                cart_choice = sc.nextInt();
                                if (cart_choice == 1) {
                                    if(choice.getStock() <= 0){
                                        System.out.println("재고가 부족합니다.");
                                        break;
                                    } else{
                                        cart.addCart(choice);
                                        System.out.println(choice.getName() + "이(가) 장바구니에 추가되었습니다.");
                                        break;
                                    }
                                } else if (cart_choice == 2) {
                                    break;
                                } else {
                                    System.out.println("유효하지 않은 입력값입니다.");
                                }
                            }

                            break;
                        }
                    case 3: //음식
                        System.out.println("[Live commerce platform - 음식]");
                        Category food = categories.get(2);
                        if(food.getProducts().isEmpty()){
                            System.out.println("상품이 없습니다");
                            break;
                        }
                        for (int i = 0; i < categories.size(); i++) {
                            Product products = food.getProducts().get(i);
                            System.out.println(i + 1 +
                                    ".  " +
                                    products.getName() +
                                    "  |  " +
                                    products.getPrice() +
                                    "  |  " +
                                    products.getDescribe());
                        }
                        System.out.println("Type 0 to return");
                        int case3_switch = sc.nextInt();
                        if (case3_switch == 0) {
                            break;
                        } else if (case3_switch >categories.size() || case3_switch <0){
                            System.out.println("Please type within the allowed range");
                            break;
                        } else{
                            Product choice = food.getProducts().get(case3_switch -1);
                            System.out.println("선택한 상품: " +
                                    choice.getName() +
                                    "  |  " +
                                    choice.getPrice() +
                                    "  |  " +
                                    choice.getDescribe());


                            while(true) {
                                System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                                System.out.println("1. 확인    2. 취소");
                                cart_choice = sc.nextInt();
                                if (cart_choice == 1) {
                                    if(choice.getStock() <= 0){
                                        System.out.println("재고가 부족합니다.");
                                        break;
                                    } else{
                                        cart.addCart(choice);
                                        System.out.println(choice.getName() + "이(가) 장바구니에 추가되었습니다.");
                                        break;
                                    }
                                } else if (cart_choice == 2) {
                                        break;
                                } else {
                                    System.out.println("유효하지 않은 입력값입니다.");
                                }
                            }

                            break;
                        }
                    case 4: //장바구니 확인
                        int total_price = 0;
                        if(cart.getProducts().isEmpty()) break;
                        System.out.println("[ 장바구니 내역 ]");
                        for(int i = 0; i < cart.getProducts().size(); i++){
                            Product cart_product = cart.getProducts().get(i);
                            total_price += cart_product.getPrice();
                            System.out.println(cart_product.getName() +
                                    "  |  " +
                                    cart_product.getPrice() +
                                    "  |  " +
                                    cart_product.getDescribe());
                        }
                        System.out.println("[ 총 주문 금액 ]");
                        System.out.println(total_price + "원");
                        System.out.println("1. 주문 확정        2. 메인으로 돌아가기");
                        int order_choice = sc.nextInt();
                        if(order_choice == 1){

                            System.out.println("주문이 완료되었습니다! 총 금액: " + total_price + "원");
                            for(int i = 0; i < cart.getProducts().size(); i++){
                                Product cart_product = cart.getProducts().get(i);
                                System.out.print(cart_product.getName() + " 재고가" + cart_product.getStock() + "개");
                                cart_product.setStock(cart_product.getStock() -1);
                                System.out.println("-> " + cart_product.getStock() + "개로 업데이트 되었습니다.");
                            }

                            cart.clearCart();
                            break;
                        } else{break;}
                    case 5: //주문 취소
                        if(cart.getProducts().isEmpty()) break;
                        else{
                            System.out.println("장바구니를 초기화했습니다.");
                            cart.clearCart();
                        }
                        break;
                    case 6: //관리자 모드
                        Manager manager = new Manager();
                        int fail_flag = 0;
                        sc.nextLine();
                        while(true){
                            System.out.println("관리자 비밀번호를 입력해주세요");
                            String pwd_guess = sc.nextLine();
                            if(manager.checkPassword(pwd_guess)){
                                break;
                            }else{
                                System.out.println("비밀번호가 틀렸습니다.");
                                fail_flag++;
                            }
                            if(fail_flag==3){
                                System.out.println("비밀번호를 3회 틀려 프로그램을 종료합니다.");
                                return;
                            }
                        }
                        managerSystem.start();

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


    public static class Cart{
        private List<Product> products;

        public Cart(){
            products = new ArrayList<>();
        }

        public List<Product> getProducts(){
            return products;
        }
        public void addCart(Product product){
            products.add(product);
        }
        public void clearCart(){
            products.clear();
        }
    }


    public static class Manager{
        private String password = "1234";

        public String getPassword() {
            return password;
        }
        public boolean checkPassword(String pwd_guess){
            return password.equals(pwd_guess);
        }
    }


    public static class ManagerSystem{
        public ManagerSystem(List<Category> categories) {
            this.categories = categories;
        }
        private List<Category> categories;

        void start(){
            while(true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("[ 관리자 모드 ]");
                System.out.println("1. 상품 추가");
                System.out.println("2. 상품 수정");
                System.out.println("3. 상품 삭제");
                System.out.println("4. 전체 상품 현황");
                System.out.println("5. 메인으로 돌아가기");
                int manager_choice = sc.nextInt();
                switch (manager_choice) {
                    case 1:
                        System.out.println("추가할 카테고리를 선택해주세요");
                        System.out.println("1. 전자제품");
                        System.out.println("2. 의류");
                        System.out.println("3. 식품");

                        int categories_choice = sc.nextInt();
                        sc.nextLine();
                        if (categories_choice == 1) {
                            Category electronic = categories.get(0);
                            System.out.println("[전자제품 카테고리에 상품 추가]");
                            System.out.print("상품명을 입력해주세요: ");
                            String newName = sc.nextLine();
                            System.out.print("상품 설명을 입력해주세요: ");
                            String newDescribe = sc.nextLine();
                            System.out.print("상품 가격을 입력해주세요: ");
                            int newPrice = sc.nextInt();
                            System.out.print("재고수량을 입력해주세요: ");
                            int newStock = sc.nextInt();
                            electronic.addProduct(new Product(newName, newDescribe, newPrice, newStock));
                        } else if (categories_choice == 2) {
                            Category cloth = categories.get(1);
                            System.out.println("[의류 카테고리에 상품 추가]");
                            System.out.print("상품명을 입력해주세요: ");
                            String newName = sc.nextLine();
                            System.out.print("상품 설명을 입력해주세요: ");
                            String newDescribe = sc.nextLine();
                            System.out.print("상품 가격을 입력해주세요: ");
                            int newPrice = sc.nextInt();
                            System.out.print("재고수량을 입력해주세요: ");
                            int newStock = sc.nextInt();
                            cloth.addProduct(new Product(newName, newDescribe, newPrice, newStock));
                        } else if (categories_choice == 3) {
                            Category food = categories.get(2);
                            System.out.println("[식품 카테고리에 상품 추가]");
                            System.out.print("상품명을 입력해주세요: ");
                            String newName = sc.nextLine();
                            System.out.print("상품 설명을 입력해주세요: ");
                            String newDescribe = sc.nextLine();
                            System.out.print("상품 가격을 입력해주세요: ");
                            int newPrice = sc.nextInt();
                            System.out.print("재고수량을 입력해주세요: ");
                            int newStock = sc.nextInt();
                            food.addProduct(new Product(newName, newDescribe, newPrice, newStock));
                        } else {
                            System.out.println("범주 내의 카테고리를 선택해주세요");
                            break;
                        }
                        break;
                    case 2:
                        System.out.println("수정할 상품명을 입력해주세요");
                        int search_flag = 0;
                        sc.nextLine();
                        String findByName = sc.nextLine();
                        for(int i = 0; i < categories.size(); i++){
                            for(int j = 0; j < categories.get(i).getProducts().size(); j++){
                                if(categories.get(i).getProducts().get(j).getName().equals(findByName)) {
                                    search_flag++;
                                    System.out.println("수정하고 싶은 부분을 입력해주세요");
                                    System.out.println("1. 가격");
                                    System.out.println("2. 상품설명");
                                    System.out.println("3. 수량");
                                    int modify_choice = sc.nextInt();
                                    switch (modify_choice) {
                                        case 1:
                                            System.out.println("수정할 가격을 입력해주세요");
                                            int modify_price = sc.nextInt();
                                            categories.get(i).getProducts().get(j).setPrice(modify_price);
                                            break;
                                        case 2:
                                            System.out.println("수정할 상품정보를 입력해주세요");
                                            sc.nextLine();
                                            String modify_describe = sc.nextLine();
                                            categories.get(i).getProducts().get(j).setDescribe(modify_describe);
                                            break;
                                        case 3:
                                            System.out.println("수정할 수량을 입력해주세요");
                                            int modify_stock = sc.nextInt();
                                            categories.get(i).getProducts().get(j).setStock(modify_stock);
                                            break;

                                    }
                                }
                                if(search_flag > 0){
                                    break;
                                }
                            }
                            if(search_flag > 0){
                                break;
                            }
                        }
                        if(search_flag == 0){
                            System.out.println("상품을 찾지 못했습니다.");
                        }
                        break;

                    case 3:
                        System.out.println("삭제할 상품명을 입력해주세요");
                        int delete_flag = 0;
                        sc.nextLine();
                        findByName = sc.nextLine();
                        for(int i = 0; i < categories.size(); i++) {
                            for (int j = 0; j < categories.get(i).getProducts().size(); j++) {
                                if (categories.get(i).getProducts().get(j).getName().equals(findByName)) {
                                    categories.get(i).getProducts().remove(j);
                                    delete_flag++;
                                    break;
                                }
                                if(delete_flag > 0){
                                    break;
                                }
                            }
                            if(delete_flag > 0){
                                break;
                            }
                        }
                        if(delete_flag == 0){
                            System.out.println("상품을 찾지 못했습니다.");
                        }
                        break;
                    case 4:
                        break;
                    case 5:
                        return;
                }
            }
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
        ManagerSystem managerSystem = new ManagerSystem(categories);

        commerceSystem.start();

    }
}

