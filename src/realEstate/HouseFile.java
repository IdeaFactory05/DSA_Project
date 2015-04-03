package realEstate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;


public class HouseFile {

    private String  filePath = "C:\\Users\\win7\\Desktop\\RealEstate\\list.txt";
    private String[] readArray = new String[7];
    private String[] writeArray = new String[7];
    private ListHouse listHouseObject = new ListHouse(writeArray[0], writeArray[1], writeArray[2], writeArray[3], writeArray[4], writeArray[5]);
    private SortedList sortedListObject = new SortedList();
    private File fileObject = new File(filePath);
    public static String line;

    public HouseFile() {
    }

    public void setWriteArray(String[] data) {
        for(int i=0; i<data.length;i++)
        writeArray[i] = data[i];
        line = writeArray[2];
    }

    public String[] getWriteArray(){
        return writeArray;
    }
        public String[] getReadArray(){
            System.out.println("_____________");
            for(String line : readArray)
                System.out.println(line);
        return readArray;
    }

    //write method will write all the information gather by the user
    //to the text file
    public void write() {
        int flag = sortedListObject.find(Integer.parseInt(writeArray[2]));
        if (flag == 101) {
            for(int i : SortedList.list){
                System.out.println("*****");
                System.out.println(i);
            }
            setFileName(writeArray[2]);
            try {
                File fileObject = new File(filePath);
                FileOutputStream fileOutputStreamObject = new FileOutputStream(fileObject);
                OutputStreamWriter outputStreamWriterObject = new OutputStreamWriter(fileOutputStreamObject);
                Writer writerObject = new BufferedWriter(outputStreamWriterObject);

                for (int i = 0; i < writeArray.length && writeArray[i] != null; i++) {
                    writerObject.write(writeArray[i]);
                    writerObject.append("\n");
                }
                writerObject.close();
            } catch (IOException e) {
                System.err.println("Problem writing to the file " + filePath);
            }
        } else {
            System.out.println("Duplicate Record.");
        }
    }

    public void writeList() {
        try {
            FileOutputStream fileOutputStreamObject = new FileOutputStream(fileObject);
            OutputStreamWriter outputStreamWriterObject = new OutputStreamWriter(fileOutputStreamObject);
            Writer writerObject = new BufferedWriter(outputStreamWriterObject);
            String line;
            for (int i=0; SortedList.list[i]!=-1;i++) {
                line = String.valueOf(SortedList.list[i]);
                writerObject.write(line);
                writerObject.append("\n");
                System.out.println(line);
            }
            System.out.println("**********");
            writerObject.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file " + filePath);
        }
    

  //Read method will read the specific given file and save the contain in writeArray
    public void read() {
        int flag = 0;//sortedListObject.find(Integer.parseInt(writeArray[2]));
        if (flag != -1) {
            try {
                FileReader inputFile = new FileReader(filePath);
                System.out.println(filePath);
                BufferedReader bufferedReader = new BufferedReader(inputFile);
                int i = 0;
                while ((readArray[i] = bufferedReader.readLine()) != null) {
                    System.out.println(readArray[i++]);
                }
                for(String line: readArray)
                    System.out.println("*"+line);
                bufferedReader.close();
            } catch (IOException e) {
                System.err.println("Problem Reading the file Text.txt");
            }
        }
    }

    public void readList() {
        String[] readArray = new String[100];
        int[] input = new int[100];
        try {
            FileReader inputFile = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(inputFile);
            int i = 0;
            while ((readArray[i] = bufferedReader.readLine()) != null) {
                System.out.println(readArray[i++]);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Problem Reading the file Text.txt");
        }
//        StringBuffer strbuf = new StringBuffer(readArray[0]);
//        strbuf.replace(0, 1, "");
//        readArray[0] = strbuf.toString();
        for (int i = 0; i < readArray.length && readArray[i] != null; i++) {
            SortedList.list[i] = Integer.parseInt(readArray[i]);
        }
//        for(int i=0;SortedList.list[i]!=-1 ;i++)
//            System.out.println(SortedList.list[i]);
    }

    public void setFileName(String lotNumber) {
        filePath = "C:\\Users\\win7\\Desktop\\RealEstate\\" + lotNumber + ".txt";
        System.out.println(filePath);
    }

    public boolean checkFileExist() {
        return fileObject.exists();
    }

    public void createDirectory() {
        File file = new File("C:\\Users\\win7\\Desktop\\RealEstate");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            }
        }
    }
    public void deleteFile(String file){
        File newFile = new File("C:\\Users\\win7\\Desktop\\RealEstate\\"+file + ".txt");
        if(newFile.exists())
            newFile.delete();
    }
   public SortedList getSortList(){
       return sortedListObject;
    }
}


