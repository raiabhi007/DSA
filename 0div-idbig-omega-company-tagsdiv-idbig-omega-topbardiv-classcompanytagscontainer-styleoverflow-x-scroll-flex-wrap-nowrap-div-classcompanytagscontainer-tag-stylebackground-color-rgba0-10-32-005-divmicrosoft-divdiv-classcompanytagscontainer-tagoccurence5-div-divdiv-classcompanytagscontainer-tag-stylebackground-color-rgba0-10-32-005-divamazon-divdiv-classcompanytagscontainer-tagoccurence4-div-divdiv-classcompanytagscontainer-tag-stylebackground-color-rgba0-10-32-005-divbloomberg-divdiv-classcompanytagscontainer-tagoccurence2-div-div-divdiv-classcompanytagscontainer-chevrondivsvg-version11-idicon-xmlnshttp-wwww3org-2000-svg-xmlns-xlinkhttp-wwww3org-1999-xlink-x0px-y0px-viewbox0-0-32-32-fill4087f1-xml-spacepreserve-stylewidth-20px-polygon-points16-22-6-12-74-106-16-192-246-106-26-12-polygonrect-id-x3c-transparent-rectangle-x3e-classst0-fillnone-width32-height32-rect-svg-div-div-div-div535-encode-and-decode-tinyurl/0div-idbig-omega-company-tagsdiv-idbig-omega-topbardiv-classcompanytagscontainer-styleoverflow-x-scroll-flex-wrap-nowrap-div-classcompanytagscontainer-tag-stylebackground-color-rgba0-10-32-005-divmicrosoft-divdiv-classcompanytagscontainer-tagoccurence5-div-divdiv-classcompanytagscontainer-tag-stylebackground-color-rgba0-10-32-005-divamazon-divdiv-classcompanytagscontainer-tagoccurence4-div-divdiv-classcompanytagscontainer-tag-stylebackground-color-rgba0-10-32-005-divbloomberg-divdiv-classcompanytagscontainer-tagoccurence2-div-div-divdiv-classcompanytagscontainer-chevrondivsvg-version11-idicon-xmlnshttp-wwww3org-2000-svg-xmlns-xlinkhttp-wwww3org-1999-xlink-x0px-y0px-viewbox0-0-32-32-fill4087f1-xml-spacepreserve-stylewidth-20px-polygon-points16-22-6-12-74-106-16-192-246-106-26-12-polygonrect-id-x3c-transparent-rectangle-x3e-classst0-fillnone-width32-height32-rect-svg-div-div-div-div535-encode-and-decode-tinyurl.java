public class Codec {
    HashMap<Integer,String> map = new HashMap<>();
    int count = 1;
    String url = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(count,longUrl);
        String temp = url+count;
        count++;
        return temp;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String temp = shortUrl.substring(19);
        int num = Integer.parseInt(temp);
        return map.get(num);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));