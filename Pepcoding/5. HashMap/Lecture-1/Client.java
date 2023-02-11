public class Client {
    public static void main(String[] args) {
        genericHashMap<String, String> map = new genericHashMap<>();

        //so this piece of generic code work beautifully
        map.put("Mayank", "Sanvi");
        map.put("Gunnu", "Bc");

        // for(var key : map.keySet()){
        //     System.out.println(key + " -> " + map.get(key));
        // }

        //FUTURE SCOPE FOR THIS PROJECT
        //if you want below thing to happen
        //you gotta implement iterable(interface for sure)
        //have hasnext 
        // for(var key : map){


        // }



        ///this is the maximum you have to do when an interviewer ask you to implement hashmap and shit
        //pretty simple and tricky if you know how to do it. Pretty dope for sure
        //rehashing , iterator, iterable left only now
    }
}
