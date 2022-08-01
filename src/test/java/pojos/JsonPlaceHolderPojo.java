package pojos;

public class JsonPlaceHolderPojo {

/*
    1) Tüm keyler için private variable 'lar oluşturuyoruz.
    2) Tüm parametrelerle ve parametresiz constructor'larımızı oluşturuyoruz.
    3) Getters ve Setters'larımızı oluşturuyoruz.
    4) toString() methodumuzu oluşturuyoruz.
     */
 //java da obje olusturmak; o sinifin bir kopyasini olusturmak demektir.****
//bir classin tum ozelligi, o clasin icinde olan variable lardir.
    // methodlar sadece islem yapmak icindir.



//1) tum keyler icin private variable'lar olusturuyoruz.

private Integer userId;
private String title;
private Boolean completed;

//2)Tüm parametrelerle ve parametresiz constructor'larımızı oluşturuyoruz.

public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
this.userId = userId; // burdaki this ne ise yarar dersek; usteki userId, title ve completed ile
this.title = title;   // karismamamasini saplamak icin koyduk.
this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }

// 3) Getters ve Setters'larımızı oluşturuyoruz.
 //BUNUN ADIN INCAPSULATION YANI KABIN ICINE KOYMUS GIBI.

    public Integer getUserId() {  // get userid'yi baska yerden okuyabilmek icindir.
        return userId;
    }

    public void setUserId(Integer userId) {//set userid ise onu degistirebilir.
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}