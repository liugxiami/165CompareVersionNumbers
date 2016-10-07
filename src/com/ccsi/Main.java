package com.ccsi;

public class Main {

    public static void main(String[] args) {
        String version1="11.22.21";
        String version2="11.022.21";
        System.out.println(compareVersion2(version1,version2));
    }
    //Compare two version numbers version1 and version2.
    //if version1>version2 return 1,if version1<version2 return -1,otherwise return 0;
    //You may assume that the version strings are non-empty and contain only digits and the . character.
    //The . character does not represent a decimal point and is used to separate number sequences.
    //For instance, 2.5 is not "two and a half" or "half way to version three",it is the fifth second-level revision
    //of the second first-level revision.
    //如果版本号以0开头，结果不对。如11.11.12 和11.011.12,结果相同，但第二个应该是早一点的版本。
    public static int compareVersion1(String version1,String version2){
        String[] v1Strs=version1.split("\\.");
        String[] v2Strs=version2.split("\\.");
        int lenV1=v1Strs.length;
        int lenV2=v2Strs.length;
        int len=Math.min(lenV1,lenV2);
        for (int i = 0; i < len; i++) {
            if(Integer.parseInt(v1Strs[i])>Integer.parseInt(v2Strs[i]))return 1;
            else if(Integer.parseInt(v1Strs[i])<Integer.parseInt(v2Strs[i])) return -1;
            else continue;
        }

        if(lenV1>lenV2) return 1;
        else if(lenV1<lenV2) return -1;
        else return 0;
    }
    public static int compareVersion2(String version1,String version2){
        String[] v1Strs=version1.split("\\.");
        String[] v2Strs=version2.split("\\.");
        int lenV1=v1Strs.length;
        int lenV2=v2Strs.length;
        int len=Math.min(lenV1,lenV2);
        for (int i = 0; i < len; i++) {
            int length1=v1Strs[i].length();
            int length2=v2Strs[i].length();
            int length=Math.min(length1,length2);
            for (int j = 0; j < length; j++) {
                if(v1Strs[i].charAt(j)>v2Strs[i].charAt(j))return 1;
                else if(v1Strs[i].charAt(j)<v2Strs[i].charAt(j))return -1;
                else continue;
            }
            if(length1>length2)return 1;
            else if(length1<length2)return -1;
            else continue;
        }
        if(lenV1>lenV2)return 1;
        else if(lenV1<lenV2)return -1;
        else return 0;
    }
}
//a better method
public static int compareVersion(String version1,String version2){
        if(version1==null||version1.length()==0)return Integer.MIN_VALUE;
        if(version2==null||version2.length()==0)return Integer.MIN_VALUE;

        while(true){
            if(version1.length()==0&&version2.length()==0)return 0;
            if(version1.length()!=0&&version2.length()==0)return 1;
            if(version1.length()==0&&version2.length()!=0)return -1;
            int nums1=0;
            int nums2=0;
            while(version1.length()!=0&&version1.charAt(0)!='.'){
                nums1*=10;
                nums1+=version1.charAt(0)-'0';
                version1=version1.substring(1);
            }
            while(version2.length()!=0&&version2.charAt(0)!='.'){
                nums2*=10;
                nums2+=version2.charAt(0)-'0';
                version2=version2.substring(1);
            }
            if(nums1>nums2)return 1;
            if(nums1<nums2)return -1;
            if(nums1==nums2){
                if(version1.length()!=0)version1=version1.substring(1);       //去除'.'
                if(version2.length()!=0)version2=version2.substring(1);
                continue;
            }
        }
    }
