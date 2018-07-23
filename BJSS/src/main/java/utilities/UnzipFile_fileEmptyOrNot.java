package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipFile_fileEmptyOrNot {

    public static void unzipFile(String zipfilepath, String destdirectory) {
        File dir= new File(destdirectory);
        if (!dir.exists())dir.mkdirs();
        FileInputStream fis;
        byte[] buffer= new byte[1024];
        try{
            fis = new FileInputStream(zipfilepath);
            ZipInputStream zis= new ZipInputStream(fis);
            ZipEntry ze= zis.getNextEntry();
            while(ze!= null){
                String filename= ze.getName();
                File newFile= new File(destdirectory+ File.separator +filename);
                String filePath=  newFile.getAbsolutePath();
                System.out.println("Unzipping to"+filePath);

                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos= new FileOutputStream(newFile);
                int len;
                while((len= zis.read(buffer))>0){
                    fos.write(buffer,0,len);
                }
                fos.close();
                zis.closeEntry();
                ze= zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
            fis.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }


    public static void checkFileEmptyOrNot(String filename) throws IOException {
        FileInputStream fis= new FileInputStream(new File(filename));
        int b= fis.read();
        if(b== -1){
            System.out.println("empty file");
        }else {System.out.println("file is not empty");}
    }









}
