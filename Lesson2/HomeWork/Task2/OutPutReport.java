import java.util.ArrayList;
import java.util.List;

public class OutPutReport implements Outputable{

    private final List<Derivable> derivables;

    public OutPutReport() {
        derivables = new ArrayList<>();
    }

    @Override
    public List<Derivable> getListOfOutput() {
        return derivables;
    }

    private void setDerivable(Derivable derivable){
        derivables.add(derivable);
    }

    public static class Builder{

        private  OutPutReport outPutReport;

        public Builder() {
            outPutReport = new OutPutReport();
        }

        public Builder addPrint(PrintReport printReport){
            outPutReport.setDerivable(printReport);
            return this;
        }

        public Builder addDisplay(DisplayReport displayReport){
            outPutReport.setDerivable(displayReport);
            return this;
        }

        public Builder addFile(SaveFileReport fileReport){
            outPutReport.setDerivable(fileReport);
            return this;
        }

        public Outputable build(){
            return outPutReport;
        }
    }

}
