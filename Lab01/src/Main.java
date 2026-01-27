import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in);
        String msg = """
                Chương trình quản lý sách
                1. Thêm 1 cuốn sách
                2. Xóa 1 cuốn sách
                3. Thay đổi sách
                4. Xuất thông tin
                5. Tìm sách Lập trình
                6. Lấy sách tối đa theo giá
                7. Tìm kiếm theo tác giả
                0. Thoát
                Chọn chức năng:""";

        int chon = 0;
        do {
            System.out.print(msg);
             chon = x.nextInt();

            switch (chon) {
                case 1 -> {
                    Book newBook = new Book();
                    newBook.input();
                    listBook.add(newBook);
                }

                case 2 -> {
                    System.out.print("Nhập vào mã sách cần xóa: ");
                    int bookid = x.nextInt();

                    Book find = listBook.stream()
                            .filter(p -> p.getId() == bookid)
                            .findFirst()
                            .orElseThrow();

                    listBook.remove(find);
                    System.out.println("Đã xóa sách thành công");
                }

                case 3 -> {
                    System.out.print("Nhập vào mã sách cần điều chỉnh: ");
                    int bookid = x.nextInt();

                    Book find = listBook.stream()
                            .filter(p -> p.getId() == bookid)
                            .findFirst()
                            .orElseThrow();

                    find.input();
                }

                case 4 -> {
                    System.out.println("\nXuất thông tin danh sách");
                    listBook.forEach(p -> p.output());
                }

                case 5 -> {
                    List<Book> list5 = listBook.stream()
                            .filter(u -> u.getTitle()
                                    .toLowerCase()
                                    .contains("lập trình"))
                            .toList();

                    list5.forEach(Book::output);
                }
                case 6 -> {
                    System.out.print("Nhập K: ");
                    int k = x.nextInt();

                    System.out.print("Nhập giá P: ");
                    double p = x.nextDouble();

                    listBook.stream()
                            .filter(b -> b.getPrice() <= p)
                            .limit(k)
                            .forEach(Book::output);
                }
                case 7 -> {
                    x.nextLine(); // xóa bộ nhớ đệm
                    System.out.print("Nhập danh sách tác giả (cách nhau bởi dấu phẩy): ");
                    String input = x.nextLine();

                    Set<String> authors = new HashSet<>();
                    for (String a : input.split(",")) {
                        authors.add(a.trim().toLowerCase());
                    }

                    listBook.stream()
                            .filter(b -> authors.contains(b.getAuthor().toLowerCase()))
                            .forEach(Book::output);
                }
            }
        } while (chon != 0);
    }
}