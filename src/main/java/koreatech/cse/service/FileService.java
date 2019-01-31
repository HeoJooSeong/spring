//package koreatech.cse.service;
//
//import org.springframework.util.FileCopyUtils;
//
//import java.io.File;
//import java.text.DecimalFormat;
//import java.util.Calendar;
//import java.util.UUID;
//import java.util.logging.Logger;
//
///**
// * Created by zoostar on 2019. 1. 31..
// */
//public class FileService {
//
//        public  String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
//
//            //겹쳐지지 않는 파일명을 위한 유니크한 값 생성
//            UUID uid = UUID.randomUUID();
//
//            //원본파일 이름과 UUID 결합
//            String savedName = uid.toString() + "_" + originalName;
//
//            //파일을 저장할 폴더 생성(년 월 일 기준)
//            String savedPath = calcPath(uploadPath);
//
//            //저장할 파일준비
//            File target = new File(uploadPath + savedPath, savedName);
//
//            //파일을 저장
//            FileCopyUtils.copy(fileData, target);
//
//            String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
//
//            String uploadedFileName = null;
//
//            //uploadedFileName는 썸네일명으로 화면에 전달된다.
//            return uploadedFileName;
//        }//
//
//        //폴더 생성 함수
//        @SuppressWarnings("unused")
//        private String calcPath(String uploadPath) {
//
//            Calendar cal = Calendar.getInstance();
//
//            String yearPath = File.separator + cal.get(Calendar.YEAR);
//
//            String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
//
//            String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
//
//            makeDir(uploadPath, yearPath, monthPath, datePath);
//
//
//            return datePath;
//        }//calcPath
//
//        //폴더 생성 함수
//        private static void makeDir(String uploadPath, String... paths) {
//
//            if(new File(uploadPath + paths[paths.length -1]).exists()) {
//                return;
//            }//if
//
//            for(String path : paths) {
//
//                File dirPath = new File(uploadPath + path);
//
//                if(!dirPath.exists()) {
//                    dirPath.mkdir();
//                }//if
//
//            }//for
//
//        }//makeDir
//
//}
