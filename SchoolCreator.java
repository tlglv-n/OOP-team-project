import data.Data;
import data.School;

public class SchoolCreator {
    
    public static void main(String args[]){
        new School("SITE", "Informational techs");
        new School("FGGE", "Geology and exploration");
        new School("SEPI", "Energy and petroleum");
        new School("SNSS", "Base for social and natural");
        new School("BS", "Business and stuff");
        new School("ISE", "International economy");
        new School("KMA", "Sea lions studying");
        new School("SMC", "Math and modeling");
        new School("SCE", "Chem and blue meth");
        new School("CAE", "Alternative energy");
        new School("SMSGT", "Materials and green tech");
        Data.serialize();
    }
}
