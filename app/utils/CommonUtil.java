package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 共通関数
 * 
 * @author kento
 *
 */
public class CommonUtil {
    public static final String FINISH_FLAG_YET 		= "0";
    public static final String FINISH_FLAG_AlREADY 	= "1";
    public static final String DATE_PATTERN 		= "yyyy/MM/dd";
    public static final String DATE_PATTERN2 		= "yyyy-MM-dd";
    
    
    
    /**
     * Stringの日付データ（yyyy/mm/dd）をDateに変換する
     *
     * SimpleDateFormatを使用して変換を行う 変換出来なかった場合にはnullを返す
     *
     * @param str
     * @return
     */
    public static Date getStr2Date(String str) {
        return getStr2Date(str, DATE_PATTERN2);
    }
    
    public static Date getStr2Date(String str, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {
            // Dateに変換
            return sdf.parse(str);
        } catch (Exception e) {
            // Dateに変換出来なかったらnullを返す
            return null;
        }
    }
    
    /**
     * Stringの数値データをLongに変換する 変換出来なかった場合にはnullを返す
     *
     * @param str
     * @return
     */
    public static Long getStr2Long(String str) {
        try {
            // intに変換
            return Long.parseLong(str);
        } catch (Exception e) {
            // intに変換出来なかったらrtnを返す
            return null;
        }
    }
    
    /**
     * LongのデータをStringに変換する 変換出来なかった場合にはnullを返す
     *
     * @param i
     * @return
     */
    public static String getLong2Str(Long i) {
        try {
            return Long.toString(i);
        } catch (Exception e) {
            return null;
        }
    }
}


