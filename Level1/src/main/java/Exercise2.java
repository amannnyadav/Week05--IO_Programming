class LegacyAPI{
    @Deprecated
    void oldFeature(){
        System.out.println("Old feature");
    }

    void newFeature(){
        System.out.println("New feature");
    }
}
public class Exercise2 {
    public static void main(String[] args) {
        LegacyAPI obj = new LegacyAPI();
        obj.newFeature();
        obj.oldFeature();
    }
}
