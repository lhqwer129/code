https://www.ruanyifeng.com/blog/2007/10/ascii_unicode_and_utf-8.html

### `ASCII码`











### java char and byte

char 类型是一个单一的 16 位 Unicode 字符, 根据Unicode编码的规定，一个英文字符占用一个字节，一个中文字符占用两个字节。char可以通过如下三种方式来赋值: 1.中文字符 2.16进制编码 3.十进制

```
public static void main(String[] args) {
    char c1 = '严';
    char c2='\u4E25';
    char c3 = 20005;
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
}
```





### 排序算法

堆排序