
import java.util.*;
import java.io.*;


public class main {

    public static void main (String[] args) {

        ArrayList<Patient> records = new ArrayList<>();

        System.out.println("**Patient records have been recorded successfully**");


        String path = "C:\\Users\\david\\Desktop\\HospitalRecords\\ListOfPatients.txt";
//Use path to the ListOfPatients.txt here
        LineNumberReader lr = null;

//allows to read information from the file line by line
        String[] oneRecord = new String[4];

//an array to store info about one patient

        try {
            //using try-catch for exception handling to catch
//possible errors with i/o operations
            FileReader inputStream = new FileReader(path);
//FileReader reads the file’s contents
            lr = new LineNumberReader(inputStream);
            String str;
            while ((str = lr.readLine()) != null) {
//while the next line exists
                oneRecord = str.split(",");
//dividing one file line by commas and assigning to array
                Patient pat = new Patient(oneRecord[0], oneRecord[1],
                        oneRecord[2], oneRecord[3]);


                records.add(pat);


                //adding patient to the ArrayList
            }
        } catch (IOException ioe) {
            System.out.println("IOExcception occured");
        }


        System.out.println("Press S for search, Press E for exit");

        Scanner sc = new Scanner(System.in);

        while (true) {

            String input = sc.next();
            if (input.equals("E")) {
                System.out.println("Exit the program. Bye...");
                System.exit(0);
            }

            else if (input.equals("S")) {
                System.out.println("Enter Patient ID to search");
            }

            else {
                System.out.println("Record not found..Please enter valid ID.....");
            }
//            switch (input) {
//                case "NHL365":
//                    System.out.println(records.get(0));
//                    System.out.println("Remove?");
//
//                    break;
//                case "NHR576":
//                    System.out.println(records.get(1));
//                    break;
//                case "NEL646":
//                    System.out.println(records.get(2));
//                    break;
//                case "NKL133":
//                    System.out.println(records.get(3));
//                    break;
//                case "NRR178":
//                    System.out.println(records.get(4));
//                    break;
//                case "NNK254":
//                    System.out.println(records.get(5));
//                    break;
//
//            }


            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).patientID.equals(input)) {
                    System.out.println(records.get(i));
                    System.out.println("Remove it or not?");

                    String inp = sc.next();
                    if (inp.equals("Y")) {
                        records.remove(i);
                        System.out.println("Removed Successfully!");
                        System.out.println("Press S for search, Press E for exit.");

//                        String inp2 = sc.next();
//                        if(!records.contains(inp2)) {
//                            System.out.println("The search found no matching patient.");
                        }
                    else if (inp.equals("N")) {
                        System.out.println("No records removed!");
                    }
                    else {
                        System.out.println("No search found on matching");
                    }

                }

            }




            System.out.println("The hospital records size is: " + records.size());


        }


    }
}


