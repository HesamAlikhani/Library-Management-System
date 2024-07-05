public abstract class CLI {
    public static void adminCommander(String command) {
        String[] commands = command.split(" ");
        if (commands[0].equals("lib")) {
            switch (commands[1]) {
                case "add":
                    if (commands[2].equals("book")) {
                        Library.addBook(new Book(commands[3], commands[4], commands[5]));
                        Library.adminCommandMenu();
                    } else if (commands[2].equals("member")) {
                        for (NormalUser normalUser : Library.normUserList) {
                            if (normalUser.userID.equals(commands[3])) {
                            Library.addAdmin(new Admin(normalUser.name, normalUser.userID, normalUser.phonenumber, commands[4]));
                            Library.normUserList.remove(normalUser);
                            } else {
                                System.out.println("User dose nit exists!");
                            }
                        }
                        Library.adminCommandMenu();
                    }
                    break;
                case "remove":
                    if (commands[2].equals("book")) {
                        for (Book book : Library.bookList) {
                            if (book.bookID == Integer.parseInt(commands[3])) {
                                Library.bookList.remove(book);
                                System.out.printf("Book <%s> removed\n", commands[3]);
                                Library.adminCommandMenu();
                            }
                        }
                    } else if (commands[2].equals("member")) {
                        for (NormalUser normalUser : Library.normUserList) {
                            if (normalUser.userID.equals(commands[3])) {
                                Library.normUserList.remove(normalUser);
                                System.out.printf("User <%s> removed\n", commands[3]);
                                Library.adminCommandMenu();
                            }
                        }
                    }
                    break;
                case "rent":
                    if (commands.length == 3) {
                        Rent rent = new Rent(commands[2]);
                        if (rent.bookVerify()) {
                            System.out.println(rent);
                        }
                        Library.adminCommandMenu();
                    } else if (commands.length == 5) {
                        Rent rent = new Rent(commands[2], commands[3], commands[4]);
                        if (rent.bookVerify() && rent.userVerify()) {
                            System.out.println(rent);
                        }
                        Library.adminCommandMenu();
                    }
                    break;
                case "get":
                    if (commands.length == 3) {
                        System.out.format("\n*******Library operating hours*******\nOpening: %d\nClosing: %d\n", Library.openTime, Library.closeTime);
                        Library.adminCommandMenu();
                    } else if (commands.length == 4) {
                        Library.bookRepo();
                        Library.adminCommandMenu();
                    }
                    break;
                case "return":
                    for (Book book : Library.bookList) {
                        if (book.title.equals(commands[2]) && !(book.availability)) {
                            book.availability = true;
                        } else {
                            System.out.println("Book has not been registered");
                        }
                    }
                    Library.adminCommandMenu();
                    break;
                default: System.out.println("Wrong entry"); break;
            }
        } else {
            System.out.println("Wrong entry! Try again:");
            Library.adminCommandMenu();
        }
    }
    public static void normCommander(String command) {
        String[] commands = command.split(" ");
        if (commands[0].equals("lib")) {
            switch (commands[1]) {
                case "add":
                    if (commands[2].equals("book")) {
                        Library.addBook(new Book(commands[3], commands[4], commands[5]));
                        Library.adminCommandMenu();
                    }
                    break;
                case "remove":
                    if (commands[2].equals("book")) {
                        for (Book book : Library.bookList) {
                            if (book.bookID == Integer.parseInt(commands[3])) {
                                Library.bookList.remove(book);
                                System.out.printf("Book <%s> removed\n", commands[3]);
                                Library.capacity++;
                                Library.adminCommandMenu();
                            }
                        }
                    }
                    break;
                case "rent":
                    if (commands.length == 3) {
                        Rent rent = new Rent(commands[2]);
                        if (rent.bookVerify()) {
                            System.out.println(rent);
                        }
                        Library.adminCommandMenu();
                    } else if (commands.length == 5) {
                        Rent rent = new Rent(commands[2], commands[3], commands[4]);
                        if (rent.bookVerify() && rent.userVerify()) {
                            System.out.println(rent);
                        }
                        Library.adminCommandMenu();
                    }
                    break;
                case "get":
                    if (commands.length == 3) {
                        System.out.format("\n*******Library operating hours*******\nOpening: %d\nClosing: %d\n", Library.openTime, Library.closeTime);
                        Library.adminCommandMenu();
                    } else if (commands.length == 4) {
                        Library.bookRepo();
                        Library.adminCommandMenu();
                    }
                    break;
                case "return":
                    for (Book book : Library.bookList) {
                        if (book.title.equals(commands[2]) && !(book.availability)) {
                            book.availability = true;
                        } else {
                            System.out.println("Book has not been registered");
                        }
                    }
                    Library.adminCommandMenu();
                    break;
                default: System.out.println("Wrong entry"); break;
            }
        } else {
            System.out.println("Wrong entry! Try again:");
            Library.normCommandMenu();
        }
    }
}