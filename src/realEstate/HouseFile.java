package realestate;

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

    private String  filePath = System.getProperty("user.home") + "\\"+ "Documents" +  "\\" + "RealEstate"+ "\\" +"list.txt";
    private String[] readArray = new String[7];
    private String[] writeArray = new String[7];
    private ListHouse listHouseObject = new ListHouse();
    private SortedList sortedListObject = new SortedList();
    private File fileObject = new File(filePath);
    public static String line;

    public HouseFile() {
    }

    public void setWriteArray(String[] data) {
        writeArray[0]=listHouseObject.getFirstName();
        writeArray[1]=listHouseObject.getLastName();
        writeArray[2]=listHouseObject.getLotNumber();
        writeArray[3]=listHouseObject.getPrice();
        writeArray[4]=listHouseObject.getSquareFeet();
        writeArray[5]=listHouseObject.getBedRooms();        
        line = writeArray[2];
    }

    public String[] getWriteArray(){
        return writeArray;
    }
        public String[] getReadArray(){
        return readArray;
    }

    //write method will write all the information gather by the user
    //to the text file
    public void write() {
        int flag = sortedListObject.find(Integer.parseInt(writeArray[2]));
        if (flag != 101) {
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
            }
            writerObject.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file " + filePath);
        }
    }

    //Read method will read the specific given file and save the contain in writeArray
    public void read() {
        
            try {
                FileReader inputFile = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(inputFile);
                int i = 0;
                while ((readArray[i] = bufferedReader.readLine()) != null) {
                    System.out.println("read:"+readArray[i++]);
                }
                listHouseObject.init(readArray[1], readArray[0], readArray[2], readArray[3], readArray[4], readArray[5]);
                bufferedReader.close();
            } catch (IOException e) {
                System.err.println("Problem Reading the file");
            }
    }

    public void readList() {
        String[] readArrayList = new String[100];
        try {
            FileReader inputFile = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(inputFile);
            int i = 0;
            while ((readArrayList[i] = bufferedReader.readLine()) != null) {
                System.out.println("readList:"+readArrayList[i++]);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Problem Reading the file Text.txt");
        }
//        StringBuffer strbuf = new StringBuffer(readArrayList[0]);
//        strbuf.replace(0, 1, "");
//        readArrayList[0] = strbuf.toString();
        for (int i = 0; i < readArrayList.length && readArrayList[i] != null; i++) {
            SortedList.list[i] = Integer.parseInt(readArrayList[i]);
        }
    }

    public void setFileName(String lotNumber) {
        filePath = System.getProperty("user.home") + "\\" + "Documents" +  "\\" + "RealEstate"+ "\\" + lotNumber + ".txt";
    }

    public boolean checkFileExist() {
        return fileObject.exists();
    }

    public void createDirectory() {
        File file = new File(System.getProperty("user.home") + "\\" + "Documents" +  "\\" + "RealEstate");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            }
        }
    }
    public void deleteFile(String file){
        File newFile = new File(System.getProperty("user.home") + "\\" + "Documents" +  "\\" + "RealEstate"+  "\\" +file + ".txt");
        if(newFile.exists())
            newFile.delete();
    }
   public SortedList getSortList(){
       return sortedListObject;
    }
}
